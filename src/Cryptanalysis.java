public class Cryptanalysis extends Cryptography {


    public Cryptanalysis(char[] characters, int key) {
        super(characters, key);
    }


    public String decrypt(String cipherText) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            if (getKey() < 0 || getKey() > getCharacters().length) {
                String info = "Invalid key enter a digit between 1 and " + getCharacters().length;
                return info;
            }
            char letter = cipherText.charAt(i);
            int originalPosition = (getMap().get(letter) - getKey()) % getCharacters().length;
            if (originalPosition < 0) {
                originalPosition += getCharacters().length;
            }
            decryptedText.append(getCharacters()[originalPosition]);
        }
        return String.valueOf(decryptedText);
    }
}
