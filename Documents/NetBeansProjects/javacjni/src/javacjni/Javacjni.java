/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacjni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class Javacjni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javacjni?zeroDateTimeBehavior=exception","root","");
            
            String query2="SELECT * FROM student";
            
            Statement st = con.createStatement();
            ResultSet rs2 = st.executeQuery(query2);
            
            System.out.println("CONNECTED");
            while(rs2.next()){
                System.out.println("\nFirstname: " +rs2.getString("fname"));
                System.out.println("Lastname: " +rs2.getString("lname"));
                System.out.println("MiddleInitial: " +rs2.getString("mname"));
                System.out.println("Course: " +rs2.getString("course"));
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "User Authenticity Error: " + e.getMessage());
        }
    }
    
}
