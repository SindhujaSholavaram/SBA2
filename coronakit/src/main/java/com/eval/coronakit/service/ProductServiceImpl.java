package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaKitException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;

	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) throws CoronaKitException {
		if (product != null) {
			if (repository.existsById(product.getId())) {
				throw new CoronaKitException("Product ID already used!");
			}

			repository.save(product);
		}
		return product;
	}

	@Override
	public List<ProductMaster> getAllProducts() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteProduct(int productId) throws CoronaKitException {
		if (!repository.existsById(productId)) {
			throw new CoronaKitException("Product Not Found");
		}

		repository.deleteById(productId);
		return true;
	}

	@Override
	public ProductMaster getProductById(int productId) {
		return repository.findById(productId).orElse(null);
	}

}
