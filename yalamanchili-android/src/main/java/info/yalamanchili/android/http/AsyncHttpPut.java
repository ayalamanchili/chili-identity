package info.yalamanchili.android.http;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public abstract class AsyncHttpPut extends AsyncTask<String, Integer, String> {
	protected DefaultHttpClient httpclient;
	protected HttpResponse response;
	protected ProgressDialog dialog;

	public AsyncHttpPut(Activity activity) {
		dialog = new ProgressDialog(activity);
		httpclient = HttpHelper.getHttpClient();
	}

	@Override
	protected void onPreExecute() {
		dialog.setMessage("Loading...");
		dialog.show();
	}

	@Override
	protected String doInBackground(String... params) {
		String result = "";
		Log.d("y-android", "HttpPutURI:" + params[0]);
		Log.d("y-android", "Content:" + params[1]);
		try {
			HttpPut put = new HttpPut(params[0]);
			put.setHeader("content-type", "application/json");
			put.setEntity(new StringEntity(params[1]));
			response = httpclient.execute(put);
		} catch (Exception e) {
			throw new RuntimeException("Http Put called failed for uri:"
					+ params[0] + e);
		}
		return result;
	}

	protected void onProgressUpdate(Integer... progress) {

	}

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
		}
		// validation errors
		else if (status.getStatusCode() == 400) {
			Log.d("y-android", "---OnValidationErrors------");
			onValidationErrors(result);
		}
		// http response failure
		else {
			Log.d("y-android", "---OnFailure------");
			throw new RuntimeException("http call failed with status code:"
					+ status.getStatusCode());
		}
	}

	protected abstract void onResponse(String result);

	// override this to handle validation errors
	protected void onValidationErrors(String errors) {

	}

}
