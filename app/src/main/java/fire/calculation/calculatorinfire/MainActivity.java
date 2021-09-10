package fire.calculation.calculatorinfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonMinus;
    Button buttonPlus;
    Button buttonMultiply;
    Button buttonDivision;
    Button buttonEquality;
    private final static String CALC = "CALC";
    private final static String TAG = "[LifeCycleOfActivity]";

    Calculation calculation = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                setContentView(R.layout.activity_main);
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_landscape);
        }

        initView();
        initListeners();
        makeToast("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeToast("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                calculation.add('1');
                break;
            case R.id.button2:
                calculation.add('2');
                break;
            case R.id.button3:
                calculation.add('3');
                break;
            case R.id.button4:
                calculation.add('4');
                break;
            case R.id.button5:
                calculation.add('5');
                break;
            case R.id.button6:
                calculation.add('6');
                break;
            case R.id.button7:
                calculation.add('7');
                break;
            case R.id.button8:
                calculation.add('8');
                break;
            case R.id.button9:
                calculation.add('9');
                break;
            case R.id.button0:
                calculation.add('0');
                break;
            case R.id.buttonMinus:
                calculation.add('-');
                break;
            case R.id.buttonPlus:
                calculation.add('+');
                break;
            case R.id.buttonMultiply:
                calculation.add('*');
                break;
            case R.id.buttonDivision:
                calculation.add('/');
                break;
            case R.id.buttonEquality:
                //textView.setText("=");
                textView.setText(calculation.calculate());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

        textView.setText(calculation.getMainRepresentation());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CALC, calculation);
        makeToast("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculation = (Calculation) savedInstanceState.getParcelable(CALC);
        textView.setText(calculation.getMainRepresentation());
        makeToast("onRestoreInstanceState");
    }

    private void initListeners() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonEquality.setOnClickListener(this);
    }

    private void initView() {
        textView = findViewById(R.id.appCompatTextView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonEquality = findViewById(R.id.buttonEquality);
    }

    private void makeToast(String message) {
        Log.d(TAG, message);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }
}