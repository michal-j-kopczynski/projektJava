package com.jv_backend.backend.Repo;

import com.jv_backend.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
