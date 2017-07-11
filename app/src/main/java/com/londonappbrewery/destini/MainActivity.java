package com.londonappbrewery.destini;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.color;
import static android.R.attr.endColor;
import static android.R.attr.id;
import static com.londonappbrewery.destini.R.color.colorEnd;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
        } else {
            mStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:



        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        if (mStoryIndex == 1){
            displayStory1();
        } else if(mStoryIndex == 2){
            displayStory2();
        } else if (mStoryIndex == 3){
            displayStory3();
        }


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mStoryIndex == 1) {
                    displayStory3();
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    displayT6End();
                    mStoryIndex = 6;
                } else if (mStoryIndex == 2) {
                    displayStory3();
                    mStoryIndex = 3;
                }

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mStoryIndex == 1) {
                    displayStory2();
                    mStoryIndex = 2;
                } else if (mStoryIndex == 3) {
                    displayT5End();
                    mStoryIndex = 6;
                } else if (mStoryIndex == 2) {
                    displayT4End();
                    mStoryIndex = 6;
                } else if (mStoryIndex == 6) {
                    finish();
                }

            }
        });

    }

    private void displayStory3(){
        mStoryTextView.setText(R.string.T3_Story);
        mTopButton.setText(R.string.T3_Ans1);
        mBottomButton.setText(R.string.T3_Ans2);
    }

    private  void displayT4End() {
        mStoryTextView.setText(R.string.T4_End);
        mTopButton.setVisibility(View.GONE);
        mBottomButton.setText(R.string.GameOver);
        mBottomButton.setBackgroundResource(R.color.colorEnd);
        
    }

    private  void displayT5End() {
        mStoryTextView.setText(R.string.T5_End);
        mTopButton.setVisibility(View.GONE);
        mBottomButton.setText(R.string.GameOver);
        mBottomButton.setBackgroundResource(R.color.colorEnd);

       // mBottomButton.setBackgroundColor(0xFF4081);
    }

    private  void displayT6End() {
        mStoryTextView.setText(R.string.T6_End);
        mTopButton.setVisibility(View.GONE);
        mBottomButton.setText(R.string.GameOver);
        mBottomButton.setBackgroundResource(R.color.colorEnd);

       // mBottomButton.setBackgroundColor(0xFF4081);
    }

    private void displayStory2() {
        mStoryTextView.setText(R.string.T2_Story);
        mTopButton.setText(R.string.T2_Ans1);
        mBottomButton.setText(R.string.T2_Ans2);
    }

    private void displayStory1() {
        mStoryTextView.setText(R.string.T1_Story);
        mTopButton.setText(R.string.T1_Ans1);
        mBottomButton.setText(R.string.T1_Ans2);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndex", mStoryIndex);
    }


}
