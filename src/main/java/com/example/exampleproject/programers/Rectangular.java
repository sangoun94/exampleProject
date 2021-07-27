package com.example.exampleproject.programers;

import java.util.HashMap;
import java.util.HashSet;

public class Rectangular {
    public static void main(String[] args) {
        Rectangular rectangular = new Rectangular();
        int[][] v= {{1, 4}, {3, 4}, {3, 10}};
        int[] solution = rectangular.solution(v);
        System.out.println("solution = " + solution);

    }
    public int[] solution(int[][] v) {
        int[] answer = {0,0};
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();


        for (int i = 0; i < v.length; i++) {
            map2.put(v[i][0], map2.getOrDefault(v[i][0],0) + 1);
            map1.put(v[i][1], map1.getOrDefault(v[i][1],0) + 1);
        }

        for (Integer integer : map2.keySet()) {
            if (map2.get(integer) == 1) {
                answer[0] = integer;
            }
        }

        for (Integer integer : map1.keySet()) {
            if (map1.get(integer) == 1) {
                answer[1] = integer;
            }
        }
        return answer;
    }
}
