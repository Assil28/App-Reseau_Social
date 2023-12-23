package com.example.rsocialback.Dao;

import com.example.rsocialback.Model.Publication;
import com.example.rsocialback.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationDao extends JpaRepository<Publication,Long> {


    List<Publication> findPublicationsByUser(User user);
}
