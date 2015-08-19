package hoyraksoftware.geoquiz;

/**
 * Created by ptrowski on 4/7/2015.
 */
public class TrueFalse {

        //creating True and False activates
    private int mQuestion;
    private boolean mTrueQuestion;
    public TrueFalse(int question, boolean trueQuestion) //question index and correct answer(boolean)
    {
        mQuestion=question;
        mTrueQuestion=trueQuestion;
    }

    public int getQuestion() {
        return mQuestion;}


    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean getTrueQuestion() {
        return mTrueQuestion;
    }
    public void setTrueQuestion(boolean trueQuestion)
    {
        mTrueQuestion=trueQuestion;
    }
}
