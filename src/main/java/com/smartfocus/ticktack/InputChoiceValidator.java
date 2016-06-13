package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class InputChoiceValidator {
    public static boolean validate(String firstPlayerChar){
        return firstPlayerChar.matches("[h,c]");
    }
}
