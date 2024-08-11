package vn.devpro.javaweb29cuoikhoa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb29cuoikhoa.model.SaleOrder;

@Service
public class SaleOrderService extends BaseService<SaleOrder> {
	@Override
	public Class<SaleOrder> clazz() {
		return SaleOrder.class;
	}
	
	@Transactional
	public SaleOrder saveOrder(SaleOrder saleOrder) {
		return super.saveOrUpdate(saleOrder);
	}
	
	public List<SaleOrder> findAllActive(){
		String sql = "SELECT*FROM tbl_sale_order WHERE status=1";
		return super.executeNativeSql(sql);
	}
}
