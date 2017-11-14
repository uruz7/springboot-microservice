package spaceshuttle.repository;

import org.springframework.data.jpa.domain.Specification;
import spaceshuttle.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class UserSpecification {
    private User user;

    public UserSpecification(User user) {
        super();
        this.user = user;
    }

    public Specification<User> findByUsername() {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(user.getUsername()), user.getUsername());
            }
        };

    }
}