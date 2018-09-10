package vCampus.biz.clent;

import com.hxtt.c.o;

import vCampus.client.biz.ShopService;
import vCampus.client.biz.ShopServiceImpl;
import vCampus.server.biz.ShopServiceDao;
import vCampus.server.biz.ShopServiceDaoImpl;
import vCampus.server.dao.ShopDao;
import vCampus.server.dao.ShopDaoImpl;
import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;

public class TestShopService {

	//test for shop service
	
	
	
	
	public static void main(String[] args) {
		
		ShopService shopService = new ShopServiceImpl(1, "213160821");
		
		//test on userQueryAccountCurrentByProductID
		
		System.out.println("test on userQueryAccountCurrentByProductID : ");
		if(shopService.queryAccountCurrentByProductID("2") != null) {
			System.out.println(shopService.queryAccountCurrentByProductID("2").get(0).getProductName());
		}
		
		//test on queryAccountCurrentByProductID
		
		System.out.println("test on queryAccountCurrentByUserName : ");
		if(shopService.queryAccountCurrentByUserName("213160821") != null) {
			System.out.println(shopService.queryAccountCurrentByUserName("213160821").size());
		}
	//	ShopDao sd = new ShopDaoImpl();
	//	System.out.println(sd.queryAccountCurrentByUserName("213160821").size());
		
	//	shopService.queryAccountCurrentByUserName("213160821");
	//	ShopServiceDao shopServiceDao = new ShopServiceDaoImpl();
	//	System.out.println(shopServiceDao.queryAccountCurrentByUserName("213160821").size());
		
		//test on queryAllCourses
		
		System.out.println("test on queryAllCourses : ");
		if(shopService.queryAllProduct() != null) {
			System.out.println(shopService.queryAllProduct().size());
		}
		
		
		//test on userQueryProductInformation
		System.out.println("test on userQueryProductInformation : ");
		if(shopService.queryProductInformation("2") != null) {
			System.out.println(shopService.queryProductInformation("2").getProductName());
			System.out.println(shopService.queryProductInformation("2").getProductPrice());

		}
		
		
		
		//test buy product
		System.out.println("test buy product : ");
		ProductPurchase buyProduct = new ProductPurchase();
		buyProduct.setProductID("5");
		buyProduct.setPurchaseAmount(1);
		buyProduct.setUserName("213161269");
		if(shopService.buyProduct(buyProduct, 0)) {
			System.out.println("buy ok!");
		}
		System.out.println(shopService.getExceptionCodes());
		
		
		
		//test admin add product
		System.out.println("test admin add product : ");
		ProductInformation newProduct = new ProductInformation();
		newProduct.setProductID("10");
		newProduct.setProductName("ham");
		newProduct.setAmount(30);
		newProduct.setProductPrice(2.5);
		if(shopService.addProductByAdmin(newProduct)) {
			System.out.println("add item ok!");
		}
		
		
		
		//test admin update product
		System.out.println("test admin update product : ");
		ProductInformation updatedProduct = new ProductInformation();
		updatedProduct.setProductID("10");
		updatedProduct.setProductName("ham");
		updatedProduct.setAmount(30);
		updatedProduct.setProductPrice(1.5);
		if(shopService.updateProductByAdmin(updatedProduct)) {
			System.out.println("update item ok!");
		}
		
		
		//test admin delete product
		System.out.println("test admin delete product : ");
		if(shopService.deleteProductByAdmin("10")) {
			System.out.println("delete item ok !");
		}
		System.out.println(shopService.getExceptionCodes());
		
	}
}
