package br.com.ChameleonEJB.Remote;

import javax.ejb.Remote;

@Remote
public interface BaseRemote<T> {

    public void add(T obj);

    public T update(T obj);

    public T getById(Long id);
}
