package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.exception.CoronaKitException;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;

	@Override
	@Transactional
	public KitDetail addKitItem(KitDetail kitItem) throws CoronaKitException {
		if (kitItem != null) {
			if (repository.existsById(kitItem.getId())) {
				throw new CoronaKitException("Kit ID already used!");
			}

			repository.save(kitItem);
		}
		return kitItem;
	}

	@Override
	public KitDetail getKitItemById(int itemId) throws CoronaKitException {
		return repository.findById(itemId).orElse(null);
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) throws CoronaKitException {
		return repository.findAll();
	}

}
