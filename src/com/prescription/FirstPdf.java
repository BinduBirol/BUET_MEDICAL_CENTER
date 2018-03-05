package com.prescription;


import java.awt.Color;
import java.io.ByteArrayOutputStream;


import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;


import java.io.FileOutputStream;

import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Font;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Paragraph;
//import com.lowagie.text.Document;
import com.lowagie.text.Element;
//import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
//import com.lowagie.text.Paragraph;

import com.lowagie.text.PageSize;

import com.lowagie.text.Phrase;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

//import com.lowagie.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

public class FirstPdf extends ActionSupport implements ServletContextAware{
	

	private static final long serialVersionUID = 1L;
	

	public String downtimePdf() throws Exception
	{
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String fileName="Downtime.pdf";

		
		/*ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();	*/	
		
		/*Document document = new Document(PageSize.A4);*/
		
		//document.setMargins(40, 40, 20, 20);
		//document.addHeader("BAT Report", "");
		
		//PdfPTable ptable = null;
		//PdfPCell pcell=null;
		
		
		try{
			
		
			
			/*Font font1 = new Font(Font.COURIER, 8, Font.BOLD); 
			font1.setColor(new Color(0x92, 0x90, 0x83));
			Font fontt = FontFactory.getFont("Helvetica", 8, Font.NORMAL,Color.BLACK);			
			Font fontb = FontFactory.getFont("Helvetica", 8, Font.BOLD,Color.BLACK);
			Font f10Bold = new Font(Font.TIMES_ROMAN,10,Font.BOLD);
			Font f10Normal = new Font(Font.TIMES_ROMAN,10,Font.NORMAL);
			Font f9Bold = new Font(Font.TIMES_ROMAN,9,Font.BOLD);
			Font f9Normal = new Font(Font.TIMES_ROMAN,9,Font.NORMAL);
			Font f8Normal = new Font(Font.TIMES_ROMAN,8,Font.NORMAL);
			*/
			
			//eEvent.setDisplayValue("DownTime Details");
			Document document = new Document();
			//Document document = new Document(PageSize.A4, 36, 36, 54, 36);
			//PdfWriter.getInstance(document, baos).setPageEvent(null);
			
			 ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            PdfWriter.getInstance(document, baos);
			
			
			document.open();
			
			/*ptable = new PdfPTable(4);
			ptable.setWidthPercentage(100);
			ptable.setWidths(new float[]{40,20,20,20});
			
			
			pcell=new PdfPCell(new Paragraph("Message",f9Bold));
			pcell.setMinimumHeight(25f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			ptable.addCell(pcell);
			
			pcell=new PdfPCell(new Paragraph("Down Time Start",f9Bold));
			pcell.setMinimumHeight(25f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ptable.addCell(pcell);
			
			pcell=new PdfPCell(new Paragraph("Down Time End",f9Bold));
			pcell.setMinimumHeight(25f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ptable.addCell(pcell);
			
			pcell=new PdfPCell(new Paragraph("Duration",f9Bold));
			pcell.setMinimumHeight(25f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ptable.addCell(pcell);*/
			
	     Paragraph paragraph = new Paragraph("Bill Prepared by :",new Font(Font.FontFamily.TIMES_ROMAN, 12,
          	      Font.BOLD));
          paragraph.setAlignment(Element.ALIGN_LEFT);
          document.add(paragraph);
        	
         
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*PdfPTable Detail = new PdfPTable(1); 
			PdfPCell detail_cell;
			float widthvald=25;
			
			detail_cell=new PdfPCell(new Paragraph("Medical Center,BUET" ));
			//detail_cell=new PdfPCell(new Paragraph(""));
			detail_cell.setFixedHeight(widthvald);  //Specify Cell height using setFixedHeight Method 
			//detail_cell.setVerticalAlignment(Element.ALIGN_TOP);  //Bottom align            
			Detail.addCell(detail_cell); */
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*PdfPTable my_first_table = new PdfPTable(2); 
			PdfPTable my_sec_table = new PdfPTable(2); 
			
			
            PdfPCell table_cell;
            PdfPCell sec_cell;
            
            
            float widthval=100;
            
            float widthval2=25;
            
            
            table_cell=new PdfPCell(new Paragraph("Cell 1 Alignment Options for PdfCell in iText. Bottom align the contents in a Cell"));
            table_cell.setFixedHeight(widthval);  //Specify Cell height using setFixedHeight Method 
            table_cell.setVerticalAlignment(Element.ALIGN_TOP);  //Bottom align            
            my_first_table.addCell(table_cell); 
            
            table_cell=new PdfPCell(new Paragraph("Cell 2 We will specify some cell positions in this example. Top Align the Contents"));
            table_cell.setFixedHeight(widthval);            
            table_cell.setVerticalAlignment(Element.ALIGN_TOP); // Top Align 
            my_first_table.addCell(table_cell);            
            
            
            sec_cell=new PdfPCell(table_cell);
            sec_cell.setFixedHeight(widthval2);  //Specify Cell height using setFixedHeight Method 
            sec_cell.setVerticalAlignment(Element.ALIGN_TOP);  //Bottom align            
            my_sec_table.addCell(sec_cell); 
            
            sec_cell=new PdfPCell(new Paragraph("aaaaaaaaaaaa"));
            sec_cell.setFixedHeight(widthval2);  //Specify Cell height using setFixedHeight Method 
            sec_cell.setVerticalAlignment(Element.ALIGN_TOP);  //Bottom align            
            my_sec_table.addCell(sec_cell); */
            
            
            
            //my_first_table.addCell(table_cell); 
            //table_cell=new PdfPCell(new Phrase("Cell 3 iText cell alignment.setting both horizontal and vertical alignment"));
            //table_cell.setFixedHeight(widthval);            
           // table_cell.setVerticalAlignment(Element.ALIGN_CENTER);  /*Center align vertically */
           // table_cell.setHorizontalAlignment(Element.ALIGN_LEFT); /* Left align horizontally */
            
            
            //my_first_table.addCell(table_cell);            
           // table_cell=new PdfPCell(new Phrase("Cell 4 I want to align contents of cell 4 to right. so, we use Element.ALIGN_RIGHT as input"));
           // table_cell.setFixedHeight(widthval);
           // table_cell.setHorizontalAlignment(Element.ALIGN_RIGHT);  /*Align Right*/ 
            
            //my_first_table.addCell(table_cell);          
            //table_cell=new PdfPCell(new Phrase("Cell 5 Center align contents of the Cell using iText API"));
            //table_cell.setFixedHeight(widthval);
            //table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);  /*Align Center */
            
            //my_first_table.addCell(table_cell);       
            //table_cell=new PdfPCell(new Phrase("Cell 6 add some more content to see how justification works. We will add a long text for this cell to check this."));
            //table_cell.setFixedHeight(widthval);
            //table_cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED); /* Align Justified */
            
            
           // my_first_table.addCell(table_cell);   
			
			
			/*PdfPTable table = new PdfPTable(4);
	        PdfPTable nested1 = new PdfPTable(2);
	        nested1.addCell("1.1");
	        nested1.addCell("1.2");
	        PdfPTable nested2 = new PdfPTable(1);
	        nested2.addCell("12.1");
	        nested2.addCell("12.2");
	        for (int k = 0; k < 16; ++k) {
	            if (k == 1) {
	                table.addCell(nested1);
	            } else if (k == 12) {
	                table.addCell(new PdfPCell(nested2));
	            } else {
	                table.addCell("cell " + k);
	            }
	        }*/
	        
			/*PdfPTable table = new PdfPTable(2);
			PdfPTable nested1 = new PdfPTable(4);
				nested1.addCell("1.1");
				nested1.addCell("1.2");
				nested1.addCell("1.3");
				nested1.addCell("1.4");
				for (int k = 0; k < 16; ++k) {
		            if (k == 1) {
		                table.addCell(nested1);
		            
		            } else {
		                table.addCell("cell " + k);
		            }
		        }*/
			//document.add(table);
			
			//document.add(my_first_table);
            
			/*document.add(Detail);*/
			document.close();		
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			/*out.write(baos.toByteArray());
			out.flush();*/
			document=null;
		}
		catch(Exception e)
			{
			e.printStackTrace();
			System.out.println(e);
			}		
		//return "success";
		return null;
	}

	public void setServletContext(ServletContext arg0) 
		{
		
		}
	
	} 