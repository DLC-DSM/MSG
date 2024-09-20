package org.example.global.auth.user;

import lombok.RequiredArgsConstructor;
import org.example.db.global.User.entity.UserEntity;
import org.example.db.global.User.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow();
        return CustomUserDetails.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities((Collection<? extends GrantedAuthority>) user.getRoles())
                .build();
    }

    public UserDetails loadUserIdByUser(Integer userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        return CustomUserDetails.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities((Collection<? extends GrantedAuthority>) user.getRoles())
                .build();
    }

}
