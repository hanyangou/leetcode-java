package com.po.quiz.math;

import java.util.ArrayList;
import java.util.List;

/***
 * be careful:
 * 1) 32-bit-signed-integer environment, range: [-2^31, 2^31 -1]
 * 2) abs(-2^31) = 2^32 which is outside of range by 1
 * Instead of a = a * -1 for making numbers negative, use a = -a.
 * Instead of using a / 2 for dividing by 2, use the right shift operator; a >> 1.
 * Instead of using a * 2 for doubling, use a = a + a, a += a, or even the left shift operator; a << 1.
 *
 * dividend / divisor
 */
public class Q29 {
    private static int HALF_INT_MIN = -1073741824;
    public int divide(int dividend, int divisor) {
        //overflow case
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int sign = 0;
        if(dividend > 0){
            sign++;
            dividend = -dividend;
        }
        if(divisor > 0){
            sign++;
            divisor = -divisor;
        }

        List<Integer> powerOfTwos = new ArrayList<>();
        List<Integer> doubles = new ArrayList<>();
        int powerOfTwo = 1;
        while (divisor >= dividend) { //remember we are working in negative to avoid overflow case
            powerOfTwos.add(powerOfTwo);
            doubles.add(divisor);
            if (divisor < HALF_INT_MIN) {
                break;
            }
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }
        int quotient = 0;
        for(int i = doubles.size() - 1; i >= 0; i--){
            if(doubles.get(i) >= dividend){
                quotient += powerOfTwos.get(i);
                dividend -= doubles.get(i);
            }
        }

        if(sign != 1) quotient = -quotient;
        return quotient;
    }
}
