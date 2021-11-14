/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.model.bean;

/**
 *
 * @author User
 */
public class Maquina {
    
    private int id;
    private String modelo;
    private String os;
    private String ano;

    public Maquina(int id) {
        this.id = id;
    }
    
    public Maquina(String modelo) {
        this.modelo = modelo;
    }

    public Maquina(int id, String modelo, String os, String ano) {
        this.id = id;
        this.modelo = modelo;
        this.os = os;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
    
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Maquina{" + "id=" + id + ", modelo=" + modelo + ", os = " + os + ", ano="+ ano +'}';
    }
    
}
