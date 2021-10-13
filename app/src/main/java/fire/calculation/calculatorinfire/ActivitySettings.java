package fire.calculation.calculatorinfire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ActivitySettings extends AppCompatActivity implements View.OnClickListener {

    Button buttonTheme1;
    Button buttonTheme2;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTheme1:
                setTheme(R.style.Theme);
                recreate();
                break;
            case R.id.buttonTheme2:
                setTheme(R.style.ThemeDark);
                recreate();
                break;
            default:
                break;
        }
    }

    private void initListeners(){
        buttonTheme1.setOnClickListener(ActivitySettings.this);
        buttonTheme2.setOnClickListener(ActivitySettings.this);
    }

    private void initView() {
        buttonTheme1 = findViewById(R.id.buttonTheme1);
        buttonTheme2 = findViewById(R.id.buttonTheme2);
        checkBox = findViewById(R.id.checkboxSystemTheme);
    }
}