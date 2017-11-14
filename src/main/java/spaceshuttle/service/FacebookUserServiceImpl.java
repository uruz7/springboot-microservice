package spaceshuttle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spaceshuttle.model.Role;
import spaceshuttle.model.User;
import spaceshuttle.repository.RoleRepository;
import spaceshuttle.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service("facebookUserService")
//@Profile("facebook")
public class FacebookUserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public List<User> findByExample(User example) {
        return null;
    }

    @Override
    public List<User> findBySpecification(Specification<User> specification) {
        return null;
    }
}