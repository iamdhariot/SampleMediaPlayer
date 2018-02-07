package in.blogspot.iamdhariot.samplemediaplayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     *  main_layout stuffs declaration
     * */
    private LinearLayout layout;
    private TextView songName;
    private Button btnPlay,btnPause,btnPrevious,btnNext;
    private ImageView songImg;
    private MediaPlayer mediaPlayer;
    private  int[] songs = {R.raw.ncs_earth,R.raw.i_know_you_are_in_trouble_tayler};
    private  int[] imageSongs={R.drawable.ncs_earth,R.drawable.tayler_swift};
    private  String[] songTitle={"NCS-Earth","Taylor Swift - I know you are in trouble"};
   private int songNum=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /**
         * Making the notification bar transparent
         * for this we check the device sdk is greater then or equal to 19
         * */
        if(Build.VERSION.SDK_INT>=19){
            // make notification bar transparent
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }else{
            // making notification bar as theme color
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


        setContentView(R.layout.activity_main);


        /**
         *  reference
         * */
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPause = (Button)findViewById(R.id.btnPause);
        btnPrevious = (Button)findViewById(R.id.btnPrevious);
        btnNext = (Button)findViewById(R.id.btnNext);
        songImg = (ImageView)findViewById(R.id.songImg);
        songName  = (TextView)findViewById(R.id.songName);

        layout = (LinearLayout)findViewById(R.id.layout);






        /**
         * MediaPlayer reference
         * */



        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

        btnNext.setOnClickListener(this);
        songNumber(songNum);

    }
    /**
     * Btn onClick events
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:

                // play button transition
                TransitionManager.beginDelayedTransition(layout);

                mediaPlayer.start();
                btnPlay.setVisibility(View.GONE);
                btnPause.setVisibility(View.VISIBLE);

                break;

            case R.id.btnPause:
                TransitionManager.beginDelayedTransition(layout);

                mediaPlayer.pause();
                btnPlay.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.GONE);
                break;
         case R.id.btnPrevious:

             TransitionManager.beginDelayedTransition(layout);

             mediaPlayer.reset();
                 if (songNum==0)
                 {
                     songNum=0;
                 }else{
                     songNum-=1;
                 }
               songNumber(songNum);
             mediaPlayer.start();
             btnPlay.setVisibility(View.GONE);
             btnPause.setVisibility(View.VISIBLE);
             break;

            case R.id.btnNext:

                TransitionManager.beginDelayedTransition(layout);

                mediaPlayer.reset();
                if (songNum==songs.length-1){
                    songNum=songs.length-1;
                }else{
                    songNum+=1;
                }
               songNumber(songNum);
                mediaPlayer.start();
                btnPlay.setVisibility(View.GONE);
                btnPause.setVisibility(View.VISIBLE);
                break;

        }


    }

    private void songNumber(int songNum){


        mediaPlayer = MediaPlayer.create(this,songs[songNum]);
        TransitionManager.beginDelayedTransition(layout);
        songImg.setImageResource(imageSongs[songNum]);
        songName.setText(songTitle[songNum]);



    }
}
