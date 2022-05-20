package com.example.appannotationandcascade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    @OneToMany(mappedBy = "shaxs",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})//BUYERDA CascadeType PERSONNI SAQLAGANDA ADDRESSNI HAM QOSHIB SAQLASH UCHUN HIZMAT QILMOQDA
    private List<Address> addresses;                                                    //REMOVE ISHLATILGANDA FORIEGN KEY QILINGAN TABLEDAGI MALUMOTLAR HAM O'CHIB KETADI
}
