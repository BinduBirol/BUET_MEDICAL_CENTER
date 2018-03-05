package store.receive;

import java.util.ArrayList;
import java.util.Map;

import table.userrole.UserRoleDTO;
import util.login.ValidateUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StoreReceiveSave extends ActionSupport{

	private static final long serialVersionUID = 98175423645678854L;
	private Long receiveno;
	private String receivedate;
	private String lotnumber;
	private String billno;
	private String billdate;
	private String remarks;
	private String expireDate[];
	
	private Long[] medid;
	private double[] unitprice;
	private Long[] receiveqty;
	private Long[] companyid;
	private Long[] genid;
	private ArrayList<StoreReceiveDetail> sdList= new ArrayList<StoreReceiveDetail>();
	
	public String execute() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
		
		StoreReceiveDAO sDAO= new StoreReceiveDAO();
		
		if(sDAO.insertReceive(receiveno, receivedate, billno, billdate, lotnumber, remarks, companyid, genid, medid,expireDate, receiveqty, unitprice))
		{
			
			sdList= sDAO.getStoreDetail(receiveno);
			
			
			return "success";
		}
		
		
		return "success";	
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

	public Long[] getMedid() {
		return medid;
	}

	public void setMedid(Long[] medid) {
		this.medid = medid;
	}

	
	public String[] getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String[] expireDate) {
		this.expireDate = expireDate;
	}

	public double[] getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double[] unitprice) {
		this.unitprice = unitprice;
	}

	public Long[] getReceiveqty() {
		return receiveqty;
	}

	public void setReceiveqty(Long[] receiveqty) {
		this.receiveqty = receiveqty;
	}

	public Long[] getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long[] companyid) {
		this.companyid = companyid;
	}

	public Long[] getGenid() {
		return genid;
	}

	public void setGenid(Long[] genid) {
		this.genid = genid;
	}

	public ArrayList<StoreReceiveDetail> getSdList() {
		return sdList;
	}

	public void setSdList(ArrayList<StoreReceiveDetail> sdList) {
		this.sdList = sdList;
	}
	
	
}
