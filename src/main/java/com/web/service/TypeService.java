package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.TypeDao;
import com.web.entity.Product;


@Service
public class TypeService {
	
	@Autowired
	private TypeDao typeDao;
	
	public List findProduuctByType(String type){
		
		return typeDao.findProduuctByType(type);
	}
	
}
