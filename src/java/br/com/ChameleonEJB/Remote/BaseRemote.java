package br.com.ChameleonEJB.Remote;

import javax.ejb.Remote;

@Remote
public interface BaseRemote<T> {

    void add(T obj);

    T update(T obj);

    T getById(Long id);    
}
