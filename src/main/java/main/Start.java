package main;

import steps.DemoInputField;

public class Start {
    public static void main(String args[]) throws Exception {
        DemoInputField demo;

        demo = new DemoInputField();
        demo.showMessage();
        demo.close();
    }
}
