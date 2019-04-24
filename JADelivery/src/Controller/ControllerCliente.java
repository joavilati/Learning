/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author jhoua
 */
import Model.ModelCliente;
import java.util.ArrayList;
import DAO.DAOCliente;
public class ControllerCliente {
    DAOCliente daoCliente = new DAOCliente();
    
    public int salvarClienteController(ModelCliente modelCliente) {
        return this.daoCliente.salvarClienteDAO(modelCliente);
    }

    public ArrayList<ModelCliente> retornarUsuariosController() {
       return this.daoCliente.retornarClientesDAO();
    }

    public boolean alterarClienteController(ModelCliente modelCliente) {
        return this.daoCliente.alterarClienteDAO(modelCliente);
    }

    public ModelCliente retornarClienteController(int codigo) {
        return this.daoCliente.retornarClienteDAO(codigo);
    }

    public boolean excluirClienteController(int codigo) {
        return this.daoCliente.excluirClienteDAO(codigo);
    }
    
}
