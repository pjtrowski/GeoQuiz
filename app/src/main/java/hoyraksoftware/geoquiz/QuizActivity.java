package hoyraksoftware.geoquiz;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class QuizActivity extends Activity {

    private static final String TAG="QuizActivity";
    private static final String KEY_INDEX="index";

    private  Button mTrueButton;
    private  Button mFalseButton;
    private  Button mNextButton;
    private  Button mPrevButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;


        private TrueFalse[] mQuestionBank=new TrueFalse[]
                {
                        new TrueFalse(R.string.q_ocean,true),
                        new TrueFalse(R.string.q_mideast,false),
                        new TrueFalse(R.string.q_africa,true),
                        new TrueFalse(R.string.q_americas,true),
                        new TrueFalse(R.string.q_asia,false),
                };
    private int mCurrentIndex=0;
    boolean mIsCheater;

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(data==null)
        {
            return;
        }
        mIsCheater=data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_IS_SHOWN,false);}

    private void updateQuestion()
    {
        int question=mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)

            //onCreate method building main components of the application
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreateBundle(Bundle),called");
        setContentView(R.layout.activity_quiz);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB) // subtitle at the top of the screen
        {
        ActionBar actionBar=getActionBar();
        actionBar.setSubtitle("Hoyrak Software");
        }


        mQuestionTextView=(TextView)findViewById(R.id.question_view);//main view
        mTrueButton=(Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,R.string.incorect_toast,Toast.LENGTH_SHORT).show();
                                        }});

        mFalseButton=(Button)findViewById(R.id.false_button); //false button
        mFalseButton.setOnClickListener(new View.OnClickListener()
            {@Override
                 public void onClick(View v){
                Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
            }});

        mNextButton=(Button)findViewById(R.id.next_button); //next button
        mNextButton.setOnClickListener(new View.OnClickListener()
        {@Override
                public void onClick(View v){
           mCurrentIndex = mCurrentIndex + 1;
            updateQuestion();

        }});

        mPrevButton=(Button)findViewById(R.id.prev_button); //prev button
        mPrevButton.setOnClickListener(new View.OnClickListener()
        {@Override
                public void onClick(View v)
            {
                mCurrentIndex=mCurrentIndex-1;
                updateQuestion();
            }});
        mCheatButton=(Button)findViewById(R.id.cheat_button); // cheat button creation
        mCheatButton.setOnClickListener(new View.OnClickListener()
        {@Override
                  public void onClick(View v)
                                            {
                                                Intent i=new Intent(QuizActivity.this,CheatActivity.class);
                                                boolean answerIsTrue=mQuestionBank[mCurrentIndex].getTrueQuestion();
                                                i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE,answerIsTrue);
                                                startActivityForResult(i, 0);
                                            }});

        if (savedInstanceState!=null)
        {
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
        }
              updateQuestion();


    }
    @Override

    public void onSaveInstanceState(Bundle savedInstanceState) /*saving state of the application
                             when user open other application, so I can be resumed when open again*/
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }

                                        //more component of saving state of the application
    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG,"onStart() called");}

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG,"onDestroy called");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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





