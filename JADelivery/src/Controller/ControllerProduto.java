/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelProduto;
import DAO.DAOProduto;

/**
 *
 * @author jhoua
 */
public class ControllerProduto {
    DAOProduto daoProduto = new DAOProduto();
    public int salvarProdutoController(ModelProduto pModelProduto) {
        return this.daoProduto.salvarProdutoDAO(pModelProduto);
    }
    
}
