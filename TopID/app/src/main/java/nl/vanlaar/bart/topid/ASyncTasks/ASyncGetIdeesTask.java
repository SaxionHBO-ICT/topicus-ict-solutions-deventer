package nl.vanlaar.bart.topid.ASyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import nl.vanlaar.bart.topid.Controller.JSONParser;
import nl.vanlaar.bart.topid.Model.Idee;

/**
 * Created by bart on 15-6-2016.
 */
public class ASyncGetIdeesTask extends AsyncTask<Void,Void,JSONArray> {
    @Override
    protected JSONArray doInBackground(Void... voids) {
        JSONArray jsonArray = null;
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL("http://localhost:1234/idee");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
            os.close();
            int responsecode = connection.getResponseCode();
            Log.d("response code ",""+ responsecode);
            if(responsecode == 200){
                InputStream inputStream = connection.getInputStream();

                jsonArray = new JSONArray(inputStream.toString());
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
