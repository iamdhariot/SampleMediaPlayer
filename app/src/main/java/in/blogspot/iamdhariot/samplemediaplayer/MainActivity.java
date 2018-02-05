package in.blogspot.iamdhariot.samplemediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     *  main_layout stuffs declaration
     * */
    private Button btnPlay,btnPause,btnSkip,btnReset;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         *  reference
         * */
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPause = (Button)findViewById(R.id.btnPause);
        btnSkip = (Button)findViewById(R.id.btnSkip);
        btnReset = (Button)findViewById(R.id.btnReset);


        /**
         * MediaPlayer reference
         * */
        mediaPlayer = MediaPlayer.create(this,R.raw.ncs_earth);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnSkip.setOnClickListener(this);

        btnReset.setOnClickListener(this);

    }

    /**
     * Btn onClick events
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:
                mediaPlayer.start();

                break;

            case R.id.btnPause:
                mediaPlayer.stop();
                break;
            case R.id.btnSkip:
                mediaPlayer.seekTo(25000);
                break;

            case R.id.btnReset:
                mediaPlayer.reset();
                break;

        }


    }
}
