package lightpath.com.ibuy.presentation.view.QReader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import lightpath.com.ibuy.R;

public class QReaderFragment extends Fragment {
    private Context context;
    Button gen, scan;

    private OnFragmentInteractionListener mListener;
    public QReaderFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_qreader, container, false);
       gen = (Button) view.findViewById(R.id.gen);
       scan = (Button) view.findViewById(R.id.scan);

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent gIntent = new Intent(getContext(), GeneratorActivity.class);
                startActivity(gIntent);
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rIntent = new Intent(getContext(), ReaderActivity.class);
                startActivity(rIntent);
            }
        });
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
