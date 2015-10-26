package turd.crap.shit.xsdllauncher;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("XSDL-Launcher", "Got return result, code = " + resultCode + " intent " + data == null ? "null" : data.toString());
        text.setText("Failed to parse return result, resultCode " + resultCode);
        try {
            text.setText("XSDL started: " + data.getStringExtra("run"));
            Log.i("XSDL-Launcher", "Got return result data: " + data.getStringExtra("run"));
        } catch(Exception e) {
            Log.i("XSDL-Launcher", "Got exception: " + e.toString());
        }

    }

    public void startXSDL(View button) {
        Log.i("XSDL-Launcher", "Launching XSDL");
        try {
            Intent i = new Intent(Intent.ACTION_MAIN, Uri.parse("x11://give.me.display:111"));
            startActivityForResult(i, 1);
        } catch(Exception e) {
            text.setText("XSDL not installed!");
        }
    }
}
