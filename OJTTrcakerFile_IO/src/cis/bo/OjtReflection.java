package cis.bo;

/**
 * OjtReflection class to hold student credential
 *
 * @author marhman2
 * @date 20200920
 */
public class OjtReflection {

    private int studientId;
    private String studentName;
    private String reflectionText;

    final String OJT = "Ojt Reflection Application";

    public OjtReflection() {
    }

    public OjtReflection(int studientId, String studentName) {
        this.studientId = studientId;
        this.studentName = studentName;
    }

    public void getInfoFromUser() {
        studientId = cis.util.CisUtility.getInputInt("Enter studentj ID");
        studentName = cis.util.CisUtility.getInputString("Enter student name");
        reflectionText = cis.util.CisUtility.getInputString("Enter reflection text");
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
        return OJT + "\n\nStudient Id: " + studientId + ", Student Name: " + studentName + ", Reflection Text: " + reflectionText + ".";
    }

}
