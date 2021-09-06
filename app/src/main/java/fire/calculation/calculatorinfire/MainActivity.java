package fire.calculation.calculatorinfire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    String expresssionString = "112+2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListeners();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                textView.setText("1");
                break;
            case R.id.button2:
                textView.setText("2");
                break;
            case R.id.button3:
                textView.setText("3");
                break;
            case R.id.button4:
                textView.setText("4");
                break;
            case R.id.button5:
                textView.setText("5");
                break;
            case R.id.button6:
                textView.setText("6");
                break;
            case R.id.button7:
                textView.setText("7");
                break;
            case R.id.button8:
                textView.setText("8");
                break;
            case R.id.button9:
                textView.setText("9");
                break;
            case R.id.button0:
                textView.setText("0");
                break;
            case R.id.buttonMinus:
                textView.setText("-");
                break;
            case R.id.buttonPlus:
                textView.setText("+");
                break;
            case R.id.buttonMultiply:
                textView.setText("*");
                break;
            case R.id.buttonDivision:
                textView.setText("/");
                break;
            case R.id.buttonEquality:
                //textView.setText("=");
                textView.setText(expressionEquality());

        }

    }

    private String expressionEquality(String expression) {

        char[] arr = expression.toCharArray();
        ArrayList<Float> num = new ArrayList<>();
        num.clear();
        int base = 0;
        char action = '1';

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {

                num.add(Float.parseFloat(String.copyValueOf(arr, base, (i - base))));
                action = arr[i];
                base = i + 1;
                num.add(Float.parseFloat(String.copyValueOf(arr, base, (arr.length - base))));
                break;
            }
        }

        float result = 0;
        switch (action) {
            case '+':
                result = num.get(0) + num.get(1);
                break;
            case '-':
                result = num.get(0) - num.get(1);
                break;
            case '*':
                result = num.get(0) * num.get(1);
                break;
            case '/':
                result = num.get(0) / num.get(1);
                break;
            default:
                break;
        }

        return String.valueOf(result);
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

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }
}