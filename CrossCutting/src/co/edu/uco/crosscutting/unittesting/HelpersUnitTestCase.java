package co.edu.uco.crosscutting.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;

class HelpersUnitTestCase {

	@Test
	void givenWantValidateIfObjectIsNullwhenObjectIsNullThenResultIsTrue() {
		//Arrange: Initial Context
		String object = null;
		
		//Act: Execute action
		boolean result = ObjectHelper.isNull(object);
		
		//Assert: Validate result
		assertTrue(result);
	}
	
	@Test
	void givenWantValidateIfObjectIsNotNullwhenObjectIsNotNullThenResultIsFalse() {
		//Arrange: Initial Context
		var object = "";
		
		//Act: Execute action
		boolean result = ObjectHelper.isNull(object);
		
		//Assert: Validate result
		assertFalse(result);
	}
	
	@Test
	void givenWantGetOriginalValuewhenObjectIsNotNullThenResultIsTheSameObject() {
		//Arrange: Initial Context
		var object = "Casa";
		var defaultValue = "Default";
		
		//Act
		var result = ObjectHelper.getDefault(object, defaultValue);
		
		//Assert
		assertEquals(object, result);
	}
	
	@Test
	void givenWantGetDefaultValuewhenObjectIsNullThenResultIsDefaultObject() {
		//Arrange: Initial Context
		String object = null;
		var defaultValue = "Default";
		
		//Act
		var result = ObjectHelper.getDefault(object, defaultValue);
		
		//Assert
		assertEquals(defaultValue, result);
	}
	
	@Test
	void givenWantValidateIfStringIsEmptywhenStringIsEmptyThenResultIsTrue() {
		//Arrange: Initial Context
		String object = null;
				
		//Act
		var result = TextHelper.isEmpty(object);
		
		//Assert
		assertTrue(result);
	}





}
