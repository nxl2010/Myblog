package com.example.myblog.api;

import com.example.myblog.enity.Quotes;
import com.example.myblog.service.impl.QuotesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/quotes")
public class QuotesApi {
    private final QuotesService quotesService;

    public QuotesApi(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping("/random")
    public Quotes findQuotes(){
        return quotesService.findRandom();
    }

}
