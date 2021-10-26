package com.sanjana.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CeilingFanMain {
    // initially fan is on “off” (speed 0) setting.
    static int speed=0;
    static boolean reverseFlag=false;
    static String cordPulled=null;
    static CeilingFanImpl ceilingFan = new CeilingFanImpl();

    static String readNextLine() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = in.readLine();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args) throws CeilingFanException {
        try {
            while (true) {
                getInput();
                getSpeed();
            }
        }
        catch(CeilingFanException e) {
            e.printStackTrace();
        }
        catch(Exception e1) {
            e1.printStackTrace();
        }
    }

    private static void getInput() throws CeilingFanException {
            if(speed!=0)
            {
                System.out.println(" Pull cord 1 (c1) or Pull cord 2 (c2): ");
            }
            else {
                System.out.println("Fan is on OFF setting");
                System.out.println("Pull cord 1 (c1) or Pull cord 2 (c2)");
            }
            cordPulled= readNextLine();

        if(!(cordPulled.equalsIgnoreCase("c1") || cordPulled.equalsIgnoreCase("c2")) ) {
            throw new CeilingFanException("Input is Invalid:- pull cord one or cord two");
        }
    }

    private static void getSpeed() throws CeilingFanException {
        if(cordPulled.equalsIgnoreCase("c1") && reverseFlag==false) {
            speed=ceilingFan.speedIncrement(speed);
            if(speed==0)
            {	System.out.println(" Speed 0 is 'off' setting");
            }else {
                System.out.println("Current Speed: " + speed + " Direction is clockwise");
            }
        }
        else if(cordPulled.equalsIgnoreCase("c1") && reverseFlag==true) {
            speed=ceilingFan.speedIncrement(speed);
            if(speed==0)
            {
                System.out.println(" Speed 0 is 'off' setting");

            }else {
                System.out.println("Current Speed: " + speed + " Direction is anti-clockwise");
            }
        }
        else if(cordPulled.equalsIgnoreCase("c2") && speed!=0) {

            if(reverseFlag==false)
            {
                System.out.println("Current Speed: "+speed +" and direction is anticlockwise");
                reverseFlag=true;
            }else if(reverseFlag==true)
            {
                System.out.println("Current Speed: "+speed +" and direction is clockwise");
                reverseFlag=false;
            }

        }
        else if(cordPulled.equalsIgnoreCase("c2") && speed==0)
        {
            System.out.println("Speed 0 is 'off' setting, Pull cord 1 for speed");
        }
    }



}
