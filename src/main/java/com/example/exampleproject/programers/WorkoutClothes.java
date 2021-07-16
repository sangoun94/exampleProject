package com.example.exampleproject.programers;

import java.util.*;

public class WorkoutClothes {
    public static void main(String[] args) {
        WorkoutClothes workoutClothes = new WorkoutClothes();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1,3};
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
        integers = createLinkedList(arr, integers);
        ListIterator<Integer> iterList = integers.listIterator();

        while (!iterList.hasNext()) {
            if (iterList.next() != 2) {

            }
        }






        return answer;
    }

    private LinkedList<Integer> createLinkedList(int[] arr, LinkedList<Integer> integers) {
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
            arr[lost[i]-1] = 0;
        }
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]-1] = 2;
        }
        return arr;
    }
}
