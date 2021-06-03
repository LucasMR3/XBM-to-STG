package xbm;

import model.VariableXBM;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private final List<String> variables = new ArrayList<>();

    private final ExtractVariablesFromXBM extract = new ExtractVariablesFromXBM();

    private final List<String> XBM_FILE;

    public Analyzer(List<String> XBM_FILE) {
        this.XBM_FILE = XBM_FILE;
    }

    public List<String> interact() {

        for (int i = 0; i < XBM_FILE.size(); i++) {
            if (XBM_FILE.get(i).contains("input")) {
                this.variables.add(extract.getVariableName(XBM_FILE.get(i)));
            }

            if (XBM_FILE.get(i).contains("output")) {
                this.variables.add(extract.getVariableName(XBM_FILE.get(i)));
            }

            if (XBM_FILE.get(i).length() > 0 && XBM_FILE.get(i).substring(0, 1).matches("[0-9]")) {
                executionState(XBM_FILE.get(i));
            }
        }

        System.out.println("\n" + variables);

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

//        System.out.println(getVarPhraseStart(line));
//        System.out.println(getBoolByVarSymbol(line, getVarPhraseStart(line)));

        VariableXBM firstVariable = new VariableXBM(extract.getVarPhraseStart(line), getBoolByVarSymbol(line, extract.getVarPhraseStart(line)));

        line = line.substring(extract.getVarPhraseStart(line).length() + 1);
        line = line.trim();

        if (line.startsWith("|")) {
            line = line.substring(1);
            line = line.trim();
        }
//        System.out.println(getVarPhraseStart(line));
//        System.out.println(getBoolByVarSymbol(line, getVarPhraseStart(line)) + "\n");
        boolean secondVar = getBoolByVarSymbol(line, extract.getVarPhraseStart(line));

        VariableXBM secondVariable = new VariableXBM(extract.getVarPhraseStart(line), getBoolByVarSymbol(line, extract.getVarPhraseStart(line)));


        System.out.println(firstVariable + " " + secondVariable);
    }





    private boolean getBoolByVarSymbol(String line, String variable) {
        return line.charAt(variable.length()) == '+';
    }
}
