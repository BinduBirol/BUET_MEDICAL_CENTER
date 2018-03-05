package util.login;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class ValidateUser
{
	public static String validate_value = "user_role";
	public static String time_out= "sessiontimeout";
	public static String user_login = "userlogin";
	public static boolean validate(Map session)
	{
		if (session.get(validate_value) != null)
			return true;

		return false;
	}

	public static boolean validate(ActionContext context)
	{
		Map session = context.getSession();
		if (session.get(validate_value) != null)
			return true;

		return false;
	}
}
