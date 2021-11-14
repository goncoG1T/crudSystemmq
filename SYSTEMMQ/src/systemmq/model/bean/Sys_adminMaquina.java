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
public class Sys_adminMaquina {
    
    private int id;
    private int idSys;
    private int idMaq;
    private String obs;
    private Sys_admin sys;
    private Maquina maq;

    public Sys_adminMaquina(int id) {
        this.id = id;
    }

    public Sys_adminMaquina(String obs) {
        this.obs = obs;
    }

    public Sys_adminMaquina(int id, int idSys, int idMaq, String obs) {
        this.id = id;
        this.idSys = idSys;
        this.idMaq = idMaq;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSys() {
        return idSys;
    }

    public void setIdSys(int idSys) {
        this.idSys = idSys;
    }

    public int getIdMaq() {
        return idMaq;
    }

    public void setIdPet(int idMaq) {
        this.idMaq = idMaq;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Sys_admin getSys() {
        return sys;
    }

    public void setSys(Sys_admin sys) {
        this.sys = sys;
    }

    public Maquina getMaq() {
        return maq;
    }

    public void setMaq(Maquina maq) {
        this.maq = maq;
    }

    @Override
    public String toString() {
        return "Sys_adminMaquina{" + "id=" + id + ", idSys=" + idSys + ", idMaq=" + idMaq + ", obs=" + obs + '}';
    }

    
}
