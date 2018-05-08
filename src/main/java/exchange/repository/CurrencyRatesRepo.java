package exchange.repository;

import exchange.model.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rates", path = "rates")
public interface CurrencyRatesRepo extends JpaRepository<CurrencyRates, Long> {

    /*@Query("SELECT r FROM CurrencyRates r JOIN r.curBase b WHERE b.base = :base and r.currency = :currency")
    List<Object> findBaseRates(@Param("base") String base, @Param("currency") String currency);*/
    @Query("SELECT r FROM CurrencyRates r WHERE r.currency = :currency")//b.base = :base and
    List<CurrencyRates> findByCurrency(@Param("currency") String currency);

    //@Query("SELECT r FROM CurrencyBase b, CurrencyRates r JOIN r.curBase WHERE r.currency = :currency and r.curBase.base = :base")//b.base = :base and
    //List<Object[]> findByBaseAndCurrency(@Param("currency") String currency, @Param("base") String base);

    @Query("SELECT r FROM CurrencyRates r WHERE r.curBase.base = :base AND r.currency = :currency")//b.base = :base and
    List<CurrencyRates> findByBaseAndCurrency(@Param("currency") String currency, @Param("base") String base);

    @Query("SELECT r FROM CurrencyRates r WHERE r.curBase.base = :base AND r.currency = :currency")//b.base = :base and
    List<CurrencyRates> findData(@Param("currency") String currency, @Param("base") String base);

}


