package Util;

import Calender.Exceptions.IncorrectArgumentException;

public class Validate {

    public static String validTrait(String trait) throws IncorrectArgumentException {
        if (trait == null || trait.isEmpty() || trait.isBlank()) {
            throw new IncorrectArgumentException("Неверное значение");
        } else {
            return trait;
        }
    }
}
