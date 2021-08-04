package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Jugador;
import modeloDAO.JugadorDAO;

/**
 * Servlet implementation class JugadorControlador
 */
@WebServlet(name = "JugadorControlador", urlPatterns = {"/JugadorControlador"})
public class JugadorControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JugadorControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter().append("Never give up!!!");
		
		JugadorDAO jugadorDao = new JugadorDAO();
		
        String accion;
        
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("vistas/jugadores.jsp");
        }else if(accion.equals("editar")){
            dispatcher = request.getRequestDispatcher("vistas/editar.jsp");
            
        }else if(accion.equals("actualizar")){
            int id = Integer.parseInt(request.getParameter("numId"));
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            int posicion = Integer.parseInt(request.getParameter("numPosicion"));
            String club = request.getParameter("txtClub");
            
            Jugador jugador = new Jugador(id,nombre,apellido,posicion,club);
            jugadorDao.editar(jugador);
            
            dispatcher = request.getRequestDispatcher("vistas/jugadores.jsp");
        }else if(accion.equals("eliminar")){
        
            int id = Integer.parseInt(request.getParameter("id"));
            jugadorDao.eliminar(id);
            
            dispatcher = request.getRequestDispatcher("vistas/jugadores.jsp");
        }else if(accion.equals("nuevo")){
            dispatcher = request.getRequestDispatcher("vistas/agregar.jsp");
        }else if(accion.equals("agregar")){
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            int posicion = Integer.parseInt(request.getParameter("numPosicion"));
            String club = request.getParameter("txtClub");
            
            Jugador jugador = new Jugador(nombre,apellido,posicion,club);
            jugadorDao.agregar(jugador);
            
            dispatcher = request.getRequestDispatcher("vistas/jugadores.jsp");
        }else{
            dispatcher = request.getRequestDispatcher("vistas/jugadores.jsp");
        }
        dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
