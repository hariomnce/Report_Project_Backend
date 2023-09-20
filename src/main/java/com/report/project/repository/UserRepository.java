package com.report.project.repository;

import com.report.project.entity.User;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);

    @Query(value = "SELECT count(*) FROM report_project.report;", nativeQuery = true)
    int findByUserCount();

}
