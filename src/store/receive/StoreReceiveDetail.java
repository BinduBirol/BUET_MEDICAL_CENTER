package store.receive;

public class StoreReceiveDetail {
	
	private Long receiveno;
	private String lotnumber;
	private Long medid;
	private String medname;
	private double unitprice;
	private Long receiveqty;
	private Long companyid;
	private String companyname;
	private Long genid;
	private String genname;
	
	
	public Long getReceiveno() {
		return receiveno;
	}
	public void setReceiveno(Long receiveno) {
		this.receiveno = receiveno;
	}
	public String getLotnumber() {
		return lotnumber;
	}
	public void setLotnumber(String lotnumber) {
		this.lotnumber = lotnumber;
	}
	public Long getMedid() {
		return medid;
	}
	public void setMedid(Long medid) {
		this.medid = medid;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public Long getReceiveqty() {
		return receiveqty;
	}
	public void setReceiveqty(Long receiveqty) {
		this.receiveqty = receiveqty;
	}
	public Long getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}
	public Long getGenid() {
		return genid;
	}
	public void setGenid(Long genid) {
		this.genid = genid;
	}
	public String getMedname() {
		return medname;
	}
	public void setMedname(String medname) {
		this.medname = medname;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getGenname() {
		return genname;
	}
	public void setGenname(String genname) {
		this.genname = genname;
	}
	
	

}
