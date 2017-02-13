package com.example.preeti.myapp.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.preeti.myapp.Content.User;
import com.example.preeti.myapp.R;
import com.example.preeti.myapp.Services.ChamberService;
import com.example.preeti.myapp.api.BaseServiceable;
import com.example.preeti.myapp.api.LoginApi;

/**
 * Created by preeti on 1/26/2017.
 */

public class LoginActivity extends BaseActivity {

    EditText edtEmail, edtPassword;
    TextView txtSignUpView;
    Button btnLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LocalBroadcastManager.getInstance(this).registerReceiver(reciever,
                new IntentFilter("logged"));
        edtEmail = (EditText) findViewById(R.id.edtEmailId);
        edtPassword = (EditText) findViewById(R.id.edtPasswordlogin);
        txtSignUpView = (TextView) findViewById(R.id.txtSignUp);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        setTitle(R.string.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (checkValidation()) {
                    LoginApi login = new LoginApi(getActivity());
                    login.setEmail(edtEmail.getText().toString()).setPassword(edtPassword.getText().toString()).setGcmId(regID).runAsync(loginApi);
                    //ChamberService.setLogin(true);
                   // Intent i = new Intent(getActivity(), MainActivity.class);
                    //startActivity(i);
                }

            }
        });
        txtSignUpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RegisterActivity.class));
            }
        });

    }

    public boolean checkValidation() {
        boolean validField = true;
        if (TextUtils.isEmpty(getEditTextData(edtEmail))) {
            edtEmail.setError("Please enter email");
            validField = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()) {
            edtEmail.setError("Please enter valid email");
            validField = false;
        } else if (TextUtils.isEmpty(getEditTextData(edtPassword))) {
            edtPassword.setError("Please enter password ");
            validField = false;
        }
        return validField;
    }

    User user;
    private BaseServiceable.OnApiFinishListener<LoginApi> loginApi = new BaseServiceable.OnApiFinishListener<LoginApi>() {
        @Override
        public void onComplete(LoginApi loginApi) {

            if (loginApi.isValidResponse()){
               // user=loginApi.getDetail();
               /*txtSignUpView.setText(user.getFirstname()+" "+user.getLastname()+" " +
                        ""+user.getEmail());*/
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);

            }
           /* else
            {
                txtSignUpView.setText("error");
            }*/

        }
    };


    private BroadcastReceiver reciever = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };


}