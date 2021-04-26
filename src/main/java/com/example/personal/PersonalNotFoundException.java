package com.example.personal;

class PersonalNotFoundException extends RuntimeException {

  PersonalNotFoundException(Long id) {
    super("No se encontro el personal con el id : " + id);
  }
}