package exchange.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CurrencyRatesData {

    private String base = "USD";
    private LocalDate date;
    private List<Rate> rates;

    public CurrencyRatesData() {
    }
    public CurrencyRatesData(String base, LocalDate date, List<Rate> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Rate> getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "CurrencyRates{" +
                "base='" + base + '\'' +
                "date='" + date +
                "rates=" + rates +
                '}';
    }
}
