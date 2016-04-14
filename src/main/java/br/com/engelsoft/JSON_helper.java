/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.engelsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

/**
 *
 * @author fosa
 */
public class JSON_helper {

    public static String getJsonUrl(String URL, String Auth) {
        String ret = "";

        String https_url = URL;
        URL url;
        try {

            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            con.setRequestProperty("Authorization", Auth);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                ret += input;
            }
            br.close();

            System.out.println(ret);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ConnectException e) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, "Exgotou o tempo de resposta");
            System.out.println("");
        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();

        }

        return ret;
    }

    public static String getJsonUrl(String URL) {
        String ret = "";

        String https_url = URL;
        URL url;
        try {

            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                ret += input;
            }
            br.close();

            System.out.println(ret);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ConnectException e) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, "Exgotou o tempo de resposta");
            System.out.println("");
        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();

        }

        return ret;
    }

    public static String postToUrl(String URL, String Auth, JSONObject post) {
        String ret = "";

        String https_url = URL;
        URL url;
        try {

            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            con.setRequestProperty("Authorization", Auth);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.connect();

//          Send post
            System.out.println(post.toString());

            byte[] outputBytes = post.toString().getBytes("UTF-8");
            OutputStream os = con.getOutputStream();
            os.write(outputBytes);
            os.close();

//            get response
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                ret += input;
            }
            br.close();

            System.out.println(ret);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            ex.printStackTrace();
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static String postToUrl(String URL, JSONObject post) {
        String ret = "";

        String http_url = URL;
        URL url;
        try {

            url = new URL(http_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.connect();

//          Send post
            System.out.println(post);

            byte[] outputBytes = post.toString().getBytes("UTF-8");
            OutputStream os = con.getOutputStream();
            os.write(outputBytes);
            os.close();

//            get response
            if (con.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String input;
                while ((input = br.readLine()) != null) {
                    ret += input;
                }
                br.close();
            } else {
                System.out.println("Erro na requisiçao code " + con.getResponseCode());
                        
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String input;
                while ((input = br.readLine()) != null) {
                    ret += input;
                }
                br.close();
            }

            System.out.println(ret);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
