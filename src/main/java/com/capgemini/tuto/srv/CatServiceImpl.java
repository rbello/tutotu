package com.capgemini.tuto.srv;

import com.capgemini.tuto.dto.CatFactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private RestTemplateBuilder builder;

    @Value("${external.service.cat}")
    private String url;

    public CatFactResponse[] getFacts() {
        return builder.build().getForObject(url, CatFactResponse[].class);
    }

}