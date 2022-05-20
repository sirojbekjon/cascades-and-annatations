package com.example.appannotationandcascade.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String phoneNumber;

    @OneToOne(mappedBy = "client",cascade = CascadeType.PERSIST)
    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        bankAccount.setClient(this);
        this.bankAccount = bankAccount;
    }
}
