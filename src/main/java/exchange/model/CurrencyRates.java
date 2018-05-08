package exchange.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CurrencyRates implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRate;
    private String currency;
    private Float rate;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "idBase")
    private CurrencyBase curBase;

    public CurrencyRates() {
    }

    public CurrencyRates(String currency, Float rate, CurrencyBase curBase) {
        this.currency = currency;
        this.rate = rate;
        this.curBase = curBase;
    }

    public long getIdRate() {
        return idRate;
    }

    public void setIdRate(long idRate) {
        this.idRate = idRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public CurrencyBase getCurBase() {
        return curBase;
    }

    public void setCurBase(CurrencyBase curBase) {
        this.curBase = curBase;
    }

    @Override
    public String toString() {
        return "CurrencyRates{" +
                "idRate=" + idRate +
                ", currency='" + currency + '\'' +
                ", rate=" + rate +
                //", curBase=" + curBase +
                '}';
    }
}
