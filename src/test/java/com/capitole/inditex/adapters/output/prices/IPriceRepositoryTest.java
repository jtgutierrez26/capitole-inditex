package com.capitole.inditex.adapters.output.prices;

import static org.junit.jupiter.api.Assertions.*;

import com.capitole.inditex.domain.prices.model.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IPriceRepositoryTest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm");
    private static final Long PRODUCT_ID = 35455L;
    public static final Long BRAND_ID = 1L;
    @Autowired
    private IPriceRepository priceRepository;

    @Test
    void findByParams() {
        String datePriceNow = "2020-06-14-10.00";
        LocalDateTime priceDate = LocalDateTime.parse(datePriceNow, DATE_TIME_FORMATTER);
        Optional<List<Price>> priceByParams = priceRepository.findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandId(priceDate, priceDate, PRODUCT_ID, BRAND_ID);
        assertEquals(1, priceByParams.map(List::size).orElse(0));

    }
}