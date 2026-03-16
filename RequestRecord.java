package LegalCase;

public class RequestRecord {

    public String id;
    public String title;

    public RequestRecord(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toCSV() {
        return id + "," + title;
    }
}