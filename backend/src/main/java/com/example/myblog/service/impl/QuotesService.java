package com.example.myblog.service.impl;

import com.example.myblog.enity.Quotes;
import com.example.myblog.repository.QuotesRepository;
import com.example.myblog.service.IQuotesService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class QuotesService implements IQuotesService {
    private final QuotesRepository quotesRepository;

    public QuotesService(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public Quotes findRandom() {
        long maxid = quotesRepository.count();
        Random random = new Random();
        int id = random.nextInt(((int) maxid - 1) + 1) + 1;
        Optional<Quotes> optionalQuotes = quotesRepository.findById(id);
        if (optionalQuotes.isPresent()){
            return optionalQuotes.get();
        }
        return null;
    }
}
