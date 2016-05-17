package uk.ac.reading.gm013960.overwatchrawsoundfiles;


import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;


public class SoundbiteActivity extends Activity {

    String[] heroSoundBites;
    AssetManager assetManager;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_soundbite);

        Intent heroSelected = getIntent();

        final Hero chosenHero = (Hero) heroSelected.getSerializableExtra("Hero");

        TextView textViewHeroName = (TextView) findViewById(R.id.textViewHeroName);

        textViewHeroName.setText(chosenHero.getName());

        assetManager = getAssets();

        // TODO Remove testing assignments
        loadSoundBites(chosenHero);

        ListAdapter theAdapter = new MyAdapter(this, heroSoundBites);

        // ListViews display data in a scrollable list
        ListView theListView = (ListView) findViewById(R.id.theListView);

        // Tells the ListView what data to use
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String soundBitePicked = String.valueOf(adapterView.getItemAtPosition(i));
                playAudioSound(chosenHero, soundBitePicked);
            }
        });
    }

    private void loadSoundBites(Hero hero) {
        try {
            heroSoundBites = assetManager.list("sounds/"+hero.getDir());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void playAudioSound(Hero hero, String audioSoundName) {

        if (player != null) {
            if (player.isPlaying()) {
                player.stop();
            }
            player.release();
            player = null;
        }

        // TODO Switch to using audio files downloaded onto phone, instead of assets
        try {
            AssetFileDescriptor afd = assetManager.openFd("sounds/"+hero.getDir()+"/"+audioSoundName);
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            //player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
            // TODO Switch to Asynchronous Preparation
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null) {
            if (player.isPlaying()) {
                player.stop();
            }
            player.release();
            player = null;
        }
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // DEALLOCATE ALL MEMORY
        if (player != null) {
            if (player.isPlaying()) {
                player.stop();
            }
            player.release();
            player = null;
        }
    }

    @Override
    protected void onPause() {
        // TODO Proper handling of audio focus loss
        if (player != null) {
            if (player.isPlaying()) {
                player.stop();
            }
            player.release();
            player = null;
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // TODO ?
        if (player != null) player.release();
        super.onDestroy();
    }
}
