import xbm.Analyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CI73A
// Arthur Lobo
// Jackson Nikolay
// Lucas Muniz
// Miguel Awad

public class Main {
    private static Scanner fileContent;

    public static void main(String[] args) {
        String fileName = "concurrence-simple";
        openArchive(fileName);
        processData(readFile(), fileName);
        closeArchive();
    }

    private static void openArchive(String fileName) {
        try {
            fileContent = new Scanner(Paths.get("src/main/resources/" + fileName + ".xbm"));
        } catch (IOException errIO) {
            System.err.println("Error while opening file");
        }

    }

    private static List<String> processData(List<String> file, String fileName) {
        Analyzer analyzer = new Analyzer(file);
        return analyzer.interact(fileName);
    }

    private static List<String> readFile() {
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
        return file;
    }

    private static void closeArchive() {
        if (fileContent != null)
            fileContent.close();
    }
}