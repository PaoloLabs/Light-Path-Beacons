package lightpath.com.ibuy.presentation.view.Receiver;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.AnimateGifMode;

import lightpath.com.ibuy.R;

public class ReceiverFragment extends Fragment {
    private Context context;
    private ImageView imgReceiver;

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
        Ion.with(imgReceiver)
                .error(R.mipmap.ic_launcher)
                .animateGif(AnimateGifMode.ANIMATE)
                .load("android.resource://"+context.getPackageName()+"/"+ R.drawable.sync)
                .withBitmapInfo();
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
}
