package LegalCase;

import java.util.LinkedList;

public class CaseRecord {

    private String caseId;
    private String title;

    private String yourParty;
    private String oppositionParty;
    private String yourLawyer;
    private String oppositionLawyer;

    private boolean yourPartyPresent = true;
    private boolean oppositionPartyPresent = true;

    private String judge;
    private String judgment;
    private int severity;
    private int hearingSlot;

    private LinkedList<String> history;

    public CaseRecord(String caseId, String title,
                      String yourParty, String oppositionParty,
                      String yourLawyer, String oppositionLawyer,
                      String judge, int severity) {

        this.caseId = caseId;
        this.title = title;
        this.yourParty = yourParty;
        this.oppositionParty = oppositionParty;
        this.yourLawyer = yourLawyer;
        this.oppositionLawyer = oppositionLawyer;
        this.judge = judge;
        this.severity = severity;
        this.judgment = "Pending";
        this.hearingSlot = -1;
        history = new LinkedList<>();
    }

    // Getters
    public String getCaseId() { return caseId; }
    public String getTitle() { return title; }
    public String getJudge() { return judge; }
    public int getSeverity() { return severity; }
    public int getHearingSlot() { return hearingSlot; }
    public String getJudgment() { return judgment; }
    public String getYourParty() { return yourParty; }
    public String getOppositionParty() { return oppositionParty; }
    public String getYourLawyer() { return yourLawyer; }
    public String getOppositionLawyer() { return oppositionLawyer; }

    public boolean isYourPartyPresent() { return yourPartyPresent; }
    public boolean isOppositionPartyPresent() { return oppositionPartyPresent; }

    // Setters
    public void setHearingSlot(int slot) { this.hearingSlot = slot; }
    public void setJudgment(String judgment) { this.judgment = judgment; }

    public void setAttendance(boolean yourPresent, boolean oppPresent) {
        this.yourPartyPresent = yourPresent;
        this.oppositionPartyPresent = oppPresent;
    }

    public void display() {

        System.out.println("\n-------------------------");
        System.out.println("Case ID: " + caseId);
        System.out.println("Title: " + title);

        System.out.println("\nYour Party: " + yourParty);
        System.out.println("Your Lawyer: " + yourLawyer);
        System.out.println("Present: " + (yourPartyPresent ? "Yes" : "No"));

        System.out.println("\nOpposition Party: " + oppositionParty);
        System.out.println("Opposition Lawyer: " + oppositionLawyer);
        System.out.println("Present: " + (oppositionPartyPresent ? "Yes" : "No"));

        System.out.println("\nJudge: " + judge);
        System.out.println("Severity: " + severity);
        System.out.println("Hearing Slot: " + hearingSlot);
        System.out.println("Judgment: " + judgment);

        if (!yourPartyPresent || !oppositionPartyPresent) {
            System.out.println("⚠ Hearing Rescheduled at Slot: " + hearingSlot);
        }

        System.out.println("-------------------------");
    }
}