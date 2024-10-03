package com.enesbayram.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.enesbayram.dto.DtoPersonel;
import com.enesbayram.model.Personel;

public interface IPersonelService {

	Page<Personel> findAllPageable(Pageable pageable);
	
	List<DtoPersonel> toDTOList(List<Personel> personelList);
}
