package com.example.exampleproject.structure;

import java.util.Stack;

public class StructureUtil {

    StringBuilder getBackwardsString(String str) {
        Stack<Character> strings = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            strings.push(str.charAt(i));
        }

        while (!strings.empty()) {
            stringBuilder.append(strings.pop());
        }

        return stringBuilder;
    }
}
