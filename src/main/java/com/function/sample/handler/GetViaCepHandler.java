package com.function.sample.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.function.sample.model.ViaCepRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetViaCepHandler implements RequestHandler<ViaCepRequest, String> {
    @Override
    public String handleRequest(ViaCepRequest viaCep, Context context) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/";
        ResponseEntity<String> response
                = restTemplate.getForEntity(url + viaCep.getCep() +"/json/", String.class);
        return response.getBody();
    }
}
