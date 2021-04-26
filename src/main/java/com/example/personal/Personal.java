package com.example.personal;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Personal {

  private @Id @GeneratedValue Long id;
  private String nombre;
  private String apellidoPaterno;
  //private String apellidomaterno;
  //private String email;
  //private String rol;

  protected Personal() {}

  public Personal(String nombre, String apellidoPaterno) {
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
  }

  @Override
  public String toString() {
    return String.format(
        "Personal[id=%d, nombre='%s', apellidoPaterno='%s']",
        id, nombre, apellidoPaterno);
  }

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Personal))
      return false;
    Personal personal = (Personal) o;
    return Objects.equals(this.id, personal.id) && Objects.equals(this.nombre, personal.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.nombre);
  }



}