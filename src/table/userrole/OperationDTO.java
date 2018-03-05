package table.userrole;

public class OperationDTO
{
	private int operationid;
	private String operationname;
	private String operationdesc;
	private String link;
	public int getOperationid()
	{
		return operationid;
	}
	public void setOperationid(int operationid)
	{
		this.operationid = operationid;
	}
	public String getOperationname()
	{
		return operationname;
	}
	public void setOperationname(String operationname)
	{
		this.operationname = operationname;
	}
	public String getOperationdesc()
	{
		return operationdesc;
	}
	public void setOperationdesc(String operationdesc)
	{
		this.operationdesc = operationdesc;
	}
	public String getLink()
	{
		return link;
	}
	public void setLink(String link)
	{
		this.link = link;
	}
}
