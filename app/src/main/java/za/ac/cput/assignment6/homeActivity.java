package za.ac.cput.assignment6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class homeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.btnLoginHome:
                Intent login = new Intent(homeActivity.this, LoginActivity.class);
                startActivity(login);
                break;
            case R.id.buttonExitApp:
                finish();
        }

    }
}
