package store.issue;

import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;

public class StoreIssueAction extends ActionSupport{

	private static final long serialVersionUID = 2288434014394168745L;
	
	private Map<Integer,String> mapcompany = new TreeMap<Integer,String>();  
	private Map<Integer,String> mapgeneric = new TreeMap<Integer,String>(); 
	private Map<Integer,String> mapmedicine = new TreeMap<Integer,String>();
	private long issueno; 
	
	
	public String execute()
	{		
		StoreIssueDAO sDAO = new StoreIssueDAO();
		//mapcompany = sDAO.getAllCompany();
		mapgeneric = sDAO.getAllGeneric();
		mapmedicine = sDAO.getAllMedicine();
		//issueno =sDAO.getMaxReceiveNo();
		return "success";
	}



	public Map<Integer, String> getMapcompany() {
		return mapcompany;
	}
	public void setMapcompany(Map<Integer, String> mapcompany) {
		this.mapcompany = mapcompany;
	}
	public Map<Integer, String> getMapgeneric() {
		return mapgeneric;
	}
	public void setMapgeneric(Map<Integer, String> mapgeneric) {
		this.mapgeneric = mapgeneric;
	}
	public Map<Integer, String> getMapmedicine() {
		return mapmedicine;
	}
	public void setMapmedicine(Map<Integer, String> mapmedicine) {
		this.mapmedicine = mapmedicine;
	}

	public long getIssueno() {
		return issueno;
	}

	public void setIssueno(long issueno) {
		this.issueno = issueno;
	}
	
	
}
