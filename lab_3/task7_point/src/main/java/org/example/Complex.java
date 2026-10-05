package org.example;

public class Complex {
    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() { return real; }
    public double getImag() { return imag; }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }
}
