package nl.vanlaar.bart.topid.ASyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import nl.vanlaar.bart.topid.Controller.JSONParser;
import nl.vanlaar.bart.topid.Model.Idee;

/**
 * Custom AsyncTask om ideeën mee op te vragen.
 */
public class ASyncGetIdeesTask extends AsyncTask<Void,Void,JSONArray> {
    @Override
    protected JSONArray doInBackground(Void... voids) {
        JSONArray jsonArray = null;
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL("http://145.2.236.128:1234/idee");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(9999);
            int responsecode = connection.getResponseCode();
            Log.d("response code ",""+ responsecode);
            Log.d("response",connection.getInputStream().toString());
            if(responsecode == 200){
                InputStream inputStream = connection.getInputStream();
                jsonArray = new JSONArray(IOUtils.toString(inputStream, "UTF-8"));
                Log.d("json array",jsonArray.toString());
                connection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray ;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        super.onPostExecute(jsonArray);
      JSONParser parser = new JSONParser();
        ArrayList<Idee> lijst = parser.jsonToIdeeënLijst(jsonArray);
        Log.d("lijst lengte",""+ lijst.size());
    }
}
