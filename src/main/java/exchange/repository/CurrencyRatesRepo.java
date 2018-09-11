package exchange.repository;

import exchange.model.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rates", path = "rates")
public interface CurrencyRatesRepo extends JpaRepository<CurrencyRates, Long> {

    @Query("SELECT r FROM CurrencyRates r WHERE r.currency = :currency")
    List<CurrencyRates> findByCurrency(@Param("currency") String currency);

    //@Query("SELECT r FROM CurrencyRates r WHERE r.curBase.base = :base AND r.currency = :currency")
    //List<CurrencyRates> findByBaseAndCurrency(@Param("currency") String currency, @Param("base") String base);

    @Query("SELECT r FROM CurrencyRates r WHERE r.curBase.base = :base AND r.currency = :currency")
    List<CurrencyRates> findData(@Param("currency") String currency, @Param("base") String base);

    @Query("SELECT r FROM CurrencyRates r WHERE r.curBase.base = :base AND r.currency = :currency")
    CurrencyRates findByBaseAndCurrency(@Param("currency") String currency, @Param("base") String base);

}


