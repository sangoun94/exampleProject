package com.example.exampleproject.programers;

public class DotProduct {
    public static void main(String[] args) {
        DotProduct dotProduct = new DotProduct();
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};
        System.out.println(dotProduct.solution(a, b));
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        int length = a.length;
        int[] c = new int[length];

        for (int i = 0; i < length; i++) {
            c[i] = a[i] * b[i];
            answer += c[i];
        }

        return answer;
    }
}
