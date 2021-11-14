/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.model.dao;

import systemmq.model.bean.Maquina;
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
public class MaquinaDao {
    
    private final Connection c;
   
    public MaquinaDao() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }

    public Maquina inserir (Maquina p) throws SQLException {
        
        String sql = "insert into maq_maquina" + " (maq_modelo,maq_os,maq_ano)" + " values (?,?,?)";

        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,p.getModelo());
            stmt.setString(2,p.getOs());
            stmt.setString(3,p.getAno());
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
    
    public Maquina buscar (Maquina p) throws SQLException {
        String sql = "select * from maq_maquina WHERE maq_id = ?";
        Maquina retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,p.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            while (rs.next()) {
                // criando o objeto Usuario
                retorno = new Maquina(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                // adiciona o usu à lista de pessoa
            }
        }
        c.close();
        return retorno;
    }

    public List<Maquina> listar (Maquina p) throws SQLException {
         // usus: array armazena a lista de registros
        List<Maquina> listaP = new ArrayList<>();
       
        String sql = "select * from maq_maquina where maq_modelo like ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"%" + p.getModelo()+ "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                Maquina mSaida = new Maquina(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                // adiciona o usu à lista de usus
                listaP.add(mSaida);
            }
            
            rs.close();
        }
        return listaP;
    }

    public Maquina alterar (Maquina p) throws SQLException {
        String sql = "UPDATE maq_maquina SET maq_modelo = ?, maq_os = ?, maq_ano = ?, WHERE maq_id = ?";
        // seta os valores
        // prepared statement para inserção
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,p.getModelo());
            stmt.setString(2,p.getOs());
            stmt.setString(3,p.getAno());
            stmt.setInt(4,p.getId());
            // executa
            stmt.execute();
        }
        return p;

    }

    public Maquina excluir (Maquina p) throws SQLException {
         String sql = "delete from maq_maquina WHERE maq_id = ?";
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
