package library.domain.repository;

import library.domain.entity.User;
import library.tool.TestData;
import library.tool.UserBuilder;

public class UserRepositorySmartImpl implements UserRepository {

    private User[] users;

    public UserRepositorySmartImpl() {
        int length = TestData.getInstance().getUserData().length;
        this.users = new User[length];
        for (int i = 0; i < length; i++) {
            String[] splitedData = TestData.getInstance().getUserData()[i].split(",");
            this.users[i] =
                    new UserBuilder()
                            .withId(Integer.valueOf(splitedData[0]))
                            .withName(splitedData[1] + " " + splitedData[2])
                            .build();

        }
    }

    @Override
    public User[] getUsers() {
        return users;
    }
}
