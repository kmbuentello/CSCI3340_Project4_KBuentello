package citation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Kayla
 */
public class CitationDatabase 
{
    //variables
    private Connection conn;
    private Statement  stmnt;
    private ResultSet  resul;
    
    //private constructor
    private CitationDatabase() { connect(); }

    //private static instance
    private static CitationDatabase singletonOfDatabase = null;

    //property to return the singleton instance
    public static CitationDatabase getSingletonOfdatabase() 
    {
        if (singletonOfDatabase == null) 
        {
            singletonOfDatabase = new CitationDatabase();
        }
        return singletonOfDatabase;
    }
    
    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * @return the stmnt
     */
    public Statement getStmnt() {
        return stmnt;
    }

    /**
     * @param stmnt the stmnt to set
     */
    public void setStmnt(Statement stmnt) {
        this.stmnt = stmnt;
    }

    /**
     * @return the resul
     */
    public ResultSet getResul() {
        return resul;
    }

    /**
     * @param resul the resul to set
     */
    public void setResul(ResultSet resul) {
        this.resul = resul;
    }
    
    //functions
    public void connect()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/citations", "root", "Jun1ourc4k35!");
            stmnt = conn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Could not connect: " + e);
        }
    }
}
