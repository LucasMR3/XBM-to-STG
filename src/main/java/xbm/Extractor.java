package xbm;

import model.VarXBM;

import static service.Service.checkBoolean;

public class Extractor {

    public static VarXBM declarations(String line) {
        line = line.replace("input", "");
        line = line.replace("Input", "");
        line = line.replace("output", "");
        line = line.replace("Output", "");
        line = line.trim();

        String number = line.substring(line.length() - 1);
        line = line.substring(0, (line.length() - 1));
        line = line.trim();

        return new VarXBM(line, checkBoolean(number));
    }

    public static int first(String line) {
        int minus = (line.indexOf('-') != -1 ? line.indexOf('-') : 123);
        int plus = (line.indexOf('+') != -1 ? line.indexOf('+') : 123);

        if (minus == 123 && plus == 123)
            return 0;
        return Math.min(minus, plus);
    }
}
