package util.encryption;

public class KeyPacket
{
	private String key;
	private String dkey;
	private String modulus;

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getDkey()
	{
		return dkey;
	}

	public void setDkey(String dkey)
	{
		this.dkey = dkey;
	}

	public String getModulus()
	{
		return modulus;
	}

	public void setModulus(String modulus)
	{
		this.modulus = modulus;
	}
}
