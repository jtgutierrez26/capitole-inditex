package com.capitole.inditex.adapters.input.prices;

import com.capitole.inditex.application.prices.services.IPriceService;
import com.capitole.inditex.domain.prices.dto.PriceDto;
import com.capitole.inditex.exceptions.ProjectException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PriceController {

    private final IPriceService iPriceService;

    public PriceController(IPriceService iPriceService) {
        this.iPriceService = iPriceService;
    }

    @GetMapping("/prices/product/{idProduct}/brand/{idBrand}")
    public ResponseEntity<PriceDto> getPrice(@PathVariable("idProduct") Long idProduct,
                                             @PathVariable("idBrand") Long idBrand,
                                             @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm") @RequestParam("date") String date) throws ProjectException {

        if (date == null || idProduct == null || idBrand == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<PriceDto> optionalPrice = iPriceService.findPriceWithDateAndProductIdAndBrandId(date, idProduct, idBrand);
        if (optionalPrice.isPresent()) {
            PriceDto price = optionalPrice.get();
            return new ResponseEntity<>(price, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new PriceDto(), HttpStatus.NOT_FOUND);
        }

    }
}
