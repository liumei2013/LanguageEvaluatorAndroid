package ca.concordia.ieltsevaluator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onViewRequirements(View view) {
        Intent intent = new Intent(this, RequirementsActivity.class);
        startActivity(intent);
    }

    public void onCallEvaluator(View view) {
        Intent intent = new Intent(this, EvaluatorActivity.class);
        startActivity(intent);
    }
}
