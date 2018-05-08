package exchange.boot;

import exchange.model.CurrencyBase;
import exchange.model.CurrencyRates;
import exchange.repository.CurrencyRatesRepo;
import exchange.repository.ExchangeRatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class LoadData implements CommandLineRunner {

    @Autowired
    private ExchangeRatesRepo exchangeRatesRepo;

    @Autowired
    private CurrencyRatesRepo currencyRatesRepo;

    @Override
    public void run(String... args) throws Exception {
        loadData();
        System.out.println("Bases are:");
        CurrencyBase baseF = exchangeRatesRepo.findByBase("USD");
        System.out.println(baseF);
        baseF.getRates().forEach(System.out::println);

        System.out.println("Rate by 'USD' base and 'EUR' currency is:");
        currencyRatesRepo.findByBaseAndCurrency("EUR","USD").forEach(System.out::println);
    }

    @Transactional
    public void loadData(){
        exchangeRatesRepo.deleteAllInBatch();

        CurrencyBase currencyBase = new CurrencyBase();
        currencyBase.setBase("USD");
        currencyBase.setDate(new Date());

        CurrencyRates currencyRates1 = new CurrencyRates();
        currencyRates1.setCurrency("EUR");
        currencyRates1.setRate(0.987898f);
        currencyRates1.setCurBase(currencyBase);

        CurrencyRates currencyRates2 = new CurrencyRates();
        currencyRates2.setCurrency("GBP");
        currencyRates2.setRate(0.824566f);
        currencyRates2.setCurBase(currencyBase);

        List<CurrencyRates> currencyRatesList = new LinkedList<>();
        currencyRatesList.add(currencyRates1);
        currencyRatesList.add(currencyRates2);
        currencyBase.setRates(currencyRatesList);

        exchangeRatesRepo.save(currencyBase);
    }
}