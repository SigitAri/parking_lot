package com.test.parkinglot;

import com.test.parkinglot.core.ParkingIntruction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Sigit on 20/05/2017.
 */
public class parking_lot {
    public static void main(String[] args) {
        ParkingIntruction parkingIntruction = new ParkingIntruction();

        if(args.length > 0){
            try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                for(String line; (line = br.readLine()) != null; ) {
                    String message = parkingIntruction.Intruction(line);
                    System.out.println(message);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Scanner reader = new Scanner(System.in);
            while (true) {
                String intruction = reader.nextLine();
                String message = parkingIntruction.Intruction(intruction);
                System.out.println(message);
            }
        }
    }
}
