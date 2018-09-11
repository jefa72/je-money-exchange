package exchange.repository;

import exchange.model.CurrencyBase;
import exchange.model.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "exchangeRates", path = "exchangeRates")
public interface ExchangeRatesRepo extends JpaRepository<CurrencyBase, Long> {
    @Query("SELECT b FROM CurrencyBase b WHERE b.base = :base")//b.base = :base and
    List<CurrencyBase> findByBase(@Param("base") String base);
}
