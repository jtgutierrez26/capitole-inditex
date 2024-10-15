package com.capitole.inditex.application.prices.services;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import com.capitole.inditex.domain.prices.dto.PriceDto;
import com.capitole.inditex.exceptions.ProjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

class PriceServiceTest {

    @Mock
    private IPriceService priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findPriceWithValidParamsSuccess() throws ProjectException {
        String dateApplication = "2020-06-14-10.00";
        Long productId = 35455L;
        Long brandId = 1L;

        PriceDto price = PriceDto.builder()
                .price(new BigDecimal("35.50"))
                .build();
        Optional<PriceDto> expectedPrice = Optional.of(price);

        when(priceService.findPriceWithDateAndProductIdAndBrandId(dateApplication, productId, brandId))
                .thenReturn(expectedPrice);

        Optional<PriceDto> actualPrice = priceService.findPriceWithDateAndProductIdAndBrandId(dateApplication, productId, brandId);

        assertTrue(actualPrice.isPresent());
        assertEquals(new BigDecimal("35.50"), actualPrice.get().getPrice());
    }

    @Test
    void findPriceWithNoResult() throws ProjectException {
        String dateApplication = "2020-06-14-10.00";
        Long productId = 99999L;  // Nonexistent product
        Long brandId = 1L;

        // It is simulated that no price is found
        when(priceService.findPriceWithDateAndProductIdAndBrandId(dateApplication, productId, brandId))
                .thenReturn(Optional.empty());

        Optional<PriceDto> actualPrice = priceService.findPriceWithDateAndProductIdAndBrandId(dateApplication, productId, brandId);

        // Empty prices are received
        assertFalse(actualPrice.isPresent());
    }

    @Test
    void findPriceWithException() {
        String dateApplication = "2020-06-14-10.00";
        Long productId = 35455L;
        Long brandId = 1L;

        // It is simulated that the service throws an exception
        when(priceService.findPriceWithDateAndProductIdAndBrandId(dateApplication, productId, brandId))
                .thenThrow(new ProjectException("Error in the query"));

        // It is verified that the exception is thrown
        ProjectException exception = assertThrows(ProjectException.class, () -> priceService.findPriceWithDateAndProductIdAndBrandId(dateApplication, productId, brandId));

        assertEquals("Error in the query", exception.getMessage());
    }
}
