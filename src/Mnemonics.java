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

        // Loop over mnemonic, check only letters
        int i = 0;
        StringBuilder numberResult = new StringBuilder();
        // Loop over message
        for (int j = 0; j < mnemonic.length() ; j++) {

            char c = mnemonic.charAt(j);

            // only get number value for letters in message (avoid signs, etc)
            if(Character.isLetter(mnemonic.charAt(j))) {
                numberResult.append(keypad.get(c));
            }else{
                numberResult.append(c);
            }
        }
        // TODO

        return numberResult.toString();
    }

    public static String fromDigits(String digits) {
        // TODO

        return "";
    }

}
