package org.Application.Requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connection {

    public static String openConnection(String urlToRequest) throws Exception {
        URL url = new URL(urlToRequest);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        String receptor = "";
        StringBuilder json = new StringBuilder();
        while ( (receptor = br.readLine()) != null){
            json.append(receptor).append('\n');
        }
        return json.toString();
    }

}
