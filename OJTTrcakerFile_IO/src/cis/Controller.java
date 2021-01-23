package cis;

import cis.bo.OjtReflection;
import cis.util.CisUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A starting project which we can use for applications that need a menu driven
 * program. Note that the name of the project should be modified to reflect the
 * specific requirements.
 *
 * @author mrahman2
 * @since 20201115
 */
public class Controller {

    private static ArrayList<OjtReflection> alist = new ArrayList<OjtReflection>();

    public static final String EXIT = "X";

    private static final String MENU
            = "-------------------------\n"
            + " OJT Reflection Application \n\n"
            + "- A- Add Reflection \n"
            + "- S- Show All Reflection \n"
            + "- U- Update Reflection \n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {

        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        String option = "";
//
//        CisUtility.display("Today is: " + CisUtility.getCurrentDate(null));
//
//        CisUtility.display("The random number is " + CisUtility.getRandom(20));

        do {
            option = CisUtility.getInputString(MENU);
            processMenuOption(option);
        } while (!option.equalsIgnoreCase(EXIT));

    }

    /**
     * This method will process the menu option specified in the input
     * parameter. It will call appropriate functionality based on its value.
     *
     * @param option The menu option
     * @since 20171102
     * @author cis1201b
     *
     */
    public static void processMenuOption(String option) {
        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "A":
                CisUtility.display("Add Reflection");
                addApplicant();
                break;
            case "S":
                CisUtility.display("Show All Reflection");
                showAllReflection();
                break;
            case "U":
                CisUtility.display("Update Reflection");
                updateReflection();
                break;
            case "GV":
                CisUtility.display(CisUtility.getRandom());
                break;
            case "X":
                CisUtility.display("User picked x");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    public static void addApplicant() {
        FileWriter fr = null;
        try {
            OjtReflection ojtr = new OjtReflection();
            ojtr.getInfoFromUser();
            alist.add(ojtr);
            File file = new File("C:\\Users\\PC\\Documents\\NetBeansProjects\\CIS_2232_Assignment1_Rahman_Mohammad\\cis2232\\reflection.json");
            fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(ojtr.toString() + System.lineSeparator());
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println("This is ....");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
               System.out.println("This is ....");
            }
        }

    }

    public static void showAllReflection() {
        // OjtReflection ojtr = new OjtReflection();
        for (OjtReflection current : alist) {
            System.out.println(current);
//            for (int i = 0; i < alist.size();  i++)
//            System.out.println("Toatl reflectioin is: " + alist.get(i));
        }

    }

    public static void updateReflection() {

    }
}
