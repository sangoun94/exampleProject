package com.example.exampleproject.programers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        int[] a = {45, 4, 35, 20, 3, 9};
        int[] b ={20, 9, 3, 45, 4, 35};
        System.out.println(" = " + lotto.solution(a,b));
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int answerMaxCnt = 0;
        HashMap<Integer, Integer> mapLotto = new HashMap<>();
        HashMap<Integer, Integer> mapWin = new HashMap<>();

        for (int lotto : lottos) {
            mapLotto.put(lotto, mapLotto.getOrDefault(lotto, 0) + 1);
        }
        for (int win : win_nums) {
            mapWin.put(win,  mapWin.getOrDefault(win, 0) + 1);
        }

        for (Integer integer : mapWin.keySet()) {
            if (mapLotto.getOrDefault(integer, 0) != 0) {
                answerMaxCnt++;
            }
        }
        answer[1] = getGrade(answerMaxCnt);
        if(mapLotto.get(0) != null)
            answerMaxCnt += mapLotto.get(0);
        answer[0] = getGrade(answerMaxCnt);


        return answer;
    }

    private int getGrade (int answerMaxCnt) {
        int grade = 0;
        int compare = 0;
        switch (answerMaxCnt) {
            case 6 : grade = 1;
                break;
            case 5 : grade = 2;
                break;
            case 4 : grade = 3;
                break;
            case 3 : grade = 4;
                break;
            case 2 : grade = 5;
                break;
            default:
                grade = 6;
        }
        return grade;
    }
}
