package vn.devpro.javaweb29cuoikhoa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb29cuoikhoa.model.Category;

@Service
public class CategoryService extends BaseService<Category>{
	
	@Override
	public Class<Category> clazz(){
		return Category.class;
	}
	
	public List<Category> findAllActive(){
		String sql = "SELECT*FROM tbl_category WHERE status=1";
		return super.executeNativeSql(sql);
	}
	
	@Transactional
	public void deleteCategory(int id) {
		super.deleteById(id);
	}
}
