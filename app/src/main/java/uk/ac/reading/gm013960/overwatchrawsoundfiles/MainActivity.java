package uk.ac.reading.gm013960.overwatchrawsoundfiles;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton bastionButton;
    ImageButton dVaButton;
    ImageButton genjiButton;
    ImageButton hanzoButton;
    ImageButton junkratButton;
    ImageButton lucioButton;
    ImageButton mcCreeButton;
    ImageButton meiButton;
    ImageButton mercyButton;
    ImageButton pharahButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bastionButton = (ImageButton) findViewById(R.id.imageButtonBastion);
        dVaButton = (ImageButton) findViewById(R.id.imageButtonDVa);
        genjiButton = (ImageButton) findViewById(R.id.imageButtonGenji);
        hanzoButton = (ImageButton) findViewById(R.id.imageButtonHanzo);
        junkratButton = (ImageButton) findViewById(R.id.imageButtonJunkrat);
        lucioButton = (ImageButton) findViewById(R.id.imageButtonLucio);
        mcCreeButton = (ImageButton) findViewById(R.id.imageButtonMcCree);
        meiButton = (ImageButton) findViewById(R.id.imageButtonMei);
        mercyButton = (ImageButton) findViewById(R.id.imageButtonMercy);
        pharahButton = (ImageButton) findViewById(R.id.imageButtonPharah);
    }

    public void onGoToSoundBites(View view) {
        Intent getSoundBiteScreenIntent = new Intent(this, SoundbiteActivity.class);

        // TODO Optimise button presses. Reduce if, else statements?

        if(view == bastionButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.BASTION);
        } else if (view == dVaButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.DVA);
        } else if (view == genjiButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.GENJI);
        } else if (view == hanzoButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.HANZO);
        } else if (view == junkratButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.JUNKRAT);
        } else if (view == lucioButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.LUCIO);
        } else if (view == mcCreeButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.MCCREE);
        } else if (view == meiButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.MEI);
        } else if (view == mercyButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.MERCY);
        } else if (view == pharahButton) {
            getSoundBiteScreenIntent.putExtra("Hero", Hero.PHARAH);
        } else {
            return;
        }

        //Not receiving information from called Activity
        startActivity(getSoundBiteScreenIntent);
    }
}
