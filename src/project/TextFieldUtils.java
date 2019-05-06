package project;

import java.awt.*;

public class TextFieldUtils {
    /*
        registeriin dugaar zow eshiig shalgana end mongol 2 useg 8 n tsipr orno
        iim nohtsoliig hangahgui ued uneng butsaana
     */
    public static boolean checkRegister(String string) {
        if (string.length() < 3) {
            return string.matches(".*[^А-ЯӨҮа-яөү]");
        } else {
            return string.length() >= 11 || string.substring(2).matches(".*[^0-9]");
        }
    }

    public  static boolean checkName(String string){
        return string.matches(".*[^А-ЯӨҮа-яөү]") || string.length() > 20;
    }

    public  static boolean checkPhone(String string){
        return string.matches(".*[^0-9]") || string.length() > 8;
    }


}
