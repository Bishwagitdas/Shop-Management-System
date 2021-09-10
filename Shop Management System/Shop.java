
import java.lang.*;

public class Shop
{
	private String ShopId;
	private String itemName;
	private String quantity;
	private double shopItemPrice;
	private String manuDate;
	
	public Shop(){}
	public Shop(String ShopId, String itemName, String quantity, double shopItemPrice, String manuDate)
	{
		this.ShopId = ShopId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.shopItemPrice = shopItemPrice;
		this.manuDate = manuDate;
	}
	
	public void setShopId(String ShopId){
		this.ShopId = ShopId;
	}
	public void setitemName(String itemName){
		this.itemName = itemName;
	}
	public void setquantity(String quantity){
		this.quantity = quantity;
	}
	public void setshopItemPrice(double shopItemPrice){
		this.shopItemPrice = shopItemPrice;
	}
	public void setmanuDate(String manuDate){
		this.manuDate = manuDate;
	}

	
	public String getShopId(){
		return this.ShopId;
	}
	public String getitemName(){
		return this.itemName;
	}
	public String getquantity(){
		return this.quantity;
	}
	public double getshopItemPrice(){
		return this.shopItemPrice;
	}
	public String getmanuDate(){
		return this.manuDate;
	}
}