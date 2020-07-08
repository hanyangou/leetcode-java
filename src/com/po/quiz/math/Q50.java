package com.po.quiz.math;

public class Q50 {
    public double myPow(double x, int n) {
        //compute until n/2
        // x^n -> x * x * x * x -> (x * x ) * ( x * x)
        if( n < 0){
            x = 1 / x;
            n = -n;
        }
        return fasterPow(x, n);
    }

    private double fasterPow(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        double half = fasterPow(x, n/2);
        double full = half * half;
        if(n % 2 == 1) full *= x;
        return full;
    }
}
