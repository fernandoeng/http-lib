/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engelsoft.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fosa
 */
public class HTTP_helper {

    public static String getHttpUrl(String URL) {
        String ret = "";

        String https_url = URL;
        URL url;
        try {

            url = new URL(https_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                ret += input;
            }
            br.close();

            System.out.println(ret);

        } catch (MalformedURLException e) {
            Logger.getLogger(HTTP_helper.class.getName()).log(Level.SEVERE, null, e);
        } catch (ConnectException e) {
            Logger.getLogger(HTTP_helper.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(HTTP_helper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }
}
