package org.apz.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberLambda {

    public static void main(String[] args) throws IOException {
        Number number = new Number();
        String answer = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String line = bufferedReader.readLine().trim();
            StringTokenizer st = new StringTokenizer(line);
            int conditionToCheck = Integer.parseInt(st.nextToken());
            int numberToCheck = Integer.parseInt(st.nextToken());
            if (conditionToCheck == 1) {
                Operation operation = number.isOdd();
                boolean result = number.checker(operation, numberToCheck);
                answer = result ? "ODD" : "EVEN";
            } else if (conditionToCheck == 2) {
            	Operation operation = number.isPrime();
            	boolean result = number.checker(operation, numberToCheck);
            	answer = result ? "PRIME" : "COMPOSITE";
            } else if (conditionToCheck == 3) {
                Operation operation = number.isPalindrome();
                boolean result = number.checker(operation, numberToCheck);
                answer = result ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(answer);
        }
    }

}

class Number {

    public boolean checker(Operation operation, int number) {
        return operation.check(number);
    }

    public Operation isOdd() {
        return (x) -> x % 2 != 0;
    }

    public Operation isPalindrome() {
        return this::palindrome;
    }

    private boolean palindrome(int x) {
        int r, sum = 0, temp;
        temp = x;
        while (x > 0) {
            r = x % 10;
            sum = (sum * 10) + r;
            x = x / 10;
        }
        return temp == sum;
    }
    
    public Operation isPrime() {
        return this::prime;
    }
    
    private boolean prime(int x) {
        for (int i = 2; i <= x / 2; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

interface Operation {
    boolean check(int number);

}
