package com.jeterson.meuorcamento.dataaccess.user.mapper;

import com.jeterson.meuorcamento.dataaccess.user.entities.UserEntity;
import com.jeterson.meuorcamento.domain.core.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {

    public UserEntity toEntity(User user) {
        var userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        return userEntity;
    }
    public User toUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();
    }
}
