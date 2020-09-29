package com.example.projectd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.ProgressDialog;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.ObjectKey;
import com.example.projectd.ATask.ProfileUpdate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MypageActivity extends Fragment {

    TextView btn_profile_update, mypage_notice, mypage_qna, mypage_logout;
    ImageView my_goods, my_rentlist, my_fav;
    ViewGroup viewGroup;
    ActionBar abar;
    LinearLayout Lin1, Lin2, Lin3;
    TextView user_nickname, member_addr;
    RatingBar ratingBar2;
    CircleImageView profile_photo;

    ProgressDialog progressDialog;
    ProfileUpdate profilUpdate;

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
        profile_photo = viewGroup.findViewById(R.id.profile_photo);

        String user = LoginActivity.loginDTO.getMember_name();
        user_nickname.setText(user);
        String addr = LoginActivity.loginDTO.getMember_addr();
        member_addr.setText(addr);

        Glide.with(this).load(LoginActivity.loginDTO.getMember_profile())
                .signature(new ObjectKey(System.currentTimeMillis()))
                .placeholder(R.drawable.cast_mini_controller_progress_drawable)
                .into(profile_photo);

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



} //class