package store.issue;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

public class StoreIssuePDFAction extends ActionSupport implements ServletContextAware{

	private static final long serialVersionUID = 2236633757082409893L;
	private ServletContext servlet;
	private Long issueno;
	private String issuedate;
	private String remarks;
	private ArrayList<StoreIssueDetail> sdList= new ArrayList<StoreIssueDetail>();
	
	
	public String execute() throws Exception
	{
		issueno = Long.parseLong((String) ServletActionContext.getRequest().getParameter("issueno"));
		StoreIssueDAO sDAO= new StoreIssueDAO();
		sdList= sDAO.getStoreIssueDetail(issueno);
		
		if(sdList!=null)
		{
			Font font14Normal = new Font(Font.TIMES_ROMAN, 14, Font.NORMAL);
			Font font10Normal = new Font(Font.TIMES_ROMAN,10, Font.NORMAL);
			Font font8Normal = new Font(Font.TIMES_ROMAN,8, Font.NORMAL);				
			Font font12Normal = new Font(Font.TIMES_ROMAN,12, Font.NORMAL);
			Font font10Bold = new Font(Font.TIMES_ROMAN,10, Font.BOLD);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			
			String fileName="StoreIssue.pdf";
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ServletOutputStream out = response.getOutputStream();		
			
			Document document = new Document(PageSize.A4);
			document.setMargins(40, 40, 20, 20);
			document.addHeader("MCENTER Report", "");
			
			PdfPTable ptable = null;
			PdfPCell pcell=null;
			
			try {
				
				PdfWriter writer = PdfWriter.getInstance(document, out);
				VoucherEndPageEvent1 eEvent = new VoucherEndPageEvent1(servlet);
				String realPath = servlet.getRealPath("/resources/images/blogo.gif");					
				//writer.setPageEvent(eEvent);
						
				PdfWriter.getInstance(document, baos).setPageEvent(eEvent);
				document.open();
			
				ptable = new PdfPTable(5);
				ptable.setWidthPercentage(96);			
				ptable.setWidths(new float[]{14f,5f,90f,5f,15f});	
				
				pcell= new PdfPCell();
				Image gif = Image.getInstance(realPath);
				gif.scaleAbsolute(60, 60); 
				gif.setAlignment(Image.LEFT);
				pcell.addElement(gif);
				pcell.setBorderColor(Color.WHITE);
				ptable.addCell(pcell);					
			
				pcell= new PdfPCell();
				pcell.setColspan(4);
			
				String header = "" +
				"Bangladesh University of Engineering and Techonology (BUET), Dhaka\n" +
				"Medical Center Main Store";	
				
				Paragraph pg = new Paragraph(header, new Font(Font.TIMES_ROMAN, 12, Font.BOLD));
				pg.setAlignment(Element.ALIGN_CENTER);
				pg.setLeading(12);// Line Spacing					
				pcell.addElement(pg);
				pcell.setBorderColor(Color.WHITE); //Table Border
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				ptable.addCell(pcell);
				document.add(ptable);
				
				ptable = new PdfPTable(4);
				ptable.setWidthPercentage(96);			
				ptable.setWidths(new float[]{15f,40f,15f,35f});					
				
				pcell = new PdfPCell(new Paragraph("Issue No:", font10Bold));
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_TOP);
				pcell.setBorderColor(Color.WHITE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph( issueno.toString(), font10Normal));
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_TOP);
				pcell.setBorderColor(Color.WHITE);
				ptable.addCell(pcell);	
				
								
				
				pcell = new PdfPCell(new Paragraph("Issue Date :",font10Bold));
				pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pcell.setVerticalAlignment(Element.ALIGN_TOP);
				pcell.setBorderColor(Color.WHITE);					
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(issuedate,font10Normal));
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_TOP);
				pcell.setBorderColor(Color.WHITE);					
				ptable.addCell(pcell);		
				
				
				pcell = new PdfPCell(new Paragraph("Remarks :",font10Bold));
				pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pcell.setVerticalAlignment(Element.ALIGN_TOP);
				pcell.setBorderColor(Color.WHITE);					
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(remarks,font10Normal));
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_TOP);
				pcell.setBorderColor(Color.WHITE);	
				//pcell.setColspan(2);
				ptable.addCell(pcell);
				
				
				
				pcell = new PdfPCell(new Paragraph("",font10Normal));
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pcell.setBorderColor(Color.WHITE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph("",font10Normal));
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pcell.setBorderColor(Color.WHITE);					
				ptable.addCell(pcell);				
				
				
				
				document.add(ptable);
				
				
				ptable = new PdfPTable(4);
				ptable.setWidthPercentage(100);
				ptable.setWidths(new float[]{35,35,15,15});
				
				
				pcell = new PdfPCell(new Paragraph("Generic Name",font10Bold));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				
				pcell = new PdfPCell(new Paragraph("Medicine",font10Bold));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
							
				
				pcell = new PdfPCell(new Paragraph("Issue Quantity",font10Bold));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				
				pcell = new PdfPCell(new Paragraph("Unit Price",font10Bold));
				pcell.setMinimumHeight(16f);
				pcell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				StoreIssueDetail stdt = new StoreIssueDetail();
				
				for(int i=0;i<sdList.size();i++)
				{
					stdt = sdList.get(i);
										
					pcell = new PdfPCell(new Paragraph(stdt.getGenname() ,font10Normal));
					pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
					pcell.setVerticalAlignment(Element.ALIGN_TOP);								
					ptable.addCell(pcell);	
					
					pcell = new PdfPCell(new Paragraph(stdt.getMedname() ,font10Normal));
					pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
					pcell.setVerticalAlignment(Element.ALIGN_TOP);								
					ptable.addCell(pcell);	
					
					pcell = new PdfPCell(new Paragraph(stdt.getIssueqty().toString() ,font10Normal));
					pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
					pcell.setVerticalAlignment(Element.ALIGN_TOP);								
					ptable.addCell(pcell);	
					
					pcell = new PdfPCell(new Paragraph(sDAO.formatCurrency(stdt.getUnitprice()) ,font10Normal));
					pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
					pcell.setVerticalAlignment(Element.ALIGN_TOP);								
					ptable.addCell(pcell);	
						
				}
				
				document.add(ptable);
				document.close();		
				response.setHeader("Content-Disposition", "attachment;filename="+fileName);
				response.setContentType("application/pdf");
				out.write(baos.toByteArray());
				out.flush();
				document=null;				
				
					
				
				
				
			}catch(Exception e){e.printStackTrace();}
						
				
		}
		
		
		return null;
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


	public ArrayList<StoreIssueDetail> getSdList() {
		return sdList;
	}

	public void setSdList(ArrayList<StoreIssueDetail> sdList) {
		this.sdList = sdList;
	}

	public ServletContext getServlet() {
		return servlet;
	}
	
	public void setServletContext(ServletContext servlet) {
		this.servlet = servlet;
	}

}

		
	class VoucherEndPageEvent1 extends PdfPageEventHelper
	{

		protected ServletContext serv = null;

		protected PdfTemplate total;
		protected BaseFont helv;
		protected PdfPTable footer;
		
		public VoucherEndPageEvent1(ServletContext servlet) {
			serv = servlet;
			
		}

		public void onOpenDocument(PdfWriter writer, Document document) {
			total = writer.getDirectContent().createTemplate(100, 100);
			total.setBoundingBox(new Rectangle(-20, -20, 100, 100));
			
			try {
				helv = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.WINANSI,
						BaseFont.NOT_EMBEDDED);
			} catch (Exception e) {
				throw new ExceptionConverter(e);
			}
		}

		public void onEndPage(PdfWriter writer, Document document) {

		}
		
		public void onStartPage(PdfWriter writer, Document document) {
			String realPath = serv.getRealPath("/resources/images/blogo.gif");
			try{
				Paragraph pg = null;


			}
			catch(Exception ex){

			}
		}	

	}	