package com.example.exampleproject.programers;

import java.util.Arrays;

public class K {
    public static void main(String[] args) {
        K k = new K();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println("k.solution(array, commands) = " + k.solution(array, commands));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int[] ints;
            ints = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(ints);

            answer[i] = ints[commands[i][2] - 1];
        }


        return answer;
    }
}
