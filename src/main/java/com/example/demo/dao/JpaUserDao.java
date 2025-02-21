package com.example.demo.dao;

import com.example.demo.service.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class JpaUserDao implements UserDao {

    @Autowired
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
        System.out.println("userEntity = " + userEntity);
        return new User(userEntity.getUser_id(), userEntity.getEmail(), userEntity.getPassword());
    }

    private UserEntity convertToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser_id(user.getUserId());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }


}
