package com.arunapi.wiremock.example;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class WiremockTest {
    Logger log = LoggerFactory.getLogger(WiremockTest.class.getName());
    @Test
    public void getMappings(){
        RestTemplate restTemplate = new RestTemplate();
        String mappingsJson = restTemplate.getForObject("http://localhost:7443/__admin/mappings",String.class);
        log.info(mappingsJson);
    }
}
