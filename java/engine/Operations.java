package engine;

public class Operations {
    private double result = 0;

    public double getResult() {
        return result;
    }

    public void sum(int a, int b) {
        result = a + b;
    }

    public void sum(double a, double b) {
        result = a + b;
    }

    public void minus(int a, int b) {
        result = a - b;
    }

    public void minus(double a, double b) {
        result = a - b;
    }

    public void divide(int a, int b) {
        result = a / (b * 1.0);
    }

    public void divide(double a, double b) {
        result = a / b;
    }

    public void multiply(int a, int b) {
        result = a * b;
    }

    public void multiply(double a, double b) {
        result = a * b;
    }
}
