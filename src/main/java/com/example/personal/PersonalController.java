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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
public class PersonalController {
	private final PersonalRepository repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/sign-up")
    public Personal signUp(@RequestBody Personal user) {
        user.setContrasenia(bCryptPasswordEncoder.encode(user.getContrasenia()));
        repository.save(user);
        return user;
    }

	PersonalController(PersonalRepository repository,BCryptPasswordEncoder bCryptPasswordEncoder) {
	    this.repository = repository;
	    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	  }


    @Operation(summary = "Obtener los datos de todo el personal")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Personal",
    content = { @Content(mediaType = "application/json",
      schema = @Schema(implementation = Personal.class)) }),
    @ApiResponse(responseCode = "400", description = "Id invalido",
    content = @Content),
    @ApiResponse(responseCode = "404", description = "Personal no encontrado", content = @Content) })
    @GetMapping("/personal")
	  CollectionModel<EntityModel<Personal>> all() {

  		List<EntityModel<Personal>> personals = repository.findAll().stream()
      		.map(personal -> EntityModel.of(personal,
             linkTo(methodOn(PersonalController.class).one(personal.getId())).withSelfRel(),
             linkTo(methodOn(PersonalController.class).all()).withRel("personal")))
            .collect(Collectors.toList());

  	return CollectionModel.of(personals, linkTo(methodOn(PersonalController.class).all()).withSelfRel());
	}


    @Operation(summary = "Obtener los datos de un personal por su id", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Personal",
    content = { @Content(mediaType = "application/json",
      schema = @Schema(implementation = Personal.class)) }),
    @ApiResponse(responseCode = "400", description = "Id invalido",
    content = @Content),
    @ApiResponse(responseCode = "404", description = "Personal no encontrado", content = @Content) })
	@GetMapping("/personal/{id}")
	EntityModel<Personal> one(@PathVariable Long id) {

	  Personal personal = repository.findById(id) //
	      .orElseThrow(() -> new PersonalNotFoundException(id));

	  return EntityModel.of(personal, //
	      linkTo(methodOn(PersonalController.class).one(id)).withSelfRel(),
	      linkTo(methodOn(PersonalController.class).all()).withRel("personal"));
	}

}

