package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;


	public class DepartmentDaoJDBC implements DepartmentDao {
		
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "INSERT INTO department (Name) "
					+ "VALUES (?) ";
			
			st = conn.prepareStatement(sql);
			
			st.setString(1, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected < 0) {
				throw new DbException("A linha não foi inserida ");
			}
			
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
