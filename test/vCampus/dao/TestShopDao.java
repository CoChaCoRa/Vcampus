package vCampus.dao;

import java.util.ArrayList;

import vCampus.server.dao.ShopDao;
import vCampus.server.dao.ShopDaoImpl;
import java.sql.Date;
import vCampus.server.exception.*;
import vCampus.vo.*;

public class TestShopDao {
	private static ShopDao shopImpl=new ShopDaoImpl();
	
	/*
	public ArrayList<ProductPurchase> queryAccountCurrentByUserName(String userName);
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID);
	public ProductInformation queryProductInformation(String productID);
	public ArrayList<ProductInformation> queryAllProduct();
	public boolean buyProduct(ProductPurchase buyProduct,int type)//type 0 student 1 teacher
			throws RecordNotFoundException,OutOfLimitException;
	public boolean addProductByAdmin(ProductInformation product)throws RecordAlreadyExistException;
	public boolean updateProductByAdmin(ProductInformation product)throws RecordNotFoundException;
	public boolean deleteProductByAdmin(String productID)throws RecordNotFoundException;
	*/

	private static void queryAccountCurrentByUserName(String userName){
		ArrayList<ProductPurchase> list=new ArrayList<ProductPurchase>();
		list=shopImpl.queryAccountCurrentByUserName(userName);
		if(list==null) {
			System.out.println("NULL!\n");
			return;
		}
		for(int i=0;i<list.size();i++)
			System.out.println(Integer.toString(i)+":  "+list.get(i));
	}
	private static void queryAccountCurrentByProductID(String productID){
		ArrayList<ProductPurchase> list=new ArrayList<ProductPurchase>();
		list=shopImpl.queryAccountCurrentByProductID(productID);
		if(list==null) {
			System.out.println("NULL!\n");
			return;
		}
		for(int i=0;i<list.size();i++)
			System.out.println(Integer.toString(i)+":  "+list.get(i));
	}
	private static void queryProductInformation(String productID) {
		ProductInformation product=shopImpl.queryProductInformation(productID);
		if(product==null) {
			System.out.println("NULL!\n");
			return;
		}
		System.out.println(product);
	}
	private static void queryAllProduct() {
		ArrayList<ProductInformation> list=new ArrayList<ProductInformation>();
		list=shopImpl.queryAllProduct();
		if(list==null) {
			System.out.println("NULL!\n");
			return;
		}
		for(int i=0;i<list.size();i++)
			System.out.println(Integer.toString(i)+":  "+list.get(i));
	}
	
	private static boolean buyProduct(ProductPurchase buyProduct,int type)throws Exception{
		return shopImpl.buyProduct(buyProduct, type);
	}
	
	private static boolean addProductByAdmin(ProductInformation product)throws Exception{
		return shopImpl.addProductByAdmin(product);
	}
	
	private static boolean updateProductByAdmin(ProductInformation product)throws Exception{
		return shopImpl.updateProductByAdmin(product);
	}
	
	private static boolean deleteProductByAdmin(String productID)throws Exception{
		return shopImpl.deleteProductByAdmin(productID);
	}
	
	
	public static void main(String[] args) {
		try {
			queryAccountCurrentByUserName("213161269");
			queryAccountCurrentByProductID("1");
			queryAccountCurrentByProductID("2");
			queryProductInformation("3");
			queryAllProduct();
			
			ProductPurchase buyProduct=new ProductPurchase();
			buyProduct.setProductID("1");
			buyProduct.setProductName("ball");
			buyProduct.setPurchaseAmount(1);
			buyProduct.setUserName("213161269");
			
			if(buyProduct(buyProduct,0)) {
				queryAccountCurrentByUserName("213161269");
			}else System.out.println("Error!");
			
			ProductInformation product=new ProductInformation();
			product.setAmount(2);
			product.setProductID("7");
			product.setProductName("ball2");
			product.setProductPrice(608.8);
			if(addProductByAdmin(product)) {
				queryProductInformation("7");
			}else System.out.println("Error!");

			product.setAmount(12);
			product.setProductID("1");
			product.setProductName("aaaaa");
			product.setProductPrice(12.8);
			if(updateProductByAdmin(product)) {
				queryProductInformation("1");
			}else System.out.println("Error!");
			
			if(deleteProductByAdmin("1")){
				queryProductInformation("1");
			}else System.out.println("Error!");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
