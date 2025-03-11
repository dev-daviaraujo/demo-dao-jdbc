package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
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
			
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);							
			    }			
		    }
			else {
				throw new DbException("A linha não foi inserida ");
			}
		}			
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	
	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ? ";
			
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "New department");
			st.setInt(2, obj.getId());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				rs = st.getGeneratedKeys();
			}
			else {
				throw new DbException("Nenhuma linha foi alterada");
			}			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
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
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT * FROM department ";
			
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();			
			
			while(rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt(1));
				department.setName(rs.getString(2));
				list.add(department);					
			}
			return list;
			
						
		}
		catch(SQLException e) {
			throw new DbException("A lista de departamentos está vazia");
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}		
	}	
}
