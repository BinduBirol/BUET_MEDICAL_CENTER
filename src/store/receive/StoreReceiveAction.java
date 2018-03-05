package store.receive;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;


public class StoreReceiveAction extends ActionSupport{

	private static final long serialVersionUID = 2288434014394168745L;
	private Map<Integer,String> mapcompany = new TreeMap<Integer,String>();  
	private Map<Integer,String> mapgeneric = new TreeMap<Integer,String>(); 
	private Map<Integer,String> mapmedicine = new TreeMap<Integer,String>();
	private Map<Integer,String> maplotno = new TreeMap<Integer,String>();
	private long receiveno; 
	
	
	public String execute()
	{
		
		StoreReceiveDAO sDAO = new StoreReceiveDAO();
		mapcompany = sDAO.getAllCompany();
		mapgeneric = sDAO.getAllGeneric();
		mapmedicine = sDAO.getAllMedicine();
		receiveno =sDAO.getMaxReceiveNo();
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
	public long getReceiveno() {
		return receiveno;
	}
	public void setReceiveno(long receiveno) {
		this.receiveno = receiveno;
	}

	public Map<Integer, String> getMaplotno() {
		return maplotno;
	}

	public void setMaplotno(Map<Integer, String> maplotno) {
		this.maplotno = maplotno;
	}
	
}
