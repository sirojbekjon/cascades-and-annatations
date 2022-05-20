package com.example.appannotationandcascade.repository;

import com.example.appannotationandcascade.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
