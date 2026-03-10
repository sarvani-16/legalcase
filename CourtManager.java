package LegalCase;

import java.io.*;
import java.util.*;

public class CourtManager {

    private HashMap<String, CaseRecord> caseMap = new HashMap<>();
    private HashMap<Integer, CaseRecord> schedule = new HashMap<>();

    private PriorityQueue<CaseRecord> priorityQueue =
            new PriorityQueue<>((a, b) -> b.getSeverity() - a.getSeverity());

    private final String FILE_NAME = "cases.csv";

    public CourtManager() {
        loadFromFile();
    }

    public void addCase(CaseRecord c) {
        caseMap.put(c.getCaseId(), c);
        priorityQueue.offer(c);
        saveToFile();
        System.out.println("Case Added Successfully!");
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            bw.write("caseId,title,yourParty,oppositionParty,yourLawyer,oppositionLawyer,judge,severity,hearingSlot,judgment,yourPresent,oppPresent");
            bw.newLine();

            for (CaseRecord c : caseMap.values()) {

                bw.write(c.getCaseId() + "," +
                        c.getTitle() + "," +
                        c.getYourParty() + "," +
                        c.getOppositionParty() + "," +
                        c.getYourLawyer() + "," +
                        c.getOppositionLawyer() + "," +
                        c.getJudge() + "," +
                        c.getSeverity() + "," +
                        c.getHearingSlot() + "," +
                        c.getJudgment() + "," +
                        c.isYourPartyPresent() + "," +
                        c.isOppositionPartyPresent());

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    private void loadFromFile() {

        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");

                if (d.length >= 12) {

                    CaseRecord c = new CaseRecord(
                            d[0], d[1], d[2], d[3],
                            d[4], d[5], d[6],
                            Integer.parseInt(d[7])
                    );

                    c.setHearingSlot(Integer.parseInt(d[8]));
                    c.setJudgment(d[9]);
                    c.setAttendance(Boolean.parseBoolean(d[10]),
                                    Boolean.parseBoolean(d[11]));

                    caseMap.put(d[0], c);
                    priorityQueue.offer(c);

                    if (c.getHearingSlot() != -1)
                        schedule.put(c.getHearingSlot(), c);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }

    public void viewAllCases() {
        for (CaseRecord c : caseMap.values()) {
            c.display();
        }
    }

    public void markAttendance(String id, boolean your, boolean opp) {
        CaseRecord c = caseMap.get(id);
        if (c != null) {
            c.setAttendance(your, opp);
            saveToFile();
            System.out.println("Attendance Updated.");
        } else {
            System.out.println("Case Not Found");
        }
    }

    public void assignHearing(String id, int slot) {
        CaseRecord c = caseMap.get(id);
        if (c != null) {
            schedule.put(slot, c);
            c.setHearingSlot(slot);
            saveToFile();
            System.out.println("Hearing Assigned");
        }
    }
}