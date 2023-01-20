package com.jeterson.meuorcamento.security.models;

import com.jeterson.meuorcamento.domain.core.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDetailsData implements UserDetails {
    private Optional<User> user;

    public UserDetailsData(User user) {
        this.user = Optional.ofNullable(user);
    }

    public UserDetailsData() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  new ArrayList<>();
    }

    public Long getId() {
        return user.orElse(User.builder().build()).getId();
    }
    public String getName() {
        return user.orElse(User.builder().build()).getName();
    }

    @Override
    public String getPassword() {
        return user.orElse(User.builder().build()).getPassword();
    }

    @Override
    public String getUsername() {
        return user.orElse(User.builder().build()).getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Optional<User> getUser() {

       if(user.isEmpty())
           return Optional.ofNullable(null);

       return Optional.of(User.builder()
                       .id(user.get().getId())
                       .name(user.get().getName())
                       .username(user.get().getUsername())
               .build());
    }
}
