package main;

import driveManager.DriverManager;
import steps.DemoInputField;
import steps.ExpediaSteps;

public class Start {
    public static void main(String args[]) throws Exception {
        ExpediaSteps demo;

        demo = new ExpediaSteps();
        try{
            demo.runExpediaPage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DriverManager.close();
        System.out.println("Driver is closed");
    }
}
