package com.kf.position.positionlongitudelatitude;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kf.position.positionlibrary.LocationUtils;

public class MainActivity extends Activity {

    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location location = LocationUtils.getInstance(MainActivity.this).showLocation();
                if (location!=null){
                    String address = "纬度："+location.getLatitude()+"经度："+location.getLongitude();
                    Log.d("FLY.onCreate",address);
                    textView.setText(address);
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocationUtils.getInstance(MainActivity.this).removeLocationUpdatesListener();
    }
}
