import javax.naming.NameNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Cryptanalysis {


    double[] frequencyPercent = new double[26];
    double array[] = new double[26];
    int[] frequency = new int[26];
    int totalLetters = 0;


    public double[] toGetFrequency(String cipherText) {
        for (int i = 0; i < cipherText.length(); i++) {
            char character = cipherText.charAt(i);
            if (Character.isLetter(character)) {
                frequency[Character.toLowerCase(character) - 'a']++;
            }
        }
        for (int i = 0; i < frequency.length; i++) {
            totalLetters += frequency[i];
        }
        for (int i = 0; i < frequency.length; i++) {
            frequencyPercent[i] = ((double) frequency[i] / totalLetters) * 100;
        }
        for (int i = 0; i < frequencyPercent.length; i++) {
            array[i] = frequencyPercent[i];
        }
        return array;
    }





    public int toGetKey(double array[]) {
        int key = 0;
        double max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                key = i;
            }
        }
        return key;
    }




    public String printPercentageOfLetters(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < frequencyPercent.length; i++) {
            char character = (char) ('a' + i);
            stringBuilder.append(" " + character +  ": " + Float.parseFloat(decimalFormat.format(frequencyPercent[i])) + " %" + "\n");

        }
        return String.valueOf(stringBuilder);
    }

}
