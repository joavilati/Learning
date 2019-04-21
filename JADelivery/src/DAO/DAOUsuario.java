/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.ModelUsuario;
import java.util.ArrayList;
import conexao.ConexaoMySql;
/**
 *
 * @author jhoua
 */
public class DAOUsuario  extends ConexaoMySql {
    ModelUsuario modelUsuario = new ModelUsuario();
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario){
        
        try{
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_usuario("
                    + "usu_nome,"
                    + "usu_login, "
                    + "usu_senha)"
                    + " VALUES "
                    + "('"+ pModelUsuario.getNome()+"', "
                    + "'"+ pModelUsuario.getLogin()+"', "
                    + "'"+ pModelUsuario.getSenha()+"')"
                    );
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }finally{
            this.fecharConexao();
        }
        
    }
    
    public ArrayList<ModelUsuario> retornarUsuariosDAO(){
        ModelUsuario modelProduto = new ModelUsuario();
        ArrayList<ModelUsuario> listaModelUsuario = new ArrayList<>();
        
        try{
            this.conectar();
            this.executarSQL("SELECT usu_id, usu_nome, usu_login,"
                    + " usu_senha FROM tbl_usuario");
            
            while(this.getResultSet().next()){
                modelUsuario = new ModelUsuario();
                modelUsuario.setId(this.getResultSet().getInt("usu_id"));
                modelUsuario.setNome(this.getResultSet().getString("usu_nome"));
                modelUsuario.setLogin(this.getResultSet().getString("usu_login"));
                modelUsuario.setSenha(this.getResultSet().getString("usu_senha"));
                listaModelUsuario.add(modelUsuario);
            }
            
        }catch(Exception e){
            System.err.println(e);
        }finally{
            this.fecharConexao();
        }
        return listaModelUsuario;
        
    }

    public boolean excluirUsuarioDAO(int codigo) {
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_usuario WHERE usu_id ="
                    + " '"+codigo+"'");
        }catch(Exception e){
            System.err.println(e);
            return false;
        }finally{
            this.fecharConexao();
        }
        
    }

    public boolean alterarUsuarioDAO(ModelUsuario pModelUsuario ) {
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_usuario SET"
                    +" usu_nome = '"+pModelUsuario.getNome()+"', "
                    +" usu_login = '"+pModelUsuario.getUsuario()+"',"
                    +" usu_senha = '"+pModelUsuario.getLogin()+"'");
        }catch(Exception e){
            System.err.println(e);
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    public boolean retornarUsuarioDAO(ModelUsuario modelUsuario) {
        
        try{
            this.conectar();
            this.executarSQL("SELECT usu_id,"
                    + " usu_nome,"
                    + " usu_login,"
                    + " usu_senha"
                    + " FROM tbl_usuario WHERE usu_login = '"
                    +modelUsuario.getLogin() +"'"
                            + " AND usu_senha = '"
                            + modelUsuario.getSenha()+"';");
            
            if(getResultSet().next()){
                return true;
            }else{
                 return false;
                
            }
        }catch(Exception e){
            System.err.println(e);
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}
