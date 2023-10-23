package com.example.myaudiovideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.MediaController;

import androidx.appcompat.app.AppCompatActivity;

public class Audio extends AppCompatActivity implements MediaController.MediaPlayerControl{
    MediaPlayer mediaPlayer;

    MediaController mediaController;

    ListView vAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_audio );

        mediaPlayer = new MediaPlayer();

        mediaController = new MediaController(this);
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(findViewById(R.id.vAudio));

        try{
            mediaPlayer.setDataSource(this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.audio));
            mediaPlayer.prepare();
            mediaPlayer.start();
        }catch (Exception e){

        }

        mediaPlayer.setOnPreparedListener( mp -> mediaController.show(100000) );

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mediaController.show();
        return false;
    }

    @Override
    protected void onDestroy (){
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }


    @Override
    public void start() {
        mediaPlayer.start();
    }

    @Override
    public void pause() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mediaPlayer.isPlaying();
    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return mediaPlayer.getAudioSessionId();
    }
}
