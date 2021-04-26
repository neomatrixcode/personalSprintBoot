package com.example.personal;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;

@RestController
public class PersonalController {
	private final PersonalRepository repository;

	PersonalController(PersonalRepository repository) {
	    this.repository = repository;
	  }

    @GetMapping("/personal")
	  CollectionModel<EntityModel<Personal>> all() {

  		List<EntityModel<Personal>> personals = repository.findAll().stream()
      		.map(personal -> EntityModel.of(personal,
             linkTo(methodOn(PersonalController.class).one(personal.getId())).withSelfRel(),
             linkTo(methodOn(PersonalController.class).all()).withRel("personal")))
            .collect(Collectors.toList());

  	return CollectionModel.of(personals, linkTo(methodOn(PersonalController.class).all()).withSelfRel());
	}

	@GetMapping("/personal/{id}")
	EntityModel<Personal> one(@PathVariable Long id) {

	  Personal personal = repository.findById(id) //
	      .orElseThrow(() -> new PersonalNotFoundException(id));

	  return EntityModel.of(personal, //
	      linkTo(methodOn(PersonalController.class).one(id)).withSelfRel(),
	      linkTo(methodOn(PersonalController.class).all()).withRel("personal"));
	}

}

