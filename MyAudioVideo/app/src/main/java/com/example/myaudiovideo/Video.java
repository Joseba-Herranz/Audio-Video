package com.example.myaudiovideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Video extends AppCompatActivity{
    MediaController mediaController;

    VideoView vVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_video );

        vVideo = findViewById(R.id.vVideo);
        mediaController = new MediaController(this);
        vVideo.setMediaController(mediaController);
        mediaController.setAnchorView(vVideo);

        try{
            vVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
            vVideo.setOnPreparedListener( mp -> {
                mediaController.show(100000);
                vVideo.start();
            });
        }catch (Exception e){

        }
        vVideo.setOnCompletionListener( mp -> {
            mediaController.show(100000);
        } );


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mediaController.show();
        return false;
    }

    @Override
    protected void onDestroy (){
        super.onDestroy();
        vVideo.stopPlayback();
    }


}
