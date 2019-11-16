package Providers;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import model.Film;

public class ReadInformation {
    public static final String URL_SWAPI = "https://swapi.co/api/films/";

    private ArrayList <Film> listOfFilms;

    public ArrayList<Film> getAllFilms () {
        listOfFilms = new ArrayList<Film>();
        callWebService();
        return listOfFilms;

    }

    public void callWebService() {
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        URL urlService = new URL(URL_SWAPI);
                        HttpsURLConnection connection = (HttpsURLConnection) urlService.openConnection();
                        connection.setRequestMethod("GET");
                        InputStream responseBody = connection.getInputStream();

                        if (connection.getResponseCode() == 200) {
                            // Success
                            InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                            BufferedReader b = new BufferedReader(responseBodyReader);
                            String s = b.readLine();
                            System.out.println(s);
                            try {
                                saveData(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            // Error handling code goes here
                            Log.v("ERROR", "ERROR");
                        }

                    } catch (MalformedURLException e) {
                        System.out.println("Handle the error u bitch x2");
                        e.printStackTrace();
                    } catch (IOException e) {
                        System.out.println("Handle the error u bitch");
                        e.printStackTrace();
                    }
                }
            });


    }


    public void saveData(String s)throws JSONException {
        JSONObject obj = new JSONObject(s);
        JSONArray arr = obj.getJSONArray("results");
        System.out.println(arr.length());
        for (int i = 0; i < arr.length(); i++) {
            String title = arr.getJSONObject(i).getString("title");
            String episode_id = "Episode "+ arr.getJSONObject(i).getString("episode_id");
            String director = arr.getJSONObject(i).getString("director");
            String opening_crawl = arr.getJSONObject(i).getString("opening_crawl").replace("\r\n\r\n","77777777").replace("\r\n"," ").replace("77777777","\r\n\r\n");
            listOfFilms.add(new Film(title, episode_id, opening_crawl, director));
        }


    }
}
