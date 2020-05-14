package com.example.mentalmath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.res.Resources;
import android.widget.Toast;

import com.example.mentalmath.Widgets.CustomEditText;
import com.example.mentalmath.Widgets.CustomLL;
import com.example.mentalmath.Widgets.CustomRL;
import com.example.mentalmath.Widgets.CustomScrollView;
import com.example.mentalmath.Widgets.CustomTV;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class LoginActivity extends AppCompatActivity {
    private CustomLL customLL;
    private CustomRL customRL;
    private CustomTV customTV;
    private CustomEditText customEditText;
    public Resources resources;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView textView = new TextView(R.id.textView);

        mAuth = FirebaseAuth.getInstance();
        LinearLayout llContent = new LinearLayout(this);
        Content(llContent);
        setContentView(llContent);
        llContent.setBackgroundResource(R.drawable.background);
    }


    private void Content(LinearLayout llContent) {
        customLL = new CustomLL(this);
        customRL = new CustomRL(this);
        customTV = new CustomTV(this);
        customEditText = new CustomEditText(this);
//        language = LocaleHelper.getLanguage(MainActivity.this);
//        Context с = LocaleHelper.onAttach(MainActivity.this, language);
        resources = getResources();
        CustomScrollView sv = new CustomScrollView(this);
        customLL.setEdit(llContent, "Content");

        RelativeLayout autorizationRL = new RelativeLayout(this);
        customRL.setAutorization(autorizationRL);
        llContent.addView(autorizationRL);

        TextView welcomeTV = new TextView(this);
        customTV.setWelcome(welcomeTV, resources.getString(R.string.welcomeFriend));
        autorizationRL.addView(welcomeTV);

        final EditText loginET = new AutoCompleteTextView(this);
        customEditText.setLogin((AutoCompleteTextView) loginET, resources.getString(R.string.login));
        autorizationRL.addView(loginET);

        final EditText passwordET = new AutoCompleteTextView(this);
        customEditText.setPassword((AutoCompleteTextView) passwordET, resources.getString(R.string.password));
        autorizationRL.addView(passwordET);

        TextView signInButton = new TextView(this);
        customTV.setSignIn(signInButton, resources.getString(R.string.signIn));
        autorizationRL.addView(signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginET.getText().toString();
                String password = passwordET.getText().toString();
                FirebaseUser currentUser = mAuth.getCurrentUser();

                if(email.isEmpty()){
                    loginET.setError(resources.getString(R.string.IncorrectLogin));
                    loginET.requestFocus();
                } else if(password.isEmpty()) {
                    passwordET.setError(resources.getString(R.string.incorrectPassword));
                    passwordET.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()){
                    Toast.makeText(LoginActivity.this, resources.getString(R.string.fieldsAreEmpty), Toast.LENGTH_LONG).show();

                } else if (!(email.isEmpty() && password.isEmpty())){
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, resources.getString(R.string.signInUnsuccesful), Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "WELCOME", Toast.LENGTH_LONG).show(); // here yyou nedd add go to another pagee
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(LoginActivity.this, resources.getString(R.string.signInUnsuccesful), Toast.LENGTH_LONG).show();
                }

                updateUI(currentUser);
            }
        });

        TextView registrationButton = new TextView(this);
        customTV.setRegistration(registrationButton, resources.getString(R.string.new_account));
        autorizationRL.addView(registrationButton);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }


        });


    }

    public void  updateUI(FirebaseUser account){
        if(account != null){
            Toast.makeText(this,"U Signed In successfully",Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(myIntent);
        }else {
            Toast.makeText(this,"U Didnt signed in",Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(myIntent);
        }
    }
}
