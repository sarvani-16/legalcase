package LegalCase;

import java.io.*;
import java.util.*;

public class CourtManager {

    private HashMap<String, CaseRecord> cases = new HashMap<>();
    private ArrayList<RequestRecord> requests = new ArrayList<>();

    private final String CASE_FILE = "cases.csv";
    private final String REQ_FILE = "requests.csv";

    public CourtManager() {
        loadCases();
        loadRequests();
    }

    // ===== LOAD CASES =====
    private void loadCases() {
        try (BufferedReader br = new BufferedReader(new FileReader(CASE_FILE))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");

                if (d.length == 8) {
                    cases.put(d[0],
                        new CaseRecord(d[0], d[1], d[2], d[3],
                                       d[4], d[5], d[6], d[7]));
                }
            }

        } catch (IOException e) {}
    }

    private void saveCases() {
        try (PrintWriter pw = new PrintWriter(CASE_FILE)) {

            for (CaseRecord c : cases.values())
                pw.println(c.toCSV());

        } catch (Exception e) {
            System.out.println("Error saving cases.");
        }
    }

    // ===== REQUESTS =====
    private void loadRequests() {
        try (BufferedReader br = new BufferedReader(new FileReader(REQ_FILE))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length == 2)
                    requests.add(new RequestRecord(d[0], d[1]));
            }

        } catch (IOException e) {}
    }

    private void saveRequests() {
        try (PrintWriter pw = new PrintWriter(REQ_FILE)) {

            for (RequestRecord r : requests)
                pw.println(r.toCSV());

        } catch (Exception e) {}
    }

    // ===== ADD CASE (ADMIN) =====
    public void addCase(Scanner sc) {

        System.out.print("Enter Case ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Your Party Name: ");
        String yp = sc.nextLine();

        System.out.print("Enter Opposition Party Name: ");
        String op = sc.nextLine();

        System.out.print("Enter Judge Name: ");
        String judge = sc.nextLine();

        cases.put(id,
            new CaseRecord(id, title, yp, op, judge,
                    "Pending", "Pending", "Not Marked"));

        saveCases();
        System.out.println("Case Added Successfully.");
    }

    // ===== VIEW =====
    public void viewCases() {

        if (cases.isEmpty()) {
            System.out.println("No cases available.");
            return;
        }

        for (CaseRecord c : cases.values())
            c.display();
    }

    // ===== UPDATE =====
    public void updateCase(Scanner sc) {

        System.out.print("Enter Case ID to update: ");
        String id = sc.nextLine();

        CaseRecord c = cases.get(id);

        if (c == null) {
            System.out.println("Case Not Found.");
            return;
        }

        System.out.print("Enter Hearing Date: ");
        c.setDate(sc.nextLine());

        System.out.print("Enter Judgment: ");
        c.setJudgment(sc.nextLine());

        System.out.print("Enter Attendance Info: ");
        c.setAttendance(sc.nextLine());

        saveCases();
        System.out.println("Case Updated.");
    }

    // ===== SEARCH =====
    public void searchCase(Scanner sc) {

        System.out.print("Enter Case ID: ");
        String id = sc.nextLine();

        CaseRecord c = cases.get(id);

        if (c != null) c.display();
        else System.out.println("Case Not Found.");
    }

    // ===== USER REQUEST =====
    public void requestCase(Scanner sc) {

        System.out.print("Requested Case ID: ");
        String id = sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        requests.add(new RequestRecord(id, title));

        saveRequests();
        System.out.println("Request Sent to Admin.");
    }

    // ===== APPROVE REQUESTS =====
    public void approveRequests() {

        for (RequestRecord r : requests) {

            cases.put(r.id,
                new CaseRecord(r.id, r.title,
                        "Not Provided", "Not Provided",
                        "Not Assigned",
                        "Pending", "Pending", "Not Marked"));
        }

        requests.clear();
        saveCases();
        saveRequests();

        System.out.println("All Requests Approved.");
    }
}