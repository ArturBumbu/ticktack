package com.smartfocus.ticktack;

import com.sun.webkit.dom.RangeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthur on 14/06/16.
 */
public class HumanInputPositionValidator {
    public static boolean validate(String position) {
        boolean response = false;
        String[] numbers = position.split(",");

        if (checkNumberOfInputParam(numbers)) return response;

        List<Integer> ints = convertStringToInteger(numbers);

        if (checkIfThereAreInvalidIntegers(ints)) return response;

        response = (checkRange(ints.get(0)) && checkRange(ints.get(1)));
        return response;
    }

    private static boolean checkIfThereAreInvalidIntegers(List<Integer> ints) {
        if (ints.size() < 2) return true;
        return false;
    }

    private static List<Integer> convertStringToInteger(String[] numbers) {
        List<Integer> ints = new ArrayList<Integer>();

        for (String s : numbers) {
            try {
                ints.add(Integer.valueOf(s));
            } catch (NumberFormatException e) {

            }
        }
        return ints;
    }

    private static boolean checkNumberOfInputParam(String[] numbers) {
        if (numbers.length < 2) {
            return true;
        }
        return false;
    }

    private static boolean checkRange(Integer number) {
        if (number > 2 || number < 0) {
            return false;
        } else {
            return true;
        }
    }
}
