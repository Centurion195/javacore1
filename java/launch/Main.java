package launch;

import engine.Operations;
import engine.Output;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в калькулятор!");
        boolean numPoint = false;
        char sign;
        int[] valuesInt = new int[2];
        double[] valuesDouble = new double[2];
        while (true) {
            System.out.println("Введите простое выражение:");
            Scanner scanner = new Scanner(System.in);
            String expression = scanner.nextLine();
            String[] values;
            if (expression.contains("+")) {
                values = expression.split("\\+");
                sign = '+';
            } else if (expression.contains("-")) {
                values = expression.split("-");
                sign = '-';
            } else if (expression.contains("/")) {
                values = expression.split("/");
                sign = '/';
            } else if (expression.contains("*")) {
                values = expression.split("\\*");
                sign = '*';
            } else {
                System.out.println("Не обнаружен знак операции! Повторите попытку.");
                continue;
            }

            values[0] = values[0].replace(',', '.');
            values[1] = values[1].replace(',', '.');
            try {
                if (values[0].contains(".") || values[1].contains(".")) {
                    valuesDouble[0] = Double.parseDouble(values[0]);
                    valuesDouble[1] = Double.parseDouble(values[1]);
                    numPoint = true;
                } else {
                    valuesInt[0] = Integer.parseInt(values[0]);
                    valuesInt[1] = Integer.parseInt(values[1]);
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка в выражении! Повторите попытку.");
            }
        }

        Operations o = new Operations();
        switch (sign) {
            case '+':
                if (numPoint) {
                    o.sum(valuesDouble[0], valuesDouble[1]);
                } else {
                    o.sum(valuesInt[0], valuesInt[1]);
                }
                break;
            case '-':
                if (numPoint) {
                    o.minus(valuesDouble[0], valuesDouble[1]);
                } else {
                    o.minus(valuesInt[0], valuesInt[1]);
                }
                break;
            case '/':
                if (numPoint) {
                    o.divide(valuesDouble[0], valuesDouble[1]);
                } else {
                    o.divide(valuesInt[0], valuesInt[1]);
                }
                break;
            case '*':
                if (numPoint) {
                    o.multiply(valuesDouble[0], valuesDouble[1]);
                } else {
                    o.multiply(valuesInt[0], valuesInt[1]);
                }
                break;
        }
        Output.print(o.getResult());
    }
}
