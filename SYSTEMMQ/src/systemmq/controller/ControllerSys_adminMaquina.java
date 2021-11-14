/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.controller;

import systemmq.model.bean.Sys_admin;
import systemmq.model.bean.Sys_adminMaquina;
import systemmq.model.bean.Maquina;
import systemmq.model.dao.Sys_adminMaquinatDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerSys_adminMaquina {
    
    static Sys_adminMaquinatDao sysmqDao;
    static ControllerSys_admin cSys;
    static ControllerMaquina cMq;
    
    public Sys_adminMaquina inserir (Sys_adminMaquina p) throws SQLException, ClassNotFoundException {
        sysmqDao = new Sys_adminMaquinatDao();
        return sysmqDao.inserir(p);
    }
    
    public Sys_adminMaquina buscar (Sys_adminMaquina p) throws SQLException, ClassNotFoundException {
        sysmqDao = new Sys_adminMaquinatDao();
        return sysmqDao.buscar(p);
    }

    public List<Sys_adminMaquina> listar (Sys_adminMaquina p) throws SQLException, ClassNotFoundException {
        sysmqDao = new Sys_adminMaquinatDao();
        List<Sys_adminMaquina> listaPP = sysmqDao.listar(p);
        for (Sys_adminMaquina listaPP2 : listaPP) {
            ControllerSys_adminMaquina.cSys = new ControllerSys_admin();
            ControllerSys_adminMaquina.cMq = new ControllerMaquina();
            Sys_admin sysEntrada = new Sys_admin(listaPP2.getIdSys());
            Maquina maqEntrada = new Maquina(listaPP2.getIdMaq());
            Sys_admin sysSaida = cSys.buscar(sysEntrada);
            Maquina maqSaida = cMq.buscar(maqEntrada);
            listaPP2.setSys(sysSaida);
            listaPP2.setMaq(maqSaida);
        }
        return listaPP;
    }

    public Sys_adminMaquina alterar (Sys_adminMaquina p) throws SQLException, ClassNotFoundException {
        sysmqDao = new Sys_adminMaquinatDao();
        return sysmqDao.alterar(p);
    }

    public Sys_adminMaquina excluir (Sys_adminMaquina p) throws SQLException, ClassNotFoundException {
        sysmqDao = new Sys_adminMaquinatDao();
        return sysmqDao.excluir(p);
    }
   
}
