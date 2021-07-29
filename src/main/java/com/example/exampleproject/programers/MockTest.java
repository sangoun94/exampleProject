package com.example.exampleproject.programers;

import org.springframework.boot.autoconfigure.amqp.AbstractRabbitListenerContainerFactoryConfigurer;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class MockTest {
    public static void main(String[] args) {
        MockTest mockTest = new MockTest();
        int[] eachStudent1 = {1,3,2,4,2};
        mockTest.solution(eachStudent1);
    }
    public int[] solution(int[] answers) {

        int[] eachStudent1 = {1, 2, 3, 4, 5};
        int[] eachStudent2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] eachStudent3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] correctCnt = {0,0,0};
        int max = 0;

        for (int i = 0; i < answers.length; i++) {
            if (eachStudent1[i % 5] == answers[i]) {
                correctCnt[0]++;
            }
            if (eachStudent2[i % 8] == answers[i]) {
                correctCnt[1]++;
            }
            if (eachStudent3[i % 10] == answers[i]) {
                correctCnt[2]++;
            }
        }
        map.put(1, correctCnt[0]);
        map.put(2, correctCnt[1]);
        map.put(3, correctCnt[2]);

        max = correctCnt[0];

        if (max < correctCnt[1]) {
            max = correctCnt[1];
        }
        if (max < correctCnt[2]) {
            max = correctCnt[2];
        }

        ArrayList<Integer> integers = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue().equals(max)) {
                integers.add(entry.getKey());
            }
        }

        int[] answer = new int[integers.size()];
        int size = 0;

        for (Integer integer : integers) {
            answer[size++] = integer;
        }

        return answer;
    }
}
