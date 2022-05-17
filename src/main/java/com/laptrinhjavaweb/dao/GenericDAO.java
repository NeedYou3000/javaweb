package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
	List<T> query(String sql, RowMapper<T> mapper, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
