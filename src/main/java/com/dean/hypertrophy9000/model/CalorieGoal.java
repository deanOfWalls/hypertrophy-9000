package com.dean.hypertrophy9000.model;

public enum CalorieGoal {
    BULK(+250),
    MAINTENANCE(0),
    CUT_LIGHT(-500),
    CUT_HEAVY(-1000);

    private final int offset;
    CalorieGoal(int offset){
        this.offset = offset;
    }
    public int getOffset(){
        return offset;
    }
}
