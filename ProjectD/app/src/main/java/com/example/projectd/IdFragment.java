package com.example.projectd;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IdFragment extends Fragment {
    EditText etTel, etAuthNum;
    Button btnTelAuth, btnSearchId;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IdFragment newInstance(String param1, String param2) {
        IdFragment fragment = new IdFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_id,
                viewGroup, false);

        btnSearchId = rootView.findViewById(R.id.btnSearchId);
        btnTelAuth = rootView.findViewById(R.id.btnTelAuth);
        etTel = rootView.findViewById(R.id.etTel);
        etAuthNum = rootView.findViewById(R.id.etAuthNum);

        // 인증 번호 받기 버튼 클릭 시
        btnTelAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = etTel.getText().toString().trim();
                // 전화번호 형식 체크
                if (tel.length() == 0){  //전화번호를 입력하지 않은 경우
                    Toast.makeText(getContext(), "핸드폰 번호를 입력해주세요!", Toast.LENGTH_SHORT).show();
                    etTel.requestFocus();
                    return;
                } else if (!Pattern.matches("^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$", tel)){
                    Toast.makeText(getContext(), "핸드폰 번호는 10 ~ 11자의 숫자만 사용가능합니다!", Toast.LENGTH_SHORT).show();
                    return;
                }

            } //onClick()
        }); //btnSearchId.setOnClickListener()

        // E-MAIL 찾기 버튼 클릭 시
        btnSearchId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = etTel.getText().toString().trim();
                // 전화번호 형식 체크
                if (tel.length() == 0){  //전화번호를 입력하지 않은 경우
                    Toast.makeText(getContext(), "핸드폰 번호를 입력해주세요!", Toast.LENGTH_SHORT).show();
                    etTel.requestFocus();
                    return;
                } else if (!Pattern.matches("^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$", tel)){
                    Toast.makeText(getContext(), "핸드폰 번호는 10 ~ 11자의 숫자만 사용가능합니다!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    // 알림 상자로 인증번호 보여주기
                    showMessage();
                }

                Toast.makeText(getContext(),  etAuthNum.getText().toString() + ", " + etTel.getText().toString(), Toast.LENGTH_LONG).show();
            }
        }); //btnSearchId.setOnClickListener()

        return rootView;
    } //onCreateView()

    // 알림 대화상자를 보여주는 메소드
    public void showMessage() {
        // getContext 안됨 / getActivity() 안됨 / getActivity().getApplicationContext() 안됨
        //getActivity(), R.style.Theme_AppCompat_Dialog_Alert 안됨
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Dialog_Alert);
        // → 대화상자를 만들기 위한 빌더 객체 생성
        builder.setTitle("인증번호");
        builder.setMessage("인증번호는" + " 입니다");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    } //showMessage()
}