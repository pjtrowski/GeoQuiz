package hoyraksoftware.geoquiz;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ptrowski on 8/13/2015.
 */
public class CheatActivity extends Activity {

        private boolean mAnswerIsTrue;
        private TextView mAnswerTextView;
        private Button mShowAnswer;

        public static final String EXTRA_ANSWER_IS_TRUE="com.bignerdranch.android.geoquiz.answer_is_true";
        public static final String EXTRA_ANSWER_IS_SHOWN="com.bignerdranch.android.geoquiz.answer_shown";

        private void setAnswerShownResult(boolean isAnswerShown)
        {
            Intent data = new Intent();
            data.putExtra(EXTRA_ANSWER_IS_SHOWN,isAnswerShown);
            setResult(RESULT_OK,data);

        }


        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            setAnswerShownResult(false);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cheat);
            mAnswerIsTrue =getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
            mAnswerTextView =(TextView)findViewById(R.id.answerTextView);
            mShowAnswer=(Button)findViewById(R.id.showAnswerButton);
            mShowAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mAnswerIsTrue) {
                        mAnswerTextView.setText(R.string.true_button);
                    } else {
                        mAnswerTextView.setText(R.string.false_button);
                    }
                    setAnswerShownResult(true);
                }
            });
        }
}
