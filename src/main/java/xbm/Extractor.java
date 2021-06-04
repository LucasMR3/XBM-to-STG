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

    public String declarations(String line) {
        line = line.replace("input", "");
        line = line.replace("output", "");
        line = line.trim();

        String number = line.substring(line.length() - 1);
        line = line.replace(number, "");
        line = line.trim();

        VarXBM varXBM = new VarXBM(line, checkBoolean(number));
        System.out.println(varXBM);

        return (line + "=" + number);
    }

    private boolean checkBoolean(String str) {
        return str.equals("1");
    }
}
