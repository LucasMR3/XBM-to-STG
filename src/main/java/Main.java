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
            fileContent = new Scanner(Paths.get("src/main/resources/ex2.xbm"));
        } catch (IOException errIO) {
            System.err.println("Error while opening file");
        }
    }

    public static String processData(String line) {
        System.out.println(line);
//        Analyzer.declareVariables(line);
        return null;
    }

    private static List<String> readAndProcessData() {
        List<String> list = new ArrayList<>();
        try {
            while (fileContent.hasNext()) {
                String a = fileContent.nextLine();
                if (a == null){
                    return null;
                }
                list.add(a);
            }
        } catch (Exception err) {
            System.err.println("Error " + err);
        }

       return Analyzer.declareVariables(list);
//        return list;
    }

    private static void closeArchive() {
        if (fileContent != null)
            fileContent.close();
    }
}