package com.capitole.inditex.adapters.input.prices;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    public static final String URL_CONTROLLER = "/prices/product";
    public static final String PRODUCT_35455 = "35455";
    public static final String BRAND_ZARA = "1";

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPriceTest1Success() {

        // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        String dateApplication = "2020-06-14-10.00";
        double priceOk = 35.50;
        try {
            mockMvc.perform(get("/prices/product/{idProduct}/brand/{idBrand}", PRODUCT_35455, BRAND_ZARA)
                    .param("date", dateApplication)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.price", Is.is(priceOk)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void getPriceTestFailure() {

        // Test KO: petición con brand que no existe
        String dateApplication = "2020-06-14-10.00";
        try {
            mockMvc.perform(get("/prices/product/{idProduct}/brand/{idBrand}", PRODUCT_35455, 2)
                    .param("date", dateApplication)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test
    void getPriceTest2Success() {

        // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        String dateApplication = "2020-06-14-16.00";
        double priceOk = 25.45;
        try {
            mockMvc.perform(get("/prices/product/{idProduct}/brand/{idBrand}", PRODUCT_35455, BRAND_ZARA)
                    .param("date", dateApplication)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.price", Is.is(priceOk)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void getPriceTest3Success() {

        // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        String dateApplication = "2020-06-14-21.00";
        double priceOk = 35.50;
        try {
            mockMvc.perform(get("/prices/product/{idProduct}/brand/{idBrand}", PRODUCT_35455, BRAND_ZARA)
                    .param("date", dateApplication)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.price", Is.is(priceOk)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void getPriceTest4Success() {

        // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
        String dateApplication = "2020-06-15-10.00";
        double priceOk = 30.50;
        try {
            mockMvc.perform(get("/prices/product/{idProduct}/brand/{idBrand}", PRODUCT_35455, BRAND_ZARA)
                    .param("date", dateApplication)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.price", Is.is(priceOk)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void getPriceTest5Success() {

        // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
        String dateApplication = "2020-06-16-21.00";
        double priceOk = 38.95;
        try {
            mockMvc.perform(get("/prices/product/{idProduct}/brand/{idBrand}", PRODUCT_35455, BRAND_ZARA)
                    .param("date", dateApplication)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.price", Is.is(priceOk)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}