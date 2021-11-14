/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmq.model.bean;

/**
 *
 * @author User
 */
public class Sys_admin {
    
    private int id;
    private String nome;
    private String idade;
    

    public Sys_admin(int id) {
        this.id = id;
    }

    public Sys_admin(String nome) {
        this.nome = nome;
    }

    public Sys_admin(int id, String nome, String idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }



    @Override
    public String toString() {
        return "Sys_admin{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + '}';
    }
    
}
