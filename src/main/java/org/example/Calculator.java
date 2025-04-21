package org.example;


public class Calculator {
    public int divide(int a, int b) {
        return a / b; // ⚠️ Intentional divide by zero possibility
    }

    public double divide(double a, double b) {
        return a / b; // ⚠️ Intentional divide by zero possibility
    }

    public int add(int a, int b) {
        return a + b;
    }
}