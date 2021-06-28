package main;

import processing.core.PImage;

import static main.Main.client;

import processing.core.PImage;

/**
 * class holding all of the files we would ever need
 */

public class Assets {

    public static PImage bloonPop;
    public static PImage redBloon;
    public static PImage blueBloon;
    public static PImage greenBloon;
    public static PImage yellowBloon;
    public static PImage pinkBloon;
    public static PImage blackBloon;
    public static PImage whiteBloon;
    public static PImage leadBloon;
    public static PImage zebraBloon;
    public static PImage rainbowBloon;
    public static PImage[] ceramicBloon;

    public static void load() {
        redBloon = client.loadImage("sprites/bloon/redBloon.png");
    }
}
