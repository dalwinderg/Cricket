package manage.com.i24r.cricket;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchDetail_1 extends Fragment {


    public MatchDetail_1() {
        // Required empty public constructor
    }


    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        view = inflater.inflate(R.layout.fragment_match_detail_1, container, false);
        return view;
    }

}
