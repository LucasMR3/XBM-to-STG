package xbm;

import model.varXBM;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private final List<String> variables = new ArrayList<>();

    private final Extractor extract = new Extractor();

    private final List<String> XBM_FILE;

    public Analyzer(List<String> XBM_FILE) {
        this.XBM_FILE = XBM_FILE;
    }

    public List<String> interact() {

        for (int i = 0; i < XBM_FILE.size(); i++) {
            if (XBM_FILE.get(i).contains("input")) {
                this.variables.add(extract.name(XBM_FILE.get(i)));
            }

            if (XBM_FILE.get(i).contains("output")) {
                this.variables.add(extract.name(XBM_FILE.get(i)));
            }

            if (XBM_FILE.get(i).length() > 0 && XBM_FILE.get(i).substring(0, 1).matches("[0-9]")) {
                execution(XBM_FILE.get(i));
            }
        }

        System.out.println("\n" + variables);

        return XBM_FILE;
    }

    private void execution(String line) {
        System.out.println("\n" + line);

        int in = Integer.parseInt(line.substring(0, 1));
        int go = Integer.parseInt(line.substring(2, 3));

        line = line.substring(3);
        line = line.trim();

        varXBM xbm1 = new varXBM(extract.beginLine(line), boolSymbol(line, extract.beginLine(line)));

        line = line.substring(xbm1.getName().length() + 1);
        line = line.trim();

        varXBM xbm2 = null;

        if (line.startsWith("|")) {
            line = line.substring(1);
            line = line.trim();
             xbm2 = new varXBM(extract.beginLine(line), boolSymbol(line, extract.beginLine(line)));
        }

        System.out.println("IN = " + in + " GO = " + go);
        System.out.println(xbm1 + " " + xbm2);
    }

    private boolean boolSymbol(String line, String variable) {
        return line.charAt(variable.length()) == '+';
    }
}
