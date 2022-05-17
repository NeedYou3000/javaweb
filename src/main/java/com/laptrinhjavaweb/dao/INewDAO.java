package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.NewModel;

import java.util.List;

public interface INewDAO {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel newModel);
	void delete(Long id);
	List<NewModel> findAll();
	int getTotalItem();
}
