/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.ModelProduto;
import conexao.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author jhoua
 */
public class DAOProduto extends ConexaoMySql{
    
    public int salvarProdutoDAO(ModelProduto pModelProduto){
        
        try{
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produto("
                    + "pro_nome,"
                    + "pro_valor_custo, "
                    + "pro_valor_venda, "
                    + "pro_estoque)"
                    + " VALUES "
                    + "('"+ pModelProduto.getNome()+"', "
                    + "'"+ pModelProduto.getValorCusto()+"', "
                    + "'"+ pModelProduto.getValorVenda()+"', "
                    + "'"+ pModelProduto.getEstoque()+"')"
                    );
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }finally{
            this.fecharConexao();
        }
        
    }
    
    public ArrayList<ModelProduto> retornarProdutosDAO(){
        ModelProduto modelProduto = new ModelProduto();
        ArrayList<ModelProduto> listaModelProduto = new ArrayList<>();
        
        try{
            this.conectar();
            this.executarSQL("SELECT pro_id, pro_nome, pro_valor_custo,"
                    + " pro_valor_venda, pro_estoque FROM tbl_produto");
            
            while(this.getResultSet().next()){
                modelProduto = new ModelProduto();
                modelProduto.setId(this.getResultSet().getInt("pro_id"));
                modelProduto.setNome(this.getResultSet().getString("pro_nome"));
                modelProduto.setValorCusto(this.getResultSet().getBigDecimal("pro_valor_custo"));
                modelProduto.setValorVenda(this.getResultSet().getBigDecimal("pro_valor_venda"));
                modelProduto.setEstoque(this.getResultSet().getInt("pro_estoque"));
                listaModelProduto.add(modelProduto);
            }
            
        }catch(Exception e){
            System.err.println(e);
        }finally{
            this.fecharConexao();
        }
        return listaModelProduto;
        
    }

    public boolean excluirProdutosDAO(int codigo) {
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_produto WHERE pro_id ="
                    + " '"+codigo+"'");
        }catch(Exception e){
            System.err.println(e);
            return false;
        }finally{
            this.fecharConexao();
        }
        
    }

    public boolean alterarProdutoDAO(ModelProduto pModelProduto) {
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_produto SET"
                    +" pro_nome = '"+pModelProduto.getNome()+"', "
                    +" pro_valor_custo = '"+pModelProduto.getValorCusto()+"',"
                    +" pro_valor_venda = '"+pModelProduto.getValorVenda()+"',"
                    +" pro_estoque = '"+pModelProduto.getEstoque()+"'"
                    +" WHERE pro_id = '"+pModelProduto.getId()+"'");
        }catch(Exception e){
            System.err.println(e);
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    public ModelProduto getProdutoNomeDAO(String pNome) {
        ModelProduto modelProduto = new ModelProduto(); 
        try{
            this.conectar();
            this.executarSQL("SELECT pro_id, pro_nome, pro_valor_custo,"
                    + " pro_valor_venda, pro_estoque FROM tbl_produto"
                    + " WHERE pro_nome = '"+pNome+"'");
            
            while(this.getResultSet().next()){
                modelProduto = new ModelProduto();
                modelProduto.setId(this.getResultSet().getInt("pro_id"));
                modelProduto.setNome(this.getResultSet().getString("pro_nome"));
                modelProduto.setValorCusto(this.getResultSet().getBigDecimal("pro_valor_custo"));
                modelProduto.setValorVenda(this.getResultSet().getBigDecimal("pro_valor_venda"));
                modelProduto.setEstoque(this.getResultSet().getInt("pro_estoque"));
        }
            
        }catch(Exception e){
            System.err.println(e);
        }finally{
            this.fecharConexao();
        }
        return modelProduto;
        
    }
}
