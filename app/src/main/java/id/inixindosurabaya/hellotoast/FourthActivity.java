package id.inixindosurabaya.hellotoast;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {
    private EditText editLinkUrl, editGoogleMap, editShareText;
    private Button btnOpenLinkUrl, btnOpenGoogleMap, btnOpenShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        // inisialisasi
        editLinkUrl = (EditText)findViewById(R.id.editLinkURL);
        editGoogleMap = (EditText)findViewById(R.id.editGoogleMap);
        editShareText = (EditText)findViewById(R.id.editShareText);
        btnOpenLinkUrl = (Button)findViewById(R.id.btnLinkURL);
        btnOpenGoogleMap = (Button)findViewById(R.id.btnGoogleMap);
        btnOpenShareText = (Button)findViewById(R.id.btnShareText);

    }

    // implement onClick setiap button
    public void openGoogleMap(View view) {
        String loc = editGoogleMap.getText().toString();
        Uri address = Uri.parse("geo:0,0?q=" + loc);
        Intent myIntent = new Intent(Intent.ACTION_VIEW, address);
        if (myIntent.resolveActivity(getPackageManager()) != null){
            startActivity(myIntent);
        } else {
            Log.d("Implicit Intent", "Tidak ada intent");
        }
    }

    public void openShareText(View view) {
        String txt = editShareText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share teks ini dengan: ")
                .setText(txt)
                .startChooser();
    }

    public void openLinkUrl(View view) {
        String url = editLinkUrl.getText().toString();
        // url harus ada http://
        Uri webpage = Uri.parse(url);
        Intent myIntent = new Intent(Intent.ACTION_VIEW, webpage);
        // cek url
        if (myIntent.resolveActivity(getPackageManager()) != null){
            startActivity(myIntent);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Tidak ada Intent yg dikerjakan!",
                    Toast.LENGTH_LONG).show();
        }
    }
}
