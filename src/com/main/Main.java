
package com.main;

import SyntheticData.SyntheticPrivateSchool;
import models.PrivateSchool;
import utilities.Utilities;

public class Main {

    public static void main(String[] args) {

        System.out.print("School has opened for the Semester! \n");
        System.out.println("\n===================================================================");
        System.out.println("Would you like to add data manually or use default data? ");
        System.out.print("Press [1] for manual mode and [2] for default mode: ");

        Utilities instance = Utilities.getUtilitiesInstance();

        int mode;
        do {
            mode = instance.integerInput();
            if (mode == 1) {
                PrivateSchool privateSchool = new PrivateSchool("PS");


                break;
            }
            else if(mode == 2) {
                SyntheticPrivateSchool syntheticPrivateSchool = new SyntheticPrivateSchool();
                break;
            }
            else
                System.out.println("Press 1 or 2");

        } while(mode != 1 || mode != 2);

        instance.Menu();

    }
}

































































