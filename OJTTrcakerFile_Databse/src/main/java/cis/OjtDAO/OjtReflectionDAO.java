
package cis.OjtDAO;

import cis.bo.OjtReflection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrahamn2
 * @date 20200929
 */
public class OjtReflectionDAO {

    public static boolean checkConnection() {
        Connection conn = null;
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ojt",
                        "root",
                        ""); //--No password.  For assignment submission this would be expected to be empty.
            } catch (Exception e) {
                return false;
            }

            return true;

    }

    /**
     * Select the records from the database
     *
     * @since 20200923
     * @author BJM
     * 
     * @date 20200929
     * @modifyed by mrahman2
     */
    public ArrayList<OjtReflection> select() {
        ArrayList<OjtReflection> ojtList = new ArrayList();

        //Select the campers from the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ojt",
                    "root",
                    ""); //--No password.  For assignment submission this would be expected to be empty.
        } catch (Exception e) {
            System.out.println("Could not make a connection to the database");
            return null;
        }

        try {

            Statement statement = conn.createStatement();

            //***************************************************
            // Select using statement
            //***************************************************
            //Next select all the rows and display them here...
            ResultSet rs = statement.executeQuery("select * from OjtReflection");

            //Show all the campers
            while (rs.next()) {
                int id = rs.getInt("id");
                String studientId = rs.getString("studientId");
                String studentName = rs.getString("studentName");
                String reflectionText = rs.getString("reflectionText");

                OjtReflection ojtr = new OjtReflection(String.valueOf(id), studientId, studentName, reflectionText);
                ojtList.add(ojtr);

            }

        } catch (SQLException ex) {
            Logger.getLogger(OjtReflectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                //Could not close.  
                System.out.println("Error closing the connection.");
            }
        }
        return ojtList;

    }

    /**
     * Insert the camper into the database.
     *
     * @since 20200923
     * @author BJM
     *
     * 20200925 BJM Modifications to get running using standard password.
     * 
     *  @date 20200929
     * @modifyed by mrahman2
     */
    public OjtReflection insert(OjtReflection ojtr) {

        Connection conn = null;

        try {
            //BJM 20200925 Removed the password.
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ojt",
                    "root",
                    "");
        } catch (SQLException ex) {
            System.out.println("SQL exception happned!");
        }

        //***************************************************
        // INSERT
        //***************************************************
        try {
            String theStatement = "INSERT INTO OjtReflection(studientId,studentName,reflectionText) "
                    + "VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(theStatement);
            stmt.setString(1, ojtr.getStudientId());
            stmt.setString(2, ojtr.getStudentName());
            stmt.setString(3, ojtr.getReflectionText());

            stmt.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("sql exception caught");
            sqle.printStackTrace();
        }

        return ojtr;
    }
}
