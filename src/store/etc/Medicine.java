package store.etc;

public class Medicine {
	
	private Long medid;
	private String medname;
	private Long companyid;	
	private String companyname;
	private Long genid;
	private String genname;
	private Long reorder;
	private String unit;
	private String lotnumber;
	private Double unitprice;
	private Long quantity;
	private String expireDate;
	
	public Long getMedid() {
		return medid;
	}
	public void setMedid(Long medid) {
		this.medid = medid;
	}
	public String getMedname() {
		return medname;
	}
	public void setMedname(String medname) {
		this.medname = medname;
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
	public Long getGenid() {
		return genid;
	}
	public void setGenid(Long genid) {
		this.genid = genid;
	}
	public String getGenname() {
		return genname;
	}
	public void setGenname(String genname) {
		this.genname = genname;
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
	public Medicine() {
		
	}
	
	
	
	
}
