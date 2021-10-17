package fire.calculation.calculatorinfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ActivitySettings extends AppCompatActivity implements View.OnClickListener {

    Button buttonThemeLight;
    Button buttonThemeDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initView();
        initListeners();

        MainActivity.makeToast("onCreate Settings");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonThemeLight:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case R.id.buttonThemeDark:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initListeners(){
        buttonThemeLight.setOnClickListener(ActivitySettings.this);
        buttonThemeDark.setOnClickListener(ActivitySettings.this);
    }

    private void initView() {
        buttonThemeLight = findViewById(R.id.buttonThemeLight);
        buttonThemeDark = findViewById(R.id.buttonThemeDark);
    }
}