package com.bean;

import java.util.HashMap;

public class Subject {
    private  HashMap<String,Integer> physics;
    private  HashMap<String,Integer> maths;
    private  HashMap<String,Integer> chemistry;


    public HashMap<String, Integer> getPhysics() {
        return physics;
    }

    public void setPhysics(HashMap<String, Integer> physics) {
        this.physics = physics;
    }

    public HashMap<String, Integer> getMaths() {
        return maths;
    }

    public void setMaths(HashMap<String, Integer> maths) {
        this.maths = maths;
    }

    public HashMap<String, Integer> getChemistry() {
        return chemistry;
    }

    public void setChemistry(HashMap<String, Integer> chemistry) {
        this.chemistry = chemistry;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "physics=" + physics +
                ", maths=" + maths +
                ", chemistry=" + chemistry +
                '}';
    }
}
