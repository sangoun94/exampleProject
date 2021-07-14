package com.example.exampleproject.structure;


import java.util.Stack;

public class StackEX {

    public static void main(String[] args) {
        String str = "어서오십시오 여기는 자료구조 세계입니다.";

        StructureUtil structureUtil = new StructureUtil();

        StringBuilder backwardsStringtoStack = structureUtil.getBackwardsString(str);
        StringBuilder stringBuilder = new StringBuilder();

        String s = stringBuilder.append(str).reverse().toString();

        System.out.println("backwardsString = " + backwardsStringtoStack);
        System.out.println("s = " + s);

    }
}
