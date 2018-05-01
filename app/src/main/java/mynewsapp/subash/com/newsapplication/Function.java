package mynewsapp.subash.com.newsapplication;

import android.content.Context;
import android.net.ConnectivityManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Crazyartist on 3/13/2018.
 */

public class Function {

    // checking up the internet connection
    public static boolean isNetworkAvailable(Context context) {

        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    // Url execution
    public static String executeGet(String targetURL, String urlparameters) {
        URL url;
        HttpURLConnection connection = null;

        try {
            // create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();

            //connection.setRequestMethod("POST");
            //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("GET");
            connection.connect();


            InputStream is;
            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                is = connection.getErrorStream();
            } else {
                is = connection.getInputStream();
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();

            return response.toString();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


     finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return  null;
    }


}
