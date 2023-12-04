package com.example.examenud2.servlet;

import com.example.examenud2.dao.PartidoDAO;
import com.example.examenud2.dao.PartidoDAOImpl;
import com.example.examenud2.dao.AbstratDAOImpl;
import com.example.examenud2.model.Partido;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "GrabarPartidosServlet", value = "/GrabarPartidosServlet")
public class GrabarPartidosServlet extends HttpServlet {

    private PartidoDAO partidoDAO = new PartidoDAOImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/crear_partido.jsp");

        dispatcher.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;

        Optional<Partido> optionalPartido = UtilServlet.validarPartido(request);

        if (optionalPartido.isPresent()) {

            Partido partido = optionalPartido.get();

            this.partidoDAO.create(partido);

            List<Partido> listado = this.partidoDAO.getAll();

            request.setAttribute("listado", listado);

            request.setAttribute("newPartidoID", partido.getId());


                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoPartidosB.jsp");
        } else {


            request.setAttribute("error", "Error de validación!");

                    dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        }


        dispatcher.forward(request, response);

    }
}

