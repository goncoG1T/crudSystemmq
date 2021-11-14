/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.view.maq;

import systemmq.controller.ControllerMaquina;
import systemmq.model.bean.Maquina;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterMaquina {
    
    public static void montarTela() throws SQLException, ClassNotFoundException {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR, 2 - BUSCAR, 3 - LISTAR, 4 - ALTERAR, 5 - EXCLUIR"));
        if (ops == 1) inserir();
        if (ops == 2) buscar();
        if (ops == 3) listar();
        if (ops == 4) alterar();
        if (ops == 5) excluir();
    }

    static void inserir() throws SQLException, ClassNotFoundException {
        String modelo = JOptionPane.showInputDialog("MODELO");
        String os = JOptionPane.showInputDialog("OS");
        String ano = JOptionPane.showInputDialog("ANO");
        Maquina maqEntrada = new Maquina(0, modelo, os, ano);
        ControllerMaquina contMaq = new ControllerMaquina();
        Maquina maqSaida = contMaq.inserir(maqEntrada);
        JOptionPane.showMessageDialog(null,"Maquina = " + maqSaida.toString());
    }

    static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Maquina maqEntrada = new Maquina(id);
        ControllerMaquina contMaq = new ControllerMaquina();
        Maquina maqSaida = contMaq.buscar(maqEntrada);
        JOptionPane.showMessageDialog(null,"Maquina = " + maqSaida.toString());
    }

    static void listar() throws SQLException, ClassNotFoundException {
        //String modelo = JOptionPane.showInputDialog("MODELO");
        //Maquina maqEntrada = new Maquina(modelo);
        String modelo = JOptionPane.showInputDialog("MODELO");
        Maquina maqEntrada = new Maquina (modelo);
        ControllerMaquina contMaq = new ControllerMaquina();
        List<Maquina> listaMaq = contMaq.listar(maqEntrada);
        listaMaq.forEach((maqL) -> {
            JOptionPane.showMessageDialog(null,maqL.toString());
        });
    }
    
    static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String modelo = JOptionPane.showInputDialog("MODELO");
        String os = JOptionPane.showInputDialog("OS");
        String ano = JOptionPane.showInputDialog("ANO");
        Maquina maqEntrada = new Maquina(id, modelo, os, ano);
        ControllerMaquina contMaq = new ControllerMaquina();
        Maquina maqSaida = contMaq.alterar(maqEntrada);
        JOptionPane.showMessageDialog(null,"Maquina = " + maqSaida.toString());
    }

    static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Maquina maqEntrada = new Maquina(id);
        ControllerMaquina contMaq = new ControllerMaquina();
        Maquina sysSaida = contMaq.excluir(maqEntrada);
        JOptionPane.showMessageDialog(null,"Maquina = " + sysSaida.toString());
    }
    
    
}
