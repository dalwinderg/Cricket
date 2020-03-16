package manage.com.i24r.cricket;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import java.util.Collections;

public class matchDetail  extends Fragment
{

    Button btn;



    Button button, findplayer;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        view = inflater.inflate(R.layout.activity_match_detail, container, false);

        getmatchdetails();



        // Inflate the layout for this fragment
        return view;
    }

    public void getmatchdetails() {

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        try {

            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, Util.urlgetmatch, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response) {
                            // display response
                            Log.d("Response", response.toString());

                            try {
            final ArrayList<Cricket> ooo=new ArrayList<>();
            JSONObject obj=new JSONObject(response.toString());
            JSONArray o=obj.getJSONArray("matches");
            for(int i=0;i<o.length();i++)
            {
                Cricket c=new Cricket(""+o.getJSONObject(i).getString("team-1")+"<---------->"+o.getJSONObject(i).getString("team-2"),""+o.getJSONObject(i).get("unique_id"));

                ooo.add(c);

            }
            System.out.print(ooo.toArray());

            MatchDetailAdapter adapter = new MatchDetailAdapter(getActivity(), ooo);
            ListView listView = (ListView) view.findViewById(R.id.mobile_list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text
                    String v=ooo.get(position).id;
                    Intent i = new Intent(getActivity(), ShowMatchDetails.class);
                    i.putExtra("id",v);
                    startActivity(i);

                }
            });

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
