package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T>{
	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/new_servlet_03112022?useSSL=false";
			String user = "root";
			String password = "vu05042001";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	//Use for query "SELECT"
	//return List of Objects which are the results of the query
	@Override
	public List<T> query(String sql, RowMapper<T> mapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			setParameter(stmt, parameters);
			
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				results.add(mapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

			}
		}
		return null;
	}
	
	//Use for query "UPDATE" and "DELETE"
	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement stmt = null;		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			setParameter(stmt, parameters);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//Use for query "INSERT"
	//return "id" of record which has been inserted
	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement stmt = null;	
		ResultSet resultSet = null;
		try {
			Long id = null;
			conn = getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(stmt, parameters);
			stmt.executeUpdate();
			resultSet = stmt.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				return null;
			}
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public int count(String sql, Object...parameters) {
		Connection conn = null;
		PreparedStatement stmt = null;	
		ResultSet resultSet = null;
		try {
			int count = 0;
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			setParameter(stmt, parameters);
			resultSet = stmt.executeQuery();
			while (resultSet.next())
				count = resultSet.getInt(1);
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	private void setParameter(PreparedStatement stmt, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					stmt.setLong(index, (Long)parameter);
				} else if (parameter instanceof String) {
					stmt.setString(index, (String)parameter);
				} else if (parameter instanceof Integer) {
					stmt.setInt(index, (Integer)parameter);
				} else if (parameter instanceof Timestamp) {
					stmt.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
