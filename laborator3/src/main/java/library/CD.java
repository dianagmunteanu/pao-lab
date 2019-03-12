package library;

public class CD extends Item{

    private String description;
    private long cdItemId;

    public CD(int id, String title) {
        super(id, title);
    }

    public CD(int id, String title, String description, long cdItemId) {
        super(id, title);
        this.description = description;
        this.cdItemId = cdItemId;
    }
}
