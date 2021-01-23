package cis;

import cis.OjtDAO.OjtReflectionDAO;
import cis.bo.OjtReflection;
import cis.bo.OjtReflectionBO;
import cis.util.CisUtility;
import cis.util.CisUtilityFile;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A starting project which we can use for applications that need a menu driven
 * program. Note that the name of the project should be modified to reflect the
 * specific requirements.
 *
 * @author bjmaclean
 * @since 20181115
 */
public class Controller {

    public static ArrayList<OjtReflection> ojtList = new ArrayList<OjtReflection>();
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

        // Loading arry list to show previos reflections
        //loadArrayList(ojtList);

        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        String option = "";

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
                if (OjtReflectionDAO.checkConnection()) {
                    addReflection();
                } else {
                    System.out.println("Can not add - database unavailable");
                }

                break;
            case "S":
                CisUtility.display("Show All Reflection\n");
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

    /**
     * Add a reflection and save to a file
     *
     * @since 2020-09-09
     * @author BJM
     *
     * @since 2020-09-21
     * @author BJM, Modifed by mrahman2
     */
    public static void addReflection() {

        OjtReflection ojtr = new OjtReflection();
        ojtr.getInfoFromUser();

        OjtReflectionBO ojtrBO = new OjtReflectionBO();
        ojtrBO.insert(ojtr);

//        //Use Logan's code to setup the file.
//        Gson gson = new Gson();
//        File file = CisUtilityFile.setupFile(OjtReflection.FILE_LOCATION);
//        String jsonToWrite = gson.toJson(ojtr);
//        System.out.println("About to save to file: " + jsonToWrite);
//        CisUtilityFile.write(jsonToWrite, file);
//
//        try {
//            //********************************************************
//            //  Write the reflection to a file.
//            //********************************************************
//
//            String fileNameOjtReflection = CisUtilityFile.getFolderFromFileName(OjtReflection.FILE_LOCATION);
//            FileOutputStream fos = new FileOutputStream(fileNameOjtReflection + File.separator + "reflection" + ojtr.getStudientId() + ".dat");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(ojtr);
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("BJM-file not found exception thrown.");
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        FileWriter fr = null;
//        try {
//            //OjtReflection ojtr = new OjtReflection();
//            ojtr.getInfoFromUser();
//            ojtList.add(ojtr);
//            //File file = new File("C:\\Users\\PC\\Documents\\NetBeansProjects\\CIS_2232_Assignment1_Rahman_Mohammad\\cis2232\\reflection.json");
//            fr = new FileWriter(file, true);
//            BufferedWriter br = new BufferedWriter(fr);
//            br.write(ojtr.toString() + System.lineSeparator());
//            br.close();
//            fr.close();
//        } catch (IOException ex) {
//            System.out.println("This is ....");
//        } finally {
//            try {
//                fr.close();
//            } catch (IOException ex) {
//                System.out.println("This is ....");
//            }
//        }
    }

    /**
     * To show all reflections
     *
     * @since 2020-09-021
     * @author mrahmn2
     */
    public static void showAllReflection() {

        System.out.println("The total number of reflection is: " + countReflection());

        OjtReflectionBO ojtrBO = new OjtReflectionBO();
        ArrayList<OjtReflection> ojtList = ojtrBO.load();

        if (ojtList != null) {
            for (OjtReflection current : ojtList) {
                System.out.println(current.toString());
            }
        }
    }

    /**
     * To load the array list to show all previous reflections
     *
     * @since 2020-09-021
     * @author mrahmn2
     */
//    public static void loadArrayList(ArrayList tempList) {
//        int count = 0;
//
//        try {
//            ArrayList<String> test = (ArrayList<String>) Files.readAllLines(Paths.get(FILE_LOCATION));
//
//            for (String current : test) {
//                System.out.println("Loading:  " + current);
//
//                Gson gson = new Gson();
//                OjtReflection temp = gson.fromJson(current, OjtReflection.class);
//                tempList.add(temp);
//                count++;
//            }
//
//        } catch (IOException ex) {
//            System.out.println("Not able to load reflection from database.");
//            System.out.println(ex.getMessage());
//        }
//
//        System.out.println("Loading reflection from database (Loaded " + count + " reflections)\n\n");
//    }

    /**
     * To count total number of reflections
     *
     * @since 2020-09-021
     * @author mrahmn2
     */
    public static int countReflection() {
        int i = 0;
        for (OjtReflection current : ojtList) {
            i++;
        }
        return i;
    }

    /**
     * To update reflection and append it with previous one
     *
     * @since 2020-09-021
     * @author mrahmn2
     */
    public static void updateReflection() {

        System.out.println("Enter required iinformation to add reflection\n");
        String tempId = cis.util.CisUtility.getInputString("Enter student id");

        for (OjtReflection current : ojtList) {
            if (current.getStudientId().equalsIgnoreCase(tempId)) {

                String tempName = cis.util.CisUtility.getInputString("Enter student name");
                if (current.getStudentName().equalsIgnoreCase(tempName)) {
                    String tempRefTest = cis.util.CisUtility.getInputString("Enter additioanl reflection text");
                    System.out.println(current.getReflectionText() + "." + tempRefTest);

                }
                break;
            }
        }
    }
}
