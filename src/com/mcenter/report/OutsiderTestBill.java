package com.mcenter.report;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import table.userrole.UserRoleDTO;
import util.login.ValidateUser;




import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.mcenter.labtestBillManagement.TestBillforOthers;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OutsiderTestBill extends ActionSupport implements ServletContextAware{

	private static final long serialVersionUID = 8818190897989491886L;
	

	private String visitID;
	
	
	 public String getVisitID() {
		return visitID;
	}


	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}
	
	
	
	private ServletContext servlet;
	
	
	public String downtimePdf() throws Exception
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
	
		
		TestBillforOthers  dDAO = new TestBillforOthers();
		dDAO.report(visitID);
		dDAO.getTestBillforOtherslist();
		
		System.out.println(dDAO.getTestBillforOtherslist());
		
		//stophistoo = dDAO.fetchStopHist(ddate, todate, module, shift, machine, sortcol, orderby);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		UserRoleDTO user = (UserRoleDTO) session1.get(ValidateUser.validate_value);
		
		System.out.println(user.getUserfullname());
		
		String fileName="Downtime.pdf";

		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();		
		
		Document document = new Document(PageSize.A4);
		document.setMargins(40, 40, 20, 20);
		document.addHeader("BAT Report", "");
		
		PdfPTable ptable = null;
		PdfPCell pcell=null;
		
		
		try{
			
			String bat ="A@B@C@D@E";
			BatReportEventsh eEvent = new BatReportEventsh(servlet, bat);
			
			Font font1 = new Font(Font.COURIER, 8, Font.BOLD); 
			font1.setColor(new Color(0x92, 0x90, 0x83));
			Font fontt = FontFactory.getFont("Helvetica", 8, Font.NORMAL,Color.BLACK);			
			Font fontb = FontFactory.getFont("Helvetica", 8, Font.BOLD,Color.BLACK);
			Font f10Bold = new Font(Font.TIMES_ROMAN,10,Font.BOLD);
			Font f10Normal = new Font(Font.TIMES_ROMAN,10,Font.NORMAL);
			Font f9Bold = new Font(Font.TIMES_ROMAN,9,Font.BOLD);
			Font f9Normal = new Font(Font.TIMES_ROMAN,9,Font.NORMAL);
			Font f8Normal = new Font(Font.TIMES_ROMAN,8,Font.NORMAL);
			
			
			//eEvent.setDisplayValue("DownTime Details");
			
			PdfWriter.getInstance(document, baos).setPageEvent(eEvent);
			
			
			document.open();
			
			ptable = new PdfPTable(5);
			ptable.setWidthPercentage(100);
			ptable.setWidths(new float[]{40,15,15,15,15});
			
			int i;
			TestBillforOthers  DAO = new TestBillforOthers();
			//StopHistPOO cBean = new StopHistPOO();
			for( i=0;i<dDAO.getTestBillforOtherslist().size();i++)
            {
        	    DAO =dDAO.getTestBillforOtherslist().get(i);//cBean = stophistoo.get(i);
				System.out.println(dDAO.getTestType());
				System.out.println(dDAO.getTestBillforOtherslist().size());
				
				pcell = new PdfPCell(new Paragraph(DAO.getTestType(),f8Normal));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(DAO.getTestName(),f8Normal));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(Double.toString(DAO.getRate()),f8Normal));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				
				pcell = new PdfPCell(new Paragraph(Double.toString(DAO.getVat()),f8Normal));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(Double.toString(DAO.getCost()),f8Normal));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
			}
			
			document.add(ptable);
			document.close();		
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			out.write(baos.toByteArray());
			out.flush();
			document=null;
		
		}catch(Exception e){e.printStackTrace();}
		
		
		
		return null;
	}
	




	public ServletContext getServlet() {
		return servlet;
	}
	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}
	



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	public void setServletContext(ServletContext servlet) {
		this.servlet = servlet;
	}
	
	

}


class BatReportEventsh extends PdfPageEventHelper
{
	protected ServletContext serv =null;
	protected PdfTemplate total;
	protected BaseFont helv;
	protected PdfPTable footer;
	protected String  ddate;
	protected String  todate;
	protected String  module;
	protected String  shift;
	protected String  machine;

