package com.capitole.inditex;

import com.capitole.inditex.application.prices.services.IPriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CapitoleInditexApplicationTests {

	@Autowired
	private IPriceService priceService;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(priceService);
	}

}
