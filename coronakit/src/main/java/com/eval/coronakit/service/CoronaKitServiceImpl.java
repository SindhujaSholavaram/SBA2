package com.eval.coronakit.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.CoronaKitRepository;
import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.exception.CoronaKitException;

@Service
public class CoronaKitServiceImpl implements CoronaKitService {

	@Autowired
	CoronaKitRepository repository;

	@Override
	@Transactional
	public CoronaKit saveKit(CoronaKit kit) throws CoronaKitException {
		if (kit != null) {
			if (!repository.existsById(kit.getId())) {
				throw new CoronaKitException("Item Not Found");
			}

			repository.save(kit);
		}
		return kit;
	}

	@Override
	public CoronaKit getKitById(int kitId) {
		return repository.findById(kitId).orElse(null);
	}

}
