package library.domain.entity;

public class MusicCD extends Item{

    private String description;
    private long cdItemId;

    public MusicCD(int id, String title) {
        super(id, title);
    }

    public MusicCD(int id, String title, String description, long cdItemId) {
        super(id, title);
        this.description = description;
        this.cdItemId = cdItemId;
    }
}
