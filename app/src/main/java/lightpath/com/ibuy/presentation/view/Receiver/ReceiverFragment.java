package lightpath.com.ibuy.presentation.view.Receiver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import lightpath.com.ibuy.R;
import lightpath.com.ibuy.presentation.view.Products.ProductsActivity;
import lightpath.com.ibuy.presentation.view.Receiver.animation.MyBounceInterpolator;

import static java.security.AccessController.getContext;

public class ReceiverFragment extends Fragment {
    private Context context;
    private ImageView imgReceiver;

    private ImageView b1;
    private ImageView b2;
    private ImageView b3;
    private ImageView b4;
    private ImageView b5;
    private ImageView b6;
    private ImageView b7;

    private OnFragmentInteractionListener mListener;

    public ReceiverFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_receiver, container, false);
        imgReceiver=(ImageView)view.findViewById(R.id.receiver_imgReceiver);
        imgReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(), ProductsActivity.class);
                startActivity(i);

            }
        });

        b1=(ImageView)view.findViewById(R.id.receiver_imgb1);
        b2=(ImageView)view.findViewById(R.id.receiver_imgb2);
        b3=(ImageView)view.findViewById(R.id.receiver_imgb3);
        b4=(ImageView)view.findViewById(R.id.receiver_imgb4);
        b5=(ImageView)view.findViewById(R.id.receiver_imgb5);
        b6=(ImageView)view.findViewById(R.id.receiver_imgb6);
        b7=(ImageView)view.findViewById(R.id.receiver_imgb7);
        animateButton();
        /**Ion.with(imgReceiver)
                .error(R.mipmap.ic_launcher)
                .animateGif(AnimateGifMode.ANIMATE)
                .load("android.resource://"+context.getPackageName()+"/"+ R.drawable.sync)
                .withBitmapInfo();*/
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    void moveCenter(ImageView img){
        final Animation animationCenter=new TranslateAnimation(0,200,0,0);
        animationCenter.setDuration(500);
        animationCenter.setFillAfter(true);
        img.startAnimation(animationCenter);
        moveOut(img);
    }

    void moveOut(ImageView img){
        final Animation animationCenter=new TranslateAnimation(200,0,0,0);
        animationCenter.setDuration(500);
        animationCenter.setFillAfter(true);
        img.startAnimation(animationCenter);
        //moveCenter(img);
    }

    void animateButton() {

        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
        double animationDuration =2* 1000;
        myAnim.setDuration((long)animationDuration);

        // Use custom animation interpolator to achieve the bounce effect
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        imgReceiver.startAnimation(myAnim);
        // Animate the button
        /*b1.startAnimation(myAnim);
        b2.startAnimation(myAnim);
        b3.startAnimation(myAnim);
        b4.startAnimation(myAnim);
        b5.startAnimation(myAnim);
        b6.startAnimation(myAnim);
        b7.startAnimation(myAnim);*/
        // Run button animation again after it finished
        myAnim.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {}

            @Override
            public void onAnimationRepeat(Animation arg0) {}

            @Override
            public void onAnimationEnd(Animation arg0) {
                animateButton();
            }
        });
    }
}
