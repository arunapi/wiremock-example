package com.arunapi.wiremock.example.priority;

import com.arunapi.wiremock.example.FileUtil;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Set;
import java.util.logging.Logger;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;


public class PriorityExample {

    Logger log = Logger.getLogger(PriorityExample.class.getName());
    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    public void shouldPayForMultipleBookingsOneOfWhichWillFailOnTheFraudCheck() throws Exception {

        // Given
        stubFor(post(urlPathEqualTo("/payments"))
                .withRequestBody(matchingJsonPath("$.creditCardNumber"))
                .withRequestBody(matchingJsonPath("$.creditCardExpiry"))
                .withRequestBody(matchingJsonPath("$.amount"))
                .withRequestBody(matchingJsonPath("$.paymentId"))
                .willReturn(
                        okJson("{" +
                                "  \"paymentResponseStatus\": \"SUCCESS\"" +
                                "}")));

        stubFor(get(urlPathEqualTo("/blacklisted-cards/0000-0000-0000-0000"))
                .atPriority(1)
                .willReturn(okJson("{" +
                        "  \"blacklisted\": \"true\"" +
                        "}")));

        stubFor(get(urlPathMatching("/blacklisted-cards/.*"))
                .atPriority(100)
                .willReturn(okJson("{" +
                        "  \"blacklisted\": \"false\"" +
                        "}")));


        RestTemplate restTemplate = new RestTemplate();
        String mappingsJson = restTemplate
                .getForObject(
                        String.format("http://localhost:%s/__admin/mappings", wireMockRule.port()),
                        String.class);

        FileUtil.saveMapping(this.getClass().getSimpleName(),mappingsJson);
        log.info(mappingsJson);
    }
}
