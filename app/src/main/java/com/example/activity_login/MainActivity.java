package com.example.activity_login;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText LoginID;
    private EditText Password;
    private TextView Info;
    public FloatingActionButton FabLogin;
    private int counter = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginID = (EditText)findViewById(R.id.loginid_et);
        Password = (EditText)findViewById(R.id.password_et);
        Info = (TextView)findViewById(R.id.attempts_tv);
        FabLogin = (FloatingActionButton)findViewById(R.id.fabLogin);
        final String message = this.getString(R.string.attempts);
        Info.setText((this.getString(R.string.attempts) + "5"));

        FabLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                validate(LoginID.getText().toString(), Password.getText().toString());
                FabLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Info.setText(message + counter);
                        validate(LoginID.getText().toString(), Password.getText().toString());

                    }
                });

            }
        });
    }

    private void validate(String userName, String Password){
        if((userName.equals("pramod.repaka@mygeorgianc.ca")) && (Password.equals("123456"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText(this.getString(R.string.attempts) + String.valueOf(counter));

            Snackbar snackbar = Snackbar.make(this.FabLogin,"Login Failed!!!",Snackbar.LENGTH_LONG);
            View snackbarView = snackbar.getView();
            snackbarView.setBackgroundColor(Color.RED);
            snackbar.show();

            if(counter == 0){
                 FabLogin.setEnabled(false );
            }
        }
    }
}
