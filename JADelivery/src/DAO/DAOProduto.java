/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.ModelProduto;
import conexao.ConexaoMySql;

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
    
}
