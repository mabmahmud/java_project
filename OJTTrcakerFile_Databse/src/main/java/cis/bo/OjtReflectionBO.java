package cis.bo;

import cis.OjtDAO.OjtReflectionDAO;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Connect to the data access object to get the reflections from the datasource.
 *
 * @since 20200929
 * @author mrahman2
 */
public class OjtReflectionBO {

    public ArrayList<OjtReflection> load() {
        //Read reflections from the database
        OjtReflectionDAO ojtrDAO = new OjtReflectionDAO();
        ArrayList<OjtReflection> ojtList = ojtrDAO.select();

        return ojtList;
    }

    public OjtReflection insert(OjtReflection ojtr) {
        OjtReflectionDAO ojtrDAO = new OjtReflectionDAO();
        ojtr = ojtrDAO.insert(ojtr);
        return ojtr;
    }

}
