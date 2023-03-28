import java.util.HashMap;
import java.util.Map;

public class Cryptography {

    private char[] characters;
    private int key;
    private StringBuilder encryptedText;
    private Map<Character, Integer> map;


    public char[] getCharacters() {
        return characters;
    }


    public int getKey() {
        return key;
    }


    public Cryptography(){

    }

    public Cryptography(char[] characters, int key) {
        this.characters = characters;
        this.key = key;
    }


    public String encrypt(String plainText) {
        encryptedText = new StringBuilder();
        map = new HashMap<>();
        for (int i = 0; i < characters.length; i++) {
            map.put(characters[i], i);
        }

        for (int i = 0; i < plainText.length(); i++) {
            if (key < 0 || key > characters.length) {
                String info = "Invalid key enter a digit between 1 and " + characters.length;
                return info;
            }
            char letter = plainText.charAt(i);
            int shiftedPosition = (map.get(letter) + key) % characters.length;
            encryptedText.append(characters[shiftedPosition]);

        }

        return String.valueOf(encryptedText);
    }
}
