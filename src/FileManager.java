import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.*;

/**
* Simple description of the class, along with the author and verison.
* @author Elliot Lunness
* @version 1.0
*/

class FileManager {
    public void store(String data, String fileLocation) {
        File file = new File(fileLocation);

        try {
            System.out.println(fileLocation);
            FileWriter fileWriter = new FileWriter(file, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();

            System.out.println("---  SAVED  ---");
        } catch(IOException e) {
            System.out.println("An error occured while trying to save!");
        }
    }

    private Scanner read(String fileLocation) {
        File inputFile = new File(fileLocation);
        Scanner in = null;

        try {
            in = new Scanner(inputFile);
        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot open " + fileLocation);
            System.exit(0);
        }
        return in;
    }
}
