package spaceshuttle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spaceshuttle.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);
}