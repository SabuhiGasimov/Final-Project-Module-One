import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {

    private String fileName;
    private String cipherText;
    private FileWriter fileWriter;

    public FileWriting(String fileName, String cipherText) {
        this.fileName = fileName;
        this.cipherText = cipherText;
    }

    public void writeToFile() throws IOException {
        fileWriter = new FileWriter(fileName);
        fileWriter.write(cipherText);
        fileWriter.close();
    }

}