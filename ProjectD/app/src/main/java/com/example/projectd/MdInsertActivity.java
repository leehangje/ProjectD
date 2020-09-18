package com.example.projectd;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
<<<<<<< HEAD
import android.util.Log;
import android.view.KeyEvent;
=======
import android.provider.MediaStore;
import android.util.Log;
>>>>>>> 5af04bb5deef9a67b5534772d8dbc4fa44c8a0ec
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> 5af04bb5deef9a67b5534772d8dbc4fa44c8a0ec
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.projectd.ATask.MdInsert;
import com.example.projectd.Common.CommonMethod;
import static com.example.projectd.Common.CommonMethod.ipConfig;
import static com.example.projectd.Common.CommonMethod.isNetworkConnected;


import com.example.projectd.ATask.MdInsert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class MdInsertActivity extends AppCompatActivity {

    EditText et_md_name, et_md_title, et_md_price, et_md_rental_term , et_md_deposit, et_md_detail_content;

    ImageView imgVwSelected;
<<<<<<< HEAD
    Button btnImageSend, btnImageSelection, btnsubmit;
    TextView tv_md_name_ck, tv_md_title_ck, tv_md_price_ck, tv_md_content_ck;
    EditText et_md_name, et_md_title, et_md_price, et_md_rental_term, et_md_content;
    String state;
    String md_name, md_title, md_photo_url, md_category, md_rental_term, md_detail_content;
    int md_price, md_deposit;


    File tempSelectFile;
=======
    Button btnImageCreate, btnImageSelection, btn_submit, btn_cancel;
    //File tempSelectFile;

    String md_name = "", md_title = "", md_category = ""
            , md_rental_term = "", md_detail_content = "", md_price = "", md_deposit = "";

    public String md_photo_url, md_photo_real_url;

    final int CAMERA_REQUEST = 1000;
    final int LOAD_IMAGE = 1001;
    File file = null;
    long fileSize = 0;

    java.text.SimpleDateFormat tmpDateFormat;

>>>>>>> 5af04bb5deef9a67b5534772d8dbc4fa44c8a0ec

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

<<<<<<< HEAD
        EditText et_date = (EditText) findViewById(R.id.et_md_rental_term);
        et_date.setText(sdf.format(myCalendar.getTime()));
=======
        EditText et_md_rental_term = (EditText) findViewById(R.id.et_md_rental_term);
        et_md_rental_term.setText(sdf.format(myCalendar.getTime()));
>>>>>>> 5af04bb5deef9a67b5534772d8dbc4fa44c8a0ec
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_insert);

<<<<<<< HEAD
=======

        //edit text
>>>>>>> 5af04bb5deef9a67b5534772d8dbc4fa44c8a0ec
        et_md_name = findViewById(R.id.et_md_name);
        et_md_title = findViewById(R.id.et_md_title);
        et_md_price = findViewById(R.id.et_md_price);
        et_md_rental_term = findViewById(R.id.et_md_rental_term);
