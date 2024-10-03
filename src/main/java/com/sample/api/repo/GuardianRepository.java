package com.sample.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.api.entity.Guardian;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian,Long> {
    
}
