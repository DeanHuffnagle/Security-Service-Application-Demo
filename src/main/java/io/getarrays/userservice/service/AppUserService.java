package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.AppUser;

import java.util.List;


public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void assignRoleToUser(String username, String roleName);
    AppUser getUser (String userName);
    List<AppUser> getUsers();
}
