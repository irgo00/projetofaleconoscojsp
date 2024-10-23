package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.CategoriaDAO;
import br.edu.ifpr.irati.model.Categoria;

import java.util.List;

public class CategoriaService {

    private CategoriaDAO categoriaDAO;

    public CategoriaService() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public List<Categoria> buscarTodos(){
        return categoriaDAO.buscarTodos();
    }

    public void salvar(Categoria categoria){
        categoriaDAO.salvar(categoria);
    }

}
