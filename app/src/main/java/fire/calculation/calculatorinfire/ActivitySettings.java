package fire.calculation.calculatorinfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivitySettings extends AppCompatActivity implements Constants {

    Button buttonThemeLight;
    Button buttonThemeDark;
    Button buttonTestIntent;
    TextView textViewSettings;
    String intentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initView();
        initListeners();

        MainActivity.makeToast("onCreate Settings");
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonThemeLight:
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    break;
                case R.id.buttonThemeDark:
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    break;
                case R.id.buttonTestIntent:
                    Uri uri = Uri.parse("testintent");
                    Intent runTestIntent = new Intent(Intent.ACTION_VIEW, uri);
                    runTestIntent.putExtra(SAYHI, intentText);
                    startActivity(runTestIntent);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initView() {
        buttonThemeLight = findViewById(R.id.buttonThemeLight);
        buttonThemeDark = findViewById(R.id.buttonThemeDark);
        buttonTestIntent = findViewById(R.id.buttonTestIntent);

        textViewSettings = findViewById(R.id.textViewSettings);
        intentText = getIntent().getExtras().getString(SAYHI);
        textViewSettings.setText(intentText);
    }

    private void initListeners() {
        buttonThemeLight.setOnClickListener(onClickListener);
        buttonThemeDark.setOnClickListener(onClickListener);
        buttonTestIntent.setOnClickListener(onClickListener);
    }
}