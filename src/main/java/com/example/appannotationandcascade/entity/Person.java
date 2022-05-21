package com.example.appannotationandcascade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.omg.CORBA.PUBLIC_MEMBER;

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
    private List<Address> addresses;//REMOVE ISHLATILGANDA FORIEGN KEY QILINGAN TABLEDAGI MALUMOTLAR HAM O'CHIB KETADI



    @Transient //VAZEFASI ENTITYDA KERAK LEKIN DATABASE DA KERAK BOLMAGAN FIELD LAR UCHUN ISHLATAMIZ
    private Integer countFullNameLetters;

    public Integer getCountFullNameLetters(){
        return fullName!=null?fullName.length():0;
    }

}
