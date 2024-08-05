package MVC.reposiotry;

import java.util.List;

public interface IRepository <T>{
    List<T> findAll();
    List<T> searchName(String name);
    T findById(int id);
    void add(T t);
    void delete(int id);
}
