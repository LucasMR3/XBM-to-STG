package stg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {

    public static void write(String fileName, List<String> content) {

        try {
            File file = new File("stg/" + fileName + ".g");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(evaluateContent(content));
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String evaluateContent(List<String> content) {
        StringBuilder a = new StringBuilder();
        for (String str : content) {
            a.append(str);
        }
        return a.toString();
    }
}