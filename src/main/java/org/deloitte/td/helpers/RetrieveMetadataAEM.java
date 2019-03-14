package org.deloitte.td.helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class RetrieveMetadataAEM {

    public static JsonObject retrieveFromAEM() {


        JsonObject aemAssetMetadata = new JsonObject();

        try {

            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("jimmyhernandez", "P@ssw0rd123!".toCharArray());
                }
            });

            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            } };

            // Install the all-trusting trust manager
            SSLContext sc = null;
            try {
                sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            URL url = new URL(
                    "https://13.88.236.91/content/dam/Canada/Insurance/general-insurance/home-auto/AMG/5924-0119_AMG_AD-St_Lawrence_JAN29.zip/jcr:content/metadata.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            int code = conn.getResponseCode();

            System.out.println(code);

            StringBuilder result = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            rd.close();

            JsonParser jsonParser = new JsonParser();
            aemAssetMetadata = (JsonObject) jsonParser.parse(result.toString());
            aemAssetMetadata.addProperty("outcome", "success");
            System.out.println(aemAssetMetadata.toString());

//            System.out.println("dam:sha1" + jo.get("dam:sha1"));

            // if (resultSha1.equals(jo.get("dam:sha1"))) {
            // System.out.println("true");
            // } else {
            // System.out.println("false");
            // }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            aemAssetMetadata.addProperty("outcome", "fail");
        } catch (IOException e) {
            e.printStackTrace();
            aemAssetMetadata.addProperty("outcome", "fail");
        }


        return aemAssetMetadata;
    }

}

