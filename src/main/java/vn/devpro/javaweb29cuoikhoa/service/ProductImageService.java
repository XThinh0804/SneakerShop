package vn.devpro.javaweb29cuoikhoa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb29cuoikhoa.model.ProductImage;

@Service
public class ProductImageService extends BaseService<ProductImage>{
	
	@Override
	public Class<ProductImage> clazz() {
		return ProductImage.class;
	}
	
	//Tìm ảnh của product
	public List<ProductImage> getImageByProductId(int productId){
		String sql = "SELECT * FROM tbl_product_image WHERE product_id="+productId;
		return super.executeNativeSql(sql);
	}
}
