package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.dao.ShopDao;
import vCampus.server.dao.ShopDaoImpl;
import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;

public class ShopServiceDaoImpl implements ShopServiceDao{
	
	private ShopDao sd = new ShopDaoImpl();
	
	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID) {
		// TODO Auto-generated method stub
		if(sd.queryAccountCurrentByProductID(productID) != null) {
			return sd.queryAccountCurrentByProductID(productID);
		}
		return null;
	}
	
	
	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByUserName(String userName) {
		// TODO Auto-generated method stub
		if(sd.queryAccountCurrentByUserName(userName) != null) {
			return sd.queryAccountCurrentByUserName(userName);
		}
		return null;
	}
	
	
	@Override
	public ArrayList<ProductInformation> queryAllProduct() {
		// TODO Auto-generated method stub
		if(sd.queryAllProduct() != null) {
			return sd.queryAllProduct();
		}
		return null;
	}
	
	
	
	@Override
	public ProductInformation queryProductInformation(String productID) {
		// TODO Auto-generated method stub
		if(sd.queryProductInformation(productID) != null) {
			return sd.queryProductInformation(productID);
		}
		return null;
	}
	
	
	@Override
	public boolean buyProduct(ProductPurchase buyProduct, int type)
			throws RecordNotFoundException, OutOfLimitException {
		// TODO Auto-generated method stub
		try {
			if(sd.buyProduct(buyProduct, type)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		return false;
	}
	
	
	@Override
	public boolean addProductByAdmin(ProductInformation product) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(sd.addProductByAdmin(product)) {
				return true;
			}
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return false;
	}
	
	
	
	@Override
	public boolean updateProductByAdmin(ProductInformation product) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(sd.updateProductByAdmin(product)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return false;
	}
	
	
	@Override
	public boolean deleteProductByAdmin(String productID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(sd.deleteProductByAdmin(productID)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
}
