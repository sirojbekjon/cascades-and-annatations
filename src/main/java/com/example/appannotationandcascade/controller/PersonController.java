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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @PostMapping
    public HttpEntity<?> addPerson(@RequestBody PersonDto personDto){

        //PERSONNI SQLAB OLDIK
        Person person = new Person();
        person.setFullName(personDto.getFullName());

        //ADDRESS NI YASAB OLAMIZ
        List<Address> addresses = new ArrayList<>();
        for (AddressDto addressDto : personDto.getAddressDtoList()) {
            Address address = new Address(
                    addressDto.getStreet(),
                    addressDto.getCity(),
                    person
                    );
            addresses.add(address);
        }
        person.setAddresses(addresses);
        personRepository.save(person);
//        List<Address> saveAddress = addressRepository.saveAll(addresses);
        return ResponseEntity.ok("saqlandi");
    }


    @PutMapping("/{id}")
    public HttpEntity<?> editPerson(@PathVariable Integer id){

        //PERSONNI SQLAB OLDIK

        Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = optionalPerson.get();
        person.setFullName("Sirojiddin");

        //ADDRESS NI YASAB OLAMIZ
        for (Address address : person.getAddresses()) {
             address.setStreet("Farobiy");
        }

        personRepository.save(person);
//        List<Address> saveAddress = addressRepository.saveAll(addresses);
        return ResponseEntity.ok("Tashkent");
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePerson(@PathVariable Integer id){
        try{
            personRepository.deleteById(id);
            return ResponseEntity.ok("o'chirildi");
        }catch (Exception e){
            return ResponseEntity.ok("o'chirilmadi");
        }
    }
}
