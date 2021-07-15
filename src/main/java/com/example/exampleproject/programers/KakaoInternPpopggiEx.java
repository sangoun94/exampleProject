package com.example.exampleproject.programers;

import java.util.Stack;

public class KakaoInternPpopggiEx {

    public static void main(String[] args) {
        KakaoInternPpopggiEx ex = new KakaoInternPpopggiEx();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(ex.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> initStack = new Stack<>();

        answer = stackManager(board, moves, initStack, answer);


        return answer;
    }

    private int stackManager(int[][] board, int[] moves, Stack<Integer> initStack, int answer) {
        int pick = 0;
        int[][] removePrototype = {{0}, {0}};
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                pick = board[i][move - 1];
                if (pick == 0) continue;
                if (!initStack.empty() && initStack.peek() == pick) {
                    initStack.pop();
                    answer += 2;
                } else {
                    initStack.push(pick);
                }
                board[i][move - 1] = removePrototype[0][0];
                break;
            }
        }
        return answer;
    }
}
