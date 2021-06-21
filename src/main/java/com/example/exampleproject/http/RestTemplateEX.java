package com.example.exampleproject.http;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class RestTemplateEX {

    public static String API_URL = null;
    private ResponseEntity<String> responseEntity = null;
    public static String ACCESS_TOKEN = null;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public class Response {
        public int		status = 0;
        public String 	plaindata = null;
        public String 	errmsg  = null;
        public String 	errcode = null;
        public Object 	data = null;
    }

    public Response send(String uri, String method, String contentType, String querystring) {

        Response response = new Response();
        RestTemplate restTemplate = createRestTemplate();
        HttpMethod httpMethod = getHttpMethod(method);
        String address = RestTemplateEX.API_URL + uri;

        apiUrlOrAccessTokenNPECheck(RestTemplateEX.API_URL, RestTemplateEX.ACCESS_TOKEN);

        HttpHeaders headers = createHeader(contentType);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(headers);

        try {
            responseEntity = getRestTemplateExchange(querystring, restTemplate, httpMethod, address, request);
        } catch (HttpClientErrorException e) {
            return getErrorResultResponse(response, "HttpClientErrorException", e);
        } catch (HttpServerErrorException e) {
            return getErrorResultResponse(response, "HttpServerErrorException:", e);
        } finally {
            logger.info(">>> KtSender SendThread Fin");

            response.plaindata = responseEntity.getBody();
            response.status = responseEntity.getStatusCodeValue();

            return response;
        }
    }

    public void apiUrlOrAccessTokenNPECheck(String apiUrl, String accessToken){
        if(apiUrl == null || accessToken == null ||
                apiUrl.length() == 0 || accessToken.length() == 0) {

            try {
                throw new IOException("API_URL or accessToken is null.");
            } catch (IOException e) {
                logger.warn(e.getMessage());
            }

        }
    }

    public ResponseEntity<String> getRestTemplateExchange(String querystring, RestTemplate restTemplate, HttpMethod httpMethod, String address, HttpEntity<MultiValueMap<String, Object>> request) {
        if (querystring != null && querystring.length() > 0) {
            responseEntity = restTemplate.exchange(address, httpMethod, request, String.class, querystring);
        } else {
            responseEntity = restTemplate.exchange(address, httpMethod, request, String.class);
        }
        return responseEntity;
    }


    public HttpHeaders createHeader(String contentType) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "Bearer " + ACCESS_TOKEN);
        headers.add("Content-Type", contentType);

        System.out.println("headers = " + headers);

        // conn.setDefaultUseCaches(false); 강제 캐시 제한
        headers.setCacheControl("private, no-store, max-age=0");
        return headers;
    }

    public RestTemplate createRestTemplate() {
        HttpComponentsClientHttpRequestFactory factory = createHttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(factory);

        return restTemplate;
    }

    public HttpComponentsClientHttpRequestFactory createHttpComponentsClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(10000);
        factory.setReadTimeout(5000);

        return factory;
    }

    public Response getErrorResultResponse(Response resp, String str, Exception e) {
        logger.warn(str + ": " + e.getMessage());
        resp.status = -1;
        resp.errmsg = e.getLocalizedMessage();

        return resp;
    }

    public HttpMethod getHttpMethod(String method) {
        HttpMethod httpMethod = null;
        if (method == "POST") {
            httpMethod = HttpMethod.POST;
        } else {
            httpMethod = HttpMethod.GET;
        }

        return httpMethod;
    }

}
