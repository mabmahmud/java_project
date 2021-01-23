package cis.bo;

import java.io.File;
import java.io.Serializable;

/**
 * OjtReflection class to hold student credential
 *
 * @author marhman2
 * @date 20200920
 */
public class OjtReflection implements Serializable {

    private String studientId;
    private String studentName;
    private String reflectionText;
    public static final String FILE_LOCATION = "\"jdbc:mysql://localhost:3306/ojt\",\n" +
"                    \"root\",\n" +
"                    \"\"";
            
//            "/Users" +File.separator
//            +"PC" +File.separator
//            +"Documents" +File.separator
//            +"NetBeansProjects" +File.separator
//            +"CIS_2232_Assignment1_Rahman_Mohammad" +File.separator
//            +"cis2232" +File.separator
//            +"reflection.json";
    final String OJT = "Ojt Reflection Application";

    public OjtReflection() {
    }

    public OjtReflection(String studientId, String studentName) {
        this.studientId = studientId;
        this.studentName = studentName;
    }

    public OjtReflection(String valueOf, String studientId, String studentName, String reflectionText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getInfoFromUser() {
        studientId = cis.util.CisUtility.getInputString("Enter studentj ID");
        studentName = cis.util.CisUtility.getInputString("Enter student name");
        reflectionText = cis.util.CisUtility.getInputString("Enter reflection text");
    }

    public String getStudientId() {
        return studientId;
    }

    public void setStudientId(String studientId) {
        this.studientId = studientId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getReflectionText() {
        return reflectionText;
    }

    public void setReflectionText(String reflectionText) {
        this.reflectionText = reflectionText;
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Studient Id: " + studientId + ", Student Name: " + studentName + ", Reflection Text: " + reflectionText + ".";
    }

}
