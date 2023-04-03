import collections.map.HashMap;
import collections.map.Map;

public class Mnemonics {

    // uninstantiable class
    private Mnemonics() {}

    private static Map<Character, Integer> keypad;

    static {
        keypad = new HashMap<>();

        String alphabet = "abcedfghijklmnopqrstuvwxyz";
        String keys = "22233344455566677778889999";

        // TODO create keypad map

        for (int i = 0; i < alphabet.length(); i++) {
            keypad.put(alphabet.charAt(i), keys.charAt(i) - '0');
        }
        
    }

    public static String toNumber(String mnemonic) {
        // TODO

        return "";
    }

    public static String fromDigits(String digits) {
        // TODO

        return "";
    }

}
