package main;

import driveManager.DriverManager;
import steps.DemoInputField;
import steps.ExpediaSteps;

public class Start {
    public static void main(String args[]) throws Exception {
        ExpediaSteps demo;

        demo = new ExpediaSteps();
        demo.runExpediaPage();
        DriverManager.close();
    }
}
