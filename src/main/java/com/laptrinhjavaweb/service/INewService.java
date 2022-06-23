package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {
    List<NewDTO> findAll(Pageable pageble);
    NewDTO findByID(long id);
    int getTotalItem();
    NewDTO save(NewDTO dto);
    void delete(long[] ids);
}
