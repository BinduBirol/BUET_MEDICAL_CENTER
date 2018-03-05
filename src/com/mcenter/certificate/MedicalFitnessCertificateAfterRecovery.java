package com.mcenter.certificate;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import util.ConnectionUtil.ConnectionManager;

import com.itextpdf.text.Chunk;
//import com.lowagie.text.Document;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.fonts.otf.TableHeader;

import com.lowagie.text.HeaderFooter;
import com.mcenter.patientManagement.TokenForPatient;
import com.opensymphony.xwork2.ActionSupport;



public class MedicalFitnessCertificateAfterRecovery extends HttpServlet {
	
	/** Inner class to add a header and a footer. *//*
    class HeaderFooter extends PdfPageEventHelper {
        *//** Alternating phrase for the header. *//*
        Phrase[] header = new Phrase[2];
        *//** Current page number (will be reset for every chapter). *//*
        int pagenumber;
 
        *//**
         * Initialize one of the headers.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         *//*
        public void onOpenDocument(PdfWriter writer, Document document) {
        	
        	
            header[0] = new Phrase("Movie history");
        }
 
        *//**
         * Initialize one of the headers, based on the chapter title;
         * reset the page number.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onChapter(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document, float,
         *      com.itextpdf.text.Paragraph)
         *//*
        public void onChapter(PdfWriter writer, Document document,
                float paragraphPosition, Paragraph title) {
            header[1] = new Phrase(title.getContent());
            pagenumber = 1;
        }
 
        *//**
         * Increase the page number.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onStartPage(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         *//*
        public void onStartPage(PdfWriter writer, Document document) {
            pagenumber++;
        }
 
        *//**
         * Adds the header and the footer.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         *//*
        public void onEndPage(PdfWriter writer, Document document) {
            Rectangle rect = writer.getBoxSize("art");
            switch(writer.getPageNumber() % 2) {
            case 0:
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_RIGHT, header[0],
                        rect.getRight(), rect.getTop(), 0);
                break;
            case 1:
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_LEFT, header[1],
                        rect.getLeft(), rect.getTop(), 0);
                break;
            }
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format("page %d", pagenumber)),
                    (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
        }
    }
 */
	
	
	
	
	////////////////////////////////
	
	class TableHeader extends PdfPageEventHelper {
	    /** The header text. */
	    String header="Printed time:"+new Date().toString();
	    /** The template with the total number of pages. */
	    PdfTemplate total;

	    /**
	     * Allows us to change the content of the header.
	     * @param header The new header String
	     */
	    public void setHeader(String header) {
	        this.header = header;
	    }

	    /**
	     * Creates the PdfTemplate that will hold the total number of pages.
	     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
	     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
	     */
	    public void onOpenDocument(PdfWriter writer, Document document) {
	        total = writer.getDirectContent().createTemplate(30, 16);
	    }

	    /**
	     * Adds a header to every page
	     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
	     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
	     */
	    public void onEndPage(PdfWriter writer, Document document) {
	    	Rectangle page = document.getPageSize();
	        PdfPTable table = new PdfPTable(3);
	        try {
	            table.setWidths(new int[]{24, 24, 2});
	           // table.setTotalWidth(527);
	            table.setLockedWidth(true);
	            table.getDefaultCell().setFixedHeight(20);
	            table.getDefaultCell().setBorder(Rectangle.TOP);
	            table.addCell(header);
	           // table.addCell("Printed time:"+new Date().toString());
	            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
	            table.addCell(String.format("Page %d of", writer.getPageNumber()));
	            PdfPCell cell = new PdfPCell(Image.getInstance(total));
	            cell.setBorder(Rectangle.TOP);
	            table.addCell(cell);
	            
	            
	            table.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
	            table.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin()-20,
	                    writer.getDirectContent()); 
	            
	       //     table.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
	            
	        }
	        catch(DocumentException de) {
	            throw new ExceptionConverter(de);
	        }
	    }

