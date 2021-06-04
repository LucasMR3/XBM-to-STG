package xbm;

import model.VarXBM;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    public String name(String line) {
        Pattern p = Pattern.compile("\\w++");
        Matcher m = p.matcher(line);
        if (m.find())
            return m.group();
        return null;
    }

    public VarXBM declarations(String line) {
        line = line.replace("input", "");
        line = line.replace("output", "");
        line = line.trim();

        String number = line.substring(line.length() - 1);
        line = line.substring(0, (line.length() - 1));
        line = line.trim();

        return new VarXBM(line, checkBoolean(number));
    }

    private boolean checkBoolean(String str) {
        return str.equals("1");
    }
}
