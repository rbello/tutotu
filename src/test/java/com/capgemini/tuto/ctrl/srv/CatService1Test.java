package com.capgemini.tuto.ctrl.srv;

import com.capgemini.tuto.dto.CatFactResponse;
import com.capgemini.tuto.srv.CatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CatService1Test {

    @Autowired
    private CatService realCatService;

    @MockBean
    private CatService mockCatService;

    @Test
    public void testWithRealRemoteEndpoint() {
        var facts = realCatService.getFacts();
        assertNotNull(facts);
        assertTrue(facts.length > 1);
    }

    @BeforeEach
    public void initMockService() {
        var facts = new CatFactResponse[2];
        facts[0] = new CatFactResponse();
        facts[1] = new CatFactResponse();
        Mockito.when(mockCatService.getFacts()).thenReturn(facts);
    }

    @Test
    public void testWithMockedEndpoint() {
        var facts = mockCatService.getFacts();
        assertNotNull(facts);
        assertEquals(2, facts.length);
    }

}
