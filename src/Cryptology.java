import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Cryptology {
    public static void main(String[] args) throws IOException {

        char[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'
                , 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'
                , 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', '"', ':', '-', '!', '?','\n'};



        FileReader fileReader = new FileReader(new File("assets/plaintext.txt"));
        String plainText = fileReader.toReadFromFile();
        int key =  3;
        CaesarCipher caesarCipher = new CaesarCipher(characters, key);
        String cipherText = caesarCipher.encrypt(plainText);
        FileWriting fileWriting = new FileWriting("assets/ciphertext.txt");
        fileWriting.writeToFile(cipherText);



        Cryptanalysis cryptanalysis = new Cryptanalysis();
        double[] frequency = cryptanalysis.toGetFrequency(cipherText);
        System.out.println(cryptanalysis.printPercentageOfLetters());


        int keyFromFrequencyAnalysis = cryptanalysis.toGetKey(frequency);
        CaesarCipher cipher = new CaesarCipher(characters, keyFromFrequencyAnalysis);
        String decryptedText = cipher.decrypt(cipherText);
        System.out.println(decryptedText);


    }
}
