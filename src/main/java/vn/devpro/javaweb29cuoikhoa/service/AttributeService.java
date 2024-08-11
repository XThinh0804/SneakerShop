package vn.devpro.javaweb29cuoikhoa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb29cuoikhoa.model.Attribute;
import vn.devpro.javaweb29cuoikhoa.model.ProductImage;

@Service
public class AttributeService extends BaseService<Attribute>{
	@Override
	public Class<Attribute> clazz(){
		return Attribute.class;
	}
	
	public List<Attribute> findAllActive(){
		String sql = "SELECT*FROM tbl_attribute WHERE status=1";
		return super.executeNativeSql(sql);
	}
	public List<Attribute> getAttributeByProductId(int productId){
		String sql = "SELECT * FROM tbl_attribute WHERE product_id="+productId;
		return super.executeNativeSql(sql);
	}
	@Transactional
	public void deleteCategory(int id) {
		super.deleteById(id);
	}
}
