package com.example.demo;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Stream;

public class JpaUserDao implements UserDao {

    private UserEntityRepository userRepository;
    public JpaUserDao(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public @NotNull Stream<User> findAll() {
        return userRepository.findAll().stream().map(this::convertToUser);
    }

    @Override
    public Optional<User> findUserById(@NotNull int userId) {
        return userRepository.findById(userId).map(this::convertToUser);
    }

    @Override
    public @NotNull User addUser(@NotNull User user) {
        UserEntity userEntity = convertToUserEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return convertToUser(savedUserEntity);
    }

    @Override
    public @NotNull User saveUser(@NotNull User user) {
        UserEntity userEntity = convertToUserEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return convertToUser(savedUserEntity);
    }

    @Override
    public void deleteUser(@NotNull int userId) {
        userRepository.deleteById(userId);
    }

    private User convertToUser(UserEntity userEntity) {
        User user = new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword());
        user.setUserId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        return user;
    }

    private UserEntity convertToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getUserId());
        userEntity.setEmail(user.getEmail());
        return userEntity;
    }


}
