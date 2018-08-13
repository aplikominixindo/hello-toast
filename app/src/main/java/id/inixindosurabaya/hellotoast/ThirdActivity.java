package id.inixindosurabaya.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    // komponen dalam layout
    TextView txtDisplay;
    Button btnKembali, btnBerikutnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // inisialisasi komponen
        txtDisplay = (TextView)findViewById(R.id.txtDisplay);
        btnKembali = (Button)findViewById(R.id.btnKembali);
        btnBerikutnya = (Button)findViewById(R.id.btnBerikutnya);

        // menerima nilai dari main activity
        Intent myIntent = getIntent();
        String str = myIntent.getStringExtra("kirim");
        txtDisplay.setText(str);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ThirdActivity.this,
                        SecondaryActivity.class);
                startActivity(myIntent);
            }
        });

        btnBerikutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ThirdActivity.this,
                        FourthActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
