package com.claudioribeiro.clinicaodontologica.controller;

import java.util.List;

public interface BaseController<T> {
    List<T> getAll();
    T getById(Integer id);
    T create(T entity);
    T update(Integer id, T entity);
    void delete(Integer id);
}
