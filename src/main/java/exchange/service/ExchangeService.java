package exchange.service;

import exchange.model.CurrencyBase;
import exchange.model.CurrencyRates;
import exchange.model.CurrencyRatesData;
import exchange.model.Rate;

import java.util.List;

public interface ExchangeService {

    CurrencyRatesData findByBase(String base);
    Rate findRate(String base, String symbol);
    void createCurrencyRates(CurrencyBase currencyBase);

    //Rate findLatest(String base, String currency);
    //CurrencyBase findByBase(String base);
}
