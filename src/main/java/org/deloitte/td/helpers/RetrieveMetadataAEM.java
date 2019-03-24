package org.deloitte.td.helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.deloitte.td.model.Asset;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RetrieveMetadataAEM {

    public static JsonObject retrieveAssetJsonFromAem(String aemAssetPath, String host) {
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jimmyhernandez", "P@ssw0rd123!".toCharArray());
            }
        });

        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        // Install the all-trusting trust manager
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(System.out);
        } catch (KeyManagementException e) {
            e.printStackTrace(System.out);
        }

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        JsonObject aemAssetMetadata = new JsonObject();
        String url = host + aemAssetPath + "/jcr:content/metadata.json";

        String jsonResponse = getHttpResponse(url);
        if (jsonResponse != null) {
            JsonParser jsonParser = new JsonParser();
            return (JsonObject) jsonParser.parse(jsonResponse);
        }

        return null;
    }

    private static String getHttpResponse(String completeUrl) {
        String jsonResponse = null;
        HttpURLConnection conn = null;
        InputStreamReader streamReader = null;
        BufferedReader rd = null;
        try {

            URL url = new URL(completeUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int code = conn.getResponseCode();
            if (code == 200) {
                StringBuilder result = new StringBuilder();
                streamReader = new InputStreamReader(conn.getInputStream());
                rd = new BufferedReader(streamReader);
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                rd.close();
                streamReader.close();
                conn.disconnect();

                jsonResponse = result.toString();

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException e) {
                }
            }
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }

        return jsonResponse;
    }

    public static HashMap<String, JsonObject> retrieveFromAEM(ArrayList<Asset> fromCSV, String host, int iteration) {

        HashMap<String, JsonObject> aemAllAssetsMetadata = new HashMap<>();

        System.out.println("Start of metadata importing from AEM for BATCH " + iteration);

        for (Asset assetFromCSV : fromCSV) {

            if (!assetFromCSV.getCorrupted()) {

                JsonObject aemAssetMetadata = new JsonObject();

                try {

                    Authenticator.setDefault(new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("jimmyhernandez", "P@ssw0rd123!".toCharArray());
                        }
                    });

                    // Create a trust manager that does not validate certificate chains
                    TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }};

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
                            host + "/content/dam/Canada/" + assetFromCSV.getContainer() + "/" + assetFromCSV.getFileName() + "/jcr:content/metadata.json");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    int code = conn.getResponseCode();
                    System.out.println(code + " : " + assetFromCSV.getContainer() + "/" + assetFromCSV.getFileName());

                    if (code == 200) {

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
                        aemAllAssetsMetadata.put(assetFromCSV.getContainer() + "/" + assetFromCSV.getFileName(), aemAssetMetadata);

                    } else {

                        aemAssetMetadata.addProperty("outcome", "fail");
                        aemAllAssetsMetadata.put(assetFromCSV.getContainer() + "/" + assetFromCSV.getFileName(), aemAssetMetadata);

                    }

                } catch (Exception e) {

                    System.out.println(e.getMessage() + " : " + assetFromCSV.getContainer() + "/" + assetFromCSV.getFileName());
                    aemAssetMetadata.addProperty("outcome", "fail");
                    aemAllAssetsMetadata.put(assetFromCSV.getContainer() + "/" + assetFromCSV.getFileName(), aemAssetMetadata);

                }
            }
        }

        System.out.println("End of metadata importing from AEM for BATCH " + iteration);

        return aemAllAssetsMetadata;
    }

}

