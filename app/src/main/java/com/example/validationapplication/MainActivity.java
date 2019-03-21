package com.example.validationapplication;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.spark.submitbutton.SubmitButton;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout emailtext;
    private TextView label;
    private SubmitButton confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailtext = (TextInputLayout)  findViewById(R.id.emailID);
        label =   (TextView) findViewById(R.id.labelID);
        confirm = (SubmitButton) findViewById(R.id.confirmID);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(emailtext.getEditText().getText().toString().trim());
            }
        });
    }
    private void validate(String email){
        if(email.contains("@")){
                label.setText("VALID");
        }else if(email.isEmpty()){

            emailtext.setError("Enter Email");
        } else{

            label.setText("INVALID");
        }
    }
}
