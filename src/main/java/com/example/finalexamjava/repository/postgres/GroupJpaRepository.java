package com.example.finalexamjava.repository.postgres;

import com.example.finalexamjava.model.GroupManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupJpaRepository extends JpaRepository<GroupManager, Long> {
    Optional<GroupManager> findByGroupName(String groupname);
}
