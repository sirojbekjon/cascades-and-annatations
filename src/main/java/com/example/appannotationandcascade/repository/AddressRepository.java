package com.example.appannotationandcascade.repository;

import com.example.appannotationandcascade.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
