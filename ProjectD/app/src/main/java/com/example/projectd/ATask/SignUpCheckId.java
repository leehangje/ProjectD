package com.example.projectd.ATask;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.example.projectd.Dto.MemberDTO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.projectd.Common.CommonMethod.ipConfig;
import static com.example.projectd.SignUpFormActivity.idCheckDTO;

public class SignUpCheckId extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "main:SignUpIdCheck";

    String member_id;

    public SignUpCheckId(String member_id) {
        this.member_id = member_id;
    }

    HttpClient httpClient;
    HttpPost httpPost;
    HttpResponse httpResponse;
    HttpEntity httpEntity;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            // MultipartEntityBuilder 생성
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

            // 문자열 및 데이터 추가
            builder.addTextBody("member_id", member_id, ContentType.create("Multipart/related", "UTF-8"));

            String postURL = ipConfig + "/app/anIdCheck";

            // 전송
            InputStream inputStream = null;
            httpClient = AndroidHttpClient.newInstance("Android");
            httpPost = new HttpPost(postURL);
            httpPost.setEntity(builder.build());
            httpResponse = httpClient.execute(httpPost);
            httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();

            idCheckDTO = readMessage(inputStream);
            Log.d(TAG, "SignUpIdCheck:doInBackground: " + idCheckDTO.getMember_id());

            inputStream.close();
        } catch (Exception e) {
            Log.d("main:loginselect", e.getMessage());
            e.printStackTrace();
        } finally {
            if(httpEntity != null){
                httpEntity = null;
            }
            if(httpResponse != null){
                httpResponse = null;
            }
            if(httpPost != null){
                httpPost = null;
            }
            if(httpClient != null){
                httpClient = null;
            }
        }

        return null;
    } //doInBackground()

    private MemberDTO readMessage(InputStream inputStream) throws IOException {

        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        reader.setLenient(true);

        String member_id = "";
        String member_name = "";
        String member_nickname = "";
        String member_tel = "";
        String member_addr = "";
        String member_latitude = "";
        String member_longitude = "";
        int member_grade = 0;

        reader.beginObject();
        while (reader.hasNext()) {
            String readStr = reader.nextName();
            if (readStr.equals("member_id")) {
                member_id = reader.nextString();
            } else if (readStr.equals("member_nickname")) {
                member_nickname = reader.nextString();
            } else if (readStr.equals("member_name")) {
                member_name = reader.nextString();
            } else if (readStr.equals("member_tel")) {
                member_tel = reader.nextString();
            } else if(readStr.equals("member_addr")) {
                member_addr = reader.nextString();
            } else if(readStr.equals("member_latitude")) {
                member_latitude = reader.nextString();
            }  else if(readStr.equals("member_longitude")) {
                member_longitude = reader.nextString();
            }  else if(readStr.equals("member_grade")) {
                member_grade = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        reader.close();
        Log.d("main:loginselect : ", member_id + "," + member_name);
        return new MemberDTO(member_id, member_nickname,
                member_tel, member_addr, member_latitude,
                member_longitude, member_grade, member_name);
    } //readMessage()

} //class

