package id.inixindosurabaya.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    // komponen dalam layout
    TextView txtDisplay;
    Button btnKembali, btnBerikutnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        // inisialisasi komponen
        txtDisplay = (TextView)findViewById(R.id.txtDisplay);
        btnKembali = (Button)findViewById(R.id.btnKembali);
        btnBerikutnya = (Button)findViewById(R.id.btnBerikutnya);

        // menerima nilai dari main activity
        Intent myIntent = getIntent();
        int nilai = myIntent
                .getIntExtra("nilai", 0);
        txtDisplay.setText(String.valueOf(nilai));

        // event handling button kembali
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SecondaryActivity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        // event handling button berikutnya
        btnBerikutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mengirim data string ke third activity
                Intent kirimIntent = new Intent(
                        SecondaryActivity.this,
                        ThirdActivity.class
                );
                kirimIntent.putExtra("kirim", txtDisplay.getText());
                startActivity(kirimIntent);
            }
        });
    }
}
