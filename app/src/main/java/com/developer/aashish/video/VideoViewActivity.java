package com.developer.aashish.video;

/**
 * Created by Aashish on 10/15/2017.
 */
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewActivity extends Activity {


    ProgressDialog pDialog;
    VideoView videoview;
//https://m.youtube.com/watch?v=________________&app=m
    String VideoURL = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
//    String VideoURL = "rtsp://r6---sn-a5mekn7k.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HCeNZMOCoAUIASARg9661h-LE8PJYigELU0JiR2VTSEt2SHcM/0F113781353318CB8F2E43558FE119F292EE2298.1C70FF356D4B59B39B29FDADD7B34865A288214B/yt6/1/video.3gp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.videoview_main);

        videoview = (VideoView) findViewById(R.id.VideoView);
                pDialog = new ProgressDialog(VideoViewActivity.this);

        pDialog.setTitle("Shubh Build Emandi Tutorial");
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();

        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    VideoViewActivity.this);
            mediacontroller.setAnchorView(videoview);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
            }
        });

    }

}