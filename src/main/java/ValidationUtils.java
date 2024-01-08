public class ValidationUtils {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public static boolean validNo(int no) {
        return MIN_VALUE <= no && no <= MAX_VALUE;
    }
}
