package library.domain.entity;

public class MovieDVD extends Item{

    private String description;
    private String genre;

    public MovieDVD(int id, String title) {
        super(id, title);
    }

    public MovieDVD(int id, String title, String description, String genre) {
        super(id, title);
        this.description = description;
        this.genre = genre;
    }
}
