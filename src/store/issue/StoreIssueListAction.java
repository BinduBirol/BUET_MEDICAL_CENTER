package store.issue;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class StoreIssueListAction extends ActionSupport{

	private static final long serialVersionUID = 6723161103674655394L;
	
	private List<StoreIssue> sdList=new ArrayList<StoreIssue>();
	
	
	public String execute()
	{
		
		StoreIssueDAO sDAO= new StoreIssueDAO();
		sdList=sDAO.getIssueSummaryList();
		
		return "success";		
	}


	public List<StoreIssue> getSdList() {
		return sdList;
	}


	public void setSdList(List<StoreIssue> sdList) {
		this.sdList = sdList;
	}

	
		
	
}
