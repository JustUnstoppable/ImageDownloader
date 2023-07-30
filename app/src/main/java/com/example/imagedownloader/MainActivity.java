package com.example.imagedownloader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
   ImageView imageView;
   public void downloadImage(View view){
     ImageDownloader task=new ImageDownloader();
     Bitmap myImage;
     try {
         myImage = task.execute("https://www.newsbugz.com/wp-content/uploads/2018/11/Donal-Bisht-Images-9-e1541057539495-700x825.jpg").get();
         imageView.setImageBitmap(myImage);
     }catch(Exception e){
         e.printStackTrace();
     }
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
    }
    public class ImageDownloader extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try{
                URL url=new URL(urls[0]);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in=connection.getInputStream();
                Bitmap myBitmap= BitmapFactory.decodeStream(in);
                return myBitmap;
            }catch (Exception e){
                e.printStackTrace();
               return null;
            }
        }
    }
}
//String river="Mississippi";
//Pattern p=Pattern.compile("Mi(.*?)pi");
//Matcher m=p.matcher(river);
//while(m.find()){
// System.out.println(m.group(1));}


//String river="Mississippi";
//String[] splitString=river.split("s");
//system.out.println(Arrays.toString(splitString));