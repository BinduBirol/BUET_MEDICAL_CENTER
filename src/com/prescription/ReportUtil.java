package com.prescription;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ReportUtil {
	
	public void downloadPdf(ByteArrayOutputStream out, HttpServletResponse response)
	{
		try{
			byte[] b =out.toByteArray();
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment;filename=TestDownload.pdf");
			response.setContentLength(b.length);
			response.getOutputStream().write(b);
			response.getOutputStream().flush();
		}catch(IOException ioEx){}
	}
	
}
