package com.enesbayram.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestPersonelController;
import com.enesbayram.controller.RestBaseController;
import com.enesbayram.dto.DtoPersonel;
import com.enesbayram.model.Personel;
import com.enesbayram.service.IPersonelService;
import com.enesbayram.utils.RestPageableEntity;
import com.enesbayram.utils.RestPageableRequest;
import com.enesbayram.utils.RestRootEntity;

@RestController
@RequestMapping("/rest/api/personel")
public class RestPersonelControllerImpl extends RestBaseController implements IRestPersonelController{
	
	@Autowired
	private IPersonelService personelService;

	@GetMapping("/list/pageable")
	@Override
	public RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(RestPageableRequest pageable) {
		 Page<Personel> page = personelService.findAllPageable(toPageable(pageable));
		 RestPageableEntity<DtoPersonel> pageableResponse = toPageableResponse(page, personelService.toDTOList(page.getContent()));
		 return ok(pageableResponse);
	}


	

}
