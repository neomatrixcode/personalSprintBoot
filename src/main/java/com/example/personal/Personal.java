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
  private String apellidoMaterno;
  private String email;
  private String rol;
  private String usuario;
  private String contrasenia;

  protected Personal() {}

  public Personal(String nombre, String apellidoPaterno, String usuario, String contrasenia, String rol, String email) {
    this.usuario = usuario;
    this.contrasenia = contrasenia;
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.rol = rol;
    this.email = email;
  }

  @Override
  public String toString() {
    return String.format(
        "Personal[id=%d, usuario='%s', nombre='%s', apellidoPaterno='%s', apellidoMaterno='%s', rol='%s', email='%s']",
        id, usuario, nombre, apellidoPaterno, apellidoMaterno, rol, email);
  }

  public Long getId() {
    return id;
  }


  public void setNombre(String nombre) {
        this.nombre = nombre;
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

  public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
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