package com.example.finalexamjava.repository.postgres;

import com.example.finalexamjava.model.GroupManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface GroupJpaRepository extends JpaRepository<GroupManager, Long>, JpaSpecificationExecutor<GroupManager> {
    Optional<GroupManager> findByGroupName(String groupname);


}
