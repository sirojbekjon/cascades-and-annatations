package com.example.appannotationandcascade.controller;

import com.example.appannotationandcascade.entity.Address;
import com.example.appannotationandcascade.entity.Person;
import com.example.appannotationandcascade.payload.AddressDto;
import com.example.appannotationandcascade.payload.PersonDto;
import com.example.appannotationandcascade.repository.AddressRepository;
import com.example.appannotationandcascade.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public HttpEntity<?> addPerson(@RequestBody List<AddressDto> addressDtoList){
            List<Address> addresses = new ArrayList<>();
        for (AddressDto addressDto : addressDtoList) {
            Optional<Person> optionalPerson = personRepository.findById(addressDto.getPersonId());
            Person person = optionalPerson.get();

            Address address = new Address(
                    addressDto.getStreet(),
                    addressDto.getCity(),
                    person);
            addresses.add(address);
        }
        List<Address> saveAddress = addressRepository.saveAll(addresses);
        return ResponseEntity.status(200).body(saveAddress);
    }

}
