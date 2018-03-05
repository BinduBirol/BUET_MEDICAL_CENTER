package com.prescription;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import table.userrole.UserRoleDTO;
import util.login.ValidateUser;


//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.BaseColor;
import com.lowagie.text.*;


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
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.patient.PatientDAO;
import com.table.PatientDetailDTO;
import com.table.PrescripDTO;
import com.table.PrescriptionDTO;


public class PrescriptionPdf extends ActionSupport implements ServletContextAware{
	
	private static final long serialVersionUID = 8854240739341830184L;
	private ServletContext servlet;
	private Long prescriptionid;
	
	
	public ServletContext getServlet() {
		return servlet;
	}

	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}

	public void setServletContext(ServletContext servlet) {
		this.servlet = servlet;
	}


	public String execute() throws Exception
	{	
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
		
		Long prescriptionid=Long.parseLong((String)ServletActionContext.getRequest().getParameter("prescriptionid"));
		String doctorname=(String)ServletActionContext.getRequest().getParameter("doctorname");
		//Long prescriptionid = 26L;
		System.out.println("doctorname:"+doctorname);
		
		
		PrescriptionDAO pDao=new PrescriptionDAO();		
		PrescripDTO pDTO = new PrescripDTO();
		PatientDetailDTO pinfo= new PatientDetailDTO();
			
		pinfo =pDao.getPInfo(prescriptionid);
		pDTO=pDao.getPrescription(prescriptionid);
		
		String visitid= pDao.getVisitID(prescriptionid);
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		PdfReader reader =null;
		ByteArrayOutputStream certificate = null;
		List<PdfReader> readers = new ArrayList<PdfReader>();
		String realPath = servlet.getRealPath("/resources/staticpdf/Medical.pdf");		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		document.setPageSize(PageSize.A4);
		document.setMargins(10, 10, 1, 10);
		//left,right,top,bottom
		
		try
		{
			
			BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.WINANSI,BaseFont.EMBEDDED);
			
			//Bella Donna
			
			BaseFont hf = BaseFont.createFont(BaseFont.TIMES_BOLDITALIC,BaseFont.WINANSI,BaseFont.EMBEDDED);
			
			
			
			reader = new PdfReader(new FileInputStream(realPath));
			certificate = new ByteArrayOutputStream();
			PdfStamper stamp = new PdfStamper(reader,certificate);
			PdfContentByte over;
			over = stamp.getOverContent(1);
			

			
			over.beginText();
			
			
			over.setFontAndSize(bf, 13);
			over.setTextMatrix(20, 690);
			over.showText("Name :");
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(60, 690);
			over.showText(pinfo.getName());
			
			
			over.setFontAndSize(bf, 13);
			over.setTextMatrix(290, 690);
			over.showText("Age :");
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(325, 690);
			over.showText(pinfo.getAge());
			
			
			over.setFontAndSize(bf, 13);
			over.setTextMatrix(400, 690);
			over.showText("Sex :");
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(430, 690);
			over.showText(pinfo.getSex());
			//over.showText("Female");
			
			
			over.setFontAndSize(bf, 13);
			over.setTextMatrix(480, 690);
			over.showText("Weight :");
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(530, 690);
			over.showText(pDTO.getWeight()+" kg");
			
			
			if(!pinfo.getDesignation().equalsIgnoreCase("nil"))
			{
				over.setFontAndSize(bf, 13);
				over.setTextMatrix(20, 660);
				over.showText("Designation :");
							
				over.setFontAndSize(bf, 12);
				over.setTextMatrix(92, 660);
				over.showText(pinfo.getDesignation());
			}
			
			if(!pinfo.getCareof().equalsIgnoreCase("nil"))
			{
				over.setFontAndSize(bf, 13);
				over.setTextMatrix(20, 660);
				over.showText("D/O :");
							
				over.setFontAndSize(bf, 12);
				over.setTextMatrix(60, 660);
				over.showText(pinfo.getCareof());
			}
			
			
			if(!pinfo.getDepartment().equalsIgnoreCase("nil"))
			{
				over.setFontAndSize(bf, 13);
				over.setTextMatrix(290, 660);
				over.showText("Department :");
				
				over.setFontAndSize(bf, 12);
				over.setTextMatrix(363, 660);
				over.showText(pinfo.getDepartment());
			}
			
			
			if(!pinfo.getHall().equalsIgnoreCase("nil"))
			{
				over.setFontAndSize(bf, 13);
				over.setTextMatrix(20, 630);
				over.showText("Hall :");
				
				over.setFontAndSize(bf, 12);
				over.setTextMatrix(60, 630);
				over.showText(pinfo.getHall());
				
				
				
				over.setFontAndSize(bf, 13);
				over.setTextMatrix(290, 630);
				over.showText("Room No. :");
				
				
				over.setFontAndSize(bf, 12);
				over.setTextMatrix(355, 630);
				over.showText(pinfo.getRoomno());
			}
			
			
			
			over.setFontAndSize(bf, 16);
			over.setTextMatrix(20, 600);
			over.showText("Visit Id :");
			
			
			over.setFontAndSize(bf, 16);
			over.setTextMatrix(90, 600);
			over.showText(visitid);
			
			
			over.setFontAndSize(bf, 16);
			over.setTextMatrix(290, 600);
			over.showText("Patient Id:");
			
			
			over.setFontAndSize(bf, 16);
			over.setTextMatrix(365, 600);
			over.showText(pinfo.getPatientid());
			
			
			
			
			
			int x = 10;
			int y = 520;
			
			if(pDTO.getCc().size()>0)
			{
				over.setFontAndSize(hf, 13);				
				over.setTextMatrix(x, y);
				over.showText("C/C");
				
				x=x+5;
				
				for(int i=0; i<pDTO.getCc().size(); i++)
				{
					y=y-18;
					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(pDTO.getCc().get(i));
					
				}				
			}
			
			
			if(pDTO.getOe().size()>0)
			{
				x=10;
				y=y-25;
				over.setFontAndSize(hf, 13);				
				over.setTextMatrix(x, y);
				over.showText("O/E");
				x=15;
				for(int i=0; i<pDTO.getOe().size(); i++)
				{
					y=y-18;					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(pDTO.getOe().get(i));					
				}				
			}
			
			if(pDTO.getDiagonasis().size()>0)
			{
				x=10;
				y=y-25;
				over.setFontAndSize(hf, 13);				
				over.setTextMatrix(x, y);
				over.showText("Diagonosis");
				x=15;
				for(int i=0; i<pDTO.getDiagonasis().size(); i++)
				{
					y=y-18;					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(pDTO.getDiagonasis().get(i));					
				}				
			}
			
			if(pDTO.getPae().size()>0)
			{
				x=10;
				y=y-25;
				over.setFontAndSize(hf, 13);				
				over.setTextMatrix(x, y);
				over.showText("P/A/E");
				x=15;
				for(int i=0; i<pDTO.getPae().size(); i++)
				{
					y=y-18;					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(pDTO.getPae().get(i));					
				}				
			}
			

			if(pDTO.getInvestigation().size()>0)
			{
				x=10;
				y=y-25;
				over.setFontAndSize(hf, 13);				
				over.setTextMatrix(x, y);
				over.showText("Investigation");
				x=15;
				for(int i=0; i<pDTO.getInvestigation().size(); i++)
				{
					y=y-18;					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(pDTO.getInvestigation().get(i));					
				}				
			}
			
			
			
			
			
			
			
			if(pDTO.getRx().size()>0)
			{
				
				
				y=530;
				String  rx, rxd="";
				String st[];
				for(int i=0; i<pDTO.getRx().size(); i++)
				{
					st=pDTO.getRx().get(i).split("@");
					rx=st[0];
					rxd=st[1];
					x=285;
					y=y-27;					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(rx);	
					
					x=325;
					y=y-16;					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(rxd);
					
					
				}				
			}
			
			
			if(pDTO.getRxdout().size()>0)
			{
				x=275;
				y=y-50;
				over.setFontAndSize(hf, 13);				
				over.setTextMatrix(x, y);
				over.showText("Outside Medicine");
				
				y=y-5;
				String  rx, rxd="";
				String st[];
				
				for(int i=0; i<pDTO.getRxdout().size(); i++)
				{
					st=pDTO.getRxdout().get(i).split("@");
					rx=st[0];
					rxd=st[1];
					
					x=285;
					y=y-27;									
					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(rx);	
					
					x=325;
					y=y-16;					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(rxd);
					
					
				}				
			}
			
			
			
			
			if(pDTO.getAdvice().size()>0)
			{
				x=275;
				y=y-50;
				over.setFontAndSize(hf, 13);				
				over.setTextMatrix(x, y);
				over.showText("Advice to be followed");
				x=285;
				for(int i=0; i<pDTO.getAdvice().size(); i++)
				{
					y=y-15;					
					over.setFontAndSize(bf, 11);				
					over.setTextMatrix(x, y);
					over.showText(pDTO.getAdvice().get(i));					
				}				
			}
			
			
			
			
			
			over.setFontAndSize(bf, 11);
			over.setTextMatrix(20, 40);
			over.showText("Prescribed By :");
			
			
			over.setFontAndSize(hf, 11);
			over.setTextMatrix(90, 40);
			over.showText(doctorname);
			
			
			
			over.setFontAndSize(hf, 10);
			over.setTextMatrix(250, 40);
			//over.showText("'##' Means : This Medicine/Investigation is not available in Buet Medical Center");
			over.showText("");
			
			
			over.setFontAndSize(bf, 13);
			over.setTextMatrix(20, 39);
			over.showText("______________________________________________________________________________________");
			
			
			over.setFontAndSize(bf, 8);
			over.setTextMatrix(20, 25);
			over.showText("Note: This is a Coumputer Generated Prescription.");
			
			over.setFontAndSize(bf, 8);
			over.setTextMatrix(405, 25);
			over.showText("Printed Date/Time: "+ new Date().toString());
			
			
			over.endText();		
			
			stamp.close();
			readers.add(new PdfReader(certificate.toByteArray()));
			
				
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
			
		
		
		
		if(readers.size()>0)
		{
			PdfWriter writer = PdfWriter.getInstance(document, out);
			
			document.open();
			
			PdfContentByte cb = writer.getDirectContent();
			PdfReader pdfReader = null;
			PdfImportedPage page;
			
			for(int k=0;k<readers.size();k++)
			{
				document.newPage();
				pdfReader = readers.get(k);
				page = writer.getImportedPage(pdfReader, 1);
				cb.addTemplate(page, 0, 0);
			}
			

			document.close();
			ReportUtil rptUtil = new ReportUtil();
			rptUtil.downloadPdf(out, response);
			document=null;	
					
		}
		
		
		
		return null;	
		
	}

	public Long getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(Long prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	
		

}