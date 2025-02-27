package com.example.demo.service;

import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Qualifier("jpaUserDao")
    @Autowired
    private UserDao userDao;

    //List<User> users = new ArrayList<>();
    //private int userIdCounter = 1;

//    @Override
//    public User createUser(int userId, String email, String password) {
//        User user = new User(userId, email, password); //userIdCounter++
////        user.setEmail(email);
////        user.setPassword(password);
//        // Cas pour List
//        //users.add(user);
//
//        // Cas pour JPA
//        userDao.addUser(user);
//        return user;
//    }

    @Override
    public User createUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll().toList();
        //return users;
    }

    @Override
    public User getUserById(UUID userId) {
        return userDao.findUserById(userId).orElse(null);
        //return users.get(userId);
    }

    @Override
    public User modifyUser(UUID userId, String email, String password) {
        User user = userDao.findUserById(userId).orElse(null);
        assert user != null;
        user.setEmail(email);
        user.setPassword(password);
        return userDao.saveUser(user);

        //before add userDAO
//        User user = getUserById(userId);
//        for (User u : users) {
//            if (user.getUserId() == u.getUserId()) {
//                u.setEmail(email);
//                u.setPassword(password);
//            }
//        }
//        return user;
    }

    @Override
    public void deleteUser(UUID userId){
        userDao.deleteUser(userId);
        // users.remove(userId);
    }


}

//@Service
//public class UserServiceImpl implements UserService {
//
//    @Qualifier("jpaUserDao")
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private UserEntityRepository userEntityRepository;
//
//    public UserServiceImpl() {}
//
//    //List<User> users = new ArrayList<>();
//    private int userIdCounter = 1;
//
//    @Override
//    public User createUser(String email, String password) {
//        User user = new User(userIdCounter++, email, password);
////        user.setEmail(email);
////        user.setPassword(password);
//        // Cas pour List
//        //users.add(user);
//
//        // Cas pour JPA
//        //System.out.println("userId =" + user.getUserId() + "/" + user.getEmail() + "/" + user.getPassword());
//        userEntityRepository.save(convertToUserEntity(user)); // TODO à voir
//        return user;
//    }
//
//    private UserEntity convertToUserEntity(User user) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(user.getUserId());
//        userEntity.setEmail(user.getEmail());
//        return userEntity;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        //return userDao.findAll().toList();
//        System.out.println("getAllUsers en cours ...");
//        return userEntityRepository.findAll().stream().map(
//                ue -> new User(ue.getId(), ue.getEmail(), ue.getPassword())).collect(Collectors.toList());
//        //return users;
//    }
//
//    @Override
//    public User getUserById(int userId) {
//        return userDao.findUserById(userId).orElse(null);
//        //return users.get(userId);
//    }
//
//    @Override
//    public User modifyUser(int userId, String email, String password) {
//        User user = userDao.findUserById(userId).orElse(null);
//        assert user != null;
//        user.setEmail(email);
//        user.setPassword(password);
//        //return userEntityRepository.save(user); // TODO à voir
//        return userDao.saveUser(user);
//
//        //before add userDAO
////        User user = getUserById(userId);
////        for (User u : users) {
////            if (user.getUserId() == u.getUserId()) {
////                u.setEmail(email);
////                u.setPassword(password);
////            }
////        }
////        return user;
//    }
//
//    @Override
//    public void deleteUser(int userId){
//        //userDao.deleteUser(userId); //TODO
//        System.out.println("deleteUser en cours ...");
//        this.userEntityRepository.deleteById(userId);
//        System.out.println("deleteUser termine");
//       // users.remove(userId);
//    }
//
//
//}





