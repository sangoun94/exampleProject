package com.example.exampleproject.programers;

public class EnglishChangeNumber {
    public static void main(String[] args) {
        EnglishChangeNumber englishChangeNumber = new EnglishChangeNumber();
        englishChangeNumber.solution("2three45sixseven");
    }
    public int solution(String s) {
        int answer = 0;
//        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        if (s.indexOf("one") != -1) {
            s = s.replaceAll("one", "1");
        }
        if (s.indexOf("two") != -1) {
            s = s.replaceAll("two", "2");
        }
        if (s.indexOf("three") != -1) {
            s = s.replaceAll("three", "3");
        }
        if (s.indexOf("four") != -1) {
            s = s.replaceAll("four", "4");
        }
        if (s.indexOf("five") != -1) {
            s = s.replaceAll("five", "5");
        }
        if (s.indexOf("six") != -1) {
            s = s.replaceAll("six", "6");
        }
        if (s.indexOf("seven") != -1) {
            s = s.replaceAll("seven", "7");
        }
        if (s.indexOf("eight") != -1) {
            s = s.replaceAll("eight", "8");
        }
        if (s.indexOf("nine") != -1) {
            s = s.replaceAll("nine", "9");
        }
        if (s.indexOf("zero") != -1) {
            s = s.replaceAll("zero", "0");
        }

        /*for (int i = 0; i < strArr.length; i++) {
            if (s.indexOf(strArr[i]) != -1) {
                s = s.replaceAll(strArr[i], Integer.toString(i));
            }
        }*/

        answer = Integer.parseInt(s);

        return answer;
    }
}
