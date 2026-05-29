package dao;

import java.util.List;

public interface DAO<T> {
    void inserir(T obj);
    List<T> listarTodos();
    void atualizar(T obj);
    void deletar(String id);
    void deletarPorInt(int id);
    T buscarPorString(String id);
}