package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;

public interface ShopService {
	
	String getExceptionCodes();
	
	public ArrayList<ProductPurchase> queryAccountCurrentByUserName(String userName);
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID);
	public ProductInformation queryProductInformation(String productID);
	public ArrayList<ProductInformation> queryAllProduct();
	
	public boolean buyProduct(ProductPurchase buyProduct,int type);//type 0 student 1 teacher
	public boolean addProductByAdmin(ProductInformation product);
	public boolean updateProductByAdmin(ProductInformation product);
	public boolean deleteProductByAdmin(String productID);
}
