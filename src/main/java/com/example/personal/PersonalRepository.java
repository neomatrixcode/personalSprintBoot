package com.example.personal;

import org.springframework.data.jpa.repository.JpaRepository;

interface PersonalRepository extends JpaRepository<Personal, Long> {
     Personal findByUsuario(String usuario);
}