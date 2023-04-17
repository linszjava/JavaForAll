package com.lin.senior.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @program: javase
 * @description: TreeSet 类的使用
 * @author: linsz
 * @create: 2022-06-08 22:39
 **/
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
//                    User user1 = (User) o1;
//                    User user2 = (User) o2;
                    if (((User) o1).getId() == ((User) o2).getId()) {
                        return ((User) o1).getName().compareTo(((User) o2).getName());
                    } else {
                        return Integer.compare(((User) o1).getId(), ((User) o2).getId());
                    }
                }
                throw new RuntimeException("输入不合法");
            }
        });

        treeSet.add(new User(1, "刘备"));
        treeSet.add(new User(4, "关羽"));
        treeSet.add(new User(6, "曹操"));
        treeSet.add(new User(-1, "项羽"));
        treeSet.add(new User(1, "马超"));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        // System.out.println(treeSet.toString());


    }

}

class User {
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
