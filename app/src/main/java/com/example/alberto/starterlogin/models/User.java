package com.example.alberto.starterlogin.models;

/**
 * Created by Alberto on 05/12/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("rif")
    @Expose
    private String rif;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("clave")
    @Expose
    private String clave;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("privilegios")
    @Expose
    private String privilegios;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("R")
    @Expose
    private String r;

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

}