package org.example.global.auth.user;

import lombok.RequiredArgsConstructor;
import org.example.global.User.List.RoleList;
import org.example.global.User.entity.Role;
import org.example.global.User.entity.User;
import org.example.global.User.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername();

        return CustomUserDetails.builder()
                .username(user.getUsername())
                .roles(getAuthorities(user.getRoles()))
                .build();
    }

    private List<GrantedAuthority> getAuthorities(List<Role> roles) {
        return roles.stream()
                .map(Role::getRole)
                .map(RoleList::getRole)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
