package com.sanjana.files;

public class CeilingFanImpl implements CeilingFan {
    private int currentFanSpeed;

    public CeilingFanImpl() {
        currentFanSpeed = 0;
    }

    // returns speed of the ceiling fan.
    public int speedIncrement(int speed) {
        currentFanSpeed= speed;
        if(currentFanSpeed==2)
        {
            return 0;
        }else {
            return ++currentFanSpeed;
        }
    }
}