	public BatReportEventsh(ServletContext serv, String cBean) {
		
		this.serv = serv;
		String [] str= cBean.split("@");
		this.ddate=str[0];
		this.todate=str[1];
		this.module=str[2];
		this.shift=str[3];
		this.machine=str[4];
	
	}

	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub

		
		
		total = writer.getDirectContent().createTemplate(100, 100);
		total.setBoundingBox(new Rectangle(-20,-20,100,100));
		
		try{
			helv=BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.WINANSI,BaseFont.NOT_EMBEDDED);
		}catch(Exception e){
			throw new ExceptionConverter(e);
		}
		
	}
	
	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub
		
		PdfContentByte cb = writer.getDirectContent();
		footer=new PdfPTable(5);
		footer.setTotalWidth(700);
		footer.setWidthPercentage(100);
		footer.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		//footer.setSpacingBefore(20f);
		
		

		try
		{
			footer.setWidths(new float[] {20,14,30,14,20});
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		PdfPCell pcell=null;
		
		Font f10nornal = new Font(Font.TIMES_ROMAN,10,Font.NORMAL);
		
		pcell=new PdfPCell(new Paragraph(" ",f10nornal));		
		pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
		
		pcell=new PdfPCell(new Paragraph("Page"+document.getPageNumber(),f10nornal));
		pcell.setColspan(3);
		pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
		
		pcell=new PdfPCell(new Paragraph(" ",f10nornal));		
		pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
			
		footer.writeSelectedRows(0, -1, (document.right()-document.left()-560)/2-document.leftMargin(),document.bottom()+4,cb);
		
		
	}
	
	@Override
	public void onStartPage(PdfWriter writer, Document document) {
		String realpath=serv.getRealPath("/resource/img/logo.png");
		try{
			Paragraph pg =null;
			
			
			PdfPTable ptable = new PdfPTable(5);
			ptable.setWidthPercentage(70);
			ptable.setWidths(new float[] {20f,15f,55f,5f,5f });
			
			
			PdfPCell pcell = new PdfPCell();
			
			Image gif = Image.getInstance(realpath);
			gif.scaleAbsolute(50, 50);			
			gif.setAlignment(Image.ALIGN_LEFT);
			pcell.addElement(gif);
			pcell.setPaddingBottom(-4f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);		
			pcell.setBorderColor(Color.WHITE);
			ptable.addCell(pcell);
			
			
			pcell = new PdfPCell();
			String header2="Stop History Analysis\n Date:"+ddate+" To "+todate+", Module:"+module+", Shift:"+shift+", Machine:"+machine;
			
			pg = new Paragraph(header2,new Font(Font.TIMES_ROMAN,10,Font.NORMAL));
			pg.setAlignment(Element.ALIGN_CENTER);
			pg.font().setStyle(Font.UNDERLINE);
			pcell.setColspan(5);
			pcell.addElement(pg);
			pcell.setPaddingBottom(-5f);
			pcell.setBorderColor(Color.WHITE);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			ptable.addCell(pcell);
						
			document.add(ptable);
			
			///Table header
			Font f9Bold = new Font(Font.TIMES_ROMAN,9,Font.BOLD);
			ptable = new PdfPTable(5);
			ptable.setWidthPercentage(100);
			ptable.setWidths(new float[]{40,15,15,15,15});
			
			
			pcell=new PdfPCell(new Paragraph("Message",f9Bold));
			pcell.setMinimumHeight(18f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			ptable.addCell(pcell);
			
			pcell=new PdfPCell(new Paragraph("Frequency",f9Bold));
			pcell.setMinimumHeight(18f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ptable.addCell(pcell);
			
			pcell=new PdfPCell(new Paragraph("Longest",f9Bold));
			pcell.setMinimumHeight(18f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ptable.addCell(pcell);
			
			pcell=new PdfPCell(new Paragraph("Total Time",f9Bold));
			pcell.setMinimumHeight(18f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ptable.addCell(pcell);
			
			pcell=new PdfPCell(new Paragraph("Avg Time",f9Bold));
			pcell.setMinimumHeight(18f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ptable.addCell(pcell);
			
			document.add(ptable);
			///table header end
			
		}catch(Exception ex){
			
		}
		
		
	}
	
	
}
