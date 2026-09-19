package dao;

import model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDAO {
    private static List<Book> libros = new ArrayList<>();

    public void agregarLibro(Book book) {
        libros.add(book);
    }

    public List<Book> obtenerTodos() {
        return libros;
    }

    public List<Book> buscarLibros(String criterio) {
        if (criterio == null || criterio.trim().isEmpty()) {
            return libros;
        }
        String lowerCriterio = criterio.toLowerCase();
        // Filtra por nombre o autor
        return libros.stream()
                .filter(b -> b.getNombre().toLowerCase().contains(lowerCriterio) ||
                             b.getAutor().toLowerCase().contains(lowerCriterio))
                .collect(Collectors.toList());
    }
}