package xbm;

import model.VarXBM;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private final List<VarXBM> inputs = new ArrayList<>();
    private final List<VarXBM> outputs = new ArrayList<>();

    private final Extractor extract = new Extractor();

    private final List<String> XBM_FILE;

    public Analyzer(List<String> XBM_FILE) {
        this.XBM_FILE = XBM_FILE;
    }

    public List<String> interact() {

        for (String s : XBM_FILE) {
            if (s.contains("input")) {
                this.inputs.add(extract.declarations(s));
            }

            if (s.contains("output")) {
                this.outputs.add(extract.declarations(s));
            }

            if (s.length() > 0 && s.substring(0, 1).matches("[0-9]")) {
                execution(s);
            }
        }

        System.out.println("\n" + inputs);
        System.out.println(outputs);

        return XBM_FILE;
    }

    private void execution(String line) {
        System.out.println("\n" + line);

        int in = Integer.parseInt(line.substring(0, 1));
        int go = Integer.parseInt(line.substring(2, 3));

        line = line.substring(3);
        line = line.trim();

        VarXBM xbm1 = new VarXBM(extract.name(line), boolSymbol(line, extract.name(line)));

        System.out.println(inputs.get(inputs.indexOf(new VarXBM(extract.name(line), false))));

        line = line.substring(xbm1.getName().length() + 1);
        line = line.trim();

        VarXBM xbm2 = null;
        if (line.startsWith("|")) {
            line = line.substring(1);
            line = line.trim();
            xbm2 = new VarXBM(extract.name(line), boolSymbol(line, extract.name(line)));

            outputs.get(outputs.indexOf(new VarXBM(extract.name(line), false))).setBoolean(boolSymbol(line, extract.name(line)));
            System.out.println(outputs.get(outputs.indexOf(new VarXBM(extract.name(line), false))));
        }

        System.out.println("IN = " + in + " GO = " + go);
        System.out.println(xbm1 + " " + xbm2);
    }

    private boolean boolSymbol(String line, String variable) {
        return line.charAt(variable.length()) == '+';
    }
}
