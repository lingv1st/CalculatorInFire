package fire.calculation.calculatorinfire;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class Calculation implements Serializable {

    private ArrayList<Character> expression;
    private ArrayList<Float> expPart;
    private char action;
    private String mainRepresentation;
    private boolean calculated;

    Calculation() {
        expression = new ArrayList<>();
        expPart = new ArrayList<>();
        calculated = false;
    }

    public void add(char symbol) {

        if (calculated) {
            expression.clear();
            calculated = false;
        }

        expression.add(symbol);
        setMainRepresentation();
    }

    /**
     * Разделяет выражение на первое число, второе число и действие
     */
    private void separateExpressionParts() {

        String str = "";
        expPart.clear();

        if (calculated) { calculated = false; }

        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i) == '+'
                    || expression.get(i) == '-'
                    || expression.get(i) == '*'
                    || expression.get(i) == '/') {

                expPart.add(Float.parseFloat(str));
                str = "";
                action = expression.get(i);

                for (int j = i + 1; j < expression.size(); j++) {
                    // Формируем строку с последовательностью чисел из оставшейся части выражения
                    str += expression.get(j);
                }

                expPart.add(Float.parseFloat(str));
                break;

            } else if (expression.get(i) != '=') {
                // Формируем строку с последовательностью чисел из первой части выражения
                str += expression.get(i);

            }
        }
    }

    /**
     * Вычисляет значение выражения. После вычисления выражение очищается
     */
    public String calculate() {

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
        setMainRepresentation(String.valueOf(result));
        return mainRepresentation;
    }

    private void setMainRepresentation() {
        mainRepresentation = String.valueOf(expression);
    }

    private void setMainRepresentation(String result) {
        mainRepresentation = result;
    }

    public String getMainRepresentation() {
        return mainRepresentation;
    }
}
