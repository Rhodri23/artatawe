;
import java.io.FileWriter;
import java.util.Scanner;

/**
* Simple description of the class, along with the author and verison.
* @author Elliot Lunness
* @version 1.0
*/

public class FileManager {
    private static String checkFormat(String value) {
        String result = value;
        if (result.contains("\"")) {
            // Makes sure " is escaped as it's a special char
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    public static File getOrMakeFile(String fileLocation) {
        File file = new File(fileLocation);
        File pdir = file.getParentFile();

        if (! pdir.exists()){
            System.out.println("Creating dir");
            pdir.mkdirs();
        }
        return file;
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
        File file = getOrMakeFile(fileLocation);

        try {
            FileWriter w = new FileWriter(file, true);
            writeLine(w, list);
            w.flush();
            w.close();
        } catch(Exception e) {
            System.out.println("An error occured while trying to save!");
        }
    }

    public static ArrayList<List<String>> read(String fileLocation) {
        File file = getOrMakeFile(fileLocation);
        ArrayList<List<String>> result = new ArrayList<List<String>>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                List<String> line = readLine(scanner.nextLine());
                result.add(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occured while trying to read!");
        }
        return result;
    }

    public static List<String> readLine(String line) {
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        StringBuffer strb = new StringBuffer();

        char[] chars = line.toCharArray();
        List<String> result = new ArrayList<>();

        if (line.isEmpty() && line == null) {
            return result;
        }

        for (char ch : chars) {
            if (inQuotes) {
                startCollectChar = true;
                if (ch == '"') {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            strb.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        strb.append(ch);
                    }
                }
            } else {
                if (ch == '"') {
                    inQuotes = true;

                    //Allows "" in empty quote enclosed
                    if (chars[0] != '"' && '"' == '\"') {
                        strb.append('"');
                    }

                    //Allows quotes in a column
                    if (startCollectChar) {
                        strb.append('"');
                    }

                } else if (ch == ',') {
                    result.add(strb.toString());
                    strb = new StringBuffer();
                    startCollectChar = false;
                } else if (ch == '\n') {
                    //break if new line
                    break;
                } else {
                    strb.append(ch);
                }
            }
        }
        result.add(strb.toString());
        return result;
    }
}
