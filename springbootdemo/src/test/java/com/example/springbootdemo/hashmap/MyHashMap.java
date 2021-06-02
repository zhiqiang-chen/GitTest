package com.example.springbootdemo.hashmap;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Objects;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/1 15:38
 */
@SpringBootTest
@Ignore
public class MyHashMap {
    private String dd;

    public MyHashMap() {
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashMap myHashMap = (MyHashMap) o;
        return Objects.equals(dd, myHashMap.dd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dd);
    }

    public void test(){
        HashMap hashMap = new HashMap();
    }
    public static void main(String[] args) {
        System.out.println("1111");
    }
}
