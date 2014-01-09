import static com.google.common.base.Strings.padStart;
import static java.lang.Integer.toBinaryString;

public class VarInt {

    public static final int SEVEN_BITS = 7;
    public static final int EIGHT_BITS = 8;

    public String from(int i) {
        return fromBinary(toBinaryString(i));
    }

    private String fromBinary(String binary) {
        if (binary.length() <= SEVEN_BITS) return padWithZero(binary, EIGHT_BITS);

        int pivot = binary.length() - SEVEN_BITS;
        String first = binary.substring(pivot);
        String last = binary.substring(0, pivot);
        return '1' + first + fromBinary(padWithZero(last, SEVEN_BITS));
    }

    private String padWithZero(String binary, int minLength) {
        return padStart(binary, minLength, '0');
    }
}
