package com.smartfocus.ticktack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arthur on 14/06/16.
 */
public class HumanInputPositionValidatorTest {

    @Test
    public void shouldReturnTrueForValidPosition() {
        assertTrue(HumanInputPositionValidator.validate("1,2"));
    }

    @Test
    public void shouldReturnFalseWhenInvalidIntegerProvided() {
        assertFalse(HumanInputPositionValidator.validate("s,2"));
    }

  @Test
    public void shouldReturnFalseWhenGreaterIntegerProvided() {
        assertFalse(HumanInputPositionValidator.validate("1,3"));
    }

    @Test
    public void shouldReturnFalseWhenOneIntegerProvided() {
        assertFalse(HumanInputPositionValidator.validate(",3"));
    }

    @Test
    public void shouldReturnFalseWhenOneIntegerWithOutCommaProvided() {
        assertFalse(HumanInputPositionValidator.validate("3"));
    }

}