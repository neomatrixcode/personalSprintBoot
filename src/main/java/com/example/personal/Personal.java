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
  private String apellidomaterno;
  private String email;
  private String rol;
  private String usuario;
  private String contrasenia;

  protected Personal() {}

  public Personal(String nombre, String apellidoPaterno, String usuario, String contrasenia, String rol, String email) {
    this.nombre = nombre;
    this.usuario = usuario;
    this.contrasenia = contrasenia;
    this.apellidoPaterno = apellidoPaterno;
    this.rol = rol;
    this.email = email;
  }

  @Override
  public String toString() {
    return String.format(
        "Personal[id=%d, nombre='%s', apellidoPaterno='%s', usuario='%s']",
        id, nombre, apellidoPaterno, usuario);
  }

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

  public String getUsuario() {
    return usuario;
  }

  public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
  }

  public void setRol(String rol) {
        this.rol = rol;
  }

  public String getRol() {
    return rol;
  }

  public void setEmail(String email) {
        this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public String getContrasenia() {
    return contrasenia;
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
    return Objects.equals(this.id, personal.id) && Objects.equals(this.nombre, personal.nombre) && Objects.equals(this.usuario, personal.usuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.nombre, this.usuario);
  }



}