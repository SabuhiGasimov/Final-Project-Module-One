import java.io.File;
import java.io.IOException;

public class Cryptology {
    public static void main(String[] args) throws IOException {

        char[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'
                , 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'
                , 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', '"', ':', '-', '!', '?', ' ', '\n'};

        FileReader fileReader = new FileReader(new File("assets/plaintext.txt"));
        String plainText = fileReader.toReadFromFile();
        int key = 3;
        Cryptography cryptography = new Cryptography(characters, key);
        String cipherText = cryptography.encrypt(plainText);

        Cryptanalysis cryptanalysis = new Cryptanalysis(characters, key);
        String decryptedText = cryptanalysis.decrypt(cipherText);

        FileWriting fileWriting = new FileWriting("assets/ciphertext.txt",cipherText);
        fileWriting.writeToFile();




        System.out.println(cipherText);
        System.out.println(decryptedText);


    }
}
