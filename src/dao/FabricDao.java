package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Fabric;

public class FabricDao {
	
	private Connection connection;
	private final String GET_FABRIC_QUERY = "Select * from fabric";
	private final String GET_FABRIC_BY_ID_QUERY = "Select * from fabric where id = ?";
	private final String CREATE_NEW_FABRIC_QUERY = "insert into fabric(fabric_type, fiber_content, yardage, color) values (?, ?, ?, ?)";
	private final String DELETE_FABRIC_BY_ID_QUERY = "Delete from fabric where id = ?";
	private final String UPDATE_FABRIC_BY_ID_QUERY = "Update fabric Set fabric_type = ?, fiber_content = ?, yardage = ?, color = ? where id = ?";

	public FabricDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Fabric> getFabrics() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_FABRIC_QUERY).executeQuery();
		List<Fabric> fabrics = new ArrayList<Fabric>();
		
		while (rs.next()) {
			fabrics.add(populateFabric(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3),
					rs.getFloat(4),
					rs.getString(5)));
		}
		return fabrics;
	}
	
	public Fabric getFabricById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_FABRIC_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateFabric(rs.getInt(1), 
				rs.getString(2), 
				rs.getString(3),
				rs.getFloat(4),
				rs.getString(5));
	}
	
	public void createNewFabric(String fabricType, String fiberContent, float yardage, String color) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_FABRIC_QUERY);
		ps.setString(1, fabricType);
		ps.setString(2, fiberContent);
		ps.setFloat(3, yardage);
		ps.setString(4, color);
		ps.executeUpdate();
	}
	
	public void deleteFabricByID(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_FABRIC_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateFabricById(String fabricType, String fiberContent, float yardage, String color, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_FABRIC_BY_ID_QUERY);
		ps.setString(1, fabricType);
		ps.setString(2, fiberContent);
		ps.setFloat(3, yardage);
		ps.setString(4, color);
		ps.setInt(5, id);
		ps.executeUpdate();
	}
	
	private Fabric populateFabric(
			int id, String fabricType, String fiberContent, float yardage, String color) {
		return new Fabric(id, fabricType,fiberContent, yardage, color);
	}
	
}
