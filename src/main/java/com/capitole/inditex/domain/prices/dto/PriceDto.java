package com.capitole.inditex.domain.prices.dto;

import com.capitole.inditex.domain.prices.model.Brand;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PriceDto implements Serializable {
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Brand brand;

    @Size(min = 1)
    @NotNull
    private Long brandId;

    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    @JsonIgnore
    @NotNull
    private Integer priceList;
    @Size(min = 1)
    @NotNull
    private Long productId;
    @NotNull
    @JsonIgnore
    private Integer priority;
    @NotNull
    @JsonProperty("" + "price")
    private BigDecimal price;
    @JsonIgnore
    @Size(max = 5)
    @NotNull
    private String curr;
}