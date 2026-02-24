package freddy.Process;


public class StringProcess {
    public StringProcess(){}

    public static String remove_first(String s){
        s = s.trim();
        boolean blank = false, modified = false;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ' '){blank = true;}
            else if(blank){
                s = s.substring(i);
                modified = true;
                break;
            }
        }
        if (!modified){
            s = "";
        }
        return s;
    }

    public static boolean isAllDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }


}
