/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.model.dao;

import systemmq.model.bean.Sys_admin;
import systemmq.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Sys_adminDao {
    
    private final Connection c;
   
    public Sys_adminDao() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }

    public Sys_admin inserir (Sys_admin p) throws SQLException {
        
        String sql = "insert into sys_admin" + " (sys_nome,sys_idade)" + " values (?,?)";

        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getIdade());
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                p.setId(id);
            }
        }
        c.close();
        return p;
    }
    
    public Sys_admin buscar (Sys_admin p) throws SQLException {
        String sql = "select * from sys_admin WHERE sys_id = ?";
        Sys_admin retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,p.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            while (rs.next()) {
                // criando o objeto Usuario
                retorno = new Sys_admin(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                // adiciona o usu à lista de pessoa
            }
        }
        c.close();
        return retorno;
    }

    public List<Sys_admin> listar (Sys_admin p) throws SQLException {
         // usus: array armazena a lista de registros
        List<Sys_admin> listaP = new ArrayList<>();
       
        String sql = "select * from sys_admin where sys_nome like ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"%" + p.getNome()+ "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                Sys_admin mSaida = new Sys_admin(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                        );
                // adiciona o usu à lista de usus
                listaP.add(mSaida);
            }
            
            rs.close();
        }
        return listaP;
    }

    public Sys_admin alterar (Sys_admin p) throws SQLException {
        String sql = "UPDATE sys_admin SET sys_nome = ?, sys_idade = ?, WHERE sys_id = ?";
        // seta os valores
        // prepared statement para inserção
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getIdade());
            stmt.setInt(3,p.getId());
            // executa
            stmt.execute();
        }
        return p;

    }

    public Sys_admin excluir (Sys_admin p) throws SQLException {
         String sql = "delete from sys_admin WHERE sys_id = ?";
        // seta os valores
        // prepared statement para inserção
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,p.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return p;
    }
}
