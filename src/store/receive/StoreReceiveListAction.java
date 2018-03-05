package store.receive;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class StoreReceiveListAction extends ActionSupport{

	private static final long serialVersionUID = -4339754817778161708L;
	private List<StoreReceive> sdList=new ArrayList<StoreReceive>();
	
	public String execute()
	{
		
		StoreReceiveDAO sDAO= new StoreReceiveDAO();
		sdList=sDAO.getReceiveSummaryList();
		
		return "success";		
	}

	public List<StoreReceive> getSdList() {
		return sdList;
	}

	public void setSdList(List<StoreReceive> sdList) {
		this.sdList = sdList;
	}
	
	
}
