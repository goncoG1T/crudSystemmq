/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.controller;

import systemmq.model.bean.Maquina;
import systemmq.model.dao.MaquinaDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerMaquina {

    static MaquinaDao maquinaDao;
    
    public Maquina inserir (Maquina p) throws SQLException, ClassNotFoundException {
        maquinaDao = new MaquinaDao();
        return maquinaDao.inserir(p);
    }
    
    public Maquina buscar (Maquina p) throws SQLException, ClassNotFoundException {
        maquinaDao = new MaquinaDao();
        return maquinaDao.buscar(p);
    }

    public List<Maquina> listar (Maquina p) throws SQLException, ClassNotFoundException {
        maquinaDao = new MaquinaDao();
        return maquinaDao.listar(p);
    }

    public Maquina alterar (Maquina p) throws SQLException, ClassNotFoundException {
        maquinaDao = new MaquinaDao();
        return maquinaDao.alterar(p);
    }

    public Maquina excluir (Maquina p) throws SQLException, ClassNotFoundException {
        maquinaDao = new MaquinaDao();
        return maquinaDao.excluir(p);
    }

    
}
