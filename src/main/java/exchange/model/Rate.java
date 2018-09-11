package exchange.model;

import javax.persistence.Entity;

public class Rate {
    private String symbol;
    private Float value;

    public Rate() {
    }

    public Rate(String symbol, Float value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }
}
