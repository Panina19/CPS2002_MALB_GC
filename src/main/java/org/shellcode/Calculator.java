package org.shellcode;

public class Calculator {
    public int add(int a, int b) {
        return a+b;
    }
    public int subtract(int a, int b) {
        return a-b;
    }
    public int multiply(int a, int b) {
        return a*b;
    }
    public int divide(int a, int b) {
        if (b!=0) return a/b;
        else throw new IllegalArgumentException("Second parameter cannot be 0");
    }

    public int pow(int a, int b) {
        return (int)Math.pow(a,b);
    }

    public int factorial(int a) {
        if(a==1) return 1;
        return a*factorial(a-1);
    }
}
