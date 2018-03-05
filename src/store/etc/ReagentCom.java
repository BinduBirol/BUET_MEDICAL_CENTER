package store.etc;

public class ReagentCom {
	
	private Long reagentid;
	private String reagentname;
	private Long companyid;	
	private String companyname;
	private Long reorder;
	private String unit;
	private String lotnumber;
	private Double unitprice;
	private Long quantity;
	private String expireDate;
	

	public Long getReagentid() {
		return reagentid;
	}
	public void setReagentid(Long reagentid) {
		this.reagentid = reagentid;
	}
	public String getReagentname() {
		return reagentname;
	}
	public void setReagentname(String reagentname) {
		this.reagentname = reagentname;
	}
	public Long getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Long getReorder() {
		return reorder;
	}
	public void setReorder(Long reorder) {
		this.reorder = reorder;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
		
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getLotnumber() {
		return lotnumber;
	}
	public void setLotnumber(String lotnumber) {
		this.lotnumber = lotnumber;
	}
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public ReagentCom() {
		
	}
	
	
	
	
}
