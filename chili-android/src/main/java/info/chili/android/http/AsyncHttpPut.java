package info.chili.android.http;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AsyncHttpPut extends AsyncTask<HttpRequest, Integer, String> {

    protected DefaultHttpClient httpclient;
    protected HttpResponse response;
    protected ProgressDialog dialog;
    protected Activity activity;

    public AsyncHttpPut(Activity activity) {
        this.dialog = new ProgressDialog(activity);
        this.activity = activity;
        httpclient = HttpHelper.getHttpClient();
    }

    @Override
    protected void onPreExecute() {
        dialog.setMessage("Loading...");
        dialog.show();
    }

    /**
     *
     * @param requestParams
     * @return
     */
    @Override
    protected String doInBackground(HttpRequest... requestParams) {
        if (requestParams == null || requestParams.length > 1
                || requestParams[0].getHeaders() == null
                || requestParams[0].getUrl() == null) {
            throw new IllegalArgumentException("Invalid request object");
        }
        String result = "";
        HttpRequest request = requestParams[0];
        Log.d(AsyncHttpPut.class.getName(), "HttpPutURL:" + request.getUrl());
        Log.d(AsyncHttpPut.class.getName(), "Content:" + request.getBody());
        Log.d(AsyncHttpPut.class.getName(), "Headers:" + request.getHeaders());
        HttpPut put = new HttpPut(request.getUrl());
        for (String headerKey : request.getHeaders().keySet()) {
            put.setHeader(headerKey, request.getHeaders().get(headerKey));
        }
        try {
            put.setEntity(new StringEntity(request.getBody()));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AsyncHttpPut.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            response = httpclient.execute(put);
        } catch (IOException ex) {
            onNetworkError(ex);
        }
        return result;
    }

    protected void onNetworkError(IOException ex) {
        Toast.makeText(activity, "error connecting...",
                Toast.LENGTH_SHORT).show();
        Log.d("chili-adnroid", "error communicating with server", ex);
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    @Override
    protected void onPostExecute(String result) {
        dialog.dismiss();
        StatusLine status = response.getStatusLine();
        if (response.getEntity() != null) {
            result = HttpHelper.convertResponseBody(response);
        }
        Log.d("y-android", "HttpPut Response code" + status.getStatusCode());
        Log.d("y-android", "result:" + result);
        // http response success
        if (status.getStatusCode() >= 200 && status.getStatusCode() <= 399) {
            Log.d("y-android", "---OnResponse------");
            onResponse(result);
        } // validation errors
        else if (status.getStatusCode() == 400) {
            Log.d("y-android", "---OnValidationErrors------");
            onValidationErrors(result);
        } // http response failure
        else {
            onError(status);
        }
    }

    protected void onError(StatusLine status) {
        Log.d("y-android", "---OnFailure------");
        throw new RuntimeException("http call failed with status code:"
                + status.getStatusCode());
    }

    protected abstract void onResponse(String result);

    // override this to handle validation errors
    protected void onValidationErrors(String errors) {
    }
}
