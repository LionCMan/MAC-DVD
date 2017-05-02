package com.example.android.macdvd2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    Button facebook;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       call =(Button)findViewById(R.id.business_call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent=new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0906481156"));
                startActivity(callIntent);
            }
        });

       facebook = (Button)findViewById(R.id.business_facebook);
        facebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent facebookIntent = openFacebook(MainActivity.this);
                 startActivity(facebookIntent);
            }
        });
    }

    public static Intent openFacebook(Context context){

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/655724254495478"));
        }
        catch (Exception e){
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/MACDVD1"));
        }
    }
}
