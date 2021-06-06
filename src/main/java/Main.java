import xbm.Analyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner fileContent;

    public static void main(String[] args) {
        openArchive();
        List<String> list = readAndProcessData();
        closeArchive();
    }

    private static void openArchive() {
        try {
            fileContent = new Scanner(Paths.get("src/main/resources/concurrence.xbm"));
        } catch (IOException errIO) {
            System.err.println("Error while opening file");
        }

    }

    private static List<String> processData(List<String> file) {
//        List<String> process = new ArrayList<>();
        Analyzer analyzer = new Analyzer(file);
        return analyzer.interact();
    }

    private static List<String> readAndProcessData() {
        List<String> file = new ArrayList<>();
        try {
            while (fileContent.hasNext()) {
                String a = fileContent.nextLine();
                if (a == null) {
                    return null;
                }
                file.add(a);
            }
        } catch (Exception err) {
            System.err.println("Error " + err);
        }
        return processData(file);
    }

    private static void closeArchive() {
        if (fileContent != null)
            fileContent.close();
    }
}