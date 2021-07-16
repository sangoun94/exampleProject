package com.example.exampleproject.programers;

import java.util.*;

public class Phoneketmon {
    public static void main(String[] args) {
        Phoneketmon phoneketmon = new Phoneketmon();
        int[] nums = {3, 3, 3, 2, 2, 4};

        System.out.println("nums = " + phoneketmon.solution(nums));
    }
    public int solution(int[] nums) {
        int answer = 0;
        int numTypeCnt = 0;
        int separate = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, 0);
        }
        numTypeCnt = map.keySet().size();

        if (separate >= numTypeCnt) {
            answer = numTypeCnt;
        } else {
            answer = separate;
        }


        return answer;
    }
}
