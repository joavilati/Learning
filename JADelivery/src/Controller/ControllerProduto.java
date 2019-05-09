/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelProduto;
import DAO.DAOProduto;
import java.util.ArrayList;

/**
 *
 * @author jhoua
 */
public class ControllerProduto {
    DAOProduto daoProduto = new DAOProduto();
    public int salvarProdutoController(ModelProduto pModelProduto) {
        return this.daoProduto.salvarProdutoDAO(pModelProduto);
    }

    public ArrayList<ModelProduto> retornarProdutoController() {
        DAOProduto daoProdutos = new DAOProduto();
        return this.daoProduto.retornarProdutosDAO();
    }

    public boolean excluirProdutoController(int codigo) {
        
        return this.daoProduto.excluirProdutosDAO(codigo);
    }

    public boolean alterarProdutoController(ModelProduto pModelProduto) {
        return this.daoProduto.alterarProdutoDAO(pModelProduto);
    }

    public ModelProduto getPodrutoNomeController(String pNome) {
        return this.daoProduto.getProdutoNomeDAO(pNome);
    }
    
}
