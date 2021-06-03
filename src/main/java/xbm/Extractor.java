package xbm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractVariablesXBM {

    public String beginLine(String line) {
        Pattern p = Pattern.compile("\\w++");
        Matcher m = p.matcher(line);
        m.find();
        return m.group();
    }

    public String name(String line) {
        Pattern p = Pattern.compile("(?<= )\\w\\w++");
        Matcher m = p.matcher(line);

        if (m.find()) {
            line = line.replace(m.group(), "");
            line = line.replace("input", "");
            line = line.replace("output", "");
            line = line.replace(" ", "");
//            line = line.trim();
            return (m.group() + "=" + line.substring(line.length() - 1));
        }
        return null;
    }
}
