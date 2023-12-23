package com.example.rsocialback.Dao;

import com.example.rsocialback.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,String> {
}
