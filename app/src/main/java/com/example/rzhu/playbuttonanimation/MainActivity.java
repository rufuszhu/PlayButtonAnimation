package com.example.rzhu.playbuttonanimation;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    private View switchButtonIcon;
    private FrameLayout switchButton;
    private boolean isPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchButton = (FrameLayout) findViewById(R.id.btn_switch);
        switchButtonIcon =  findViewById(R.id.tv_morph);
        isPause = false;
        final int animationLength = getResources().getInteger(R.integer.play_btn_animation_length);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPause){
                    switchButtonIcon.setBackground(getResources().getDrawable(R.drawable.switch_btn_stop_vector));
                    ((Animatable) switchButtonIcon.getBackground()).start();
                    switchButton.setBackground(getResources().getDrawable(R.drawable.switch_btn_bg_pause_transition));
                    TransitionDrawable transition = (TransitionDrawable) switchButton.getBackground();
                    transition.startTransition(animationLength);
                    isPause = false;
                }

                else{
                    switchButtonIcon.setBackground(getResources().getDrawable(R.drawable.switch_btn_start_vector));
                    ((Animatable) switchButtonIcon.getBackground()).start();
                    switchButton.setBackground(getResources().getDrawable(R.drawable.switch_btn_bg_resume_transition));
                    TransitionDrawable transition = (TransitionDrawable) switchButton.getBackground();
                    transition.startTransition(animationLength);
                    isPause = true;
                }
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
