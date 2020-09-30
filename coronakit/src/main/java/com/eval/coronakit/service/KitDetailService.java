package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.exception.CoronaKitException;

public interface KitDetailService {
	public KitDetail addKitItem(KitDetail kitItem) throws CoronaKitException;
	public KitDetail getKitItemById(int itemId) throws CoronaKitException;
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) throws CoronaKitException;
}
