package dao;

import java.util.List;

public interface DAO<T> {
    void inserir(T obj);
    List<T> listarTodos();
    void deletarPorString(String id);
    void deletarPorInt(int id);
}