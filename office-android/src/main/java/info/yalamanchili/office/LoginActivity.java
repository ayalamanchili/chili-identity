package info.yalamanchili.office;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Map;

import org.json.JSONObject;

import info.chili.android.commons.Base64;
import info.chili.android.http.AsyncHttpPut;
import info.chili.android.http.HttpRequest;
import org.json.JSONException;

public class LoginActivity extends Activity implements View.OnClickListener {

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
        JSONObject entity = new JSONObject();
        try {
            Log.d(OfficeWelcome.TAG, "username" + userNameTb.getText().toString().trim());
            entity.put("username", userNameTb.getText().toString().trim());
            entity.put("passwordHash", passwordTb.getText().toString().trim());
        } catch (JSONException ex) {
           throw new RuntimeException(ex);
        }
        
        HttpRequest request = new HttpRequest(loginUrl(),
                entity.toString(),
                headers());
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

    protected String loginUrl() {
        return OfficeWelcome.baseURL + "admin/login";
    }

    protected Map<String, String> headers() {
        OfficeWelcome.getHeaders().put("Content-Type", "application/json");
        String userpass = userNameTb.getText().toString().trim() + ":" + passwordTb.getText().toString().trim();
        OfficeWelcome.getHeaders().put("Authorization",
                "Basic " + Base64.encodeBytes(userpass.getBytes()));
        return OfficeWelcome.getHeaders();
    }
}
