/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelCliente;

import conexao.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author jhoua
 */
public class DAOCliente extends ConexaoMySql{
     public int salvarClienteDAO(ModelCliente pModelCliente){
        
        try{
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_cliente("
                    + "cli_telefone,"
                    + "cli_nome, "
                    + "cli_cpf_cnpj, "
                    + "cli_email, "
                    + "cli_observacao, "
                    + "cli_endereco, "
                    + "cli_numero, "
                    + "cli_complemento, "
                    + "cli_bairro, "
                    + "cli_cidade, "
                    + "cli_cep, "
                    + "cli_taxa_de_entrega)"
                    + " VALUES "
                    + "('"
                    + pModelCliente.getTelefone()+"', "
                    + "'"+pModelCliente.getNome()+"', "
                    + "'"+pModelCliente.getCpfCnpj()+"', "
                    + "'"+pModelCliente.getEmail()+"', "
                    + "'"+pModelCliente.getObs()+"', "
                    + "'"+pModelCliente.getEndereco()+"', "
                    + "'"+pModelCliente.getNumero()+"', "
                    + "'"+pModelCliente.getComplemento()+"', "
                    + "'"+pModelCliente.getBairro()+"', "
                    + "'"+pModelCliente.getCidade()+"', "
                    + "'"+pModelCliente.getCep()+"', "
                    + "'"+pModelCliente.getTxe()
                    + "')"
                    );
        }catch(Exception e){
            System.err.println(e);
            return 0;
        }finally{
            this.fecharConexao();
        }
        
    }
    
    public ArrayList<ModelCliente> retornarClientesDAO(){
        ModelCliente modelCliente = new ModelCliente();
        ArrayList<ModelCliente> listaModelCliente = new ArrayList<>();
        
        try{
            this.conectar();
            this.executarSQL("SELECT cli_id, cli_telefone, cli_nome, cli_cpf_cnpj, "
                    + "cli_email, cli_observacao, cli_endereco, cli_numero, "
                    + "cli_complemento, cli_bairro, cli_cidade, cli_cep, "
                    + "cli_taxa_de_entrega FROM tbl_cliente");
            
            while(this.getResultSet().next()){
                modelCliente = new ModelCliente();
                modelCliente.setCod(this.getResultSet().getInt("cli_id"));
                modelCliente.setTelefone(this.getResultSet().getString("cli_telefone"));
                modelCliente.setNome(this.getResultSet().getString("cli_nome"));
                modelCliente.setCpfCnpj(this.getResultSet().getString("cli_cpf_cnpj"));
                modelCliente.setEmail(this.getResultSet().getString("cli_email"));
                modelCliente.setObs(this.getResultSet().getString("cli_observacao"));
                modelCliente.setEndereco(this.getResultSet().getString("cli_endereco"));
                modelCliente.setComplemento(this.getResultSet().getString("cli_complemento"));
                modelCliente.setBairro(this.getResultSet().getString("cli_bairro"));
                modelCliente.setCidade(this.getResultSet().getString("cli_cidade"));
                modelCliente.setCep(this.getResultSet().getString("cli_cep"));
                modelCliente.setTxe(this.getResultSet().getBigDecimal("cli_taxa_de_entrega"));
                listaModelCliente.add(modelCliente);
            }
            
        }catch(Exception e){
            System.err.println(e);
        }finally{
            this.fecharConexao();
        }
        return listaModelCliente;
        
    }

    public boolean excluirClienteDAO(int codigo) {
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_cliente WHERE cli_id ="
                    + " '"+codigo+"'");
        }catch(Exception e){
            System.err.println(e);
            return false;
        }finally{
            this.fecharConexao();
        }
        
    }

    public boolean alterarClienteDAO(ModelCliente pModelCliente) {
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_produto SET"
                    +" cli_telefone = '"+pModelCliente.getTelefone()+"', "
                    +" cli_nome = '"+pModelCliente.getNome()+"',"
                    +" cli_cpf_cnpj = '"+pModelCliente.getCpfCnpj()+"',"
                    +" cli_email = '"+pModelCliente.getEmail()+"', "
                    +" cli_observacao = '"+pModelCliente.getObs()+"', "
                    +" cli_endereco = '"+pModelCliente.getEndereco()+"', "
                    +" cli_numero = '"+pModelCliente.getNumero()+"', "
                    +" cli_complemento = '"+pModelCliente.getComplemento()+"', "
                    +" cli_bairro = '"+pModelCliente.getBairro()+"', "
                    +" cli_cidade = '"+pModelCliente.getCidade()+"', "
                    +" cli_cep = '"+pModelCliente.getCep()+"', "
                    +" cli_taxa_de_entrega = '"+pModelCliente.getTxe()
                    +" WHERE cli_id = '"+pModelCliente.getCod()+"'");
        }catch(Exception e){
            System.err.println(e);
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    public ModelCliente retornarClienteDAO(int cod){
        ModelCliente modelCliente = new ModelCliente();
        
        
        try{
            this.conectar();
            this.executarSQL("SELECT cli_id, cli_telefone, cli_nome, cli_cpf_cnpj, "
                    + "cli_email, cli_observacao, cli_endereco, cli_numero, "
                    + "cli_complemento, cli_bairro, cli_cidade, cli_cep, "
                    + "cli_taxa_de_entrega FROM tbl_cliente WHERE cli_id = '"
                    +cod+"'");
            
            while(this.getResultSet().next()){
                modelCliente = new ModelCliente();
                modelCliente.setCod(this.getResultSet().getInt("cli_id"));
                modelCliente.setTelefone(this.getResultSet().getString("cli_telefone"));
                modelCliente.setNome(this.getResultSet().getString("cli_nome"));
                modelCliente.setCpfCnpj(this.getResultSet().getString("cli_cpf_cnpj"));
                modelCliente.setEmail(this.getResultSet().getString("cli_email"));
                modelCliente.setObs(this.getResultSet().getString("cli_observacao"));
                modelCliente.setEndereco(this.getResultSet().getString("cli_endereco"));
                modelCliente.setComplemento(this.getResultSet().getString("cli_complemento"));
                modelCliente.setBairro(this.getResultSet().getString("cli_bairro"));
                modelCliente.setCidade(this.getResultSet().getString("cli_cidade"));
                modelCliente.setCep(this.getResultSet().getString("cli_cep"));
                modelCliente.setTxe(this.getResultSet().getBigDecimal("cli_taxa_de_entrega"));
                
            }
            
        }catch(Exception e){
            System.err.println(e);
        }finally{
            this.fecharConexao();
        }
        return  modelCliente;
        
    }
    
}
