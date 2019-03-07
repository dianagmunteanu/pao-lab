public class User {

    private int id;
    private String name;
    private String type;


    public User(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
}
