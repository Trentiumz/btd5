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
        blueBloon = client.loadImage("sprites/bloon/blueBloon.png");
        greenBloon = client.loadImage("sprites/bloon/greenBloon.png");
        yellowBloon = client.loadImage("sprites/bloon/yellowBloon.png");
        pinkBloon = client.loadImage("sprites/bloon/pinkBloon.png");
        blackBloon = client.loadImage("sprites/bloon/blackBloon.png");
        whiteBloon = client.loadImage("sprites/bloon/whiteBloon.png");
        leadBloon = client.loadImage("sprites/bloon/leadBloon.png");
        zebraBloon = client.loadImage("sprites/bloon/zebraBloon.png");
        rainbowBloon = client.loadImage("sprites/bloon/rainbowBloon.png");
        ceramicBloon[0] = client.loadImage("sprites/bloon/ceramicBloon.png");
    }
}
