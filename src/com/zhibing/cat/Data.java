package com.zhibing.cat;

import javax.swing.*;

import java.net.URL;

public class Data {
    //public static URL headerURL = Data.class.getResource("/statics/header.png");
    //public static ImageIcon header = new ImageIcon(headerURL);
    public static URL upURL = Data.class.getResource("/statics/up.png");
    public static URL downURL = Data.class.getResource("/statics/down.png");
    public static URL leftURL = Data.class.getResource("/statics/left.png");
    public static URL rightURL = Data.class.getResource("/statics/right.png");
    public static URL bodyURL = Data.class.getResource("/statics/body.png");
    public static URL foodURL = Data.class.getResource("/statics/food.png");
    public static URL pizzaURL = Data.class.getResource("/statics/pizza.png");
    public static URL bodyUpURL = Data.class.getResource("/statics/bodyUp.png");
    public static URL bodyDownURL = Data.class.getResource("/statics/bodyDown.png");


    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);
    public static ImageIcon body = new ImageIcon(bodyURL);
    public static ImageIcon food = new ImageIcon(foodURL);
    public static ImageIcon pizza = new ImageIcon(pizzaURL);
    public static ImageIcon bodyUp = new ImageIcon(bodyUpURL);
    public static ImageIcon bodyDown = new ImageIcon(bodyDownURL);
}
