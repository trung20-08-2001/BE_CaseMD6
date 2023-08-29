package com.be.service;

import com.be.model.Account;

import java.util.List;

public interface ICrudService <E>{
    List<E> getAll();
    void save(E e);
    void edit(E e);
    void  delete(int id);
    Account findById(int id);
}
