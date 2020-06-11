package com.function.sample.function;

import com.function.sample.model.ViaCepRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

public class GetViaCep implements Function<ViaCepRequest, String> {
    @Override
    public String apply(ViaCepRequest viaCep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/";
            ResponseEntity<String> response
                    = restTemplate.getForEntity(url + viaCep.getCep() +"/json/", String.class);
            return response.getBody();

    }
}
