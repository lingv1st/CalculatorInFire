package fire.calculation.calculatorinfire;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Calculation implements Parcelable {

    private ArrayList<Character> expression;    // выражение
    private ArrayList<Float> expPart;           // часть выражения
    private char action;                        // действие в выражении
    private String mainRepresentation;          // строковое представление выражения
    private boolean calculated;

    Calculation() {
        expression = new ArrayList<>();
        expPart = new ArrayList<>();
        calculated = false;
    }

    protected Calculation(Parcel in) {
        action = (char) in.readInt();
        mainRepresentation = in.readString();
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

        //String str = "";
        StringBuilder stringBuilder = new StringBuilder();
        expPart.clear();

        if (calculated) { calculated = false; }



        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i) == '+'
                    || expression.get(i) == '-'
                    || expression.get(i) == '*'
                    || expression.get(i) == '/') {

                expPart.add(Float.parseFloat(String.valueOf(stringBuilder)));
                //str = "";
                action = expression.get(i);

                for (int j = i + 1; j < expression.size(); j++) {
                    // Формируем строку с последовательностью чисел из оставшейся части выражения
                    //str += expression.get(j);
                    stringBuilder.append(expression.get(j));
                }

                expPart.add(Float.parseFloat(String.valueOf(stringBuilder)));
                break;

            } else if (expression.get(i) != '=') {
                // Формируем строку с последовательностью чисел из первой части выражения
                //str += expression.get(i);
                stringBuilder.append(expression.get(i));
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt((int) action);
        parcel.writeString(mainRepresentation);
        parcel.writeByte((byte) (calculated ? 1 : 0));
    }
}
