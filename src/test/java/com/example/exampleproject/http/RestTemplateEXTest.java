package com.example.exampleproject.http;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RequiredArgsConstructor
@SpringBootTest
class RestTemplateEXTest {




    @Test
    public void 센드후_레스트템플릿만들기() throws Exception{
        //given
        RestTemplateEX mockedRest = mock(RestTemplateEX.class);
        //when
        mockedRest.send("http://naver.com","POST","application/json","dkanrjtehahffkdy:wkrldi");
        //then
        verify(mockedRest, times(1)).send("http://naver.com","POST","application/json","dkanrjtehahffkdy:wkrldi");
        when(mockedRest.createRestTemplate()).thenReturn(new RestTemplate());
    }

    @Test
    public void 메서드확인() throws Exception{
        //given
        RestTemplateEX mockedRest = mock(RestTemplateEX.class);
        //when
        mockedRest.send("http://naver.com","POST","application/json","dkanrjtehahffkdy:wkrldi");
        //then
        verify(mockedRest).send("http://naver.com","POST","application/json","dkanrjtehahffkdy:wkrldi");
        when(mockedRest.getHttpMethod("POST")).thenReturn(HttpMethod.POST);
    }

    @Test
    public void 센드후_쿼리스트링널포인트예외체크() {
        //given
        RestTemplateEX mockedRest = mock(RestTemplateEX.class);

        //when
        mockedRest.send("http://naver.com","POST","application/json","dkanrjtehahffkdy:wkrldi");
        mockedRest.apiUrlOrAccessTokenNPECheck("null", "soenklsg32195");
        //then
        verify(mockedRest).send("http://naver.com","POST","application/json","dkanrjtehahffkdy:wkrldi");
        verify(mockedRest).apiUrlOrAccessTokenNPECheck("null", "soenklsg32195");

        doThrow(new MockitoException("TestMessage"))
                .when(mockedRest)
                .apiUrlOrAccessTokenNPECheck(isNull(),anyString());
        mockedRest.apiUrlOrAccessTokenNPECheck(null, "soenklsg32195");

    }

    
    @Test
    public void 헤더만들기() throws Exception{
        //given
        RestTemplateEX mockedRest = mock(RestTemplateEX.class);
        //when
        HttpHeaders header = mockedRest.createHeader("application/json");
        when(mockedRest.createHeader("application/json")).thenReturn(new HttpHeaders());
        //then

    }

}