package br.com.dio.diobank.service;

import br.com.dio.diobank.domain.model.User;

public interface UserService {
    User findById(Long id);

    User createUser(User user);
}
