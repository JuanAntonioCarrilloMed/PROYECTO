/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.crepas.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidad que representa a un usuario en el sistema.
 * 
 * Esta clase se utiliza para la autenticación de acceso,
 * permitiendo que un usuario inicie sesión mediante un login y contraseña.
 * 
 * La anotación @Entity indica que esta clase será mapeada como una tabla en la base de datos.
 * 
 * Autor: juana
 */
@Entity
public class Usuario {

    /**
     * Identificador único del usuario. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nombre de usuario utilizado para iniciar sesión.
     */
    private String login;

    /**
     * Contraseña del usuario (almacenada en texto plano o cifrada según la implementación).
     */
    private String password;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
