package app;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Scanner sc = new Scanner(System.in);
        int cislo = hod();
        System.out.println(cislo);
        int figurky = 4;
        int pole = 8;
        int hraci = 4;
    }
    public static int hod() {
        Random generator = new Random();
        int a = generator.nextInt(6) + 1;
        return a;
    }
}

