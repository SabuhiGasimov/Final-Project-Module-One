import java.util.HashMap;
import java.util.Map;


public class Cryptanalysis extends Cryptography {

    private StringBuilder decryptedText;
    private Map<Character, Integer> map;

    public Cryptanalysis(char[] characters, int key) {
        super(characters, key);
    }

    public Cryptanalysis(){

    }

    public String decrypt(String cipherText) {
        decryptedText = new StringBuilder();
        map = new HashMap<>();
        for (int i = 0; i < getCharacters().length; i++) {
            map.put(getCharacters()[i], i);
        }


        for (int i = 0; i < cipherText.length(); i++) {

            if (getKey() < 0 || getKey() > getCharacters().length) {
                String info = "Invalid key enter a digit between 1 and " + getCharacters().length;
                return info;
            }
            char letter = cipherText.charAt(i);
            int originalPosition = (map.get(letter) - getKey()) % getCharacters().length;

            if (originalPosition < 0) {
                originalPosition += getCharacters().length;
            }
            decryptedText.append(getCharacters()[originalPosition]);
        }

        return String.valueOf(decryptedText);
    }
}
