package com.example.exampleproject.programers;

public class NewIdKakao {
    public static void main(String[] args) {
        NewIdKakao newIdKakao = new NewIdKakao();
        newIdKakao.solution("=.=");
    }

    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
//        answer = answer.replaceAll("[^a-z\\d\\-_.]", "");
        answer = answer.replaceAll("[^\\w\\-_.]", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");

        if (answer.length() == 0) {
            answer = answer.concat("a");
        }

        if (answer.length() > 15)
            answer = answer.substring(0, 15).replaceAll("[.]$", "");

        if (answer.length() == 2)
            answer = answer.concat(String.valueOf(answer.charAt(answer.length() - 1)));
        else if (answer.length() == 1) {
            answer = answer.concat(String.valueOf(answer.charAt(answer.length() - 1)));
            answer = answer.concat(String.valueOf(answer.charAt(answer.length() - 1)));
        }

        return answer;
    }
}
