package exchange.controllers;

import exchange.model.CurrencyRates;
import exchange.model.Rate;
import exchange.repository.CurrencyRatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/latest")
public class ExchangeRateController {
    @Autowired
    private CurrencyRatesRepo currencyRatesRepo;

    @RequestMapping(method = GET)
    Rate getLatestRate(@RequestParam(value="base") String base, @RequestParam(value="symbol") String symbol){

        System.out.println("Rate by 'USD' base and 'EUR' currency is:");
        List<CurrencyRates> ratesList = currencyRatesRepo.findByBaseAndCurrency(symbol,base);
        ratesList.forEach(System.out::println);
        CurrencyRates currencyRates = ratesList.get(0);

        Rate rate = new Rate(currencyRates.getCurrency(), currencyRates.getRate());
        return rate;

    }
}

