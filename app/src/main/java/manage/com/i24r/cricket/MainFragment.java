package manage.com.i24r.cricket;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainFragment extends Fragment {

    Button button, findplayer;
    View view;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        view = inflater.inflate(R.layout.fragment_main1, container, false);

        button = view.findViewById(R.id.button);
        findplayer = view.findViewById(R.id.findplayer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                ((Main3Activity) getActivity()).replaceFragments(new matchDetail());
        }
        });

        findplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText taskEditText = new EditText(mContext);
                AlertDialog dialog = new AlertDialog.Builder(mContext)
                        .setTitle("Search Player")
                        .setMessage("Search Player By Name")
                        .setView(taskEditText)
                        .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());

                                Util.datajson=task;
                                ((Main3Activity) getActivity()).replaceFragments(new PlayerDetails());
//

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

}
