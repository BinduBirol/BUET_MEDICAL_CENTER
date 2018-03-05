package com.mcenter.report;

import java.awt.Color;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

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





public  class TokenforOutsiderTestPatient1  extends HttpServlet { 
	
	private static final long serialVersionUID = 8854240739341830184L;
	private int i;
	private String visitID;
	private ServletContext servlet;
	
	
	 public String getVisitID() {
		return visitID;
	}

	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}
		
	public ServletContext getServlet() {
		return servlet;
	}


	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}

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
	
	


	public String report(String patientname,String patientID,String designation,String refDoctor,String gender,String ageStr,String serialNumber) 
			throws Exception{
	        try {
	        	
	        	 
	        	  Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
	        	   Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
	        	   
	        	   
	        
	        /*	HttpServletRequest request = ServletActionContext.getRequest();
	        	visitID=request.getParameter("serialNo");*/
	        	   
	        	   
	        	
	        	HttpServletResponse response = ServletActionContext.getResponse();
	        	
	        	//Document document = new Document(PageSize.A4);
	        	Document document = new Document(PageSize.A7,5,0,0,0);
	 //       	Document document = new Document(PageSize.A4, 36, 36, 54, 36);
	        	
	        	
	    		String fileName="Downtime.pdf";

	    		
	    		//medicinebillreport
	        	
	    		TokenForPatient  dDAO = new  TokenForPatient();
	    		 dDAO.report(visitID);
	    		
	    		
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
	       
	          
	             /*TableHeader event = new TableHeader();
	             writer.setPageEvent(event);*/
	         
	            
	            document.open();
	          //  writer.addJavaScript("this.print(false);", false);
	         //  write.addJavaScript("this.print({bUI: false, bSilent: true, bShrinkToFit:true});",false);
	           writer.addJavaScript("this.print({bUI: false, bSilent: true, bShrinkToFit:true});",false);
	           /*Acrobat.Print();*/
	           /*PrinterJob.getPrinterJob();*/
            
	            document.add(new Paragraph(" "));
	            
	     
	           
	          
	            Font bold = new Font(Font.FontFamily.HELVETICA, 8f, Font.BOLD);
	            Font normal = new Font(Font.FontFamily.HELVETICA, 8f, Font.NORMAL);
	            
	            PdfPTable table1 = new PdfPTable(2);
	            table1 .setWidthPercentage(100);
	            float[] colWidths = {20f,80f};
	            table1.setWidths(colWidths);
	            String imageUrl = "http://teacher.buet.ac.bd/arifur/BUETlogo.png";
	     //       String realPath = servlet.getRealPath("/resources/img/logo.png");
	     //       Image image2 = Image.getInstance(realPath);
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
	            
/*	            cellnew = new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 12,
                        Font.BOLD)));
	            cellnew.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellnew.setBorder(Rectangle.NO_BORDER);
	            table1.addCell(cellnew);
	            
	            cellnew = new PdfPCell(new Phrase(" ",new Font(Font.FontFamily.HELVETICA, 13,
                        Font.BOLD)));
	            cellnew.setHorizontalAlignment(Element.ALIGN_RIGHT);
	            cellnew.setBorder(Rectangle.NO_BORDER);
	            table1.addCell(cellnew);*/
	          
	            document.add(table1);
	           // document.add( Chunk.NEWLINE);
	            /////////////////////////////
               PdfPTable table = new PdfPTable(6);
	            
	            // set the width of the table to 100% of page
	            table.setWidthPercentage(100);
	     
	            // set relative columns width
	            table.setWidths(new float[]{0.6f, 1.4f, 0.8f,0.8f,1.8f,2.6f});
	     
	            // ----------------Table Header "Title"----------------
	            // font
	            Font font = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.WHITE);
	            // create header cell
	            PdfPCell cell = new PdfPCell(new Phrase("Outsider Test Patient Serial",font));
	            // set Column span "1 cell = 6 cells width"
	            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
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
	            
	            PdfPTable infotable = new PdfPTable(2);
	            infotable.setWidthPercentage(100);
	            infotable.setHorizontalAlignment(Element.ALIGN_LEFT);
	            float[] colWidthsinfo = {50f,50f};
	            infotable.setWidths(colWidthsinfo);
	            
	            
	            PdfPCell cellinfo = new PdfPCell();
	            
	            cellinfo = new PdfPCell(new Phrase("Serial Number:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(serialNumber,new Font(Font.FontFamily.HELVETICA,9,
                        Font.BOLD)));
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
	            
	            cellinfo = new PdfPCell(new Phrase(patientname,new Font(Font.FontFamily.HELVETICA, 9,
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
	            
	            cellinfo = new PdfPCell(new Phrase(patientID,new Font(Font.FontFamily.HELVETICA, 9,
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
	            
	            cellinfo = new PdfPCell(new Phrase(designation,new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            /*cellinfo = new PdfPCell(new Phrase("Medical ID:",new Font(Font.FontFamily.HELVETICA, 10,
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
	            infotable.addCell(cellinfo);*/
	            
	            
	            cellinfo = new PdfPCell(new Phrase("Gender:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase(gender,new Font(Font.FontFamily.HELVETICA, 9,
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
	            
	           cellinfo = new PdfPCell(new Phrase(ageStr,new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            cellinfo = new PdfPCell(new Phrase("Referenced Doctor:",new Font(Font.FontFamily.HELVETICA, 10,
                        Font.BOLD)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	           cellinfo = new PdfPCell(new Phrase(refDoctor,new Font(Font.FontFamily.HELVETICA, 9,
                        Font.NORMAL)));
	            cellinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellinfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            cellinfo.setBorder(Rectangle.NO_BORDER);
	            infotable.addCell(cellinfo);
	            
	            
	            
	            
	            
	        /*  cellinfo = new PdfPCell(new Phrase("Relation:",new Font(Font.FontFamily.HELVETICA, 10,
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
	            infotable.addCell(cellinfo);*/
	            document.add(infotable);
	          
	            
	            
	           // document.add( Chunk.NEWLINE);
	            
	            
	            Paragraph paragraphnew = new Paragraph("Printed time:"+new Date().toString(),new Font(Font.FontFamily.TIMES_ROMAN, 10,
	            	      Font.BOLD));
	            paragraphnew.setAlignment(Element.ALIGN_LEFT);
	            document.add(paragraphnew);
	         ////////////////////////////////////
	       
	            
	            //////////////////////////////

	           /* PDFDocument doc = new PDFDocument();            
	            document.AddOpenActionJavaScript("this.print();"); 
	            document.AddOpenActionNamed(PDFActionName.Print);*/
	            
	            
	          
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
