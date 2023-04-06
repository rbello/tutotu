package com.capgemini.tuto.ctrl.srv;

import com.capgemini.tuto.srv.CatService;
import com.github.tomakehurst.wiremock.http.Fault;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.web.client.ResourceAccessException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 1234)
public class CatService2Test {

    @Autowired
    private CatService realCatService;

    @Test
    public void testSuccess() {
        stubFor(get(urlEqualTo("/facts")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json;charset=UTF-8")
                .withBodyFile("cat-service.json")));

        var facts = realCatService.getFacts();
        assertNotNull(facts);
        assertEquals(3, facts.length);
    }

    @Test
    public void testFailure() {
        stubFor(get(urlEqualTo("/facts")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json;charset=UTF-8")
                .withFixedDelay(1000)
                .withFault(Fault.CONNECTION_RESET_BY_PEER)
                .withBodyFile("cat-service.json")));

        assertThrows(ResourceAccessException.class, () -> realCatService.getFacts());
    }

}
