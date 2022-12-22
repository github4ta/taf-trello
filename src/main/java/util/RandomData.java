package util;

import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

public class RandomData {
    static MockNeat mock = MockNeat.threadLocal();

    public static String generateRandomStringLettersAndNumbers() {
        String someString = mock.strings()
                .size(8)
                .get();
        return someString;
    }

    public static String generateRandomStringLetters() {
        String randomString = mock.strings()
                .size(8)
                .type(StringType.LETTERS)
                .get();
        return randomString;
    }

    public static String generateNumbers() {
        String randomNumber = mock.strings()
                .size(8)
                .type(StringType.NUMBERS)
                .get();
        return randomNumber;
    }

    public static String generateRandomStringLettersAndNumbersWithSymbols() {
        String someString = mock.strings()
                .size(8)
                .get();
        return (someString + "@" + generateNumbers());
    }

    public static String generateNumbersWithSymbols() {
        String randomNumber = mock.strings()
                .size(8)
                .type(StringType.NUMBERS)
                .get();
        return (randomNumber + "@" + generateRandomStringLetters());
    }
}
