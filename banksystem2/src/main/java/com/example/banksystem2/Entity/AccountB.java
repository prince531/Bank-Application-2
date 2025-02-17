package com.example.banksystem2.Entity;

import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ToString
public class AccountB {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;
    private String accountHolderName;
    private double balance;
}
