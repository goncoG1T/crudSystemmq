/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.controller;

import systemmq.model.bean.Sys_admin;
import systemmq.model.dao.Sys_adminDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerSys_admin {

    static Sys_adminDao sys_adminDao;
    
    public Sys_admin inserir (Sys_admin p) throws SQLException, ClassNotFoundException {
        sys_adminDao = new Sys_adminDao();
        return sys_adminDao.inserir(p);
    }
    
    public Sys_admin buscar (Sys_admin p) throws SQLException, ClassNotFoundException {
        sys_adminDao = new Sys_adminDao();
        return sys_adminDao.buscar(p);
    }

    public List<Sys_admin> listar (Sys_admin p) throws SQLException, ClassNotFoundException {
        sys_adminDao = new Sys_adminDao();
        return sys_adminDao.listar(p);
    }

    public Sys_admin alterar (Sys_admin p) throws SQLException, ClassNotFoundException {
        sys_adminDao = new Sys_adminDao();
        return sys_adminDao.alterar(p);
    }

    public Sys_admin excluir (Sys_admin p) throws SQLException, ClassNotFoundException {
        sys_adminDao = new Sys_adminDao();
        return sys_adminDao.excluir(p);
    }

}
