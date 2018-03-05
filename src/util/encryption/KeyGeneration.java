package util.encryption;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class KeyGeneration 
{

	private int PrimeLength = 0;
	
	public String execute()
	{
		PrimeLength = 256;
		ArrayList lst = new ArrayList();
		ServletActionContext.getRequest().setAttribute("keylen", PrimeLength);
		KeyPacket kp = rsa(lst);
		ServletActionContext.getRequest().setAttribute("keypacket", kp);
		KeyPacket kp1 = (KeyPacket) lst.get(0);
		ServletActionContext.getRequest().getSession().setAttribute("kpacket", (KeyPacket) lst.get(0));
		
		try
		{
			String xml = "<xml><key>"+kp.getKey()+"</key><modulus>"+kp.getModulus()+"</modulus><keylen>"+(PrimeLength*2)+"</keylen></xml>";
//			String xml = "<xml><key>17</key><modulus>949075e647bb47dba292ae89e8157a43c30199b7ce56c119bacece0ea71f5ca9</modulus><keylen>"+(PrimeLength*2)+"</keylen></xml>";
			ServletActionContext.getResponse().setContentType("text/xml");
			ServletActionContext.getResponse().getWriter().write(xml);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public KeyPacket rsa(ArrayList lst)
	{
		byte byte0 = 24;
		PrimeLength = PrimeLength / 2;
		boolean flag = false;
		BigInteger biginteger = new BigInteger("1");
		BigInteger biginteger1 = new BigInteger("0");
		BigInteger biginteger3 = new BigInteger("23");
		BigInteger biginteger4 = new BigInteger("23");
		BigInteger biginteger5 = new BigInteger("0");
		BigInteger biginteger6 = new BigInteger("0");
		BigInteger biginteger7 = new BigInteger("0");
		BigInteger biginteger9 = new BigInteger("0");
		do
		{
			if (flag)
			{
				break;
			}
			Random random = new Random();
			BigInteger biginteger8 = new BigInteger(PrimeLength, byte0, random);
			random = new Random();
			random = new Random();
			BigInteger biginteger10 = new BigInteger(PrimeLength, byte0, random);
			biginteger8 = biginteger8.abs();
			biginteger10 = biginteger10.abs();
			biginteger5 = biginteger8.multiply(biginteger10);
			biginteger8 = biginteger8.subtract(biginteger);
			biginteger10 = biginteger10.subtract(biginteger);
			biginteger6 = biginteger8.multiply(biginteger10);
			biginteger6 = biginteger6.abs();
			BigInteger biginteger2 = biginteger3.gcd(biginteger6);
			if (biginteger2.equals(biginteger))
			{
				flag = true;
			}
		} while (true);

		biginteger4 = biginteger3.modInverse(biginteger6);
		String s = biginteger3.toString(16) + "Z" + biginteger4.toString(16)
				+ "Z" + biginteger5.toString(16);

		KeyPacket kp = new KeyPacket();
		kp.setKey(biginteger3.toString(16));
		kp.setModulus(biginteger5.toString(16));

		KeyPacket kp1 = new KeyPacket();
		kp1.setKey(biginteger3.toString(16));
		kp1.setModulus(biginteger5.toString(16));
		kp1.setDkey(biginteger4.toString(16));
		lst.add(kp1);
//		System.out.println("modulus length " + kp1.getDkey().length());
		return kp;
	}
}