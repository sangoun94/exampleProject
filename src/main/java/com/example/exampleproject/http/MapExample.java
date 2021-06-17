package com.example.exampleproject.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

    private String send() {

        ArrayList<String> headerKey = new ArrayList<>();
        ArrayList<String> headerValue = new ArrayList<>();
        headerKey.add("Authorization");
        headerKey.add("Content-Type");
        headerValue.add("Bearer ");
        headerValue.add("contentType ");
        List<Map<ArrayList<String>, ArrayList<String>>> headerList = getHeaderList(headerKey, headerValue);

        return "";
    }

    private List<Map<ArrayList<String>, ArrayList<String>>> getHeaderList(ArrayList<String> key, ArrayList<String> value) {
        List<Map<ArrayList<String>, ArrayList<String>> > headerList = new ArrayList<>();
        Map<ArrayList<String>, ArrayList<String>> headerMap = new HashMap<>();
        headerMap.put(key, value);

        headerList.add(headerMap);
        return headerList;
    }

    public static void main(String[] args) {
        MapExample mapExample = new MapExample();
        mapExample.send();
    }
}
