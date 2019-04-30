package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends inventory {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {


        character player=new character();
        while (player.inGame){
            player.choice();
        }

    }

}
