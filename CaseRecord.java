package LegalCase;

public class CaseRecord {

    private String id;
    private String title;
    private String yourParty;
    private String oppositionParty;
    private String judge;
    private String hearingDate;
    private String judgment;
    private String attendance;

    // ===== CORRECT CONSTRUCTOR (8 PARAMETERS) =====
    public CaseRecord(String id, String title,
                      String yourParty, String oppositionParty,
                      String judge, String hearingDate,
                      String judgment, String attendance) {

        this.id = id;
        this.title = title;
        this.yourParty = yourParty;
        this.oppositionParty = oppositionParty;
        this.judge = judge;
        this.hearingDate = hearingDate;
        this.judgment = judgment;
        this.attendance = attendance;
    }

    public String getId() {
        return id;
    }

    public void setDate(String d) {
        hearingDate = d;
    }

    public void setJudgment(String j) {
        judgment = j;
    }

    public void setAttendance(String a) {
        attendance = a;
    }

    public String toCSV() {
        return id + "," + title + "," + yourParty + "," +
               oppositionParty + "," + judge + "," +
               hearingDate + "," + judgment + "," + attendance;
    }

    public void display() {

        System.out.println("\n===== CASE DETAILS =====");
        System.out.println("Case ID           : " + id);
        System.out.println("Title             : " + title);
        System.out.println("Your Party        : " + yourParty);
        System.out.println("Opposition Party  : " + oppositionParty);
        System.out.println("Judge             : " + judge);
        System.out.println("Hearing Date      : " + hearingDate);
        System.out.println("Judgment          : " + judgment);
        System.out.println("Attendance        : " + attendance);
    }
}