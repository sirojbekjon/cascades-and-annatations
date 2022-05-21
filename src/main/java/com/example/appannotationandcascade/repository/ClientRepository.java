package com.example.appannotationandcascade.repository;

import com.example.appannotationandcascade.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


//@RepositoryRestResource(path="client")
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
