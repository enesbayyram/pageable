package com.enesbayram.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enesbayram.dto.DtoDepartment;
import com.enesbayram.dto.DtoPersonel;
import com.enesbayram.model.Personel;
import com.enesbayram.repository.PersonelRepository;
import com.enesbayram.service.IPersonelService;

@Service
public class PersonelServiceImpl implements IPersonelService {

	@Autowired
	private PersonelRepository personelRepository;

	@Override
	public Page<Personel> findAllPageable(Pageable pageable) {
		Page<Personel> allPersonel = personelRepository.findAllPersonel(pageable);
		return allPersonel;
	}

	@Override
	public List<DtoPersonel> toDTOList(List<Personel> personelList) {
		List<DtoPersonel> dtoList = new ArrayList<>();
		for (Personel personel : personelList) {
			DtoPersonel dtoPersonel = new DtoPersonel();
			DtoDepartment dtoDepartment = new DtoDepartment();

			BeanUtils.copyProperties(personel, dtoPersonel);
			BeanUtils.copyProperties(personel.getDepartment(), dtoDepartment);

			dtoPersonel.setDepartment(dtoDepartment);

			dtoList.add(dtoPersonel);
		}
		return dtoList;
	}

}
