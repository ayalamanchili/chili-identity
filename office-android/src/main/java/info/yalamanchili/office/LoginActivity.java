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

import org.json.JSONObject;

import info.chili.android.http.AsyncHttpPut;
import info.chili.android.http.HttpRequest;
import org.json.JSONException;

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
    }

    protected void postCreateSuccess(String result) {
        try {
            JSONObject user = new JSONObject(result);
//            initUserRoles(user);
            Intent intent = new Intent(this, OfficeWelcome.class);
            startActivity(intent);
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.equals(loginB)) {
            loginClicked();
        }
    }

    protected void loginClicked() {
        //set username and password
        OfficeConfig.username = userNameTb.getText().toString().trim();
        OfficeConfig.password = passwordTb.getText().toString().trim();
        JSONObject entity = new JSONObject();
        try {
            Log.d(OfficeConfig.TAG, "username" + userNameTb.getText().toString().trim());
            entity.put("username", userNameTb.getText().toString().trim());
            entity.put("passwordHash", passwordTb.getText().toString().trim());
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }

        HttpRequest request = new HttpRequest(loginUrl(),
                entity.toString(),
                OfficeConfig.getHeaders());
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
            protected void onValidationErrors(String errorsString) {
            }
        }.execute(request);
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
}
