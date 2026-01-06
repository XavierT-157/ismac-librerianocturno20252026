package com.distribuida.service;

import com.distribuida.dao.LibroRepository;
import com.distribuida.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findOne(int id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(int id, Libro libro) {
        Optional<Libro> libroExistente = libroRepository.findById(id);

        if (libroExistente == null) {
            return null;
        }

        libroExistente.orElse(null).setTitulo(libro.getTitulo());
        libroExistente.orElse(null).setEditorial(libro.getEditorial());
        libroExistente.orElse(null).setNumPaginas(libro.getNumPaginas());
        libroExistente.orElse(null).setEdicion(libro.getEdicion());
        libroExistente.orElse(null).setIdioma(libro.getIdioma());
        libroExistente.orElse(null).setFechaPublicacion(libro.getFechaPublicacion());
        libroExistente.orElse(null).setDescripcion(libro.getDescripcion());
        libroExistente.orElse(null).setTipoPasta(libro.getTipoPasta());
        libroExistente.orElse(null).setISBN(libro.getISBN());
        libroExistente.orElse(null).setNumEjemplares(libro.getNumEjemplares());
        libroExistente.orElse(null).setPortada(libro.getPortada());
        libroExistente.orElse(null).setPresentacion(libro.getPresentacion());
        libroExistente.orElse(null).setPrecio(libro.getPrecio());
        libroExistente.orElse(null).setAutor(libro.getAutor());
        libroExistente.orElse(null).setCategoria(libro.getCategoria());

        return libroRepository.save(libroExistente.orElse(null));
    }

    @Override
    public void delete(int id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
        }
    }
}
