/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOUsuario;
import Model.ModelUsuario;
import java.util.ArrayList;

/**
 *
 * @author jhoua
 */
public class ControllerUsuario {
    DAOUsuario daoUsuario = new DAOUsuario();
    public ArrayList<ModelUsuario> retornarUsuariosController() {
        return this.daoUsuario.retornarUsuariosDAO();
    }

    public int salvarUsuarioController(ModelUsuario pModelUsuario) {
        
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
        
    }

    public boolean excluirUsuarioController(int codigo) {
        return this.daoUsuario.excluirUsuarioDAO(codigo);
    }

    public boolean getUsuarioController(ModelUsuario modelUsuario) {
        return this.daoUsuario.retornarUsuarioDAO(modelUsuario);
    }
    
}
