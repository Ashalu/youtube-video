package com.developer.aashish.video;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;



import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

    public class MainActivity extends Activity {

        ImageButton button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Get the layout from video_main.xml
            setContentView(R.layout.activity_main);

            // Locate the button in activity_main.xml
            button = (ImageButton) findViewById(R.id.play);

            // Capture button clicks
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {

                    // Start NewActivity.class
                    Intent myIntent = new Intent(MainActivity.this,
                            VideoViewActivity.class);
                    startActivity(myIntent);
                }
            });
        }

    }