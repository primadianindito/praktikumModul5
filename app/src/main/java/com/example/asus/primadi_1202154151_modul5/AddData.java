package com.example.asus.primadi_1202154151_modul5;

/**
 * Created by Asus on 3/25/2018.
 */

public class AddData {
    //deklarasi variable
    String todo, desc, prior;

    //konstruktor
    public AddData(String todo, String deskripsi, String priority){
        this.todo=todo;
        this.desc=deskripsi;
        this.prior=priority;
    }
    //method setter dan getter untuk to do , description dan priority
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrior() {
        return prior;
    }

    public void setPrior(String prior) {
        this.prior = prior;
    }
}
