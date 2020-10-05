package com.example.projectd;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.projectd.ATask.LoginSelect;
import com.example.projectd.ATask.NaverJoin;
import com.example.projectd.ATask.NaverLogin;
import com.example.projectd.Dto.MemberDto;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "main:LoginActivity";

    public static MemberDto loginDTO = null;
    public static MemberDto naverLoginDTO = null;

    EditText etId, etPw;
    TextView id_pw_search, signUp;
    Button loginSubmitBtn;
    String state = "";
    ImageView naverLoginBtn, kakaoLoginBtn;

    //네이버 로그인 관련
    // https://developers.naver.com/apps/#/myapps/4HyB0M2cnGc8fif15HRb/overview
    private static String OAUTH_CLIENT_ID = "cEfqX1rKoH7meFdpxDrl"; //클라이언트 아이디
    private static String OAUTH_CLIENT_SECRET = "ulRbzFfLxf";       //Client Secret Key
    private static String OAUTH_CLIENT_NAME = "대여안대여";         //애플리케이션 이름
    public static OAuthLogin mOAuthLoginInstance;
    public static OAuthLoginButton mOAuthLoginButton;
    public static Context mContext;
    public static Map<String, String> mUserInfoMap;

    //카카오 로그인 관련
    SessionCallback sessionCallback;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkDangerousPermissions();    //위험 권한 주기

        sessionCallback = new SessionCallback(getApplicationContext());

        id_pw_search = findViewById(R.id.id_pw_search);
        signUp = findViewById(R.id.signUp);
        loginSubmitBtn = findViewById(R.id.loginSubmitBtn);
        etId = findViewById(R.id.etId);
        etPw = findViewById(R.id.etPw);
        naverLoginBtn = findViewById(R.id.naverLoginBtn);
        kakaoLoginBtn = findViewById(R.id.kakaoLoginBtn);

        mContext = LoginActivity.this;

        //네이버 로그인 초기화
        initData();

        naverLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOAuthLoginInstance.startOauthLoginActivity(LoginActivity.this, mOAuthLoginHandler);
            }
        });

        // 아이디/비밀번호 찾기 화면 띄우기
        id_pw_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SearchIDActivity.class);
                startActivity(intent);
            }
        }); //id_pw_search.setOnClickListener()

        // 회원가입 화면 띄우기
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpFormActivity.class);
                startActivity(intent);
            }
        }); //signUp.setOnClickListener()

        // 로그인 버튼 클릭 시 실행되는 메소드
        loginSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDTO = null;

                if(etId.getText().toString().length() != 0 && etPw.getText().toString().length() != 0) {
                    String member_id = etId.getText().toString();
                    String member_pw = etPw.getText().toString();

                    LoginSelect loginSelect = new LoginSelect(member_id, member_pw);
                    try {
                        loginSelect.execute().get();
                    } catch (ExecutionException e) {
                        e.getMessage();
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "아이디와 암호를 모두 입력하세요.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", "아이디와 암호를 모두 입력하세요.");
                    return;
                }

                if(loginDTO != null){
                    String member_nickname = loginDTO.getMember_nickname();
                    String member_addr = loginDTO.getMember_addr();
                    Toast.makeText(LoginActivity.this, loginDTO.getMember_id() + "님 로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", loginDTO.getMember_id() + "님 로그인 되었습니다.");

                    // 로그인 정보에 값이 있으면 로그인이 되었으므로 메인화면으로 이동
                    Intent intent = new Intent(LoginActivity.this, RealMainActivity.class);
                    intent.putExtra("member_nickname", member_nickname);
                    intent.putExtra("member_addr", member_addr);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "아이디나 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", "아이디나 비밀번호가 일치하지 않습니다.");
                    etId.setText("");
                    etPw.setText("");
                    etId.requestFocus();
                }

            }
        }); //loginSubmitBtn.setOnClickListener()

        // 카카오세션 콜백 등록
        session = Session.getCurrentSession();
        session.addCallback(sessionCallback);

        // 카카오 로그인 버튼 클릭 시
        kakaoLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.open(AuthType.KAKAO_LOGIN_ALL, LoginActivity.this);
                Log.d(TAG, "onClick: 카카오로그인완료");
            }
        });

    } //onCreate()

    /****************************************************************************************************************
     * Kakao
     ****************************************************************************************************************/

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 카카오세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /****************************************************************************************************************
     * Naver
     ****************************************************************************************************************/

    private void initData() {
        //초기화
        mOAuthLoginInstance = OAuthLogin.getInstance();
        mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);

        mOAuthLoginButton = findViewById(R.id.naverLoginBtn);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);
        mOAuthLoginButton.setBgResourceId(R.drawable.naver_login);
    }

    // 네이버 로그인 관련 핸들러
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
                String tokenType = mOAuthLoginInstance.getTokenType(mContext);

                Toast.makeText(mContext, "success:" + accessToken, Toast.LENGTH_SHORT).show();

                Log.d(TAG, "run: accessToken > " + accessToken);
                Log.d(TAG, "run: refreshToken > " + refreshToken);
                Log.d(TAG, "run: expiresAt > " + String.valueOf(expiresAt));
                Log.d(TAG, "run: tokenType > " + tokenType);
                Log.d(TAG, "run: getState() > " + mOAuthLoginInstance.getState(mContext).toString());

                RequestApiTask rat = new RequestApiTask();
                rat.execute();

                //본인이 이동할 액티비티를 입력
                //redirectSignupActivity();

            } else {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode
                        + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "run: error");
            }
        }
    };

    private class RequestApiTask extends AsyncTask<Void, Void, Void> {
        String member_id, member_nickname, member_name;
        private String token = mOAuthLoginInstance.getAccessToken(mContext);
        String member_loginType = "N";

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... params) {
            String url = "https://openapi.naver.com/v1/nid/getUserProfile.xml";
            String at = mOAuthLoginInstance.getAccessToken(mContext);
            mUserInfoMap = requestNaverUserInfo(mOAuthLoginInstance.requestApi(mContext, at, url));
            Log.d(TAG, "doInBackground: 들어옴");
            return null;
        }

        protected void onPostExecute(Void content) {

            if (mUserInfoMap.get("email") == null) {
                Toast.makeText(mContext, "로그인 실패하였습니다.  잠시후 다시 시도해 주세요!!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPostExecute: 로그인 실패");
            } else {

                //네이버 로그인 성공
                Log.d(TAG, 6+ String.valueOf(mUserInfoMap));
                member_id = mUserInfoMap.get("id");
                member_nickname = mUserInfoMap.get("nickname");
                Log.d(TAG, "onPostExecute: member_id = "+ member_id);
                Log.d(TAG, "onPostExecute: member_nickname = "+ member_nickname);

                NaverLogin naverLogin = new NaverLogin(member_id, member_loginType);
                try {
                    naverLogin.execute().get();
                    Log.d(TAG, "onSessionOpened: try 구문 안");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toast.makeText(LoginActivity.this, "네이버 로그인 됐습니다...", Toast.LENGTH_SHORT).show();

                if(naverLoginDTO == null){
                    NaverJoin naverJoin = new NaverJoin(member_id, member_nickname, member_name, member_loginType, token);
                    try {
                        String state = naverJoin.execute().get();
                        Log.d(TAG, "onSessionOpened: " + state);
                    } catch (Exception e) {
                        Log.d(TAG, "onPostExecute: " + e.getMessage());
                    }

                    Toast.makeText(LoginActivity.this, "네이버 로그인 됐습니다...", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onSuccess: 네이버 로그인 됐습니다");

                }

                Intent intent = new Intent(getApplicationContext(), LogoutActivity.class);
                startActivity(intent);

                finish();


                /*LoginSelect loginSelect = new LoginSelect(member_email, "0000");
                try {
                    String result = loginSelect.execute().get();
                    Log.d(TAG, "onSessionOpened: " + result);
                    Log.d(TAG, "onSessionOpened: " + loginDTO);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                /*if(loginDTO == null){
                    JoinInsert joinInsert = new JoinInsert(member_email, "0000", member_nickname,"");
                    try {
                        String result = joinInsert.execute().get();
                        Log.d(TAG, "onSessionOpened: " + result);
                    } catch (Exception e) {
                        Log.d(TAG, "onPostExecute: " + e.getMessage());
                    }
                    loginDTO = new MemberDTO(member_email, member_nickname, null);
                    Log.d(TAG, "onSuccess: 네이버로그인됐습니다"+loginDTO.getMember_email());
                }*/

            }
        }
    } //class RequestApiTask

    private static Map<String, String> requestNaverUserInfo(String data) {  //xml 파싱
        String f_array[] = new String[9];
        try {
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            InputStream input = new ByteArrayInputStream(data.getBytes("UTF-8"));
            parser.setInput(input, "UTF-8");

            int parserEvent = parser.getEventType();
            String tag;
            boolean inText = false;
            boolean lastMatTag = false;

            int colIdx = 0;

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case  XmlPullParser.START_TAG:
                        tag = parser.getName();

                        if(tag.compareTo("xml") == 0) {
                            inText = false;
                        } else if(tag.compareTo("data") == 0) {
                            inText = false;
                        } else if(tag.compareTo("result") == 0) {
                            inText = false;
                        } else if(tag.compareTo("resultcode") == 0) {
                            inText = false;
                        } else if(tag.compareTo("message") == 0) {
                            inText = false;
                        } else if(tag.compareTo("response") == 0) {
                            inText = false;
                        } else {
                            inText = true;
                        }
                        break;
                    case XmlPullParser.TEXT:
                        tag = parser.getName();
                        if(inText) {
                            if(parser.getText() == null) {
                                f_array[colIdx] = "";
                            } else {
                                f_array[colIdx] = parser.getText().trim();
                            }
                            colIdx++;
                        }
                        inText = false;
                        break;
                    case XmlPullParser.END_TAG:
                        tag = parser.getName();
                        inText = false;
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (Exception e) {
            Log.e(TAG, "requestNaverUserInfo: Error is network call", e);

        }

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("nickname", f_array[1]);
        resultMap.put("id", f_array[6]);
        resultMap.put("name", f_array[7]);

        return resultMap;
    } //requestNaverUserInfo

    // 성공 후 이동할 액티비티
    protected void redirectSignupActivity() {
        final Intent intent = new Intent(this, LogoutActivity.class);
        startActivity(intent);
        finish();
        //Toast.makeText(mContext, "NAVER LOGIN", Toast.LENGTH_SHORT).show();
    }




    //----------------------------------------------------------------
    // 위험 권한
    private void checkDangerousPermissions () {
        String[] permissions = {
                android.Manifest.permission.INTERNET,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult ( int requestCode, String[] permissions,
                                             int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


} //class