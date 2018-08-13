package id.inixindosurabaya.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // tulis komponen yg ada didalam layout
    private Button btnToast, btnCount;
    private TextView txtDisplay;
    private int myCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi setiap komponen dalam layout
        // mengenal setiap ID komponen
        btnToast = (Button)findViewById(R.id.btnToast);
        btnCount = (Button)findViewById(R.id.btnCount);
        txtDisplay = (TextView)findViewById(R.id.txtDisplay);

        // event handling untuk button toast
        btnToast.setOnClickListener(this);
        // event handling untuk button count
        btnCount.setOnClickListener(this);

        // menampilkan info lifecycle
        Toast.makeText(MainActivity.this,
                "Activity onCreate",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if (v == btnToast) {
            Toast.makeText(MainActivity.this,
                    "Klik Tombol Toast",
                    Toast.LENGTH_LONG).show();

            Intent myIntent = new Intent(
                    MainActivity.this,
                    SecondaryActivity.class
            );
            myIntent.putExtra("nilai", myCount);
            startActivity(myIntent);
        }
        if (v == btnCount) {
            myCount++;
            if (txtDisplay != null) {
                txtDisplay.setText(Integer.toString(myCount));
            }
        }
    }

    // lifecycle onStart
    protected void onStart(){
        super.onStart();
        Toast.makeText(MainActivity.this,
                "Activity onStart",
                Toast.LENGTH_LONG).show();
    }

    // lifecycle onResume
    protected void onResume(){
        super.onResume();
        Toast.makeText(MainActivity.this,
                "Activity onResume",
                Toast.LENGTH_LONG).show();
    }

    // lifecyle onPause
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,
                "Activity onPause",
                Toast.LENGTH_LONG).show();
    }

    // lifecycle onStop
    protected void onStop(){
        super.onStop();
        Toast.makeText(MainActivity.this,
                "Activity onStop",
                Toast.LENGTH_LONG).show();
    }

    // lifecycle onRestart
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(MainActivity.this,
                "Activity onRestart",
                Toast.LENGTH_LONG).show();
    }

    // lifecycle onDestroy
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(MainActivity.this,
                "Activity onDestroy",
                Toast.LENGTH_LONG).show();
    }
}
