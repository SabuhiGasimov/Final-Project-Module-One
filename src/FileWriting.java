import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {

    private String fileName;

    private FileWriter fileWriter;

    public FileWriting(String fileName) {
        this.fileName = fileName;

    }

    public void writeToFile(String cipherText) throws IOException {
        fileWriter = new FileWriter(fileName);
        fileWriter.write(cipherText);
        fileWriter.close();
    }

}