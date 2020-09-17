package com.example.projectd;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectd.ATask.MdInsert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class MdInsertActivity extends AppCompatActivity {

    ImageView imgVwSelected;
    Button btnImageSend, btnImageSelection, btnsubmit;
    TextView tv_md_name_ck, tv_md_title_ck, tv_md_price_ck, tv_md_content_ck;
    EditText et_md_name, et_md_title, et_md_price, et_md_rental_term, et_md_content;
    String state;
    String md_name, md_title, md_photo_url, md_category, md_rental_term, md_detail_content;
    int md_price, md_deposit;


    File tempSelectFile;

    Calendar myCalendar = Calendar.getInstance();

    //DATEPICKER
    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    // 달력에서 지정한 날짜 EDITTEXT에 띄우는 메소드
    private void updateLabel() {
        String myFormat = "yyyy/MM/dd까지";    // 출력형식   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.et_md_rental_term);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_insert);

        et_md_name = findViewById(R.id.et_md_name);
        et_md_title = findViewById(R.id.et_md_title);
        et_md_price = findViewById(R.id.et_md_price);
        et_md_rental_term = findViewById(R.id.et_md_rental_term);
        et_md_content = findViewById(R.id.et_md_content);
        tv_md_name_ck = findViewById(R.id.tv_md_name_ck);
        tv_md_title_ck = findViewById(R.id.tv_md_title_ck);
        tv_md_price_ck = findViewById(R.id.tv_md_price_ck);
        tv_md_content_ck = findViewById(R.id.tv_md_content_ck);

        btnsubmit = findViewById(R.id.btnSubmit);

        et_md_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                String name = et_md_name.getText().toString();
                /*if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (name.length() == 0) {  //상품명을 입력하지 않은 경우
                        tv_md_name_ck.setText("상품명을 입력하세요!");
                        tv_md_name_ck.setVisibility(View.VISIBLE);
                        et_md_name.setText("");
                        et_md_name.requestFocus();
                        return false;
                    }
                }*/
                return false;
            }
        });//et md name

        et_md_title.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                String title = et_md_title.getText().toString();
               /* if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (title.length() == 0) {  //제목을 입력하지 않은 경우
                        tv_md_title_ck.setText("제목을 입력하세요!");
                        tv_md_title_ck.setVisibility(View.VISIBLE);
                        et_md_title.setText("");
                        et_md_title.requestFocus();
                        return false;
                    }
                }*/
                return false;
            }
        });//et md title

        et_md_price.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                String title = et_md_price.getText().toString();
               /* if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (title.length() == 0) {  //가격을 입력하지 않은 경우
                        tv_md_price_ck.setText("가격을 입력하세요!");
                        tv_md_price_ck.setVisibility(View.VISIBLE);
                        et_md_price.setText("");
                        et_md_price.requestFocus();
                        return false;
                    }
                }*/
                return false;
            }
        });//et md price

        et_md_content.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                String title = et_md_content.getText().toString();
                /*if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (title.length() == 0) {  //상세설명을 입력하지 않은 경우
                        tv_md_content_ck.setText("상세설명을 입력하세요!");
                        tv_md_content_ck.setVisibility(View.VISIBLE);
                        et_md_content.setText("");
                        et_md_content.requestFocus();
                        return false;
                    }
                }*/
                return false;
            }
        });//et md content

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                md_name = et_md_name.getText().toString();
                md_title = et_md_title.getText().toString();
                md_price = Integer.parseInt(et_md_price.getText().toString());
                md_rental_term = et_md_rental_term.getText().toString();
                md_detail_content = et_md_content.getText().toString();

                MdInsert mdInsert = new MdInsert(md_name, md_title, md_category, md_rental_term, md_detail_content, md_deposit, md_price);

                try {
                    state = mdInsert.execute().get().trim();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (state.equals("1")) {
                    Toast.makeText(MdInsertActivity.this, "삽입성공 !!!", Toast.LENGTH_SHORT).show();
                    Log.d("main:joinact", "삽입성공 !!!");
                    finish();
                } else {
                    Toast.makeText(MdInsertActivity.this, "삽입실패 !!!", Toast.LENGTH_SHORT).show();
                    Log.d("main:joinact", "삽입실패 !!!");
                }

            }


        });

        //EDITTEXT 클릭 시 달력 띄우기
        EditText et_Date = (EditText) findViewById(R.id.et_md_rental_term);
        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MdInsertActivity.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        //카테고리 스피너
        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnImageSend = findViewById(R.id.btnImageSend);
        btnImageSend.setEnabled(false);
        btnImageSend.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                FileUploadUtils.send2Server(tempSelectFile);
            }
        });

        btnImageSelection = findViewById(R.id.btnImageSelection);
        btnImageSelection.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                // Intent를 통해 이미지를 선택
                Intent intent = new Intent();
                //intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        imgVwSelected = findViewById(R.id.imgVwSelected);

    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1 || resultCode != RESULT_OK) {
            return;
        }
        Uri dataUri = data.getData();
        imgVwSelected.setImageURI(dataUri);
        try {
            // ImageView 에 이미지 출력
            InputStream in = getContentResolver().openInputStream(dataUri);
            Bitmap image = BitmapFactory.decodeStream(in);
            imgVwSelected.setImageBitmap(image);
            in.close();
            // 선택한 이미지 임시 저장
            String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
            tempSelectFile = new File(Environment.getExternalStorageDirectory() + "/Pictures/Test/", "temp_" + date + ".jpeg");
            OutputStream out = new FileOutputStream(tempSelectFile);
            image.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        btnImageSend.setEnabled(true);
    }





}