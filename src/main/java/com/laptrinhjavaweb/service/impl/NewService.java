package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository repository;

    @Autowired
    private NewConverter converter;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<NewDTO> findAll(Pageable pageble) {
        List<NewDTO> models = new ArrayList<>();
        List<NewEntity> newEntities = repository.findAll(pageble).getContent();
        for (NewEntity item:newEntities) {
            models.add(converter.toDto(item));
        }
        return models;
    }

    @Override
    public NewDTO findByID(long id) {
        NewEntity entity = repository.findById((Long) id).get();
        return converter.toDto(entity);
    }

    @Override
    public int getTotalItem() {
        return (int) repository.count();
    }


    @Override
    @Transactional
    //Su dung cho insert new and update new
    public NewDTO save(NewDTO dto) {
        CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
        NewEntity newEntity;
        if(dto.getId() != null) {
            NewEntity oldNew = repository.findById(dto.getId()).get();
            oldNew.setCategory(category);
            newEntity = converter.toEntity(oldNew, dto);
        } else {
            newEntity = converter.toEntity(dto);
            newEntity.setCategory(category);
        }
        return converter.toDto(repository.save(newEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id:ids) {
            repository.deleteById(id);
        }
    }


}
