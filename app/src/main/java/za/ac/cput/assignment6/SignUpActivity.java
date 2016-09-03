package za.ac.cput.assignment6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import za.ac.cput.assignment6.model.LoginDetails;
import za.ac.cput.assignment6.model.RegistryManager;
import za.ac.cput.assignment6.services.Impl.SignUpServiceImpl;
import za.ac.cput.assignment6.services.SignupService;

public class SignUpActivity extends Activity {


    private Button submit;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private String userExists = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Register();
    }

    public void onClick(View view)
    {
        Intent openStep = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(openStep);
    }

    public void Register()
    {
        submit = (Button)findViewById(R.id.buttonSignup);
        email = (EditText)findViewById(R.id.editEmail2);
        password = (EditText)findViewById(R.id.editPass2);
        confirmPassword = (EditText)findViewById(R.id.editConfPass2);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals(""))
                {
                    email.requestFocus();
                    email.setError("Cannot be empty.");
                }
                else if(password.getText().toString().equals(""))
                {
                    password.requestFocus();
                    password.setError("Cannot be empty.");
                }
                else if(password.getText().toString().length() < 8 || !password.getText().toString().matches(".*\\d+.*") || !password.getText().toString().matches(".*[a-zA-Z]+.*"))
                {
                    password.requestFocus();
                    password.setError("Password must have 8 or more characters.\nPassword must have numbers.");
                }
                else if(confirmPassword.getText().toString().equals(""))
                {
                    confirmPassword.requestFocus();
                    confirmPassword.setError("Cannot be empty.");
                }
                else if(!confirmPassword.getText().toString().equals(password.getText().toString()))
                {
                    confirmPassword.requestFocus();
                    confirmPassword.setError("Passwords do not match!");
                }
                else{
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //CREATE A SERVICE OBJECT
                            SignupService service = new SignUpServiceImpl();

                            LoginDetails loginDetails = new LoginDetails();
                            RegistryManager registryManager = new RegistryManager();

                            loginDetails.setEmail(email.getText().toString());
                            loginDetails.setPassword(password.getText().toString());
                            registryManager.setLoginDetails(loginDetails);

                            userExists = service.signUp_RegistryManager(registryManager);
                        }
                    });


                    thread.start();

                    try {
                        //RUNS THE THREAD
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (userExists==null) {
                        //Go to Login page, send email to txtLoginUsername
                        Intent openStep = new Intent(SignUpActivity.this, LoginActivity.class);
                        openStep.putExtra("Email", email.getText().toString());
                        startActivity(openStep);
                    } else {
                        email.requestFocus();
                        email.setError("Email already exists.");
                    }
                }
            }
        });
    }
}
