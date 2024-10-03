package com.enesbayram.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PagerUtil {

	public  boolean isNullOrEmpty(String value) {
		return value == null || value.trim().length() == 0;
	}

	public Pageable toPageable(RestPageableRequest pageable) {
		if (!isNullOrEmpty(pageable.getColumnName())) {
			String columnName = pageable.getColumnName();
			Sort sortBy = pageable.isAsc() ? Sort.by(Direction.ASC, columnName) : Sort.by(Direction.DESC, columnName);
			return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sortBy);
		}
		return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
	}

	public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content) {
		RestPageableEntity<T> pageableEntity = new RestPageableEntity<>();
		pageableEntity.setContent(content);
		pageableEntity.setPageNumber(page.getPageable().getPageNumber());
		pageableEntity.setPageSize(page.getPageable().getPageSize());
		pageableEntity.setTotalElement(page.getTotalElements());
		return pageableEntity;
	}
}
