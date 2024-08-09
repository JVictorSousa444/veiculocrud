package com.example.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ProprietarioDAO;
import com.example.model.Proprietario;

public class ProprietarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProprietarioDAO proprietarioDAO;

    @Override
    public void init() throws ServletException {
        proprietarioDAO = new ProprietarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch(action) {
                case "list":
                    listProprietarios(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteProprietario(request, response);
                    break;
                case "archive":
                case "reactivate":
                    break;
                default:
                    response.sendRedirect("listProprietarios.jsp");
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch(action) {
                case "add":
                    addProprietario(request, response);
                    break;
                case "update":
                    updateProprietario(request, response);
                    break;
                case "archive":
                case "reactivate":
                case "delete":
                    int id = Integer.parseInt(request.getParameter("id"));
                    if (action.equals("archive")) {
                        updateProprietarioStatus(id, false);  // Marca como inativo
                    } else if (action.equals("reactivate")) {
                        updateProprietarioStatus(id, true);  // Marca como ativo
                    } else if (action.equals("delete")) {
                        deleteProprietario(id);  // Exclusão lógica
                    }
                    break;
                default:
                    response.sendRedirect("listProprietarios.jsp");
                    break;
            }
            response.sendRedirect("proprietarios?action=list");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void addProprietario(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String cpfCnpj = request.getParameter("cpf_cnpj");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        boolean ativo = true;

        Proprietario novoProprietario = new Proprietario(0, cpfCnpj, nome, endereco, ativo);
        proprietarioDAO.insert(novoProprietario);
    }

    private void updateProprietario(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cpfCnpj = request.getParameter("cpf_cnpj");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        boolean ativo = request.getParameter("ativo") != null;

        Proprietario proprietario = new Proprietario(id, cpfCnpj, nome, endereco, ativo);
        proprietarioDAO.update(proprietario);
    }

    private void deleteProprietario(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        proprietarioDAO.delete(id);
    }

    private void deleteProprietario(int id) throws SQLException {
        updateProprietarioStatus(id, false);
    }

    private void updateProprietarioStatus(int id, boolean ativo) throws SQLException {
        Proprietario proprietario = new Proprietario(id, null, null, null, ativo);
        proprietarioDAO.updateStatus(proprietario);
    }
    
    private void listProprietarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String statusParam = request.getParameter("status");
        boolean ativo = (statusParam == null || statusParam.equals("ativos"));

        request.setAttribute("proprietarios", proprietarioDAO.listByStatus(ativo));
        request.setAttribute("statusFiltro", ativo ? "ativos" : "inativos");
        request.getRequestDispatcher("listProprietarios.jsp").forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Proprietario proprietario = proprietarioDAO.findById(id);
        request.setAttribute("proprietario", proprietario);
        request.getRequestDispatcher("editProprietario.jsp").forward(request, response);
    }
}
