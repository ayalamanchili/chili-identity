package info.yalamanchili.office;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import info.chili.android.commons.Base64;

import org.json.JSONObject;

import info.chili.android.http.AsyncHttpPut;
import info.chili.android.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.StatusLine;

public class LoginActivity extends Activity implements View.OnClickListener {

    public static SharedPreferences preferences;
    EditText userNameTb;
    EditText passwordTb;
    Button loginB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the layout
        setContentView(R.layout.login);
        //assign the fields
        userNameTb = (EditText) findViewById(R.id.login_usernameTb);
        passwordTb = (EditText) findViewById(R.id.login_passwordTb);
        loginB = (Button) findViewById(R.id.login_loginB);
        //add listner
        loginB.setOnClickListener(this);
        //preferecnes
        initPreferences();
        populateUsername();
    }

    protected void populateUsername() {
        String username = preferences.getString("username", "NA");
        if (username.equals("NA")) {
            username = null;
        }
        if (username != null) {
            userNameTb.setText(username);
        }
    }

    protected void saveUsername() {
        String username = preferences.getString("username", "NA");
        if (username.equals("NA")) {
            username = null;
        }
        SharedPreferences.Editor prefEditor = preferences.edit();
        if (username == null) {
            prefEditor.putString("username", OfficeConfig.username);
            prefEditor.commit();
        } else if (!OfficeConfig.username.equals(username)) {
            prefEditor.putString("username", OfficeConfig.username);
            prefEditor.commit();
        }
    }

    protected void postCreateSuccess(String result) {
        //set username and password
        OfficeConfig.username = userNameTb.getText().toString().trim();
        OfficeConfig.password = passwordTb.getText().toString().trim();
        saveUsername();
        JSONObject user = JSONUtils.getObject(result);
//            initUserRoles(user);
        Intent intent = new Intent(this, OfficeWelcome.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(loginB)) {
            loginClicked();
        }
    }

    protected void loginClicked() {
        if (!validate()) {
            return;
        }
        JSONObject entity = new JSONObject();
        JSONUtils.putValue(entity, "username", userNameTb.getText().toString().trim());
        JSONUtils.putValue(entity, "passwordHash", passwordTb.getText().toString().trim());
        HttpRequest request = new HttpRequest(loginUrl(),
                entity.toString(), getHeaders());
        new AsyncHttpPut(this) {
            @Override
            protected void onResponse(String result) {
                Toast.makeText(LoginActivity.this, "Login Success",
                        Toast.LENGTH_LONG);
                postCreateSuccess(result);
                //TODO Should this be called here or at the impl activity
                finish();
            }

            @Override
            protected void onError(StatusLine status) {
                if (status.getStatusCode() == 401) {
                    //TODO change this to alert
                    Toast.makeText(LoginActivity.this, "incorrect username or password. please try again",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }.execute(request);
    }

    protected boolean validate() {
        if (userNameTb.getText() == null || passwordTb.getText() == null || userNameTb.getText().toString().trim().length() < 1 || passwordTb.getText().toString().trim().length() < 1) {
            Toast.makeText(LoginActivity.this, "username and password are required",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    protected void initPreferences() {
        if (preferences == null) {
            PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        }
        preferences = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.portal_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu_preferences:
                Intent prefActitvity = new Intent(this,
                        OfficePreferencesActivity.class);
                startActivity(prefActitvity);
                break;
        }
        return true;
    }

    public static String getEndpoint() {
        return preferences.getString("endpoint", "NA");
    }

    public static String getContextPath() {
        return preferences.getString("contextPath", "NA");
    }

    protected String loginUrl() {
        return OfficeConfig.getBaseUrl() + "admin/login";
    }

    public Map<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        String userpass = userNameTb.getText().toString().trim() + ":" + passwordTb.getText().toString().trim();
        headers.put("Authorization",
                "Basic " + Base64.encodeBytes(userpass.getBytes()));
        return headers;
    }
}
