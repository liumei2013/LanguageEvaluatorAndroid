package ca.concordia.ieltsevaluator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RequirementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirements);

        TextView tvc = findViewById(R.id.req_content);
        tvc.setKeyListener(null);
        tvc.setText(R.string.ielts_req);

        TextView tvt = findViewById(R.id.req_title);
        tvt.setKeyListener(null);
    }
}
