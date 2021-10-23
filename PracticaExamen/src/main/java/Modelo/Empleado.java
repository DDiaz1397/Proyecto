package Modelo;

import java.util.Date;



public class Empleado {
    private String idEmpleado;
    private String primapellido;
    private String segpellido;
    private String nombre;
    private Date fechaIngreso;
    private Date fechaNac;
    private int edad;
    private String sexo;
    private String telefono;
    private String email;

    public Empleado(String idEmpleado, String primapellido, String segpellido, String nombre, Date fechaIngreso, Date fechaNac, int edad, String sexo, String telefono, String email) {
        this.idEmpleado = idEmpleado;
        this.primapellido = primapellido;
        this.segpellido = segpellido;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.fechaNac = fechaNac;
        this.edad = edad;
        this.sexo = sexo;
        this.telefono = telefono;
        this.email = email;
    }

    public Empleado() {
        
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPrimapellido() {
        return primapellido;
    }

    public void setPrimapellido(String primapellido) {
        this.primapellido = primapellido;
    }

    public String getSegpellido() {
        return segpellido;
    }

    public void setSegpellido(String segpellido) {
        this.segpellido = segpellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngrreso() {
        return fechaIngreso;
    }

    public void setFechaIngrreso(Date fechaIngrreso) {
        this.fechaIngreso = fechaIngrreso;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
