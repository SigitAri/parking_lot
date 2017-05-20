package com.test.parkinglot;

import com.test.parkinglot.core.ParkingIntruction;

import java.util.Scanner;

/**
 * Created by Sigit on 20/05/2017.
 */
public class parking_lot {
    public static void main(String[] args) {
        ParkingIntruction parkingIntruction = new ParkingIntruction();
        Scanner reader = new Scanner(System.in);
        while (true) {
            String intruction = reader.nextLine();
            String message = parkingIntruction.Intruction(intruction);
            System.out.println(message);
        }
    }
}
