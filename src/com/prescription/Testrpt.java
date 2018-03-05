package com.prescription;
 
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Properties;
 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
 
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
/*import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Paragraph;*/
import java.io.FileOutputStream;

public class Testrpt {
	
	public void execute() throws Exception{
		Document document = new Document();
		PdfWriter.getInstance(document,  new FileOutputStream("HelloWorld.pdf"));
		document.open();
		document.add(new Paragraph("Hello World"));
		document.close();
			
	}}
	
	/*public static void main(String args[]){
		try{
			new Testrpt();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}*/