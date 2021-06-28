package main;

import processing.core.PImage;

import static main.Main.client;

/**
 * class holding all of the files we would ever need
 */
public class Assets {
    public static PImage redBloon;

    public static void load() {
        redBloon = client.loadImage("sprites/bloon/redBloon.png");
    }
}
