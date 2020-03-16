package manage.com.i24r.cricket;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class PlayerDetails extends Fragment {


    private Context mContext;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        view = inflater.inflate(R.layout.fragment_player_details, container, false);

        getplayerdetails(Util.datajson);



        // Inflate the layout for this fragment
        return view;

    }





    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }


    public void getplayerdetails(String id) {

        RequestQueue queue = Volley.newRequestQueue(mContext);
        try {

            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, Util.urlgetmatchPlayerdetailsDetails+""+id, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response) {
                            // display response
try {


                            final ArrayList<Cricket> ooo=new ArrayList<>();
                            JSONObject obj=new JSONObject(response.toString());
                            JSONArray o=obj.getJSONArray("data");
                            for(int i=0;i<o.length();i++)
                            {
                                Cricket c=new Cricket(""+o.getJSONObject(i).getString("fullName"),"");
                                ooo.add(c);

                            }


                            MatchDetailAdapter adapter = new MatchDetailAdapter(getActivity(), ooo);
                            ListView listView = (ListView) view.findViewById(R.id.mobile_list_1);
                            listView.setAdapter(adapter);
}catch (Exception e)
{

}

                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }
            );
            queue.add(getRequest);


        } catch (Exception exception) {
            Log.d("Chak", "" + exception);
        }
    }
}
