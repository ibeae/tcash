package com.appsflyer;

import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
import twitter4j.HttpResponseCode;

public class BackgroundHttpTask extends AsyncTask<String, Void, String> {
    private static final int WAIT_TIMEOUT = 30000;
    private String bodyAsString;
    public Map<String, String> bodyParameters;
    private String content = null;
    private boolean error = false;
    private Context mContext;

    public BackgroundHttpTask(Context context) {
        this.mContext = context;
    }

    protected String doInBackground(String... strArr) {
        try {
            URL url = new URL(strArr[0]);
            LogMessages.logMessageMaskKey("call = " + url + " parameters = " + this.bodyParameters.toString());
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setReadTimeout(WAIT_TIMEOUT);
            httpsURLConnection.setConnectTimeout(WAIT_TIMEOUT);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(this.bodyAsString);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == HttpResponseCode.OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    this.content += readLine;
                }
                AFLogger.afLog("Status 200 ok");
            }
        } catch (MalformedURLException e) {
            AFLogger.afLog("MalformedURLException: " + e.toString());
        } catch (ProtocolException e2) {
            AFLogger.afLog("ProtocolException: " + e2.toString());
        } catch (IOException e3) {
            AFLogger.afLog("IOException: " + e3.toString());
        } catch (Exception e4) {
            AFLogger.afLog("Exception: " + e4.toString());
        }
        return this.content;
    }

    protected void onCancelled() {
    }

    protected void onPostExecute(String str) {
        if (this.error) {
            AFLogger.afLog("Connection error");
        } else {
            AFLogger.afLog("Connection call succeeded");
        }
    }

    protected void onPreExecute() {
        JSONObject jSONObject = new JSONObject(this.bodyParameters);
        if (jSONObject != null) {
            this.bodyAsString = jSONObject.toString();
        }
    }
}
