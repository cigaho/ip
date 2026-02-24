package freddy.Process;

/**
 * String Process class is for processing strings for specific needs
 */
public class StringProcess {

    /**
     * Create a StringProcess instance
     */
    public StringProcess(){}

    /**
     * remove first words from string to handle commands
     * @param s, to be processed string
     * @return processed string
     */
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

    /**
     * Check if a string is a digit
     * @param str, string to be check
     * @return true if it is a digit
     */
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
