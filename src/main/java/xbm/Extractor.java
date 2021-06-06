package xbm;

import model.VarXBM;

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

    private static boolean checkBoolean(String str) {
        return str.equals("1");
    }

    public static int first(String line) {
        int minus = (line.indexOf('-') != -1 ? line.indexOf('-') : 1000);
        int plus = (line.indexOf('+') != -1 ? line.indexOf('+') : 1000);

        return Math.min(minus, plus);
    }
}
