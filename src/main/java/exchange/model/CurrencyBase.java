package exchange.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class CurrencyBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBase;

    private String base = "USD";

    private Date date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="curBase", cascade= CascadeType.ALL)
    private List<CurrencyRates> rates;

    public CurrencyBase() {
    }

    public CurrencyBase(String base, Date date, List<CurrencyRates> rates) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<CurrencyRates> getRates() {
        if (this.rates == null) {
            return Collections.EMPTY_LIST;
        }
        return rates;
    }

    public void setRates(List<CurrencyRates> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "CurrencyBase{" +
                "idBase=" + idBase +
                ", base='" + base + '\'' +
                ", date=" + date +
                //", rates=" + rates +
                '}';
    }
}
