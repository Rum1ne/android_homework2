package com.example.app;

import java.util.Random;

public class Problem {
    private int result;
    private final Random random = new Random();

    public int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public int getResult() {
        return result;
    }

    public String getProblem() {
        int a = getRandom(-50, 50);
        int b = getRandom(5, 50);
        int smaller_a = getRandom(1, 20);
        int smaller_b = getRandom(1, 20);
        String sign = getRandomSign();
        if (sign.equals("+")) {
            result = a + b;
            return a + " " + sign + " " + b;
        } else if (sign.equals("-")) {
            result = a - b;
            return a + " " + sign + " " + b;
        } else if (sign.equals("*")) {
            result = smaller_a * smaller_b;
            return smaller_a + " " + sign + " " + smaller_b;
        } else {
            while (a % smaller_b != 0) {
                a = getRandom(-50, 50);
                smaller_b = getRandom(1, 20);
            }
            result = a/smaller_b;
            return a + " " + sign + " " + smaller_b;
        }
    }


    public int getNoiseResult() {
        int noise = getRandom(-10, 10);
        while (noise == 0) noise = getRandom(-10, 10);
        return result + noise;
    }

    private String getRandomSign() {
        int sign = getRandom(1, 5);
        if (sign == 1) return "+";
        else if (sign == 2) return "-";
        else if (sign == 3) return "*";
        else return "/";
    }

}
