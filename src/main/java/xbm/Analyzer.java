package xbm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    static List<String> variables = new ArrayList<>();

    public static List<String> declareVariables(List<String> list) {
//        for (String i : list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("input")) {
//                System.out.println("\nInput encontrada! =" + list.get(i) + "\n");
                getVariableName(list.get(i));
            }

            if (list.get(i).contains("output")) {
//                System.out.println("\nOutput encontrada! =" + list.get(i) + "\n");
                getVariableName(list.get(i));
            }
        }

        System.out.println(variables);

        return list;
    }

    private static void getVariableName(String line) {
        Pattern p = Pattern.compile("(?<= )\\w\\w++");
        Matcher m = p.matcher(line);
        m.find();
//        System.out.println("\noriginal: " + line);

        line = line.replace(m.group(), "");
        line = line.replace("input", "");
        line = line.replace("output", "");
        line = line.replace(" ", "");

//        System.out.println("corte =" + m.group() + " =" + line.substring(line.length() - 1));
        variables.add(m.group() + "=" + line.substring(line.length() - 1));
    }
}
