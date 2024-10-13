package com.capitole.inditex.application.prices.services;

import com.capitole.inditex.adapters.output.prices.IPriceRepository;
import com.capitole.inditex.domain.prices.dto.PriceDto;
import com.capitole.inditex.domain.prices.model.Price;
import com.capitole.inditex.exceptions.ProjectException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements IPriceService {

    private final IPriceRepository iPriceRepository;
    private final ModelMapper modelMapper;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm");
    private static String MESSAGE_NOT_FOUND_PRICE = "Error: No found any price";
    private static String MESSAGE_NOT_FOUND_BRAND = "Error: No found any brand";
    private static String MESSAGE_NOT_FOUND_PRODUCT = "Error: No found any product";
    private static String MESSAGE_INVALID_FORMAT_DATE = "Error: Invalid format date, please use yyyy-MM-dd-HH.mm format";

    public PriceServiceImpl(IPriceRepository iPriceRepository, ModelMapper modelMapper) {
        this.iPriceRepository = iPriceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<PriceDto> findPriceWithDateAndProductIdAndBrandId(String dateApplication, Long productId, Long brandId) throws ProjectException {
        validateInputData(dateApplication, productId, brandId);
        LocalDateTime date = LocalDateTime.parse(dateApplication, DATE_TIME_FORMATTER);
        List<Price> prices = iPriceRepository.findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandId(date, date, productId, brandId)
                .orElseThrow(() -> new ProjectException(MESSAGE_NOT_FOUND_PRICE));

        if (prices.isEmpty()) {
            throw new ProjectException(MESSAGE_NOT_FOUND_PRICE);
        }

        Price price = prices
                .stream().max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new ProjectException(MESSAGE_NOT_FOUND_PRICE));

        return Optional.of(modelMapper.map(price, PriceDto.class));
    }

    private void validateInputData(String priceDateStr, Long productId, Long brandId) throws ProjectException {
        List<Price> pricesByBrand = iPriceRepository.findAllByBrandId(brandId).orElse(null);
        if (CollectionUtils.isEmpty(pricesByBrand)) {
            throw new ProjectException(MESSAGE_NOT_FOUND_BRAND);
        }

        List<Price> pricesByProduct = iPriceRepository.findAllByProductId(productId).orElse(null);
        if (CollectionUtils.isEmpty(pricesByProduct)) {
            throw new ProjectException(MESSAGE_NOT_FOUND_PRODUCT);
        }

        try {
            LocalDateTime.parse(priceDateStr, DATE_TIME_FORMATTER);
        } catch (Exception e) {
            throw new ProjectException(MESSAGE_INVALID_FORMAT_DATE);
        }
    }
}
