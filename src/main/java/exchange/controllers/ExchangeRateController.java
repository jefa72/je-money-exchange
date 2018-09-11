package exchange.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import exchange.model.CurrencyBase;
import exchange.model.CurrencyRates;
import exchange.model.CurrencyRatesData;
import exchange.model.Rate;
import exchange.repository.CurrencyRatesRepo;
import exchange.repository.ExchangeRatesRepo;
import exchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ExchangeRateController {

    @Autowired
    ExchangeService exchangeService;


    @Autowired
    private CurrencyRatesRepo currencyRatesRepo;

    @Autowired
    private ExchangeRatesRepo exchangeRatesRepo;


    @RequestMapping(path = {"/create"}, method = POST)
    public ResponseEntity<Void> createCurrencyRates(@RequestBody CurrencyBase currencyBase){

        if(exchangeService.findByBase(currencyBase.getBase())!=null){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        exchangeService.createCurrencyRates(currencyBase);
        return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);

    }

    @RequestMapping(path = {"/base"}, method = GET)
    public ResponseEntity<CurrencyRatesData> findByBase(@RequestParam(value="base") String base){

        CurrencyRatesData cRates = exchangeService.findByBase(base);
        if(cRates == null){
            return new ResponseEntity<CurrencyRatesData>(cRates, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CurrencyRatesData>(cRates, HttpStatus.OK);
    }

    @RequestMapping(path = {"/latest"}, method = GET)
    public ResponseEntity<Rate> findByBaseAndSymbol(@RequestParam(value="base") String base, @RequestParam(value="symbol") String symbol){

        Rate rate = exchangeService.findRate(base, symbol);
        return new ResponseEntity<Rate>(rate, HttpStatus.OK);
    }

}

