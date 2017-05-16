/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Luis Rivera
 */
public class Usuarios {
    private String user;
    private String contra;
    private String nivel;
    private String nombre;
    private String ocupacion;
    private String email;
    private String preguntas;
    private String rrspuesta;
   private int id;

    public String getPreguntas() {
        return preguntas;
    }

    public Usuarios(String user, String contra, String nivel, String nombre, String ocupacion, String email, String preguntas, String rrspuesta, int id) {
        this.user = user;
        this.contra = contra;
        this.nivel = nivel;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.email = email;
        this.preguntas = preguntas;
        this.rrspuesta = rrspuesta;
        this.id = id;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public String getRrspuesta() {
        return rrspuesta;
    }

    public void setRrspuesta(String rrspuesta) {
        this.rrspuesta = rrspuesta;
    }
    

    public Usuarios() {
    }

    public Usuarios(String user, String contra, String nivel, String nombre, String ocupacion, String email) {
        this.user = user;
        this.contra = contra;
        this.nivel = nivel;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
}
