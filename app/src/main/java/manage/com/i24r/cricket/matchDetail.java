package manage.com.i24r.cricket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class matchDetail extends Activity {
    // Array of strings...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        final Intent intent = getIntent();
        String d=""+intent.getStringExtra("json");
        try {
//            arrlist.toArray(arr)
            final ArrayList<Cricket> ooo=new ArrayList<>();
            JSONObject obj=new JSONObject(d);
            JSONArray o=obj.getJSONArray("matches");
            for(int i=0;i<o.length();i++)
            {
                Cricket c=new Cricket(""+o.getJSONObject(i).getString("team-1")+"<---------->"+o.getJSONObject(i).getString("team-2"),""+o.getJSONObject(i).get("unique_id"));

            ooo.add(c);

            }
            System.out.print(ooo.toArray());
//            ArrayAdapter adapter = new ArrayAdapter<ArrayList<String> >(this,
//                    R.layout.content_activity_main, Collections.singletonList(ooo));

            MatchDetailAdapter adapter = new MatchDetailAdapter(this, ooo);
// Attach the adapter to a ListView



            ListView listView = (ListView) findViewById(R.id.mobile_list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text
                   String v=ooo.get(position).id;
                    Intent i = new Intent(matchDetail.this, ShowMatchDetails.class);
                    i.putExtra("id",v);
                    startActivity(i);

                }
            });

        }catch (Exception e)
        {

        }

    }
}