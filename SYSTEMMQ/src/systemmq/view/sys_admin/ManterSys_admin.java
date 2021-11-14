/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.view.sys_admin;

import systemmq.controller.ControllerSys_admin;
import systemmq.model.bean.Sys_admin;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterSys_admin {
    
    public static void montarTela() throws SQLException, ClassNotFoundException {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR, 2 - BUSCAR, 3 - LISTAR, 4 - ALTERAR, 5 - EXCLUIR"));
        if (ops == 1) inserir();
        if (ops == 2) buscar();
        if (ops == 3) listar();
        if (ops == 4) alterar();
        if (ops == 5) excluir();
    }
    
    static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        String idade = JOptionPane.showInputDialog("IDADE");
        Sys_admin sysEntrada = new Sys_admin(0, nome, idade);
        ControllerSys_admin contSys = new ControllerSys_admin();
        Sys_admin sysSaida = contSys.inserir(sysEntrada);
        JOptionPane.showMessageDialog(null,"Sys_admin = " + sysSaida.toString());
    }

    static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Sys_admin sysEntrada = new Sys_admin(id);
        ControllerSys_admin contSys = new ControllerSys_admin();
        Sys_admin sysSaida = contSys.buscar(sysEntrada);
        JOptionPane.showMessageDialog(null,"Sys_admin = " + sysSaida.toString());
    }

    static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Sys_admin sysEntrada = new Sys_admin(nome);
        ControllerSys_admin contSys = new ControllerSys_admin();
        List<Sys_admin> listaP = contSys.listar(sysEntrada);
        listaP.forEach((sysL) -> {
            JOptionPane.showMessageDialog(null,sysL.toString());
        });
    }
    
    static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String idade = JOptionPane.showInputDialog("IDADE");
        Sys_admin sysEntrada = new Sys_admin(id, nome, idade);
        ControllerSys_admin contSys = new ControllerSys_admin();
        Sys_admin sysSaida = contSys.alterar(sysEntrada);
        JOptionPane.showMessageDialog(null,"Sys_admin = " + sysSaida.toString());
    }

    static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Sys_admin sysEntrada = new Sys_admin(id);
        ControllerSys_admin contSys = new ControllerSys_admin();
        Sys_admin sysSaida = contSys.excluir(sysEntrada);
        JOptionPane.showMessageDialog(null,"Sys_admin = " + sysSaida.toString());
    }

}
