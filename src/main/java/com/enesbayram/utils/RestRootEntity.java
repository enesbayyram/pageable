package com.enesbayram.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class RestRootEntity<T> {

	private Integer status;

	private T payload;

	private String errorMessage;

	//Amaç , bütün dönen tipleri tek bir formatta dönebilmektir.
	public static <T> RestRootEntity<T> build(Integer status, T payload, String errorMessage) {
		RestRootEntity<T> rootEntity = new RestRootEntity<>();
		rootEntity.setStatus(status);
		rootEntity.setPayload(payload);
		rootEntity.setErrorMessage(errorMessage);
		return rootEntity;
	}

	public static <T> RestRootEntity<T> ok(T payload) {
		return build(200, payload, null);
	}

	public static <T> RestRootEntity<T> error(String errorMessage) {
		return build(500, null, errorMessage);
	}
}
