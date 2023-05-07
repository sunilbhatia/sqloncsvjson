package dev.sunilb.entities;

public class Raw {
    public int getRawId() {
        return rawId;
    }

    private int rawId;

    public String[] getValues() {
        return values;
    }

    private String[] values;
    public Raw(int rawId,String[] values){
        this.rawId=rawId;
        this.values=values;
    }

}
