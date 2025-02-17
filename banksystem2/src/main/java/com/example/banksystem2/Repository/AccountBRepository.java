package com.example.banksystem2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banksystem2.Entity.AccountB;
@Repository
public interface AccountBRepository extends JpaRepository<AccountB, Long> {
    
}
