package controller;

import dao.BookDAO;
import model.Book;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String criterio = request.getParameter("criterio");

        List<Book> listaLibros;
        if ("buscar".equals(accion) && criterio != null) {
            listaLibros = bookDAO.buscarLibros(criterio);
        } else {
            listaLibros = bookDAO.obtenerTodos();
        }

        // Envía la lista a la vista JSP
        request.setAttribute("libros", listaLibros);
        request.getRequestDispatcher("/WEB-INF/views/libreria.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String autor = request.getParameter("autor");
        double precio = Double.parseDouble(request.getParameter("precio"));

        Book nuevoLibro = new Book(nombre, autor, precio);
        bookDAO.agregarLibro(nuevoLibro);

        // Redirige al GET para actualizar y mostrar la tabla
        response.sendRedirect("BookServlet"); 
    }
}