import java.io.File;
import java.util.Scanner;

public class FileReader {

    private File file;
    public FileReader(File file) {
        this.file = file;
    }

    public String toReadFromFile(){
        StringBuilder textFromFile = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String stringLine = scanner.nextLine();
                textFromFile.append(stringLine);
                textFromFile.append("\n");
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return String.valueOf(textFromFile);
    }

}
