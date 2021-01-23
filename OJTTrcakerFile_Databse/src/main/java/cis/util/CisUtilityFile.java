package cis.util;

import cis.bo.OjtReflection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generic CIS File Methods
 *
 * @author bjm
 * @since 20200911
 */
public class CisUtilityFile {

    public static String getFolderFromFileName(String fileName) {
        int location = fileName.lastIndexOf("\\");
        String folder = fileName.substring(0, location);
        return folder;
    }

    /**
     * Method which will ensure that the file directory and the file is created
     * to be used.
     *
     * @param fileName 
     * @return  The file 
     * @since 20200911
     * @author BJM
     */
    public static File setupFile(String fileName) {

        //Note this can be useful too:  Files.createDirectories(Paths.get(folder));
        //Make sure that the directory structure exists;
        //Where was this taken????
        File file = new File(fileName);
        File dir = new File(file.getParent());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            if (file.createNewFile()) {
                System.out.println("New File Created!");
            } else {
                //System.out.println("File already exists!");
            }
        } catch (IOException ex) {
            Logger.getLogger(CisUtilityFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }

    /**
     * Method to take the content and write it to the specified file.
     * @since 2020-09-11
     * @author BJM
     */
    
    public static void write(String content, File file) {

        //Write this camper to the file.
        //https://www.journaldev.com/881/java-append-to-file
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(content + System.lineSeparator());
            br.close();
        } catch (IOException ex) {
            System.out.println("There was an exception encountered related to i/o");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("There was an exception closing the file.");
            }
        }

//        //Using Java nio 
//        //https://examples.javacodegeeks.com/core-java/nio/file-nio/java-nio-write-file-example/
//        Path path = Paths.get("D:\\cis\\cis2232\\topic1\\campers.csv");
//        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
//            //Note this will overwrite the file.  More research needed to add syntax top open with append.
//            writer.write(camper.toString() + System.lineSeparator());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

}
