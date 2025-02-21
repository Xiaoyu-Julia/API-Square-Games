package com.example.demo.dao;

import com.example.demo.service.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JdbcUserDao implements UserDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcUserDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public @NotNull Stream<User> findAll() {
        String selectSql = "SELECT userId, email, password FROM user";
        List<User> users = jdbcTemplate.query(selectSql, userRowMapper());
        return users.stream();
    }

    @Override
    public Optional<User> findUserById(@NotNull int userId) {
        String selectUserSql = "SELECT userId, name, email FROM user WHERE userId = :userId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        return Optional.ofNullable(jdbcTemplate.queryForObject(selectUserSql, params, userRowMapper()));
    }

    @Override
    public User addUser(@NotNull User user) {
        String insertSql = "INSERT INTO user (name, email) VALUES (:name, :email)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", user.getEmail());
        params.addValue("password", user.getPassword());
        int newUserId = jdbcTemplate.queryForObject(insertSql, params, Integer.class);
        user.setUserId(newUserId);
        return user;
    }

    @Override
    public @NotNull User saveUser(@NotNull User user) {
        String updateSql = "UPDATE user SET name = :name, email = :email WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", user.getUserId());
        params.addValue("email", user.getEmail());
        params.addValue("password", user.getPassword());
        jdbcTemplate.update(updateSql, params);
        return user;
    }

    @Override
    public void deleteUser(@NotNull int userId) {
        String deleteSql = "DELETE FROM user WHERE userId = :userId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        jdbcTemplate.update(deleteSql, params);
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User(1,"test@test.com", "test");
            user.setUserId(rs.getInt("userId"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        };
    }

//    @Override
//    public @NotNull Stream<User> findAll() {
//        String selectSql = "select * from user";
//        SqlParameterSource parameters = new MapSqlParameterSource();
//        return jdbcTemplate.query(selectSql, parameters, rs -> {
//            List<User> users = new ArrayList<>(); // Initialisez la liste des utilisateurs
//            // Parcourez tous les enregistrements du ResultSet
//            while (rs.next()) {
//                User user = new User(); // Créez un nouvel objet User pour chaque enregistrement
//                user.setUserId(rs.getInt("userId"));
//                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("password"));
//                users.add(user); // Ajoutez l'utilisateur à la liste
//            }
//            return users.stream(); // Retournez le flux des utilisateurs
//        });
//    }
}

