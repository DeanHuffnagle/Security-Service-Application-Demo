package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.repo.RoleRepo;
import io.getarrays.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service@RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    @Override
    public User saveUser(User user) {
        log.info("saving new user {} to the database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void assignRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        log.info("adding role {} to user {}", roleName, username);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all users");
        return userRepo.findAll();
    }
}
