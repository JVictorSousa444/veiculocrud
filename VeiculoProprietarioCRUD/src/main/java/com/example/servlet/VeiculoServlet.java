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

        try {
            if ("list".equals(action)) {
                List<Veiculo> list = dao.getAllVeiculos();
                request.setAttribute("veiculos", list);
                request.getRequestDispatcher("/listVeiculos.jsp").forward(request, response);
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Veiculo v = dao.getVeiculo(id);
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
            throw new ServletException(e);
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
                dao.addVeiculo(v);
                response.sendRedirect("veiculos?action=list");
            } else if ("update".equals(action)) {
                Veiculo v = new Veiculo();
                v.setId(Integer.parseInt(request.getParameter("id")));
                v.setPlaca(request.getParameter("placa"));
                v.setRenavam(request.getParameter("renavam"));
                v.setIdProp(Integer.parseInt(request.getParameter("id_prop")));
                dao.updateVeiculo(v);
                response.sendRedirect("veiculos?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
