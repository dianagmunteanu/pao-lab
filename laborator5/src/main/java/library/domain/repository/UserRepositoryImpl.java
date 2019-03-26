package library.domain.repository;

import library.tool.UserBuilder;
import library.domain.entity.User;

public class UserRepositoryImpl implements UserRepository{

    private User[] users =
            new User[]{
                    new UserBuilder()
                            .withName("Gigel")
                            .withId(1)
                            .withEmail("email@test.com")
                            .build(),
                    new UserBuilder()
                            .withName("John Doe")
                            .withId(2)
                            .withEmail("email@test.com")
                            .build(),
                    new UserBuilder()
                            .withName("John Mark Doe")
                            .withId(3)
                            .withEmail("email@test.com")
                            .build(),
                    new UserBuilder()
                            .withName("John Doe Mark")
                            .withId(4)
                            .withEmail("email@test.com")
                            .build(),
                    new UserBuilder()
                            .withName("John Dan")
                            .withId(5)
                            .withEmail("email@test.com")
                            .build()
            };

    @Override
    public User[] getUsers() {
        return users;
    }

}
