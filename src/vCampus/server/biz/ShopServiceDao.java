package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;

public interface ShopServiceDao {
	/**
	 * 传入userName参数,返回ArrayList<ProductPurchase>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<ProductPurchase>
	 */
	public ArrayList<ProductPurchase> queryAccountCurrentByUserName(String userName);
	
	/**
	 *传入productID参数,返回ArrayList<ProductPurchase>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<ProductPurchase>
	 */
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID);
	
	/**
	 *传入productID参数,返回ProductInformation对象,未查询成功将返回null
	 * @param String
	 * @return ProductInformation
	 */
	public ProductInformation queryProductInformation(String productID);
	
	/**
	 * 无传入参数,返回ArrayList<ProductInformation>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<ProductInformation>
	 */
	public ArrayList<ProductInformation> queryAllProduct();
	
    /**
	 * 传入buyProduct以及type 0代表学生 1代表老师,SQL异常返回false
	 * 若商品不存在/商品数量不足或者余额不足(用uMsg区分)则抛出异常
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean buyProduct(ProductPurchase buyProduct,int type)//type 0 student 1 teacher
			throws RecordNotFoundException,OutOfLimitException;

	/**
	 * 传入ProductInformation,若包含的商品已经存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean addProductByAdmin(ProductInformation product)throws RecordAlreadyExistException;
	
	/**
	 * 传入ProductInformation,若包含的商品不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updateProductByAdmin(ProductInformation product)throws RecordNotFoundException;
	
    /**
	 * 传入productID,若商品信息不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteProductByAdmin(String productID)throws RecordNotFoundException;
}
