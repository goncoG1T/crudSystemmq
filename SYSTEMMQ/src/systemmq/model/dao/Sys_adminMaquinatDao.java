/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.model.dao;

import systemmq.model.bean.Sys_adminMaquina;
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
public class Sys_adminMaquinatDao {
    
    private final Connection c;
   
    public Sys_adminMaquinatDao() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }

    public Sys_adminMaquina inserir (Sys_adminMaquina p) throws SQLException {
        
        String sql = "insert into sysmq_sysmq" + " (sysmq_idSys,sysmq_idMaq,sysmq_obs)" + " values (?,?,?)";

        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setInt(1,p.getIdSys());
            stmt.setInt(2,p.getIdMaq());
            stmt.setString(3,p.getObs());
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
    
    public Sys_adminMaquina buscar (Sys_adminMaquina p) throws SQLException {
        String sql = "select * from sysmq_sysmq WHERE sysmq_id = ?";
        Sys_adminMaquina retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,p.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            while (rs.next()) {
                // criando o objeto Usuario
                retorno = new Sys_adminMaquina(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4));
                // adiciona o usu à lista de pessoa
            }
        }
        c.close();
        return retorno;
    }

    public List<Sys_adminMaquina> listar (Sys_adminMaquina p) throws SQLException {
         // usus: array armazena a lista de registros
        List<Sys_adminMaquina> listaP = new ArrayList<>();
       
        String sql = "select * from sysmq_sysmq where sysmq_obs like ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"%" + p.getObs()+ "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                Sys_adminMaquina mSaida = new Sys_adminMaquina(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4));
                // adiciona o usu à lista de usus
                listaP.add(mSaida);
            }
            
            rs.close();
        }
        return listaP;
    }

    public Sys_adminMaquina alterar (Sys_adminMaquina p) throws SQLException {
        String sql = "UPDATE sysmq_sysmq SET sysmq_idSys = ?, sysmq_idMaq = ?, sysmq_obs = ? WHERE sysmq_id = ?";
        // seta os valores
        // prepared statement para inserção
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,p.getIdSys());
            stmt.setInt(2,p.getIdMaq());
            stmt.setString(3,p.getObs());
            stmt.setInt(4,p.getId());
            // executa
            stmt.execute();
        }
        return p;

    }

    public Sys_adminMaquina excluir (Sys_adminMaquina p) throws SQLException {
         String sql = "delete from sysmq_sysmq WHERE sysmq_id = ?";
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
