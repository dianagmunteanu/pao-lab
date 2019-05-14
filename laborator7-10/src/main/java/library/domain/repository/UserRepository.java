package library.domain.repository;

import library.domain.entity.User;

import java.util.Set;

public interface UserRepository {
    public Set<User> getUsers();
}
