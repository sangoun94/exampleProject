package com.example.exampleproject.programers;

import java.util.*;

public class MarathonParticipant {

    public static void main(String[] args) {
        MarathonParticipant marathonParticipant = new MarathonParticipant();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String solution = marathonParticipant.solution(participant, completion);
        System.out.println(solution);
        System.out.println("solution = " + solution);
        System.out.println();
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hashMap = new HashMap<>();

        for (String player : participant) {
            hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        }

        for (String comp : completion) {
            hashMap.put(comp, hashMap.get(comp)-1);
        }

        for (String key : hashMap.keySet()) {
            if(hashMap.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
    /**
     * 탐색으로 찾아보기  [시간 초과 뜸]
     * @param participant
     * @param completion
     * @return
     */
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(completion));
        for (int j = 0; j < participant.length; j++) {
            int index = strings.indexOf(participant[j]);

            // 해당 값(participant[j])이 completion 어디에 포함되어 있는지
            if (index != -1) {
                strings.remove(index);
            } else {
                answer = participant[j];
            }
        }

        return answer;
    }
}
