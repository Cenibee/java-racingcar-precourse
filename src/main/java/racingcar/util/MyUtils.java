package racingcar.util;

public class MyUtils {

    public static boolean lengthIn(String str, int minLength, int maxLength) {
        return str.length() >= minLength && str.length() <= maxLength;
    }

    public static boolean lengthNotIn(String str, int minLength, int maxLength) {
        return !lengthIn(str, minLength, maxLength);
    }

}
