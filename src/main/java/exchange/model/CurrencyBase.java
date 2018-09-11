package exchange.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class CurrencyBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBase;

    private String base = "USD";

    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="curBase", cascade= CascadeType.ALL)
    private List<CurrencyRates> rates = new ArrayList<>();

    public CurrencyBase() {
    }

    public CurrencyBase(String base, LocalDate date, List<CurrencyRates> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public long getIdBase() {
        return idBase;
    }

    public void setIdBase(long idBase) {
        this.idBase = idBase;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<CurrencyRates> getRates() {
        if (this.rates == null) {
            return Collections.EMPTY_LIST;
        }
        return rates;
    }

    public void setRates(List<CurrencyRates> rates) {
        for(CurrencyRates cr : rates){
            this.rates.add(cr);
        }
    }

    @Override
    public String toString() {
        StringBuilder ratesString = new StringBuilder("");
        for(CurrencyRates cRates : rates){
            ratesString.append(cRates.getCurrency()).append(": ").append(cRates.getRate()).append('\n');
        }
        return "CurrencyBase{" +
                "idBase=" + idBase +
                ", base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + ratesString +
                '}';
    }
}
