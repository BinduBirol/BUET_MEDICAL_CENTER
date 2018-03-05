package store.receive;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.ServletActionContext;

import table.userrole.UserRoleDTO;
import util.login.ValidateUser;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StoreReceiveEditAction extends ActionSupport{

	private static final long serialVersionUID = 823814428603139413L;
	private Map<Integer,String> mapcompany = new TreeMap<Integer,String>();  
	private Map<Integer,String> mapgeneric = new TreeMap<Integer,String>(); 
	private Map<Integer,String> mapmedicine = new TreeMap<Integer,String>();
	private Long receiveno;
	private String receivedate;
	private String lotnumber;
	private String billno;
	private String billdate;
	private String remarks;
	private ArrayList<StoreReceiveDetail> sdList= new ArrayList<StoreReceiveDetail>();
	
	public String execute() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
		
		
		receiveno = Long.parseLong((String) ServletActionContext.getRequest().getParameter("receiveno"));
		StoreReceiveDAO sDAO = new StoreReceiveDAO();		
		StoreReceive sd = new StoreReceive();
		mapcompany = sDAO.getAllCompany();
		mapgeneric = sDAO.getAllGeneric();
		mapmedicine = sDAO.getAllMedicine();
		
		sd = sDAO.getReceiveSummary(receiveno);
		sdList= sDAO.getStoreDetail(receiveno);
		receivedate=sd.getReceivedate();
		lotnumber=sd.getLotnumber();
		billno=sd.getBillno();
		billdate=sd.getBilldate();
		remarks=sd.getRemarks();		
		
		
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


	public Long getReceiveno() {
		return receiveno;
	}


	public void setReceiveno(Long receiveno) {
		this.receiveno = receiveno;
	}


	public String getReceivedate() {
		return receivedate;
	}


	public void setReceivedate(String receivedate) {
		this.receivedate = receivedate;
	}


	public String getLotnumber() {
		return lotnumber;
	}


	public void setLotnumber(String lotnumber) {
		this.lotnumber = lotnumber;
	}


	public String getBillno() {
		return billno;
	}


	public void setBillno(String billno) {
		this.billno = billno;
	}


	public String getBilldate() {
		return billdate;
	}


	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public ArrayList<StoreReceiveDetail> getSdList() {
		return sdList;
	}


	public void setSdList(ArrayList<StoreReceiveDetail> sdList) {
		this.sdList = sdList;
	}
	
	

}
