package com.example.cashedandcustomer.repository;

import com.example.cashedandcustomer.Models.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBalanceRepository extends JpaRepository<UserBalance,Integer> {
    List<UserBalance> findByValueAfter(int value);
}
