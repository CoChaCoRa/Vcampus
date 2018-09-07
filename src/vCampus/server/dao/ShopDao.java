
import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;
import vCampus.server.exception.*;
import java.util.ArrayList;

public interface ShopDao {	
	/**
	 * @param String
	 * @param ProductInformation
	 * @param ProductPurchase
	 * @return
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 */
	public ArrayList<ProductPurchase> queryAccountCurrentByUserName(String userName);
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID);
	public ProductInformation queryProductInformation(String productID);
	public ArrayList<ProductInformation> queryAllProduct();
	public boolean buyProduct(ProductPurchase buyProduct,int type)//type 0 student 1 teacher
			throws RecordNotFoundException,OutOfLimitException;
	public boolean addProductByAdmin(ProductInformation product)throws RecordAlreadyExistException;
	public boolean updateProductByAdmin(ProductInformation product)throws RecordNotFoundException;
	public boolean deleteProductByAdmin(String productID)throws RecordNotFoundException;
}

