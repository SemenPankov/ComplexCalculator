package org.example;

import org.example.Interface.iCalculable;
import org.example.Model.Calculator;
import org.example.Model.Decorator;
import org.example.Model.Logger;
import org.example.View.ViewCalculator;

public class Main {
    public static void main(String[] args) {


        iCalculable decorator = new Decorator(new Calculator(0, 0), new Logger());

        ViewCalculator view = new ViewCalculator(decorator);
        view.run();
    }
}