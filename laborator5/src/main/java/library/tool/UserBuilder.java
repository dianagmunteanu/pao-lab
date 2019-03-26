package library.tool;


import library.domain.entity.User;

public class UserBuilder {
    private final User target = new User();


    public UserBuilder withName(String userName) {
        target.setName(userName);
        return this;
    }

    public UserBuilder withId(int id) {
        target.setId(id);
        return this;
    }

    public UserBuilder withEmail(String email) {
        target.setEmail(email);
        return this;
    }

    public User build() {
        return target;
    }
}
