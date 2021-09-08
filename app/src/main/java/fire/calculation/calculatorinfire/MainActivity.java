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

    Calculation calculation = new Calculation();
//    ArrayList<Character> expression = new ArrayList<>();
//    String expressionString;

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

    private String expressionEquality(ArrayList<Character> expression) {

        String str = "";
        ArrayList<Float> num = new ArrayList<>();
        num.clear();
        char action = '1';

        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i) == '+' || expression.get(i) == '-' || expression.get(i) == '*' || expression.get(i) == '/') {

                num.add(Float.parseFloat(str));
                str = "";
                action = expression.get(i);

                for (int j = i + 1; j < expression.size(); j++) {
                    str += expression.get(j);

                }

                num.add(Float.parseFloat(str));
                break;

            } else if (expression.get(i) != '=') {

                str += expression.get(i);

            }
        }

        float result = 0;
        switch (action) {
            case '+':
                result = num.get(0) + num.get(1);
                expression.clear();
                break;
            case '-':
                result = num.get(0) - num.get(1);
                expression.clear();
                break;
            case '*':
                result = num.get(0) * num.get(1);
                expression.clear();
                break;
            case '/':
                result = num.get(0) / num.get(1);
                expression.clear();
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