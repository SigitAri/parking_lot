package com.test.parkinglot.core;

import com.test.parkinglot.model.Slot;

/**
 * Created by Sigit on 20/05/2017.
 */
public class ParkingIntruction {
    Slot[] slots;

    public String Intruction(String intr){
        String results = "Introduction not recognized";
        String[] partsIntr = intr.split("\\s+");
        if(partsIntr.length > 0)
        {
            switch (partsIntr[0]){
                case "create_parking_lot" :
                    return createParkingLot(partsIntr[1]);
                case "park" :
                    return park(partsIntr[1], partsIntr[2]);
                case "leave" :
                    return leave(partsIntr[1]);
                case "status" :
                    return status();
                case "registration_numbers_for_cars_with_colour" :
                    return registrationByColour(partsIntr[1]);
                case "slot_numbers_for_cars_with_colour" :
                    return slotByColour(partsIntr[1]);
                case "slot_number_for_registration_number" :
                    return slotByRegistration(partsIntr[1]);
                default:
                    return results;
            }
        }

        return results;
    }

    private String isCreateLot(){
        if(slots == null){
            return "please create a parking lot";
        }
        return "";
    }

    private String createParkingLot(String lotSize){
        int size = Integer.parseInt(lotSize);
        slots = new Slot[size];
        return "Created a parking lot with "+size+" slots";
    }

    private String park(String registration, String colour){
        if(!isCreateLot().equals("")){
            return isCreateLot();
        }
        Slot slot = new Slot();
        slot.setRegistration(registration);
        slot.setColour(colour);

        for (int i = 0; i<slots.length; i++){
            if (slots[i] == null) {
                slot.setId(i+1);
                slots[i] = slot;
                return "Allocated slot number : "+ (i+1);
            }
        }
        return "Sorry, parking lot is full";
    }

    private String leave(String noSlaot){
        if(!isCreateLot().equals("")){
            return isCreateLot();
        }

        int nomor = Integer.parseInt(noSlaot);
        if(nomor <= slots.length){
            slots[nomor-1] = null;
            return "Slot number "+noSlaot+" is free";
        }
        return "not found";
    }

    private String status(){
        if(!isCreateLot().equals("")){
            return isCreateLot();
        }

        String message = "Slot No. \t Registration No \t Colour\n";
        for (Slot slot : slots){
            if(slot != null) {
                message += slot.getId() + "\t" + slot.getRegistration() + "\t" + slot.getColour() + "\n";
            }
        }
        return message;
    }

    private String registrationByColour(String colour){
        if(!isCreateLot().equals("")){
            return isCreateLot();
        }

        String message = "";
        for (int i=0; i<slots.length; i++){
            if(slots[i] != null && slots[i].getColour().equals(colour)){
                if(!message.equals("")){
                    message +=", ";
                }
                message +=  slots[i].getRegistration();
            }
        }
        return message;
    }

    private String slotByColour(String colour){
        if(!isCreateLot().equals("")){
            return isCreateLot();
        }

        String message = "";
        for (int i=0; i<slots.length; i++){
            if(slots[i] != null && slots[i].getColour().equals(colour)){
                if(!message.equals("")){
                    message +=", ";
                }
                message +=  slots[i].getId();
            }
        }
        return message;
    }

    private String slotByRegistration(String registration){
        if(!isCreateLot().equals("")){
            return isCreateLot();
        }

        for(Slot slot : slots){
            if( slot != null && slot.getRegistration().equals(registration)){
                return String.valueOf(slot.getId());
            }
        }
        return "Not found";
    }
}
