package com.enesbayram.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.enesbayram.utils.PagerUtil;
import com.enesbayram.utils.RestPageableEntity;
import com.enesbayram.utils.RestPageableRequest;
import com.enesbayram.utils.RestRootEntity;

public class RestBaseController {
	
	public static Pageable toPageable(RestPageableRequest pageable) {
		return PagerUtil.toPageable(pageable);
	}
	
	public static <T> RestPageableEntity<T> toPageableResponse(Page<?> page , List<T> content) {
		return PagerUtil.toPageableResponse(page, content);
	}
	
	public static <T> RestRootEntity<T> ok(T payload){
		return RestRootEntity.ok(payload);
	}
	
	public static <T> RestRootEntity<T> error(String errorMessage){
		return RestRootEntity.error(errorMessage);
	}
}
