package com.example.exampleproject;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@SpringBootTest
@Slf4j
class ExampleProjectApplicationTests {

    URL ocu = null;
    BufferedReader in = null;
    String inputLine;
    URLConnection conn = null;
    @Test
    void url() {
        try {
            ocu = new URL("https://naver.com");
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }
        try {
            in = new BufferedReader(new InputStreamReader(ocu.openStream()));
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        try {
            while (((inputLine = in.readLine()) != null))
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    void urlConnection() {
        try {
            ocu = new URL("https://naver.com");
            conn = ocu.openConnection();
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        try {
            in = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        try {
            while (((inputLine = in.readLine()) != null))
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
