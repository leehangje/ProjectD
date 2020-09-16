/*
package com.example.projectd.ATask;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.example.projectd.Dto.MdDTO;
import com.example.projectd.MdDetailActivity;

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


public class DetailSelect extends AsyncTask<Void, Void, Void> {
    String md_serial_number;

    public DetailSelect(String md_serial_number) {
        this.md_serial_number = md_serial_number;
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
            builder.addTextBody("md_serial_number", md_serial_number, ContentType.create("Multipart/related", "UTF-8"));

            String postURL = ipConfig + "/app/anDetail";

            // 전송
            InputStream inputStream = null;
            httpClient = AndroidHttpClient.newInstance("Android");
            httpPost = new HttpPost(postURL);
            httpPost.setEntity(builder.build());
            httpResponse = httpClient.execute(httpPost);
            httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();

            MdDetailActivity.detailDTO = readMessage(inputStream);


        } catch (Exception e) {
            Log.d("main:detailselect", e.getMessage());
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
    }


    private MdDTO readMessage(InputStream inputStream) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

        String md_name = "";
        String md_category = "";
        int md_price = 0;
        String md_rental_term = "";
        int md_deposit = 0;
        String md_detail_content = "";
        String md_photo_url = "";
        String member_id = "";
        String member_addr = "";
        int md_fav_count = 0;
        String md_registration_date = "";
        String md_serial_number = "";
        int md_rent_status = 0;
        int md_hits = 0;

        reader.beginObject();
        while (reader.hasNext()) {
            String readStr = reader.nextName();
            if (readStr.equals("md_name")){
                md_name = reader.nextString();
            } else if (readStr.equals("md_category")){
                md_category = reader.nextString();
            } else if (readStr.equals("md_price")){
                md_price = reader.nextInt();
            } else if (readStr.equals("md_rental_term")){
                md_rental_term = reader.nextString();
            } else if (readStr.equals("md_deposit")){
                md_deposit = reader.nextInt();
            } else if (readStr.equals("md_detail_content")){
                md_detail_content = reader.nextString();
            } else if (readStr.equals("md_photo_url")){
                md_photo_url = reader.nextString();
            } else if (readStr.equals("member_id")){
                member_id = reader.nextString();
            } else if (readStr.equals("member_addr")){
                member_addr = reader.nextString();
            } else if (readStr.equals("md_fav_count")){
                md_fav_count = reader.nextInt();
            } else if (readStr.equals("md_registration_date")){
                md_registration_date = reader.nextString();
            } else if (readStr.equals("md_serial_number")){
                md_serial_number = reader.nextString();
            } else if (readStr.equals("md_rent_status")){
                md_rent_status = reader.nextInt();
            } else if (readStr.equals("md_hits")){
                md_hits = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        Log.d("main:detailselect : ", md_serial_number + "," + md_name);
        return new MdDTO(md_name, md_category, md_price, md_rental_term,
                md_deposit, md_detail_content, md_photo_url, member_id, member_addr,
                md_fav_count, md_registration_date, md_serial_number, md_rent_status, md_hits);

    }//readMessage()

}
*/
