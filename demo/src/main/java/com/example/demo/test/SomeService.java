package com.example.demo.test;

import java.util.Arrays;

public class SomeService {

    public float computeAverage(int[] arr) {
        return (float) Arrays.stream(arr).sum() / getArrayLength(arr);
    }

    public int getArrayLength(int[] arr) {
        return arr.length;
    }
}
