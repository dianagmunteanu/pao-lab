package library.domain.repository;

import library.domain.ErrorCode;
import library.domain.LibraryException;
import library.domain.entity.User;

import java.util.Set;

public interface UserRepository {

    public Set<User> getUsers();

    default public User getUserBy(int id) {
        throw new LibraryException(ErrorCode.NOT_IMPLEMENTED, "Method is not implemented");
    }

    default public boolean insertUser(User user) {
        throw new LibraryException(ErrorCode.NOT_IMPLEMENTED, "Method is not implemented");
    }

    default public boolean saveUpdatedUser(User user) {
        throw new LibraryException(ErrorCode.NOT_IMPLEMENTED, "Method is not implemented");
    }

    default public boolean deleteUser(int id) {
        throw new LibraryException(ErrorCode.NOT_IMPLEMENTED, "Method is not implemented");
    }

    default public int getNextId(){
        throw new LibraryException(ErrorCode.NOT_IMPLEMENTED, "Method is not implemented");
    }

    default public void updateUser(String text, String newAddress){
        throw new LibraryException(ErrorCode.NOT_IMPLEMENTED, "Method is not implemented");

    };
}
