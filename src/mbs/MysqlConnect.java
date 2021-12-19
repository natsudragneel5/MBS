/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbs;

/**
 *
 * @author alroy
 */
import java.sql.*;
public class MysqlConnect {
    static Connection con= null;
	
        @SuppressWarnings("empty-statement")
	public static Connection dbConnnector(){
		try {
			MysqlConnect.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbs","root","mypass12345");
			System.out.println("Successfully connected to Database");
			return con;
		}
		catch(SQLException e1){
			System.out.println("No database named mbs");
			try {
			Statement stm=MysqlConnect.con.createStatement();
			String query = "create database mbs";
			stm.executeUpdate(query);
			dbConnnector();
			}
			catch(Exception e2) {
				System.out.println(e2);
				dbConnnector();
			}
			return null;
		}
	}
        public static void main(String[] args) throws SQLException{
            Connection con1= MysqlConnect.dbConnnector();
        }
}