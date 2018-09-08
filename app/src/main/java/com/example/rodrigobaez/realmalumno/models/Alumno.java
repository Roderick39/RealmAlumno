package com.example.rodrigobaez.realmalumno.models;

import com.example.rodrigobaez.realmalumno.application.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Alumno extends RealmObject {

    @PrimaryKey
    private int Id;
    private String Rut;
    private String Nombre;
    private String Apellido;
    private String Edad;
    private String Carrera;
    private String Ano;
    private String Semestre;

    public Alumno() {}

    public  Alumno(String rut, String nombre, String apellido, String edad, String carrera, String ano, String semestre){
        Id = MyApplication.AlumnoId.incrementAndGet();
        Rut = rut;
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
        Carrera = carrera;
        Ano = ano;
        Semestre = semestre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        Rut = rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEdad() {
        return Edad;
    }



    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String ano) {
        Ano = ano;
    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String semestre) {
        Semestre = semestre;
    }
}


