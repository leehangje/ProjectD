package com.example.projectd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MypageActivity extends Fragment {

    TextView btn_profile_update, mypage_notice, mypage_qna, mypage_logout;
    ImageView my_goods, my_rentlist, my_fav;
    ViewGroup viewGroup;
    ActionBar abar;
    LinearLayout Lin1, Lin2, Lin3;
    TextView user_nickname, member_addr;
    RatingBar ratingBar2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_mypage, null);

        setHasOptionsMenu(true);

        btn_profile_update = viewGroup.findViewById(R.id.btn_profile_update);
        my_goods = viewGroup.findViewById(R.id.my_goods);
        my_rentlist = viewGroup.findViewById(R.id.my_rentlist);
        my_fav = viewGroup.findViewById(R.id.my_fav);
        mypage_notice = viewGroup.findViewById(R.id.mypage_notice);
        mypage_qna = viewGroup.findViewById(R.id.mypage_qna);
        mypage_logout = viewGroup.findViewById(R.id.mypage_logout);
        Lin1 = viewGroup.findViewById(R.id.Lin1);
        Lin2 = viewGroup.findViewById(R.id.Lin2);
        Lin3 = viewGroup.findViewById(R.id.Lin3);
        user_nickname = viewGroup.findViewById(R.id.user_nickname);
        member_addr = viewGroup.findViewById(R.id.member_addr);
        ratingBar2 = viewGroup.findViewById(R.id.ratingBar2);
        checkDangerousPermissions();

        Intent intent = getActivity().getIntent();

        String user = intent.getExtras().getString("member_nickname");
        user_nickname.setText(user);
        String addr = intent.getExtras().getString("member_addr");
        member_addr.setText(addr);

        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // 저는 0개를 주기싫어서, 만약 1개미만이면 강제로 1개를 넣었습니다.
                if (ratingBar2.getRating()<1.0f){
                    ratingBar2.setRating(2);
                }
            }
        });



        //빌린 목록
        Lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LendListActivity.class);
                startActivity(intent);
            }
        });

        //빌려준 목록
        Lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RentListActivity.class);
                startActivity(intent);
            }
        });

        //찜목록
        Lin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FavListActivity.class);
                startActivity(intent);
            }
        });



        //프로필 수정
        btn_profile_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                startActivity(intent);

            }
        });

        //공지사항
        mypage_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        //자주묻는질문
        mypage_qna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QnAListActivity.class);
                startActivity(intent);
            }
        });

        //로그아웃
        mypage_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return viewGroup;

    }//onCreateView()

    // 위험 권한
    private void checkDangerousPermissions () {
        String[] permissions = {
                android.Manifest.permission.INTERNET,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(getActivity(), permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getActivity(), "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permissions[0])) {
                Toast.makeText(getActivity(), "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(getActivity(), permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult ( int requestCode, String[] permissions,
                                             int[] grantResults){
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

} //class