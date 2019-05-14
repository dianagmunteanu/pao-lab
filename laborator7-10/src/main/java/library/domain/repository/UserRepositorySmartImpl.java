package library.domain.repository;

import library.domain.entity.User;
import library.tool.TestData;
import library.tool.UserBuilder;

import java.util.HashSet;
import java.util.Set;

public class UserRepositorySmartImpl implements UserRepository {

    private Set<User> users;

    public UserRepositorySmartImpl() {
        int length = TestData.getInstance().getUserData().length;
        this.users = new HashSet<>();
        for (int i = 0; i < length; i++) {
            String[] splitedData = TestData.getInstance().getUserData()[i].split(",");
            this.users.add(
                    new UserBuilder()
                            .withId(Integer.valueOf(splitedData[0]))
                            .withName(splitedData[1] + " " + splitedData[2])
                            .build());

        }
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }
}
