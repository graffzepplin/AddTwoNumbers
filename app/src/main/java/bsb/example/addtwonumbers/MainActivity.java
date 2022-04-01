package bsb.example.addtwonumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button add;
    TextView textview2;

    public static final String EXTRA_MESSAGE = "bsb.example.addtwonumbers.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        add = findViewById(R.id.add);
        textview2 = findViewById(R.id.textView2);


        SharedPreferences sp = getSharedPreferences("myPref", MODE_PRIVATE);
        String savedata = sp.getString("summation", "No values as of now");
        textview2.setText(savedata);
    }

    public void sendMessage(View view) {

        double num1 = Double.parseDouble(edit1.getText().toString());
        double num2 = Double.parseDouble(edit2.getText().toString());
        double sum = num1 + num2;
        String message = Double.toString(sum);


        Intent intent = new Intent(this, DisplayAdd.class);

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

        SharedPreferences sp = getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("summation", message);
        ed.apply();
//        textview2.setText(message);


    }
}