package com.po.quiz.math;

import java.util.ArrayList;
import java.util.List;

/***
 * be careful:
 * 1) 32-bit-signed-integer environment, range: [-2^31, 2^31 -1]
 * 2) abs(-2^31) = 2^32 which is outside of range by 1
 * due to the fact that all negative integers cover the range of positive integer
 * we first convert both dividend and divisor to negative, tracking the # of negative signs
 * and later on convert the quotient back to what it should be based on # of negative signs
 *
 * dividend / divisor
 */
public class Q29 {
    public int divide(int dividend, int divisor) {
        //corner case: overflow
        Integer HALF = Integer.MIN_VALUE / 2;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int negative = 2;
        if(dividend > 0){
            negative--;
            dividend = dividend * -1;
        }
        if(divisor > 0){
            negative--;
            divisor = divisor * -1;
        }

        List<Integer> doubles = new ArrayList<>();
        List<Integer> powerOfTwos = new ArrayList<>();

        int powerOfTwo = -1;
        while (divisor >= dividend){
            doubles.add(divisor);
            powerOfTwos.add(powerOfTwo);
            if(divisor < HALF) break;
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }
        int quotient = 0;
        for(int i = doubles.size() - 1; i >= 0; i--){
            if(dividend <= doubles.get(i)){
                quotient += powerOfTwos.get(i);
                dividend -= doubles.get(i);
            }
        }
        if(negative != 1){
            quotient = quotient * -1;
        }
        return quotient;
    }
}
