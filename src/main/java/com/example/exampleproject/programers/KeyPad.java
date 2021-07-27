package com.example.exampleproject.programers;

public class KeyPad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] pad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -2}};
        int[][] leftHand = new int[0][];
        int[][] rightHand = new int[0][];

        for (int i = 0; i < pad.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (pad[i][0] == numbers[j]) {
                    answer += "L";
                } else if (pad[i][2] == numbers[j]) {
                    answer += "R";
                } else if (pad[i][1] == numbers[j]) {

                }
            }

            for (int j = 0; j < pad[i].length; j++) {



            }
        }

        return answer;
    }
}