<<<<<<< HEAD
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
=======
        et_md_deposit = findViewById(R.id.et_md_deposit);
        et_md_detail_content = findViewById(R.id.et_md_detail_content);

        btnImageCreate = findViewById(R.id.btnImageCreate);
        btnImageSelection = findViewById(R.id.btnImageSelection);
        btn_submit = findViewById(R.id.btn_submit);
        btn_cancel = findViewById(R.id.btn_cancel);
        imgVwSelected = findViewById(R.id.imgVwSelected);

        //EDITTEXT 클릭 시 달력 띄우기
        EditText et_md_rental_term = (EditText) findViewById(R.id.et_md_rental_term);
        et_md_rental_term.setOnClickListener(new View.OnClickListener() {
>>>>>>> 5af04bb5deef9a67b5534772d8dbc4fa44c8a0ec
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

        btnImageCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    file = createFile();
                    Log.d("FilePath ", file.getAbsolutePath());

                }catch(Exception e){
                    Log.d("LendListAdd:filepath", "Something Wrong", e);
                }

                imgVwSelected.setVisibility(View.VISIBLE);

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { // API24 이상 부터
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                            FileProvider.getUriForFile(getApplicationContext(),
                                    getApplicationContext().getPackageName() + ".fileprovider", file));
                    Log.d("LendList:appId", getApplicationContext().getPackageName());
                }else {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                }

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, CAMERA_REQUEST);
                }
            }
        });

        btnImageSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVwSelected.setVisibility(View.VISIBLE);

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), LOAD_IMAGE);
            }
        });


        //btnImageSend.setEnabled(false);
      /*  btnImageSend.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                FileUploadUtils.send2Server(tempSelectFile);
            }
        });

        btnImageSelection.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                // Intent를 통해 이미지를 선택
                Intent intent = new Intent();
                //intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });*/


    }

    private File createFile() throws IOException {
        String imageFileName = "My" + tmpDateFormat.format(new Date()) + ".jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File curFile = new File(storageDir, imageFileName);
        return curFile;
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            try {
                // 이미지 돌리기 및 리사이즈
                Bitmap newBitmap = CommonMethod.imageRotateAndResize(file.getAbsolutePath());
                if(newBitmap != null){
                    imgVwSelected.setImageBitmap(newBitmap);
                }else{
                    Toast.makeText(this, "이미지가 null 입니다...", Toast.LENGTH_SHORT).show();
                }

                md_photo_real_url = file.getAbsolutePath();
                String uploadFileName = md_photo_real_url.split("/")[md_photo_real_url.split("/").length - 1];
                md_photo_url = ipConfig + "/app/resources/" + uploadFileName;

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (requestCode == LOAD_IMAGE && resultCode == RESULT_OK) {
            try {
                String path = "";
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    // Get the path from the Uri
                    path = getPathFromURI(selectedImageUri);
                }
                // 이미지 돌리기 및 리사이즈
                Bitmap newBitmap = CommonMethod.imageRotateAndResize(path);
                if(newBitmap != null){
                    imgVwSelected.setImageBitmap(newBitmap);
                }else{
                    Toast.makeText(this, "이미지가 null 입니다...", Toast.LENGTH_SHORT).show();
                }

                md_photo_real_url = path;
                Log.d("LendListAdd", "md_photo_real_url Path : " + md_photo_real_url);
                String uploadFileName = md_photo_real_url.split("/")[md_photo_real_url.split("/").length - 1];
                md_photo_url = ipConfig + "/app/resources/" + uploadFileName;

            } catch (Exception e){
                e.printStackTrace();
            }
        }


        /*if (requestCode != 1 || resultCode != RESULT_OK) {
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
        btnImageCreate.setEnabled(true);*/
    }

    private String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    public void btnSubmitClicked(View view){
        if(isNetworkConnected(this) == true){
            if(fileSize <= 30000000) {  // 파일크기가 30메가 보다 작아야 업로드 할수 있음
                md_name = et_md_name.getText().toString();
                md_title = et_md_title.getText().toString();
                md_rental_term = et_md_rental_term.getText().toString();
                md_detail_content = et_md_detail_content.getText().toString();
                md_price = et_md_price.getText().toString();
                md_deposit = et_md_deposit.getText().toString();

                MdInsert mdInsert = new MdInsert(md_name, md_photo_url, md_photo_real_url, md_title, md_category
                        , md_rental_term, md_detail_content, md_price, md_deposit);
                mdInsert.execute();

                Intent showIntent = new Intent(getApplicationContext(), LendListActivity.class);
                showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |   // 이 엑티비티 플래그를 사용하여 엑티비티를 호출하게 되면 새로운 태스크를 생성하여 그 태스크안에 엑티비티를 추가하게 됩니다. 단, 기존에 존재하는 태스크들중에 생성하려는 엑티비티와 동일한 affinity(관계, 유사)를 가지고 있는 태스크가 있다면 그곳으로 새 엑티비티가 들어가게됩니다.
                        Intent.FLAG_ACTIVITY_SINGLE_TOP | // 엑티비티를 호출할 경우 호출된 엑티비티가 현재 태스크의 최상단에 존재하고 있었다면 새로운 인스턴스를 생성하지 않습니다. 예를 들어 ABC가 엑티비티 스택에 존재하는 상태에서 C를 호출하였다면 여전히 ABC가 존재하게 됩니다.
                        Intent.FLAG_ACTIVITY_CLEAR_TOP); // 만약에 엑티비티스택에 호출하려는 엑티비티의 인스턴스가 이미 존재하고 있을 경우에 새로운 인스턴스를 생성하는 것 대신에 존재하고 있는 엑티비티를 포그라운드로 가져옵니다. 그리고 엑티비티스택의 최상단 엑티비티부터 포그라운드로 가져올 엑티비티까지의 모든 엑티비티를 삭제합니다.
                startActivity(showIntent);

                finish();
            }else{
                // 알림창 띄움
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("알림");
                builder.setMessage("파일 크기가 30MB초과하는 파일은 업로드가 제한되어 있습니다.\n30MB이하 파일로 선택해 주십시요!!!");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }

        }else{
            Toast.makeText(this, "인터넷이 연결되어 있지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void btnCancleClicked(View view){
        finish();
    }

}