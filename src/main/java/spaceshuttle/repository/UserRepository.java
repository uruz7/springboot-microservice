package spaceshuttle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spaceshuttle.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    User findUserByEmail(String email);

    User findById(Long id);

    @Query("select u from User u")
    List<User> findAllUsers();

}