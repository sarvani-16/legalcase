package LegalCase;

import java.util.Scanner;

public class LegalCaseSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourtManager manager = new CourtManager();

        int choice;

        do {
            System.out.println("\n===== LEGAL CASE SYSTEM =====");
            System.out.println("1. Add Case");
            System.out.println("2. View All Cases");
            System.out.println("3. Assign Hearing Slot");
            System.out.println("4. Mark Attendance");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Case ID: ");
                    String caseId = sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Party Name: ");
                    String yourParty = sc.nextLine();

                    System.out.print("Enter Opposition Party Name: ");
                    String oppParty = sc.nextLine();

                    System.out.print("Enter Lawyer Name: ");
                    String yourLawyer = sc.nextLine();

                    System.out.print("Enter Opposition Lawyer Name: ");
                    String oppLawyer = sc.nextLine();

                    System.out.print("Enter Judge Name: ");
                    String judge = sc.nextLine();

                    System.out.print("Enter Severity (1-10): ");
                    int severity = sc.nextInt();
                    sc.nextLine();

                    CaseRecord newCase =
                            new CaseRecord(caseId, title,
                                    yourParty, oppParty,
                                    yourLawyer, oppLawyer,
                                    judge, severity);

                    manager.addCase(newCase);
                    break;

                case 2:
                    manager.viewAllCases();
                    break;

                case 3:
                    System.out.print("Enter Case ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Slot Number: ");
                    int slot = sc.nextInt();
                    sc.nextLine();
                    manager.assignHearing(id, slot);
                    break;

                case 4:
                    System.out.print("Enter Case ID: ");
                    String cid = sc.nextLine();

                    System.out.print("Is Your Party Present? (true/false): ");
                    boolean your = sc.nextBoolean();

                    System.out.print("Is Opposition Present? (true/false): ");
                    boolean opp = sc.nextBoolean();
                    sc.nextLine();

                    manager.markAttendance(cid, your, opp);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        sc.close();
    }
}