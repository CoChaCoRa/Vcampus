package vCampus.server.dao;

import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import vCampus.server.dao.DBConnection;
import vCampus.server.dao.ShopDao;
import vCampus.server.exception.*;
import vCampus.vo.*;


/**
 * @author YangHangyuan
 *
 */
public class ShopDaoImpl implements ShopDao{

	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private ArrayList<ProductPurchase> ResultSetToProductPurchaseArrayList(){
		try {
			 ArrayList<ProductPurchase> list=new ArrayList<ProductPurchase>();
			 
			 do {
				 ProductPurchase pp;
				 pp=new ProductPurchase();
				 pp.setCurrentAccount(rs.getDouble("currentAccount"));
				 pp.setOneConsumption(rs.getDouble("oneConsumption"));
				 pp.setProductID(rs.getString("productID"));
				 pp.setProductName(rs.getString("productName"));
				 pp.setPurchaseAmount(rs.getInt("purchaseAmount"));
				 pp.setPurchaseTime(rs.getDate("purchaseTime"));
				 pp.setUserName(rs.getString("userName"));
				 
				 list.add(pp);
			 }while(rs.next());
			 
			 return list;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	private ArrayList<ProductInformation> ResultSetToProductInformationArrayList(){
		try {
			ArrayList<ProductInformation> list=new ArrayList<ProductInformation>();
			
			do {
				ProductInformation pi;
				pi=new ProductInformation();
				pi.setAmount(rs.getInt("amount"));
				pi.setProductID(rs.getString("productID"));
				pi.setProductName(rs.getString("productName"));
				pi.setProductPrice(rs.getDouble("productPrice"));
				
				list.add(pi);
			}while(rs.next());
			
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	private ProductInformation ResultSetToProductInformation() {
		try {
			ProductInformation pi;
			pi=new ProductInformation();
			pi.setAmount(rs.getInt("amount"));
			pi.setProductID(rs.getString("productID"));
			pi.setProductName(rs.getString("productName"));
			pi.setProductPrice(rs.getDouble("productPrice"));
			return pi;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByUserName(String userName) {
		try {
			String sql1="SELECT * FROM tbl_productpurchase WHERE userName='"+userName+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToProductPurchaseArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID) {
		try {
			String sql1="SELECT * FROM tbl_productpurchase WHERE productID='"+productID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToProductPurchaseArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductInformation queryProductInformation(String productID) {
		try {
			String sql1="SELECT * FROM tbl_productinformation WHERE productID='"+productID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToProductInformation();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ProductInformation> queryAllProduct() {
		try {
			String sql1="SELECT * FROM tbl_productinformation";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToProductInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/* ProductPurchase 中的oneConsumpTion\currentAccount\purchaseTime为后台计算得出
	 * 
	 * */
	@Override
	public boolean buyProduct(ProductPurchase buyProduct,int type) 
			throws RecordNotFoundException, OutOfLimitException {
		try {
			String table=new String(type==0?"tbl_student":"tbl_teacher");
			String sql1="SELECT * FROM tbl_productinformation WHERE productID='"
					+buyProduct.getProductID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			int amount=rs.getInt("amount");
			double price=rs.getDouble("productPrice");
			if(amount<buyProduct.getPurchaseAmount()) {
				OutOfLimitException e=new OutOfLimitException();
				e.setMsg("Amount is out of limit!");
				throw e;
			}
			amount-=buyProduct.getPurchaseAmount();
			
			String sql2="SELECT * FROM "+table+" WHERE userName='"+buyProduct.getUserName()+"'";
			stmt=DBC.con.prepareStatement(sql2);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			
			buyProduct.setOneConsumption(buyProduct.getPurchaseAmount()*price);
			double money=rs.getDouble("money");
			if(money<buyProduct.getOneConsumption()){
				OutOfLimitException e=new OutOfLimitException();
				e.setMsg("Balance in Ecard is insufficient!");
				throw e;
			}
			money-=buyProduct.getOneConsumption();
			
			//UPDATE tbl_productpurchase
			String sql="INSERT INTO tbl_productpurchase (productID,productName,purchaseAmount,"
						+"userName,purchaseTime,oneConsumption,currentAccount) VALUES (?,?,?,?,?,?,?)";
		    Date ts = new Date(System.currentTimeMillis());
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,buyProduct.getProductID());
			stmt.setString(2,buyProduct.getProductName());
			stmt.setInt(3,buyProduct.getPurchaseAmount());
			stmt.setString(4,buyProduct.getUserName());
			stmt.setDate(5,ts);
			stmt.setDouble(6, buyProduct.getOneConsumption());
			stmt.setDouble(7, money);
			stmt.executeUpdate();
			
			//UPDATE tbl_productinformation
			if(amount==0) {
				String sqll="DELETE FROM tbl_productinformation WHERE productID='"
						+buyProduct.getProductID()+"'";
				stmt=DBC.con.prepareStatement(sqll);
				stmt.executeUpdate();
			}else {
				String sqll="UPDATE tbl_productinformation SET amount=? WHERE productID=?";
				stmt=DBC.con.prepareStatement(sqll);
				stmt.setInt(1,amount);
				stmt.setString(2,buyProduct.getProductID());
				stmt.executeUpdate();
			}
			
			//UPDATE table
			String sqlll="UPDATE "+table+" SET money=? WHERE userName=?";
			stmt=DBC.con.prepareStatement(sqlll);
			stmt.setDouble(1, money);
			stmt.setString(2, buyProduct.getUserName());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean addProductByAdmin(ProductInformation product) throws RecordAlreadyExistException {
		try {
			String sql1="SELECT * FROM tbl_productinformation WHERE productID='"
					+product.getProductID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next())throw new RecordAlreadyExistException();
			
			String sql="INSERT INTO tbl_productinformation (productID,productName,productPrice,amount)"
					+" VALUES (?,?,?,?)";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, product.getProductID());
			stmt.setString(2, product.getProductName());
			stmt.setDouble(3, product.getProductPrice());
			stmt.setInt(4, product.getAmount());
			stmt.executeUpdate();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateProductByAdmin(ProductInformation product) throws RecordNotFoundException {
		try {
			String sql1="SELECT * FROM tbl_productinformation WHERE productID='"
					+product.getProductID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			
			//UPDATE tbl_productinformation
			String sql="UPDATE tbl_productinformation SET productName=?,productPrice=?,amount=?"
					+" WHERE productID=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, product.getProductName());
			stmt.setDouble(2, product.getProductPrice());
			stmt.setInt(3, product.getAmount());
			stmt.setString(4, product.getProductID());
			stmt.executeUpdate();
			
			//UPDATE tbl_productpurchase
			String sqll="UPDATE tbl_productpurchase SET productName=?"
					+" WHERE productID=?";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductID());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteProductByAdmin(String productID) throws RecordNotFoundException {
		try {
			String sql1="SELECT * FROM tbl_productinformation WHERE productID='"
					+productID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			
			//UPDATE tbl_productinformation
			String sql="DELETE FROM tbl_productinformation WHERE productID='"
					+productID+"'";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();

			//NOT TO UPDATE tbl_productpurchase
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
