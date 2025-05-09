package br.com.dio.diobank.service.impl;

import br.com.dio.diobank.domain.model.User;
import br.com.dio.diobank.domain.repository.UserRepository;
import br.com.dio.diobank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User createUser(User user) {
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists!");
        }
        return userRepository.save(user);
    }
}
