package com.example.examenud2.servlet;

import com.example.examenud2.model.Partido;
import jakarta.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class UtilServlet {
    public static Optional<Partido> validarPartido(HttpServletRequest request) {

        //CÓDIGO DE VALIDACIÓN
        boolean valida = true;
        int partidoID = -1;
        Date fecha = null;
        String equipo1 = null;
        int puntos_equipo1 = -1;
        String equipo2 = null;
        int puntos_equipo2 = -1;
        String tipo_partido = null;
        java.sql.Date sqlDate = null;


        try {
            Objects.requireNonNull(request.getParameter("equipo1"));
            if (request.getParameter("equipo1").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            equipo1 = request.getParameter("equipo1");
            puntos_equipo1 = parseInt(request.getParameter("puntos_equipo1"));


            Objects.requireNonNull(request.getParameter("equipo2"));
            if (request.getParameter("equipo2").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            equipo2 = request.getParameter("equipo2");
            puntos_equipo2 = parseInt(request.getParameter("puntos_equipo2"));

            if(request.getParameter("partidoID") != null){
                partidoID = parseInt(request.getParameter("partidoID"));
            }

            Objects.requireNonNull(request.getParameter("tipo_partido"));
            if (request.getParameter("tipo_partido").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            tipo_partido = request.getParameter("tipo_partido");

            Objects.requireNonNull(request.getParameter("fecha"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaFormateada = format.parse(request.getParameter("fecha"));
            sqlDate = new java.sql.Date(fechaFormateada.getTime());
            return Optional.of(new Partido(partidoID, fechaFormateada, equipo1, puntos_equipo1, equipo2, puntos_equipo2, tipo_partido));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();

    }
}
