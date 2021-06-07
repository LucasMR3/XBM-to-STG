package service;

public class Service {

    public static String convertBoolToSymbol (boolean bool) {
        if(bool) {
            return "+";
        } else return "-";
    }

    public static boolean checkBoolean(String str) {
        return str.equals("1");
    }
}
