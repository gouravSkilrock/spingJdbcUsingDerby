package org.panwar.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.panwar.model.Circle;

public class CircleDao {

	public Circle getCircle(int circleId) {
		Circle circle =null;
		Connection connection=null;
		try{
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			System.out.println("Driver Loading...");
			System.out.println("Driver Loaded Successfull!");
			connection=DriverManager.getConnection("jdbc:derby://localhost:1527/FIRSTTABLE");
			System.out.println("Connection established successfull!");
			PreparedStatement ps=connection.prepareStatement("select * from FIRSTTABLE where id=?");
			ps.setInt(1, circleId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				circle = new Circle(circleId, rs.getString("name"));
			}
			ps.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();	
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return circle;
	}
}
