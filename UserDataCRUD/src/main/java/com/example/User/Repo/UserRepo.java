package com.example.User.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
