package com.advencedjava.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.advencedjava.api.dto.SearchResult;

public class JSONParse {
    private static final Logger log = LoggerFactory.getLogger(JSONParse.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        SearchResult result = restTemplate.getForObject("https://api.openagenda.com/v1/agendas/46935850/events?lat=43.524360&lng=5.445613&radius=1000&key=s89Zf831m52LgHMNCUTWfVdNHte8VUtG", SearchResult.class);
        log.info(result.getCode().toString());
    }
}
