/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.view.usuario;

import systemmq.controller.ControllerUsuario;
import systemmq.model.bean.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterUsuario {

    public static void montarTela() throws SQLException, ClassNotFoundException  {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("INSERIR = 1, LISTAR = 2, BUSCAR = 3, ALTERAR = 4, EXCLUIR = 5"));
        if(ops == 1 ) inserir();
        if(ops == 2 ) listar();
        if(ops == 3 ) buscar();
        if(ops == 4 ) alterar();
        if(ops == 5 ) excluir();
    }

      public static boolean validaUsuario() throws SQLException, ClassNotFoundException  {
          boolean retorno = false;
          String login = JOptionPane.showInputDialog("LOGIN");
          String senha = JOptionPane.showInputDialog("SENHA");
          Usuario usuEntrada = new Usuario(login,senha);
          ControllerUsuario contUsu = new ControllerUsuario();
          Usuario usuSaida = contUsu.valida(usuEntrada);
          if(usuSaida != null) {
              retorno = true;
          }
          return retorno;
      }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"INSERIR USUARIO");
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Usuario usu = new Usuario(0,login,senha,status,tipo);
        ControllerUsuario contU = new ControllerUsuario();
        usu = contU.inserir(usu);
        JOptionPane.showMessageDialog(null,"USUARIO = " + usu.toString());
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"LISTAR USUARIO");
        String login = JOptionPane.showInputDialog("ENTRE COM O LOGIN");
        Usuario usu = new Usuario(login);
        ControllerUsuario contU = new ControllerUsuario();
        List<Usuario> listaU = contU.listar(usu);
        listaU.forEach((usuL) -> {
            JOptionPane.showMessageDialog(null,usuL.toString());
        });
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"BUSCAR USUARIO");
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
        Usuario usu = new Usuario(idUsu);
        ControllerUsuario contU = new ControllerUsuario();
        usu = contU.buscar(usu);
        JOptionPane.showMessageDialog(null,"USUARIO = " + usu.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"ALTERAR USUARIO");
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Usuario usu = new Usuario(idUsu,login,senha,status,tipo);
        ControllerUsuario contU = new ControllerUsuario();
        usu = contU.alterar(usu);
        JOptionPane.showMessageDialog(null,"USUARIO = " + usu.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"EXCLUIR USUARIO");
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
        Usuario usu = new Usuario(idUsu);
        ControllerUsuario contU = new ControllerUsuario();
        usu = contU.excluir(usu);
        JOptionPane.showMessageDialog(null,"USUARIO = " + usu.toString());

    }
}

