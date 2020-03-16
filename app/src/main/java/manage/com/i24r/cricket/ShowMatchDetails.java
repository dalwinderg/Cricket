package manage.com.i24r.cricket;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowMatchDetails extends AppCompatActivity {

    TextView t;
    TextView t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_match_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Intent intent = getIntent();
         t=findViewById(R.id.stat);
         t1=findViewById(R.id.score);
         t2=findViewById(R.id.details);




        String d=""+intent.getStringExtra("id");



       getmatchdetails(d);
    }


    public void getmatchdetails(String id) {
        Log.d("Response", id);
        RequestQueue queue = Volley.newRequestQueue(this);
        try {

            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, Util.urlgetmatchSingleDetails+""+id, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response) {
                            // display response
                            Log.d("Response", response.toString());
                            try {
                                JSONObject o=new JSONObject(response.toString());

                                t.setText(o.getString("stat"));
                                t1.setText(o.getString("score"));
                                t2.setText(o.getString("description"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//                            Intent i = new Intent(MainActivity.this, matchDetail.class);
//                            i.putExtra("json",response.toString());
//                            startActivity(i);

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
