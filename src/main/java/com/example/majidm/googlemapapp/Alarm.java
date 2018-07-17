package com.example.majidm.googlemapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class Alarm extends AppCompatActivity {
    Button btn ;
    TextView t1 , t2 ;
    EditText latitude_txt , longitude_txt ;
    boolean check = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        latitude_txt = (EditText)findViewById(R.id.latitude);
        longitude_txt = (EditText)findViewById(R.id.longitude);

        Bundle extras = getIntent().getExtras();
        double lati = extras.getDouble("latitude");
        double longi = extras.getDouble("longitude");
        latitude_txt.setText(lati+"");
        longitude_txt.setText(longi+"");

        TextView t = (TextView)findViewById(R.id.text);
       // t.setText(value1+" & "+value2);

    }

    @Override
    public void finish() {
        if(check==true) {
            double lati = Double.parseDouble(latitude_txt.getText().toString());
            double longi = Double.parseDouble(longitude_txt.getText().toString());
            // Prepare data intent
            Intent i = new Intent();
            i.putExtra("alarm_location_latitude", lati);
            i.putExtra("alarm_location_longitude", longi);
            // Activity finished ok, return the data
            setResult(RESULT_OK, i);
        }
        super.finish();
    }

    public void SetAlram(View v){
        check = true;
        finish();
    }

}
