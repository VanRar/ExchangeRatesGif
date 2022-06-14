package ru.alfabank.exchangeratesgif.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.alfabank.exchangeratesgif.service.CompareRatesService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CompareRatesServiceTest {
	@Autowired
	CompareRatesService sut;

	private final static String CURRENCY = "RUB";
	private final static Set<Integer> EXPECTED = Set.of(-1,0,1); // result may be -1/0/1 accordingly to daily currency rates changes

	@Test
	void compareRatesMethodTest() {
		int compareRatesServiceResult = sut.compareRates(CURRENCY);
		assertTrue(EXPECTED.contains(compareRatesServiceResult));
	}
}
