
import java.lang.*;
import java.util.ArrayList;


public class ShopRepo implements IShopRepo
{
	DatabaseConnection dbc;
	
	public ShopRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Shop mt)
	{
		String query = "INSERT INTO items VALUES (null,'"+mt.getShopId()+"','"+mt.getitemName()+"','"+mt.getquantity()+"',"+mt.getshopItemPrice()+",'"+mt.getmanuDate()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String ShopId)
	{
		String query = "DELETE from items WHERE shopItemId='"+ShopId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	// public void updateInDB(Shop mt)
	// {
	// 	String query = "UPDATE items SET itemName='"+mt.getitemName()+"', quantity = '"+mt.getquantity()+"', itemPrice = "+mt.getshopItemPrice()+", manufacture = '"+mt.getmanuDate()+"' WHERE shopItemId='"+mt.getShopId()+"'";
		
	// 	try
	// 	{
	// 		dbc.openConnection();
	// 		dbc.st.executeUpdate(query);
	// 		dbc.closeConnection();
	// 	}
	// 	catch(Exception ex){System.out.println(ex.getMessage());}
	// }
	public Shop searchItem(String ShopId)
	{
		Shop mt = null;
		String query = "SELECT itemName, quantity, itemPrice, manufacture FROM items WHERE (shopItemId LIKE '"+ShopId+"%');";
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String itemName = dbc.result.getString("itemName");
				String quantity = dbc.result.getString("quantity");
				double shopItemPrice = dbc.result.getDouble("itemPrice");
				String manuDate = dbc.result.getString("manufacture");
				
				mt = new Shop();
				mt.setShopId(ShopId);
				mt.setitemName(itemName);
				mt.setquantity(quantity);
				mt.setshopItemPrice(shopItemPrice);
				mt.setmanuDate(manuDate);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return mt;
	}
	public String[][] getAllMovie()
	{
		ArrayList<Shop> ar = new ArrayList<Shop>();
		String query = "SELECT * FROM items;";
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String ShopId = dbc.result.getString("shopItemId");
				String itemName = dbc.result.getString("itemName");
				String quantity = dbc.result.getString("quantity");
				double shopItemPrice = dbc.result.getDouble("itemPrice");
				String manuDate = dbc.result.getString("manufacture");
				
				Shop mt = new Shop(ShopId,itemName,quantity,shopItemPrice,manuDate);
				ar.add(mt);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Shop)obj[i]).getShopId();
			data[i][1] = ((Shop)obj[i]).getitemName();
			data[i][2] = ((Shop)obj[i]).getquantity();
			data[i][3] = ((Shop)obj[i]).getmanuDate();
			data[i][4] = (((Shop)obj[i]).getshopItemPrice())+"";
		}
		return data;
	}
}












































