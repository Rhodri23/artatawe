import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.io.File;
import java.io.FileWriter;

/**
* Simple description of the class, along with the author and verison.
* @author Elliot Lunness
* @version 1.0
*/

public class FileManager {
    private static String checkFormat(String value) {
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    public static void writeLine(Writer w, List<String> values) throws IOException {
        boolean first = true;
        StringBuilder sb = new StringBuilder();

        for (String value : values) {
            if (!first) {
                sb.append(',');
            }
            sb.append('"').append(checkFormat(value)).append('"');
            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }

    public static void store(String fileLocation, List<String> list) throws Exception {
        File file = new File(fileLocation);
        File parent_directory = file.getParentFile();

        if (! parent_directory.exists()){
            System.out.println("Creating dir");
            parent_directory.mkdirs();
        }

        try {
            FileWriter writer = new FileWriter(file, true);
            writeLine(writer, list);
            writer.flush();
            writer.close();
        } catch(Exception e) {
            System.out.println("An error occured while trying to save!");
        }
    }
}
