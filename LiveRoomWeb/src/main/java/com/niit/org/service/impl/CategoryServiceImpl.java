package com.niit.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.org.bean.Category;
import com.niit.org.mapper.CategoryMapper;
import com.niit.org.service.CategoryService;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{

	@Resource 
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> getCategoryList() {
		return categoryMapper.getCategoryList();
	}

}
