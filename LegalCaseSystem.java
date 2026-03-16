package LegalCase;

import java.util.Scanner;

public class LegalCaseSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourtManager cm = new CourtManager();

        System.out.println("===== COURT CASE SYSTEM =====");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");

        int role = sc.nextInt();
        sc.nextLine();

        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        if (role == 1 && AuthManager.adminLogin(u, p)) {

            int ch;

            do {
                System.out.println("\n--- ADMIN MENU ---");
                System.out.println("1 Add Case");
                System.out.println("2 View Cases");
                System.out.println("3 Update Case");
                System.out.println("4 Search Case");
                System.out.println("5 Approve Requests");
                System.out.println("0 Exit");

                ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1 -> cm.addCase(sc);
                    case 2 -> cm.viewCases();
                    case 3 -> cm.updateCase(sc);
                    case 4 -> cm.searchCase(sc);
                    case 5 -> cm.approveRequests();
                }

            } while (ch != 0);
        }

        else if (role == 2 && AuthManager.userLogin(u, p)) {

            int ch;

            do {
                System.out.println("\n--- USER MENU ---");
                System.out.println("1 View Cases");
                System.out.println("2 Search Case");
                System.out.println("3 Request New Case");
                System.out.println("0 Exit");

                ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1 -> cm.viewCases();
                    case 2 -> cm.searchCase(sc);
                    case 3 -> cm.requestCase(sc);
                }

            } while (ch != 0);
        }

        else {
            System.out.println("Login Failed.");
        }

        sc.close();
    }
}