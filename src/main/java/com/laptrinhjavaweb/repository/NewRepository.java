package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.NewEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewRepository extends PagingAndSortingRepository<NewEntity, Long> {
}