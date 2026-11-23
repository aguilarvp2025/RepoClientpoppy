/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.poppyclient.entities;

import com.google.gson.annotations.SerializedName;

public class Empleado {
    private Integer id;
    private String nombre;
    private String puesto;
    private String departamento;
    private String salario;

    @SerializedName("fecha_contratacion")
    private String fechaContratacion;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getSalario() { return salario; }
    public void setSalario(String salario) { this.salario = salario; }
    public String getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(String f) { this.fechaContratacion = f; }
}