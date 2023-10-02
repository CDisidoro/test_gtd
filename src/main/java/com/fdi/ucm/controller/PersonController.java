package com.fdi.ucm.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fdi.ucm.repository.PersonRepository;
import com.google.common.hash.Hashing;
import com.fdi.ucm.model.Person;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
	private PersonRepository repository;
	
    @GetMapping("/test")
    public String test(){
        return "Esto funciona";
    }

	@GetMapping("/person/hash/{id}")
	public String getHashById(@PathVariable long id){
		Optional<Person> person = repository.findById(id);
		if(person.isPresent()){
			String hashed = Hashing.sha256().hashString(person.toString(), StandardCharsets.UTF_8).toString();
			return hashed;
		}else{
			return "Person not found";
		}
	}

	@GetMapping("/persons")
	public List<Person> allPersons(){
		return repository.findAll();
	}
	
	@GetMapping("/person/{name}")
	public List<Person> findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}
	
	@PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
		return repository.save(person);
	}
	
	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable int id ,@RequestBody Person person) {
		return repository.save(person);
	}
	
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
