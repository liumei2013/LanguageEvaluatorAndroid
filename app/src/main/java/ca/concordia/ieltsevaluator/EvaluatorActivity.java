package ca.concordia.ieltsevaluator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EvaluatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluator);
    }

    public void onEvaluate(View view) {

        TextView tvl = findViewById(R.id.listen_score);
        TextView tvs  = findViewById(R.id.speak_score);
        TextView tvr   = findViewById(R.id.read_score);
        TextView tvw  = findViewById(R.id.write_score);

        double listeningScore = Double.parseDouble(tvl.getText().toString());
        double speakingScore = Double.parseDouble(tvs.getText().toString());
        double readingScore = Double.parseDouble(tvr.getText().toString());
        double writingScore = Double.parseDouble(tvw.getText().toString());

        // Handle decimal of average score
        double averageScore = (listeningScore + speakingScore + readingScore + writingScore) / 4;
        double difference = averageScore - (int)averageScore;
        if (difference < 0.23) // 0 and 0.125 will get 0
            difference = 0;
        else if (difference < 0.66) // 0.25, 0.375, 0.5, 0.625 will get 0.5
            difference = 0.5;
        else
            difference = 1.0; // 0.75, 0.875 will get 1

        // Get overall score
        double overallScore = (int)averageScore + difference;

        String result = new String();

        // Display important scores
        result += "Your overall score is: " + overallScore;
        result += "\nYour reading score is: " + readingScore;
        result += "\nYour writing score is: " + writingScore;

        // Display result to applicant
        // When compare double score use 0.1 as margin of error
        if (overallScore > 6.4 && readingScore > 5.9 && writingScore > 5.9) {
            result += "\n\nCongratulations!\nYou are eligible for Admission.";
        }
        else if (overallScore > 6.4 && (readingScore < 5.9 || writingScore < 5.9)) {
            result += "\n\nYou are eligible for Conditional Admission.";
        }
        else if (overallScore - 6.0 < 0.1 && readingScore > 5.9 && writingScore > 5.9) {
            result += "\n\nYou are eligible for Conditional Admission.";
        }
        else if (overallScore - 6.0 < 0.1 && readingScore < 5.9 && writingScore < 5.9) {
            result += "\n\nSorry, you have to retake the exam.";
        }
        else if (overallScore < 5.9) {
            result += "\n\nSorry, you have to retake the exam.";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(result).setTitle("Result").setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
