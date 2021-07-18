package com.example.exampleproject.programers;

import java.util.*;

public class WorkoutClothes {
    public static void main(String[] args) {
        WorkoutClothes workoutClothes = new WorkoutClothes();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 2, 3};
        workoutClothes.solution(n, lost, reserve);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        // 1. lost 와 reserve 인접해 있는지
        // 2. reserve 1명 구재
        // 3. 최대는 n명
        int answer = 0;
        int[] arr = new int[n];
        LinkedList<Integer> integers = new LinkedList<>();

        arr = createArray(n, lost, reserve, arr);
        integers = addLinkedList(arr, integers);

        integers = procList(integers);

        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > 0)
                answer += 1;
        }
        return answer;
    }

    private LinkedList<Integer> procList(LinkedList<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            if (i-1 > -1 && integers.get(i - 1) == 0 && integers.get(i) == 2) {
                integers.set(i - 1, 1);
                integers.set(i, 1);
            } else if (i+1 < integers.size() && integers.get(i + 1) == 0 && integers.get(i) == 2) {
                integers.set(i + 1, 1);
                integers.set(i, 1);
            }
        }
        return integers;
    }

    private LinkedList<Integer> addLinkedList(int[] arr, LinkedList<Integer> integers) {
        for (int i : arr) {
            integers.add(i);
        }
        return integers;
    }

    private int[] createArray(int n, int[] lost, int[] reserve, int[] arr) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1] = arr[lost[i] - 1] - 1;
        }
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1] = arr[reserve[i] - 1] + 1;
        }
        return arr;
    }
}
