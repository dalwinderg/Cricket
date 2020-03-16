package manage.com.i24r.cricket;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {

    public static String urlgetmatch="https://cricapi.com/api/matches?apikey=pxHW5UucDVSnou7KdVAazOLEI692";
    public static String urlgetmatchSingleDetails="https://cricapi.com/api/cricketScore?apikey=pxHW5UucDVSnou7KdVAazOLEI692&unique_id=";
    public static String urlgetmatchPlayerdetailsDetails="https://cricapi.com/api/playerFinder?apikey=pxHW5UucDVSnou7KdVAazOLEI692&name=";

    public static String datajson="";
    public static String readResponse(HttpResponse res) {
        InputStream is=null;
        String return_text="";
        try {
            is=res.getEntity().getContent();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
            String line="";
            StringBuffer sb=new StringBuffer();
            while ((line=bufferedReader.readLine())!=null)
            {
                sb.append(line);
            }
            return_text=sb.toString();
            is.close();
            bufferedReader.close();
//            Log.d("Response",""+return_text);
        } catch (Exception e)
        {
//            Log.d("Response Er",""+e);
        }
        return return_text;


    }

}
