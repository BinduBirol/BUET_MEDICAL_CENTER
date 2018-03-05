package store.issue;

import java.util.ArrayList;
import java.util.Map;

import store.receive.StoreReceiveDAO;
import store.receive.StoreReceiveDetail;
import table.userrole.UserRoleDTO;
import util.login.ValidateUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StoreIssueSave extends ActionSupport{

	private static final long serialVersionUID = 98175423645678854L;
	private Long issueno;
	private String issuedate;
	private String remarks;
	
	private Long[] medid;
	private String expireDate[];
	private double[] unitprice;
	private Long[] issueqty;
	private Long[] stock;
	private Long[] genid;
	private String[] lotnumber;
	private ArrayList<StoreIssueDetail> sdList= new ArrayList<StoreIssueDetail>();
	
	public String execute() throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
		
		StoreIssueDAO sDAO= new StoreIssueDAO();
		
		issueno=sDAO.getMaxIssueNo();
		
		
		if(sDAO.insertIssue(issueno, issuedate, remarks, genid, medid,expireDate, lotnumber, unitprice, stock, issueqty))
		{
			
			sdList= sDAO.getStoreIssueDetail(issueno);
			
			
			return "success";
		}
		
		
		return "success";	
	}

	public Long getIssueno() {
		return issueno;
	}

	public void setIssueno(Long issueno) {
		this.issueno = issueno;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
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

	public Long[] getIssueqty() {
		return issueqty;
	}

	public void setIssueqty(Long[] issueqty) {
		this.issueqty = issueqty;
	}

	public Long[] getStock() {
		return stock;
	}

	public void setStock(Long[] stock) {
		this.stock = stock;
	}

	public Long[] getGenid() {
		return genid;
	}

	public void setGenid(Long[] genid) {
		this.genid = genid;
	}

	public String[] getLotnumber() {
		return lotnumber;
	}

	public void setLotnumber(String[] lotnumber) {
		this.lotnumber = lotnumber;
	}

	public ArrayList<StoreIssueDetail> getSdList() {
		return sdList;
	}

	public void setSdList(ArrayList<StoreIssueDetail> sdList) {
		this.sdList = sdList;
	}
	
		
	
}
