package LegalCase;

public class AuthManager {

    public static boolean adminLogin(String u, String p) {
        return u.equals("admin") && p.equals("1234");
    }

    public static boolean userLogin(String u, String p) {
        return !u.isEmpty() && !p.isEmpty();
    }
}