package com.capitole.inditex.application.prices.services;

import com.capitole.inditex.domain.prices.dto.PriceDto;
import com.capitole.inditex.exceptions.ProjectException;

import java.util.Optional;

public interface IPriceService {
    Optional<PriceDto> findPriceWithDateAndProductIdAndBrandId(String dateApplication, Long productId, Long brandId) throws ProjectException;
}
