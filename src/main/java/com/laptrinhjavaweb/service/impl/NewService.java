package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService implements INewService {
    @Autowired
    private INewDAO newDAO;

    @Override
    public List<NewModel> findAll() {
        return newDAO.findAll();
    }
}