	    /**
	     * Fills out the total number of pages before the document is closed.
	     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(
	     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
	     */
	    public void onCloseDocument(PdfWriter writer, Document document) {
	        ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
	                new Phrase(String.valueOf(writer.getPageNumber() - 1)),
	                2, 2, 0);
	    }
	}  
	
	 DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
	   //get current date time with Date()
	   Date serialdate1 = new Date();
	   String DateofSerial1 = dateFormat1.format(serialdate1);
	
	private String medicalID;
	private String medicalIDholderName;
	private String department;
	private String designation;
	
	
	
	
	public String getMedicalID() {
		return medicalID;
	}

   public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
	}

	public String getMedicalIDholderName() {
		return medicalIDholderName;
	}

	public void setMedicalIDholderName(String medicalIDholderName) {
		this.medicalIDholderName = medicalIDholderName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}



	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	
	public String execute() throws Exception{
		System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
                       
           
			
		//System.out.println(medicalID);
			//////////////////////////////////////////////	/
			  
			  String sql2="select distinct t1.id, t1.name ,t1.departmentname,t1.DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1";
		        ps2 = con.prepareStatement(sql2);
		         
		         
				 ResultSet rs2=ps2.executeQuery();
				 while(rs2.next()){
					
					
					
					
					
					 medicalIDholderName=rs2.getString(2);
			         department=rs2.getString(3);
					 designation=rs2.getString(4);
					
					}
				 
				 if(designation==null)
				 {
					 designation="Student";	 
					 
				 }
			  
			 
			
			
			
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		        if (ps1!= null) {
		        	ps1.close();
		        }
		       
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }
	
	

	public String report() throws Exception{
		Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
	        try {
	        	
	        	/* Class.forName("oracle.jdbc.driver.OracleDriver");
	    	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	    	     
	        	  Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
	        	   Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
	        	   
	        	   
	        
	        	HttpServletRequest request = ServletActionContext.getRequest();
	           String id=request.getParameter("medicalId");
	           String name=request.getParameter("idholderName");
	           String department=request.getParameter("department");
	           String designation=request.getParameter("designation");
	           String fromdate=request.getParameter("fdate");
	           String todate=request.getParameter("tdate");
	           String restdays=request.getParameter("restday");
	           
	           
	           
	           
	           
	        	   
	        	   
	        	
	        	HttpServletResponse response = ServletActionContext.getResponse();
	        	
	        	//Document document = new Document(PageSize.A4);
	        	Document document = new Document(PageSize.A4, 36, 36, 54, 36);
	        	
	        	
	    		String fileName="Downtime.pdf";

	    		
	    		//medicinebillreport
	        	
	    		
	    		
	    		
	    		/////////////////////////////
	    		// step 2
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            PdfWriter.getInstance(document, baos);
	    		
	    		/////////////////////////////
	    		  //get the output stream for writing binary data in the response.
	    		  ServletOutputStream os = response.getOutputStream();
	    		  //set the response content type to PDF
	    		  response.setContentType("application/pdf"); 
	    ///////////////////////////////////////////////////////////
	        // OutputStream file = new FileOutputStream(new File("C:\\Users\\Adnan\\Desktop\\SamplePDF.pdf"));
	   ////////////////////////////////////////////////////////////       
	           
	          PdfWriter writer =PdfWriter.getInstance(document,os);
	       
	          
	             TableHeader event = new TableHeader();
	             writer.setPageEvent(event);
	         
	            
	            document.open();
	            document.add(new Paragraph(" "));
	            
	     
	           
	          
	            Font bold = new Font(Font.FontFamily.HELVETICA, 8f, Font.BOLD);
	            Font normal = new Font(Font.FontFamily.HELVETICA, 8f, Font.NORMAL);
	            
	            PdfPTable table1 = new PdfPTable(4);
	            table1 .setWidthPercentage(100);
	            float[] colWidths = {10f,40f,10f,40f};
	            table1.setWidths(colWidths);
	            String imageUrl = "http://teacher.buet.ac.bd/arifur/BUETlogo.png";
	            Image image2 = Image.getInstance(new URL(imageUrl));
	            image2.setWidthPercentage(100);
	            table1.getDefaultCell().setBorder(1);
	            table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	            table1.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
	            PdfPCell cellnew = new PdfPCell();
	            cellnew.setBorder(Rectangle.NO_BORDER);
	            cellnew.addElement(image2);
	            
	           
	            table1.addCell(cellnew);
	            
	            cellnew = new PdfPCell(new Phrase("Medical Center, BUET",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cellnew.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellnew.setBorder(Rectangle.NO_BORDER);
	            table1.addCell(cellnew);
	            
	            cellnew = new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cellnew.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew.setBorder(Rectangle.NO_BORDER);
	            table1.addCell(cellnew);
	            
	            cellnew = new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 13,
                        Font.BOLD)));
	            cellnew.setHorizontalAlignment(Element.ALIGN_RIGHT);
	            cellnew.setBorder(Rectangle.NO_BORDER);
	            table1.addCell(cellnew);
	          
	            document.add(table1);
	            document.add( Chunk.NEWLINE);
	            /////////////////////////////
               PdfPTable table = new PdfPTable(6);
	            
	            // set the width of the table to 100% of page
	            table.setWidthPercentage(100);
	     
	            // set relative columns width
	            table.setWidths(new float[]{0.6f, 1.4f, 0.8f,0.8f,1.8f,2.6f});
	     
	            // ----------------Table Header "Title"----------------
	            // font
	            Font font = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.WHITE);
	            // create header cell
	            PdfPCell cell = new PdfPCell(new Phrase("Medical Fitness certificate(after recovery from disease)",font));
	            // set Column span "1 cell = 6 cells width"
	            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     
	            // padding
	            cell.setPaddingLeft(3f);
	            cell.setPaddingTop(0f);
	     
	            // background color
	            cell.setBackgroundColor(BaseColor.GRAY);
	     
	            // border
	            cell.setBorder(0);
	            cell.setBorderWidthBottom(1);
	            cell.setBorderColorBottom(BaseColor.GRAY);
	     
	            // height
	            cell.setMinimumHeight(18f);
	            cell.setColspan(6);
	         
	            table.addCell(cell);
	            document.add(table);
	            
	            //////////////////////////////
	            document.add( Chunk.NEWLINE );
	            document.add( Chunk.NEWLINE );
	            
	            
	            
	            PdfPTable table2 = new PdfPTable(4);
	            table2 .setWidthPercentage(100);
	            float[] colWidths2 = {40f,10f,10f,40f};
	            table2.setWidths(colWidths2);
	            /*String imageUrl = "http://teacher.buet.ac.bd/arifur/BUETlogo.png";
	            Image image2 = Image.getInstance(new URL(imageUrl));
	            image2.setWidthPercentage(100);*/
	            table2.getDefaultCell().setBorder(1);
	            table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	            table2.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
	            PdfPCell cellnew2 = new PdfPCell();
	            cellnew2.setBorder(Rectangle.NO_BORDER);
	            
	            
	            cellnew2 = new PdfPCell(new Phrase("Source:BUETMC/......",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.NORMAL)));
	            cellnew2.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellnew2.setBorder(Rectangle.NO_BORDER);
	            table2.addCell(cellnew2);
	           
	           
	            
	            cellnew2 = new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cellnew2.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellnew2.setBorder(Rectangle.NO_BORDER);
	            table2.addCell(cellnew2);
	            
	            cellnew2 = new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cellnew2.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew2.setBorder(Rectangle.NO_BORDER);
	            table2.addCell(cellnew2);
	            
	            cellnew2 = new PdfPCell(new Phrase("Date:"+DateofSerial1,new Font(Font.FontFamily.HELVETICA, 13,
                        Font.NORMAL)));
	            cellnew2.setHorizontalAlignment(Element.ALIGN_RIGHT);
	            cellnew2.setBorder(Rectangle.NO_BORDER);
	            table2.addCell(cellnew2);
	          
	            document.add(table2);
	            ///////////////////////////////////
	            document.add( Chunk.NEWLINE );
	            document.add( Chunk.NEWLINE );
	            
	            
	           
	            
	            /////////////////////////////////////////
	           
	            Paragraph paragraph = new Paragraph("This is to certify that "+name+","+designation+" "+"of"+" "+department+" "+"Department,ID:"+" "+id+" "+"suffered from"+" "+fromdate+" "+ "to"+" "+todate+".He/She was under my treatment and was advised to take rest for"+" "+restdays+" days.",new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            	      Font.NORMAL));
	            paragraph.setAlignment(Element.ALIGN_LEFT);
	            document.add(paragraph);
	            
	            document.add( Chunk.NEWLINE);
	            document.add( Chunk.NEWLINE);
	            
	            Paragraph paragraph1 = new Paragraph("Now,he/she is healthy and can resume to his/her duties .",new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL));
	            paragraph1.setAlignment(Element.ALIGN_LEFT);
	            document.add(paragraph1);
	            
	            
	            document.add( Chunk.NEWLINE);
	            document.add( Chunk.NEWLINE);
	            document.add( Chunk.NEWLINE);
	            
	            
	           
	         ////////////////////////////////////
	            //////////////////////////////////////////////
	            PdfPTable table3 = new PdfPTable(4);
	            table3 .setWidthPercentage(100);
	            float[] colWidths3= {40f,10f,10f,40f};
	            table3.setWidths(colWidths3);
	            /*String imageUrl = "http://teacher.buet.ac.bd/arifur/BUETlogo.png";
	            Image image2 = Image.getInstance(new URL(imageUrl));
	            image2.setWidthPercentage(100);*/
	            table3.getDefaultCell().setBorder(1);
	            table3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	            table3.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
	            PdfPCell cellnew3 = new PdfPCell();
	            cellnew3.setBorder(Rectangle.NO_BORDER);
	            
	            
	            cellnew3 = new PdfPCell(new Phrase("-----------------------------------------------",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.NORMAL)));
	            cellnew3.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellnew3.setBorder(Rectangle.NO_BORDER);
	            table3.addCell(cellnew3);
	           
	           
	            
	            cellnew3= new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cellnew3.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellnew3.setBorder(Rectangle.NO_BORDER);
	            table3.addCell(cellnew3);
	            
	            cellnew3= new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cellnew3.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew3.setBorder(Rectangle.NO_BORDER);
	            table3.addCell(cellnew3);
	            
	            cellnew3= new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 13,
                        Font.NORMAL)));
	            cellnew3.setHorizontalAlignment(Element.ALIGN_RIGHT);
	            cellnew3.setBorder(Rectangle.NO_BORDER);
	            table3.addCell(cellnew3);
	          
	            document.add(table3);
	     
	            
	            //////////////////////////////////////////////
	            Paragraph paragraph2= new Paragraph("Name and signature of the physician",new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            	      Font.BOLD));
	            paragraph2.setAlignment(Element.ALIGN_LEFT);
	           
	            document.add(paragraph2);
	            
	            Paragraph paragraphnew1 = new Paragraph("CMO/DCMO/MO",new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            	      Font.BOLD));
	            paragraphnew1.setAlignment(Element.ALIGN_LEFT);
	           
	            document.add(paragraphnew1);
	            
	            Paragraph paragraphnew = new Paragraph("BUET Medical Center",new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            	      Font.BOLD));
	            paragraphnew.setAlignment(Element.ALIGN_LEFT);
	           
	            document.add(paragraphnew);
	            ///////////////////////////////////
	           

	        	            
	            ///////////////////////////////////////
	            
	            
	            
	          
	            document.newPage();
	            document.close();
	            
	         
	            
	         // setting some response headers
	            response.setHeader("Expires", "0");
	            response.setHeader("Cache-Control",
	                "must-revalidate, post-check=0, pre-check=0");
	            response.setHeader("Pragma", "public");
	            // setting the content type
	            response.setContentType("application/pdf");
	            // the contentlength
	            response.setContentLength(baos.size());
	           
	            baos.writeTo(os);
	            os.flush();
	            os.close();
	            
	           response.setHeader("Content-Disposition", "attachment;filename="+fileName);
	
	            
	            
	            
				document=null;

	        } catch (Exception e) {

	            e.printStackTrace();
	        
	           
	            
	        }
	        return null;
	    }
	
	
	
		
	

}


