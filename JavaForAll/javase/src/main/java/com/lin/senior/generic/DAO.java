package com.lin.senior.generic;

import java.util.List;

/**
 * @program: javase
 * @description: 泛型在继承方面的体现
 * @author: linsz
 * @create: 2022-06-10 14:25
 **/
public class DAO<T> {

    public void insert(User user) {
    }

    public void add(User user) {
    }

    public void update(User user) {
    }

    public void delete(int id) {
    }

    public List<T> listAll(List<Integer> list) {

        return null;
    }
}

class User {

}
