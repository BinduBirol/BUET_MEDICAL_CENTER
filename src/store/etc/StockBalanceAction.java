package store.etc;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class StockBalanceAction extends ActionSupport{

	
	private static final long serialVersionUID = 8577857926005559429L;
	private List<Medicine> medicine=new ArrayList<Medicine>();
	
	public String execute()
	{
		String type = (String) ServletActionContext.getRequest().getParameter("type");		
		StockDAO sDAO= new StockDAO();
		
		if(type.equalsIgnoreCase("cstore"))
			medicine=sDAO.getAllMedicineStock();
		else if(type.equalsIgnoreCase("cstoreExpiredMed"))
			medicine=sDAO.getAllExpiredMedicineStock();
		else if(type.equalsIgnoreCase("lstore"))
			medicine=sDAO.getAllMedicineLocalStock();	
		else if(type.equalsIgnoreCase("lstoreExpiredMed"))
			medicine=sDAO.getAllExpiredMedicineLocalStock();
		
		
		
		return type;
	}

	
	
	public List<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
	
	
	
	

}
