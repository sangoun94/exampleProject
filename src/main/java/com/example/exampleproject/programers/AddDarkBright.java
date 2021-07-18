package com.example.exampleproject.programers;

public class AddDarkBright {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i] == false) {
                absolutes[i] = -absolutes[i];
            }
        }
        for (int absolute : absolutes) {
            answer += absolute;
        }
        return answer;
    }
}
