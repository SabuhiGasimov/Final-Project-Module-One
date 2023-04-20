import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {

    private char[] characters;
    private int key;
    private Map<Character, Integer> map;


    public CaesarCipher(char[] characters, int key) {
        this.characters = characters;
        this.key = key;
        map = new HashMap<>();
        fillMap(characters);
    }

    private void fillMap(char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            map.put(characters[i], i);
            //map.put(characters[i], characters[i + key % characters.length]);
        }
    }

    public String encrypt(String plainText) {

        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            if (key < 0 || key > 25) {
                String info = "Invalid key: Enter a number between 1 to " + 25;
                System.out.println(info);
                break;
            }
            char letter = plainText.charAt(i);
            if (letter == ' ') {
                encryptedText.append(' ');
                continue;
            }
            int shiftedPosition = (map.get(letter) + key) % characters.length;

            encryptedText.append(characters[shiftedPosition]);

        }

        return String.valueOf(encryptedText);
    }


    public String decrypt(String cipherText) {

        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            if (key < 0 || key > 25) {
                String info = "Invalid key: Enter a number between 1 to " + 25;
                System.out.println(info);
                break;
            }
            char letter = cipherText.charAt(i);
            if (letter == ' ') {
                decryptedText.append(' ');
                continue;
            }
            int originalPosition = (map.get(letter) - key) % characters.length;
            if (originalPosition < 0) {
                originalPosition += characters.length;
            }
            decryptedText.append(characters[originalPosition]);
        }
        return String.valueOf(decryptedText);
    }
}
