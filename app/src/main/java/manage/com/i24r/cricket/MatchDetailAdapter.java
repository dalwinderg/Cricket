package manage.com.i24r.cricket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MatchDetailAdapter extends ArrayAdapter<Cricket> {

public MatchDetailAdapter(Context context, ArrayList<Cricket> users) {
        super(context, 0, users);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Cricket user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.content_activity_main, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.label);

        tvName.setText(user.match);
        // Return the completed view to render on screen
        return convertView;
        }
        }