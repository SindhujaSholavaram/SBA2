package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.dao.RolesRepository;
import com.eval.coronakit.dao.UserRepository;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.Roles;
import com.eval.coronakit.entity.User;
import com.eval.coronakit.exception.CoronaKitException;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RolesRepository rolesRepository;

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

	@Override
	public boolean deleteProductFromKit(int productId) throws CoronaKitException {
		if (!repository.existsById(productId)) {
			throw new CoronaKitException("Product ID Not Found!!");
		}
		repository.deleteById(productId);
		return true;
	}

	@Override
	public User addUserDetails(User user, Roles roles) throws CoronaKitException {
		if(user!=null) {
			rolesRepository.save(roles);
			userRepository.save(user);
		}
		return user;
	}

}
