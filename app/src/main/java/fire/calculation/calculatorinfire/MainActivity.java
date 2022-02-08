package fire.calculation.calculatorinfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Constants {

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
    Button buttonSettings;

    final String sayHi = "Hello, I am your Daddy"; // its hardcode!

    private final static String TEXT = "PARAM-PAM-PAM";

    Calculation calculation = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListeners();

        makeToast("onCreate Main");
    }

    /* Проверки состояний жизненного цикла Activity
    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart");
    }
    */
    @Override
    protected void onResume() {
        super.onResume();
//        onRestoreInstanceState(savedInstanceState);
        makeToast("onResume"); //TODO добавить заполнение TextView из сохраненного состояния
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

    View.OnClickListener onClickListener = new View.OnClickListener() {
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
                    calculation.calculate();
                    break;
                case R.id.buttonSettings:
                    Intent runSettings = new Intent(MainActivity.this, ActivitySettings.class);
                    runSettings.putExtra(SAYHI, textView.getText());
                    startActivity(runSettings);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }

            setTextViewExpression(calculation);
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CALC, calculation);
        makeToast("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculation = savedInstanceState.getParcelable(CALC);

        setTextViewExpression(calculation);

        makeToast("onRestoreInstanceState");
    }

    private void setTextViewExpression(@NonNull Calculation calculation) {
        if (calculation.getExpResult().isEmpty()) {
            textView.setText(calculation.getExpressionString());
        } else {
            textView.setText(calculation.getExpResult());
        }
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

        buttonSettings = findViewById(R.id.buttonSettings);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        String text = bundle.getString(TEXT);

        textView.setText(text);
    }

    private void initListeners() {
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
        button9.setOnClickListener(onClickListener);
        button0.setOnClickListener(onClickListener);
        buttonMinus.setOnClickListener(onClickListener);
        buttonPlus.setOnClickListener(onClickListener);
        buttonMultiply.setOnClickListener(onClickListener);
        buttonDivision.setOnClickListener(onClickListener);
        buttonEquality.setOnClickListener(onClickListener);

        buttonSettings.setOnClickListener(onClickListener);
    }

    static void makeToast(String message) {
        Log.d(TAG, message);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }
}