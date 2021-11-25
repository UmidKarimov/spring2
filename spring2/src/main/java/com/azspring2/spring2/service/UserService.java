package com.azspring2.spring2.service;

import com.azspring2.spring2.entity.UserEntity;
import com.azspring2.spring2.exceptions.UserAlreadyExistsException;
import com.azspring2.spring2.exceptions.UserNotFoundException;
import com.azspring2.spring2.model.UserModel;
import com.azspring2.spring2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                throw new UserAlreadyExistsException("User with this username <"+user.getUsername() + "> already exists!");
            }
            return userRepo.save(user);
    }

    public UserModel getUserById(Long id) throws UserNotFoundException{

        UserEntity userEntity = userRepo.findById(id).get();
        if (userEntity == null) {
            throw new UserNotFoundException("User with this id <"+ id + "> not found!");
        }
        return  UserModel.toModel(userEntity);
    }

    public Long deleteUser (Long id) throws UserNotFoundException {

        UserEntity userEntity = userRepo.findById(id).get();
        if (userEntity == null) {
            throw new UserNotFoundException("User with this id <"+ id + "> not found!");
        }
        userRepo.deleteById(id);
        return id;
    }
}
