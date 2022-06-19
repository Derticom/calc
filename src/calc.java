import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class calc {

    static int a;
    static int b;
    static String mathSymbols;
    static int result;


    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        String mathExpression = input.nextLine();

        if (mathExpression.contains("I") || mathExpression.contains("V") || mathExpression.contains("X")) {
            GetRomanValuesFromString(mathExpression);
            Counts();
            PrintRomanRezult();
        } else {
            GetArabValuesFromString(mathExpression);
            Counts();
            PrintArabRezult();
        }
    }

    static void GetArabValuesFromString(String mathExpression) throws IOException {
        String[] partsOfExpression = mathExpression.split(" ");
        a = Integer.parseInt(partsOfExpression[0]);
        mathSymbols = partsOfExpression[1];
        b = Integer.parseInt(partsOfExpression[2]);
        if (a > 10 || b > 10 || a < 1 || b < 1)
            throw new IOException("Недопустимое значение");
    }

    static void PrintArabRezult() {
        System.out.println(result);
    }

    static void GetRomanValuesFromString(String mathExpression) throws IOException {
        String[] partsOfExpression = mathExpression.split(" ");
        a = ConvertRomanToArab(partsOfExpression[0]);
        mathSymbols = partsOfExpression[1];
        b = ConvertRomanToArab(partsOfExpression[2]);
    }

    static void Counts() throws IOException {
        switch (mathSymbols) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
            default -> throw new IOException("Недопустимый символ");
        }
    }

    static int ConvertRomanToArab(String romanValue) throws IOException {
        switch (romanValue) {
            case "I" -> {
                return 1;
            }
            case "II" -> {
                return 2;
            }
            case "III" -> {
                return 3;
            }
            case "IV" -> {
                return 4;
            }
            case "V" -> {
                return 5;
            }
            case "VI" -> {
                return 6;
            }
            case "VII" -> {
                return 7;
            }
            case "VIII" -> {
                return 8;
            }
            case "IX" -> {
                return 9;
            }
            case "X" -> {
                return 10;
            }
            default -> throw new IOException("Недопустимое значение");
        }
    }


    static void PrintRomanRezult() throws Exception {
        if (result <= 0)
            throw new Exception("Нуля и отрицательных чисел в римской системе счисления не существует");

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((result > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= result) {
                sb.append(currentSymbol.name());
                result -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        System.out.println(sb);
    }


}
