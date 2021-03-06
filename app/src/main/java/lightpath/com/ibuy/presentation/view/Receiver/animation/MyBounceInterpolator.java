package lightpath.com.ibuy.presentation.view.Receiver.animation;

/**
 * Created by LUIS on 08/03/2017.
 */

public class MyBounceInterpolator implements android.view.animation.Interpolator {

    double mAmplitude=1;
    double mFrequency=10;

    public MyBounceInterpolator(double amplitude, double frequency){
        mAmplitude=amplitude;
        mFrequency=frequency;
    }

    @Override
    public float getInterpolation(float v) {
        return (float) (-1 * Math.pow(Math.E, -v/ mAmplitude) * Math.cos(mFrequency * v) + 1);
    }
}
