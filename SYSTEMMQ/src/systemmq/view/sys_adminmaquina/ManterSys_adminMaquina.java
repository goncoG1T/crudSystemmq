/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.view.sys_adminmaquina;

import systemmq.controller.ControllerSys_adminMaquina;
import systemmq.model.bean.Sys_adminMaquina;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterSys_adminMaquina {
    
    public static void montarTela() throws SQLException, ClassNotFoundException {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR, 2 - BUSCAR, 3 - LISTAR, 4 - ALTERAR, 5 - EXCLUIR"));
        if (ops == 1) inserir();
        if (ops == 2) buscar();
        if (ops == 3) listar();
        if (ops == 4) alterar();
        if (ops == 5) excluir();
    }

    static void inserir() throws SQLException, ClassNotFoundException {
        int idSys = Integer.parseInt(JOptionPane.showInputDialog("IDSYS"));
        int idMaq = Integer.parseInt(JOptionPane.showInputDialog("IDMAQ"));
        String obs = JOptionPane.showInputDialog("OBS");
        Sys_adminMaquina sysmqEntrada = new Sys_adminMaquina(0, idSys, idMaq, obs);
        ControllerSys_adminMaquina contMaq = new ControllerSys_adminMaquina();
        Sys_adminMaquina sysmqSaida = contMaq.inserir(sysmqEntrada);
        JOptionPane.showMessageDialog(null,"SystemMq = " + sysmqSaida.toString());
    }

    static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Sys_adminMaquina maqEntrada = new Sys_adminMaquina(id);
        ControllerSys_adminMaquina contMaq = new ControllerSys_adminMaquina();
        Sys_adminMaquina maqSaida = contMaq.buscar(maqEntrada);
        JOptionPane.showMessageDialog(null,"SystemMq  = " + maqSaida.toString());
    }

    static void listar() throws SQLException, ClassNotFoundException {
        String modelo = JOptionPane.showInputDialog("OBS");
        Sys_adminMaquina maqEntrada = new Sys_adminMaquina(modelo);
        ControllerSys_adminMaquina contMaq = new ControllerSys_adminMaquina();
        List<Sys_adminMaquina> listaMaq = contMaq.listar(maqEntrada);
        listaMaq.forEach((maqL) -> {
            JOptionPane.showMessageDialog(null, maqL.toString() + " PESSOA " + maqL.getSys().getNome() + " Maquina" + maqL.getMaq().getModelo());
        });
    }
    
    static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idSys = Integer.parseInt(JOptionPane.showInputDialog("IDSYS"));
        int idMaq = Integer.parseInt(JOptionPane.showInputDialog("IDMAQ"));
        String obs = JOptionPane.showInputDialog("OBS");
        Sys_adminMaquina sysmqEntrada = new Sys_adminMaquina(id, idSys, idMaq, obs);
        ControllerSys_adminMaquina contMaq = new ControllerSys_adminMaquina();
        Sys_adminMaquina sysmqSaida = contMaq.alterar(sysmqEntrada);
        JOptionPane.showMessageDialog(null,"SystemMq = " + sysmqSaida.toString());
    }

    static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Sys_adminMaquina sysEntrada = new Sys_adminMaquina(id);
        ControllerSys_adminMaquina contMaq = new ControllerSys_adminMaquina();
        Sys_adminMaquina sysSaida = contMaq.excluir(sysEntrada);
        JOptionPane.showMessageDialog(null,"SystemMq = " + sysSaida.toString());
    }
    
}