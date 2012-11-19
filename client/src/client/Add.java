package client;

import server.Task;

import java.io.Serializable;

public class Add implements Task<Integer>,Serializable{

    public Integer execute() {
        System.out.println(new Test("abc").name);
        return 1+2;
    }
}
