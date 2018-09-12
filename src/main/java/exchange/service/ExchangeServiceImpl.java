package exchange.service;

import exchange.model.CurrencyBase;
import exchange.model.CurrencyRates;
import exchange.model.CurrencyRatesData;
import exchange.model.Rate;
import exchange.repository.CurrencyRatesRepo;
import exchange.repository.ExchangeRatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("exchangeService")
@Transactional

public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private CurrencyRatesRepo currencyRatesRepo;

    @Autowired
    private ExchangeRatesRepo exchangeRatesRepo;

    @Override
    public CurrencyRatesData findByBase(String base) {
        List<CurrencyBase> baseList = exchangeRatesRepo.findByBase(base);
        if(baseList.size()==0){
            return null;
        }

        CurrencyBase cBase = baseList.get(0);
        List<Rate> rates = new ArrayList<>();
        List<CurrencyRates> ratesList = cBase.getRates();
        for(CurrencyRates cR : ratesList){
            Rate r = new Rate();
            r.setSymbol(cR.getCurrency());
            r.setValue(cR.getRate());
            rates.add(r);
        }
        return new CurrencyRatesData(cBase.getBase(), cBase.getDate(), rates);
    }

    @Override
    public void createCurrencyRates(CurrencyBase currencyBase) {
        exchangeRatesRepo.save(currencyBase);
    }

    @Override
    public Rate findRate(String base, String symbol) {
        CurrencyRates cRates = currencyRatesRepo.findByBaseAndCurrency(symbol, base);
        Rate rate = new Rate(cRates.getCurrency(), cRates.getRate());
        return rate;
    }
}
