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
public class Actividad {
    private int id;
    private String titulo;
    private String color;
    private boolean todoeldia;
    private String inicio;
    private String fin;
    private String notas;
    private String user;
    private boolean notificacion;

    public Actividad(int id, String titulo, String color, boolean todoeldia, String inicio, String fin, String notas, String user, boolean notificacion) {
        this.id = id;
        this.titulo = titulo;
        this.color = color;
        this.todoeldia = todoeldia;
        this.inicio = inicio;
        this.fin = fin;
        this.notas = notas;
        this.user = user;
        this.notificacion = notificacion;
    }

    public Actividad() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isTodoeldia() {
        return todoeldia;
    }

    public void setTodoeldia(boolean todoeldia) {
        this.todoeldia = todoeldia;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isNotificacion() {
        return notificacion;
    }

    public void setNotificacion(boolean notificacion) {
        this.notificacion = notificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
