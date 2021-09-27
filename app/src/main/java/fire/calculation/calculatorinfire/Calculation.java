package fire.calculation.calculatorinfire;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Calculation implements Parcelable {

    private StringBuilder expression;   // выражение
    private ArrayList<Float> expPart;   // часть выражения (слагаемые ...)
    private char action;                // действие в выражении (+, -, *, /, ...)
    private String expResult;           // результат вычисления выражения
    private boolean calculated;         //

    Calculation() {
        expression = new StringBuilder();
        expPart = new ArrayList<>();
        calculated = false;
        expResult = "";
    }

    protected Calculation(Parcel in) {
        action = (char) in.readInt();
        calculated = in.readByte() != 0;
    }

    public static final Creator<Calculation> CREATOR = new Creator<Calculation>() {
        @Override
        public Calculation createFromParcel(Parcel in) {
            return new Calculation(in);
        }

        @Override
        public Calculation[] newArray(int size) {
            return new Calculation[size];
        }
    };

    public void add(char symbol) {

        //if (!expResult.isEmpty()) { clearExpResult(); }

        if (calculated) {
            expression.delete(0, expression.length());
            clearExpResult();
            calculated = false;
        }

        expression.append(symbol);
    }

    /**
     * Разделяет выражение на первое число, второе число и действие
     */
    private void separateExpressionParts() {

        StringBuilder stringBuilder = new StringBuilder();
        expPart.clear();

        if (calculated) {
            calculated = false;
        }

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+'
                    || expression.charAt(i) == '-'
                    || expression.charAt(i) == '*'
                    || expression.charAt(i) == '/') {

                expPart.add(Float.parseFloat(String.valueOf(stringBuilder)));
                action = expression.charAt(i);
                stringBuilder.delete(0, stringBuilder.length());

                for (int j = i + 1; j < expression.length(); j++) {
                    // Формируем строку с последовательностью чисел из оставшейся части выражения
                    stringBuilder.append(expression.charAt(j));
                }

                expPart.add(Float.parseFloat(String.valueOf(stringBuilder)));
                break;

            } else if (expression.charAt(i) != '=') {
                // Формируем строку с последовательностью чисел из первой части выражения
                stringBuilder.append(expression.charAt(i));
            }
        }
    }

    /**
     * Вычисляет значение выражения. После вычисления выражение очищается
     */
    public void calculate() {

        this.separateExpressionParts();

        float result = 0;
        switch (action) {
            case '+':
                result = expPart.get(0) + expPart.get(1);
                break;
            case '-':
                result = expPart.get(0) - expPart.get(1);
                break;
            case '*':
                result = expPart.get(0) * expPart.get(1);
                break;
            case '/':
                result = expPart.get(0) / expPart.get(1);
                break;
            default:
                break;
        }

        calculated = true;
        setExpResult(String.valueOf(result));
    }

    public String getExpResult() {
        return expResult;
    }

    public void setExpResult(String expResult) {
        this.expResult = expResult;
    }

    public String clearExpResult() {
        return expResult = "";
    }

    public String getExpressionString() {
        return String.valueOf(expression);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
