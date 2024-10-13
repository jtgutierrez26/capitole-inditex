package com.capitole.inditex.adapters.output.prices;

import com.capitole.inditex.domain.prices.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPriceRepository extends JpaRepository<Price, Long> {
    Optional<List<Price>> findAllByBrandId(Long brandId);
    Optional<List<Price>> findAllByProductId(Long productId);
    Optional<List<Price>> findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandId(LocalDateTime startDate, LocalDateTime priceDate, Long productId, Long brandId);
}
