package junitTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import TennisGameJSwing.junit;

class numTest {
	
	@ParameterizedTest
	@ValueSource(ints = {1,3,5,7,9, Integer.MAX_VALUE})
	void isOdd(int num) {
		Assertions.assertTrue(junit.isOdd(num));
	}

}
