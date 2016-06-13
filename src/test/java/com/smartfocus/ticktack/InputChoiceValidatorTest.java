package com.smartfocus.ticktack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arthur on 13/06/16.
 */
public class InputChoiceValidatorTest {

    @Test
    public void shouldReturnTrueWhenCProvided(){
    assertTrue(InputChoiceValidator.validate("c"));
    }

    @Test
    public void shouldReturnTrueWhenHProvided(){
    assertTrue(InputChoiceValidator.validate("h"));
    }

   @Test
    public void shouldReturnTrueWhenInvalidCharProvided(){
    assertFalse(InputChoiceValidator.validate("s"));
    }

}