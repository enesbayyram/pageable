package com.enesbayram.controller;

import com.enesbayram.dto.DtoPersonel;
import com.enesbayram.utils.RestPageableEntity;
import com.enesbayram.utils.RestPageableRequest;
import com.enesbayram.utils.RestRootEntity;

public interface IRestPersonelController {

	RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(RestPageableRequest pageable);
}
