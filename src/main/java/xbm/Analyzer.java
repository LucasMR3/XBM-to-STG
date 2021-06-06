package xbm;

import model.XBMCode;
import model.Step;
import model.VarXBM;
import stg.Compiler;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private final List<VarXBM> inputs = new ArrayList<>();
    private final List<VarXBM> outputs = new ArrayList<>();

    private final List<Step> steps = new ArrayList<>();

    private final List<String> XBM_FILE;

    public Analyzer(List<String> XBM_FILE) {
        this.XBM_FILE = XBM_FILE;
    }

    public List<String> interact() {

        for (String line : XBM_FILE) {
            if (line.toLowerCase().contains("input")) {
                this.inputs.add(Extractor.declarations(line));
            }

            if (line.toLowerCase().contains("output")) {
                this.outputs.add(Extractor.declarations(line));
            }

            if (line.length() > 0 && line.substring(0, 1).matches("[0-9]")) {
                execution(line);
            }
        }

        XBMCode XBMCode = new XBMCode(inputs, outputs, steps);

        Compiler compiler = new Compiler(XBMCode);
        compiler.Compile();

        return XBM_FILE;
    }

    private void execution(String line) {
        int in = Integer.parseInt(line.substring(0, 1));
        int go = Integer.parseInt(line.substring(2, 3));

        String inputsLine = line.substring(3, line.indexOf("|"));
        String outputsLine = line.substring(line.indexOf("|") + 1);

        inputsLine = inputsLine.trim();
        outputsLine = outputsLine.trim();

        steps.add(new Step(in, go, processLine(inputsLine), processLine(outputsLine)));
    }

    private List<VarXBM> processLine(String line) {
        List<VarXBM> list = new ArrayList<>();
        String extracted = line.substring(0, Extractor.first(line) + 1);

        while (line.length() != extracted.length()) {
            list.add(new VarXBM(extracted.substring(0, extracted.length() - 1), boolSymbol(line)));

            line = line.substring(extracted.length());
            line = line.trim();
            extracted = line.substring(0, Extractor.first(line) + 1);
        }

        extracted = extracted.trim();
        list.add(new VarXBM(extracted.substring(0, extracted.length() - 1), boolSymbol(line)));

        return list;
    }

    private boolean boolSymbol(String line) {
        return line.charAt(Extractor.first(line)) == '+';
    }
}
