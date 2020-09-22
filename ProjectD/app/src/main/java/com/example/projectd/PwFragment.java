package com.example.projectd;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectd.ATask.SignUpCheckId;

import java.util.concurrent.ExecutionException;

import static com.example.projectd.SignUpFormActivity.checkEmail;
import static com.example.projectd.SignUpFormActivity.idCheckDTO;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PwFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PwFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "PwFragment";
    GMailSender sender = new GMailSender("dteam0420@gmail.com", "hanul123");

    EditText etEmail, etEmailAuthNum;
    Button btnEmailAuth, btnResetPw;

    ViewGroup rootView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PwFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PwFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PwFragment newInstance(String param1, String param2) {
        PwFragment fragment = new PwFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_pw,
                viewGroup, false);

        etEmail = rootView.findViewById(R.id.etEmail);
        etEmailAuthNum = rootView.findViewById(R.id.etEmailAuthNum);
        btnEmailAuth = rootView.findViewById(R.id.btnEmailAuth);
        btnResetPw = rootView.findViewById(R.id.btnResetPw);

        // 이메일 발송하기 버튼 클릭시
        btnEmailAuth.setOnClickListener(this);

        // 비밀번호 재설정 버튼 클릭시
        btnResetPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAuthNum = etEmailAuthNum.getText().toString().trim();
                if (emailAuthNum == sender.getEmailCode()) {    // 인증번호가 일치할때
                    rootView = (ViewGroup) inflater.inflate(R.layout.fragment_pw_reset,
                            viewGroup, false);
                } else {
                    Toast.makeText(getContext(), "인증번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                }
            } //onClick()
        }); //btnResetPw.setOnClickListener()

        return rootView;
    } //onCreateView()

    // 알림 대화상자를 보여주는 메소드
    public void showMessage(String title, String message) {

        // getContext 안됨 / getActivity() 안됨 / getActivity().getApplicationContext() 안됨
        //getActivity(), R.style.Theme_AppCompat_Dialog_Alert 안됨
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // → 대화상자를 만들기 위한 빌더 객체 생성
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    } //showMessage()

    @Override
    public void onClick(View view) {
        String id = etEmail.getText().toString().trim();

        if (id.length() == 0) {  //이메일를 입력하지 않은 경우
            Toast.makeText(getContext(), "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        } else if (!checkEmail(id)) { //이메일 형식에 맞지 않는 경우
            Toast.makeText(getContext(), "이메일 형식으로 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            //이메일 중복 체크
            SignUpCheckId signUpCheckId = new SignUpCheckId(id);

            try {
                signUpCheckId.execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (idCheckDTO == null) {
                showMessage("알림", "가입하신 이메일이 존재하지 않습니다.\n다시 입력해주세요.");
                return;
            } else {
                showMessage("알림", "인증번호 이메일을 발송했습니다.\n이메일을 통해 인증번호를 입력해주세요");
                idCheckDTO = null;
                //G메일 전송
                try {
                    Toast.makeText(getContext(), "try 구문 안1, " + id, Toast.LENGTH_SHORT).show();
                    sender.sendMail("대여 안대여 - 이메일 인증을 진행해 주세요!",
                            "이메일 인증번호는 "+ sender.getEmailCode() + " 입니다. \n인증번호를 입력해주세요!",
                            "dteam0420@gmail.com",
                            id);
                    Toast.makeText(getContext(), "try 구문 안2", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onClick: " + sender.getEmailCode());
                } catch (Exception e) {
                    Toast.makeText(getContext(), "catch 구문 안1", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onClick: 이메일 보내기 오류");
                } //try-catch
            }
        }
    } //onClick()
}