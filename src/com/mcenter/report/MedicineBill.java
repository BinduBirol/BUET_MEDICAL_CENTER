package com.mcenter.report;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import table.userrole.UserRoleDTO;
import util.login.ValidateUser;

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
import com.mcenter.pharmasistBillManagement.PharmacyMedicineBill;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class MedicineBill   extends ActionSupport {
	
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
	
	
	private int i;
	private String visitID;
	private String billID;
	
	
	
	 public String getBillID() {
		return billID;
	}


	public void setBillID(String billID) {
		this.billID = billID;
	}


	public String getVisitID() {
		return visitID;
	}


	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}


	public String report() throws Exception{
	        try {
	        	
	        	
	    		
	    		//user.getUserfullname();
	        	
	        	
	        	  Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
	        	   Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
	        	   
	        	   
	        
	        	HttpServletRequest request = ServletActionContext.getRequest();
	        	visitID=request.getParameter("visitID");
	        	billID=request.getParameter("billID");
	        	   
	        	   
	        	
	        	HttpServletResponse response = ServletActionContext.getResponse();
	        	
	        	Document document = new Document(PageSize.A4, 36, 36, 54, 36);
	        	
	        	
	    		String fileName="Downtime.pdf";
	    		
	    		Map<String, Object> session = ActionContext.getContext().getSession();
	    		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
	    		
	    		System.out.println(user.getUserfullname());
	    		System.out.println(user.getUserdesignation());
	    		
	    		//medicinebillreport
	        	
	    		 PharmacyMedicineBill  dDAO = new  PharmacyMedicineBill();	    		 
	    		 dDAO.medicinebillreport(visitID,billID);
	    		 dDAO.getPharmacyMedicineBilllist();
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
	            
	            cellnew = new PdfPCell(new Phrase("Medicine bill of regular patient",new Font(Font.FontFamily.HELVETICA, 13,
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
	            PdfPCell cell = new PdfPCell(new Phrase("Patient Information",font));
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
	            PdfPTable infotable = new PdfPTable(2);
	            infotable.setWidthPercentage(50);
	            float[] colWidthsinfo = {50f,50f};
	            infotable.setWidths(colWidthsinfo);
	            
	            
	            PdfPCell cellinfo = new PdfPCell();
	            
	            cellinfo = new PdfPCell(new Phrase("Serial Number:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getvID(),new Font(Font.FontFamily.HELVETICA,9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	           
	            cellinfo = new PdfPCell(new Phrase("Assigned Doctor:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getDoctorName(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Visiting Date:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getPrescriptionDate(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Medical ID:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getMedicalID(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("ID holder Name:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getMedicalIDholderName(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Department:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getDepartment(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Designation:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getDesignation(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Patient ID:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	           cellinfo = new PdfPCell(new Phrase(dDAO.getPatientID(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Patient Name:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getPatientName(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            
	            
	            
	            cellinfo = new PdfPCell(new Phrase("Age:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getAgeStr(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Sex:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getGender(),new Font(Font.FontFamily.HELVETICA,9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Relation:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(dDAO.getPatientRelationWithIDholder(),new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	          
	            
	            
	            
	            document.add(infotable);
	            
	         ////////////////////////////////////
	            document.add( Chunk.NEWLINE );
                 PdfPTable table2 = new PdfPTable(6);
	            
	            // set the width of the table to 100% of page
                 table2.setWidthPercentage(100);
	     
	            // set relative columns width
                 table2.setWidths(new float[]{0.6f, 1.4f, 0.8f,0.8f,1.8f,2.6f});
	     
	            // ----------------Table Header "Title"----------------
	            // font
	            Font font1 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.WHITE);
	            // create header cell
	            PdfPCell cellbar2 = new PdfPCell(new Phrase("Medicine Bill in Detail",font1));
	            // set Column span "1 cell = 6 cells width"
	            cellbar2.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cellbar2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     
	            // padding
	            cellbar2.setPaddingLeft(3f);
	            cellbar2.setPaddingTop(0f);
	     
	            // background color
	            cellbar2.setBackgroundColor(BaseColor.GRAY);
	     
	            // border
	            cellbar2.setBorder(0);
	            cellbar2.setBorderWidthBottom(1);
	            cellbar2.setBorderColorBottom(BaseColor.GRAY);
	     
	            // height
	            cellbar2.setMinimumHeight(18f);
	            cellbar2.setColspan(6);
	           
	            table2.addCell(cellbar2);
	            document.add(table2);
	            
	            //////////////////////////////

	        
	            document.add( Chunk.NEWLINE );
	           
	            //Create a table in PDF
	            PdfPTable pdfTable = new PdfPTable(5);
	            pdfTable.setWidthPercentage(100);
	            float[] columnWidths = new float[] {10f, 45f, 25f, 15f,15f};
	            pdfTable.setWidths(columnWidths);
	            
	            document.add(pdfTable);
	            
	            
	            PdfPCell cell1 = new PdfPCell(new Phrase("No".toUpperCase(),new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell1.setGrayFill(0.9f);
               
                
	            pdfTable.addCell(cell1);
	            
	            cell1 = new PdfPCell(new Phrase("Medicine Name".toUpperCase(),new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell1.setGrayFill(0.9f);
	            pdfTable.addCell(cell1);

	            cell1 = new PdfPCell(new Phrase("Quantity".toUpperCase(),new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell1.setGrayFill(0.9f);
	            
	            pdfTable.addCell(cell1);
	            

	            cell1 = new PdfPCell(new Phrase("Rate".toUpperCase(),new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell1.setGrayFill(0.9f);
	            pdfTable.addCell(cell1);
	            
	            cell1 = new PdfPCell(new Phrase("Price".toUpperCase(),new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell1.setGrayFill(0.9f);
	            pdfTable.addCell(cell1);
	            
	           
	           
	            pdfTable.setHeaderRows(1);
	            
	           System.out.println("Size:"+dDAO.getPharmacyMedicineBilllist().size()); 
	           
	          
	           PharmacyMedicineBill  DAO = new PharmacyMedicineBill();
		      
	           
           for( i=0;i<dDAO.getPharmacyMedicineBilllist().size();i++)
            {
        	    DAO =dDAO.getPharmacyMedicineBilllist().get(i);
	            
        	    
        	    PdfPCell cell2 = new PdfPCell(new Phrase(String.valueOf(i+1),new Font(Font.FontFamily.TIMES_ROMAN, 11,
                        Font.NORMAL)));
	            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        	    pdfTable.addCell(cell2);
        	    
        	    
        	    PdfPCell cell3 = new PdfPCell(new Phrase(DAO.getMedicineName(),new Font(Font.FontFamily.TIMES_ROMAN, 11,
                        Font.NORMAL)));
	            cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
	            pdfTable.addCell(cell3 );
	            
	            
	            PdfPCell cell4 = new PdfPCell(new Phrase(Double.toString(DAO.getMedicineQuantity()),new Font(Font.FontFamily.TIMES_ROMAN, 11,
                        Font.NORMAL)));
	            cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
	            pdfTable.addCell(cell4);
	            
	            
	            PdfPCell cell5 = new PdfPCell(new Phrase(Double.toString(DAO.getRate()),new Font(Font.FontFamily.TIMES_ROMAN, 11,
                        Font.NORMAL)));
	            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	            pdfTable.addCell(cell5);
	            
	            PdfPCell cell6 = new PdfPCell(new Phrase(Double.toString(DAO.getMedicineQuantity()*DAO.getRate()),new Font(Font.FontFamily.TIMES_ROMAN, 11,
                        Font.NORMAL)));
	            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
	            pdfTable.addCell(cell6);
	            
               }

          
           cell1 = new PdfPCell(new Phrase("Grand Total=",new Font(Font.FontFamily.HELVETICA, 12,
                   Font.BOLD)));
           cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
           cell1.setGrayFill(0.9f);
           cell1.setColspan(4);
           pdfTable.addCell(cell1);
           cell1 = new PdfPCell(new Phrase(Double.toString(DAO.getTotal()),new Font(Font.FontFamily.HELVETICA, 12,
                   Font.BOLD)));
           cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell1.setGrayFill(0.9f);
          
           
           pdfTable.addCell(cell1);
           document.add(pdfTable);
	            PdfPTable tableword = new PdfPTable(2);
	            tableword .setWidthPercentage(100);
	            float[] colWidths2 = {20,80};
	            tableword.setWidths(colWidths2);
	            
	            PdfPCell cellword = new PdfPCell();
	            
	            
	            cellword = new PdfPCell(new Phrase("Amount in Word:",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cellword.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellword.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellword.setBorder(Rectangle.NO_BORDER);
	            tableword.addCell(cellword);
	            
	            cellword = new PdfPCell(new Phrase(dDAO.getInword()+" "+"Only",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.NORMAL)));
	            cellword.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellword.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellword.setBorder(Rectangle.NO_BORDER);
	            tableword.addCell(cellword);
	           
	            document.add(tableword);
	            
	            document.add( Chunk.NEWLINE );
	            document.add( Chunk.NEWLINE );
	            
	            
	            Paragraph paragraph = new Paragraph("Bill Prepared by :",new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            	      Font.BOLD));
	            paragraph.setAlignment(Element.ALIGN_LEFT);
	            //New line
	         
	           // paragraph.add(new Paragraph(" "));
	            paragraph.add(new Paragraph(user.getUserfullname(),new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            	      Font.NORMAL)));
	            paragraph.setAlignment(Element.ALIGN_LEFT);
	            
	            paragraph.add(new Paragraph(user.getUserdesignation(),new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            	      Font.NORMAL)));
	            paragraph.setAlignment(Element.ALIGN_LEFT);
	            document.add(paragraph);	            
	            
	            
	            
	            
	          
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
