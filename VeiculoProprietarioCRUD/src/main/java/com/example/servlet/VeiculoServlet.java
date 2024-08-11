package com.example.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.VeiculoDAO;
import com.example.model.Veiculo;

public class VeiculoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private VeiculoDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new VeiculoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String statusParam = request.getParameter("status");
        String placaParam = request.getParameter("placa");
        String renavamParam = request.getParameter("renavam");

        try {
            if ("list".equals(action) || action == null) {
                List<Veiculo> list;
                if (statusParam != null && !statusParam.isEmpty()) {
                    int status = Integer.parseInt(statusParam);
                    list = dao.getVeiculosByStatus(status);
                } else {
                    list = dao.searchVeiculos(placaParam, renavamParam);
                }
                request.setAttribute("veiculos", list);
                request.setAttribute("selectedStatus", statusParam);
                request.getRequestDispatcher("/listVeiculos.jsp").forward(request, response);
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Veiculo v = dao.getVeiculoById(id);
                request.setAttribute("veiculo", v);
                request.getRequestDispatcher("/editVeiculo.jsp").forward(request, response);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteVeiculo(id);
                response.sendRedirect("veiculos?action=list");
            } else {
                response.sendRedirect("veiculos?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException("Erro ao processar a solicitação", e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                Veiculo v = new Veiculo();
                v.setPlaca(request.getParameter("placa"));
                v.setRenavam(request.getParameter("renavam"));
                v.setIdProp(Integer.parseInt(request.getParameter("id_prop")));
                v.setIdStatus(Integer.parseInt(request.getParameter("id_status")));
                dao.addVeiculo(v);
                response.sendRedirect("veiculos?action=list");
            } else if ("update".equals(action)) {
                Veiculo v = new Veiculo();
                v.setId(Integer.parseInt(request.getParameter("id")));
                v.setPlaca(request.getParameter("placa"));
                v.setRenavam(request.getParameter("renavam"));
                v.setIdProp(Integer.parseInt(request.getParameter("id_prop")));
                v.setIdStatus(Integer.parseInt(request.getParameter("id_status")));
                dao.updateVeiculo(v);
                response.sendRedirect("veiculos?action=list");
            } else {
                response.sendRedirect("veiculos?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException("Erro ao processar a solicitação", e);
        }
    }
}
