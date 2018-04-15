package task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class csvTask{
public static void main(String[] args) throws IOException, SQLException
{
	 PreparedStatement preparedStatement = null;
	 int n=4;
	 try { 
		 	// change the "root" to your username and "sqlpass" to your password
    	    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csvmanager?useSSL=false","root","sqlpass");
    	  		Statement myst= con.createStatement();
    	  		BufferedReader bReader = new BufferedReader(new FileReader("csvmanager.csv"));
    	  		while (bReader != null) {
    	  				String read;
    	  				try {
    	  					read = bReader.readLine();
    	  					if (read != null) 
    	  					{
    	  						String[] array = read.split(",");
    	  						System.out.println(array[1]);
    	  						preparedStatement = con.prepareStatement("insert into  candidate_Info values (default, ?, ?, ?, ? )");
    	  						preparedStatement.setString(1, array[0]);
    	  						preparedStatement.setString(2, array[1]);
    	  						preparedStatement.setString(3, array[2]);
    	  						preparedStatement.setString(4, array[3]);
    	  						preparedStatement.executeUpdate();
                    	  		System.out.println("inserted");
    	  					} 
    	  					}
    	  				catch (IOException ex) {
    	  					ex.printStackTrace();
    	  					}
    	  				finally
    	  				{
    	  					if (bReader == null) 
    	  					{
    	  						bReader.close();
    	  					}
    	  				}
    	  			}
      } catch (FileNotFoundException ex) {
          ex.printStackTrace();
      }
}
}
  		
  	
    		  			

