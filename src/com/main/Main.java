
package com.main;

import SyntheticData.SyntheticPrivateSchool;
import utilities.Utilities;

public class Main {


    public static void main(String[] args) {

        System.out.print("Welcome to Lyceum XAVALE \n");
        System.out.println("\n===================================================================");
        System.out.println("Would you like to add data manually or use default data? ");
        System.out.print("Press [1] for manual mode and [2] for default mode: ");

        int mode;
        do {
            mode = Utilities.integerInput();
            if (mode == 1) {
                models.PrivateSchool ps = new models.PrivateSchool("PS");
                break;
            }
            else if(mode == 2) {
                SyntheticPrivateSchool sp = new SyntheticPrivateSchool();
                break;
            }
            else
                System.out.println("Press 1 or 2");
        } while(mode != 1 || mode != 2);

        Utilities.Menu(mode);

    }
}

































































