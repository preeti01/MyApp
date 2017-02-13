package com.example.preeti.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by preeti on 1/27/2017.
 */

public class BaseActivity extends AppCompatActivity {
    public final BaseActivity getActivity() {
        return this;
    }

    String regID="1234";

    public final void setTitle(String title) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(title);
    }
public final String getEditTextData(EditText editText){
    if(editText==null)
        return  null;
    return editText.getText().toString().trim();
}
    public final void setTitle(int resId) {
        setTitle(getString(resId));
    }
}
