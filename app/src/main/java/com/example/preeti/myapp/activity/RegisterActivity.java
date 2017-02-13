package com.example.preeti.myapp.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.preeti.myapp.R;
import com.example.preeti.myapp.Services.ChamberService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by preeti on 1/24/2017.
 */
/*
TextView txt
EditText ed
ListView ls
Layout lay
ScrollView  scr
Button btn
RadioButton rad
CheckBox chk
 */
public class RegisterActivity extends BaseActivity {

    EditText edtFirstName,edtLastName,edtEmail,edtPassword,edtCompany,edtPhone;
    TextView txtShowPassword,txtMemberView,txtNotificationView,txtPrivacyPolicy,txtLogin;
    RadioButton radYesMember,radNoMember,radYesNotification,radNoNotification;
    Button btnSignUp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        LocalBroadcastManager.getInstance(this).registerReceiver(reciever,
                new IntentFilter("logged"));
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtEmail = (EditText) findViewById(R.id.edtEmail_Id);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        txtShowPassword = (TextView) findViewById(R.id.txtShowPassword);
        edtCompany = (EditText) findViewById(R.id.edtCompany);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        txtMemberView = (TextView) findViewById(R.id.txtMember);
        radYesMember = (RadioButton) findViewById(R.id.radYesMember);
        radNoMember = (RadioButton) findViewById(R.id.radNoMember);
        txtNotificationView = (TextView) findViewById(R.id.txtNotificationView);
        radYesNotification = (RadioButton) findViewById(R.id.radYesNotification);
        radNoNotification = (RadioButton) findViewById(R.id.radNoNotification);
        txtPrivacyPolicy = (TextView) findViewById(R.id.txtPrivacyPolicy);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        txtLogin = (TextView) findViewById(R.id.txtLoginView);

//        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Registration</font>"));
        setTitle(R.string.registration);
//        getSupportActionBar().setTitle(R.string.registration);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkFieldValidation())
                {
                    return;
                }
                else {
//                    ChamberService.setLogin(true);
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                }
            }
        });

        txtShowPassword.setOnClickListener(new View.OnClickListener() {
            boolean click=true;
            @Override
            public void onClick(View v) {
                if (click)
                {
                    edtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    txtShowPassword.setText("Hide Password");
                    click=false;
                }
                else
                {
                    edtPassword.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    txtShowPassword.setText("Show Password");
                    click = true;
                }
            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });

    }



        public boolean checkFieldValidation()
        {
            boolean valid=true;

            if(edtFirstName.getText().toString().equals(""))
            {
                edtFirstName.setError("Please enter first name");
                valid=false;
            }
            else if(edtLastName.getText().toString().equals(""))
            {
                edtLastName.setError("Please enter last name");
                valid=false;
            }
            else if(edtEmail.getText().toString().equals(""))
            {
                edtEmail.setError("Please enter email");
                valid = false;
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()) {
                edtEmail.setError("Please enter valid email");
                valid = false;
            }
            else if(edtPassword.getText().toString().equals(""))
            {
                edtPassword.setError("Please enter password ");
                valid = false;
            }
            else if(edtPassword.getText().toString().length()<5)
            {
                edtPassword.setError("Minimum length is 5");
                valid=false;
            }
            else if(edtPhone.getText().toString().equals(""))
            {
                edtPhone.setError("Please enter phone number");
                valid=false;
            }
            else if(edtCompany.getText().toString().equals(""))
            {
                edtCompany.setError("Please enter company name");
                valid = false;
            }
            return valid;
        }

    private BroadcastReceiver reciever = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };


   /*  public void finish() {
        super.finish();
    }*/


    }

