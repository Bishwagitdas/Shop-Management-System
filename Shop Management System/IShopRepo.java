
import java.lang.*;


public interface IShopRepo
{
	public void insertInDB(Shop mt);
	public void deleteFromDB(String ShopId);
	public void updateInDB(Shop mt);
	public Shop searchItem(String ShopId);
	public String[][] getAllMovie();
}