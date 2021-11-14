/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq;

import systemmq.view.usuario.ManterUsuario;
import systemmq.view.sys_admin.ManterSys_admin;
import systemmq.view.sys_adminmaquina.ManterSys_adminMaquina;
import systemmq.view.maq.ManterMaquina;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SYSTEMMQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        boolean retorno = ManterUsuario.validaUsuario();
        
        if(retorno) {
            int ops = Integer.parseInt(JOptionPane.showInputDialog("SYS_ADMIN = 1, MAQUINA = 2, SYS_ADMINMAQUINA = 3, USUARIO = 4"));
            if(ops == 1 ) ManterSys_admin.montarTela();
            if(ops == 2 ) ManterMaquina.montarTela();
            if(ops == 3 ) ManterSys_adminMaquina.montarTela();
            if(ops == 4 ) ManterUsuario.montarTela();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario invalido");
        }
    }
}
