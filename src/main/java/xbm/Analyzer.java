package xbm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    private final List<String> variables = new ArrayList<>();

    private final List<String> XBM_FILE;

    public Analyzer(List<String> XBM_FILE) {
        this.XBM_FILE = XBM_FILE;
    }

    public List<String> declareVariables() {

        for (int i = 0; i < XBM_FILE.size(); i++) {
            if (XBM_FILE.get(i).contains("input")) {
                getVariableName(XBM_FILE.get(i));
            }

            if (XBM_FILE.get(i).contains("output")) {
                getVariableName(XBM_FILE.get(i));
            }

            if (XBM_FILE.get(i).length() > 0 && XBM_FILE.get(i).substring(0, 1).matches("[0-9]")) {
                executionState(XBM_FILE.get(i));
            }
        }

        System.out.println(variables);

        return XBM_FILE;
    }

    private void executionState(String line) {

        int firstGo = Integer.parseInt(line.substring(0, 1));
        int secondGo = Integer.parseInt(line.substring(2, 3));

//        System.out.println(firstCommand);
//        System.out.println(secondCommand);

        line = line.substring(3);
        line = line.trim();

        System.out.println("\n" + line);

        System.out.println(getVarPhraseStart(line));

        System.out.println(getBoolByVarSymbol(line, getVarPhraseStart(line)));

        line = line.substring(getVarPhraseStart(line).length() + 1);
        line = line.trim();

        if(line.startsWith("|")){
            line = line.substring(1);
            line = line.trim();
        }
        System.out.println(getVarPhraseStart(line));
        System.out.println(getBoolByVarSymbol(line, getVarPhraseStart(line)) + "\n");


    }

    private void getVariableName(String line) {
        Pattern p = Pattern.compile("(?<= )\\w\\w++");
        Matcher m = p.matcher(line);

        if (m.find()) {
            line = line.replace(m.group(), "");
            line = line.replace("input", "");
            line = line.replace("output", "");
            line = line.replace(" ", "");
//            line = line.trim();
            this.variables.add(m.group() + "=" + line.substring(line.length() - 1));
        }
    }

    private String getVarPhraseStart(String line) {
        Pattern p = Pattern.compile("\\w++");
        Matcher m = p.matcher(line);
        m.find();
        return m.group();
    }

    private boolean getBoolByVarSymbol(String line, String variable) {
        return line.charAt(variable.length()) == '+';
    }
}
