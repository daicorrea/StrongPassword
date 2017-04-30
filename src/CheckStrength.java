/**
 * Classe que verifica a for�a de uma senha
 */
public class CheckStrength 
{
	/**
	 * N�veis de for�a da senha
	 */
	public enum LEVEL 
	{
		EASY, MEDIUM, STRONG, VERY_STRONG, EXTREMELY_STRONG
	}

	private static final int NUM = 1;
	private static final int SMALL_LETTER = 2;
	private static final int CAPITAL_LETTER = 3;
	private static final int OTHER_CHAR = 4;

	/**
	 * Dicion�rio de senhas simples
	 */
	private final static String[] DICTIONARY = 
	{ 
		"password", 
		"abc123", 
		"iloveyou", 
		"adobe123", 
		"123123", 
		"sunshine", 
		"1314520", 
		"a1b2c3", 
		"123qwe", 
		"aaa111", 
		"qweasd", 
		"admin", 
		"passwd" 
	};

	/**
	 * Verifica o tipo de um caractere
	 */
	private static int checkCharacterType(char c) 
	{
		if (c >= 48 && c <= 57) 
		{
			return NUM;
		}
		
		if (c >= 65 && c <= 90) 
		{
			return CAPITAL_LETTER;
		}
		
		if (c >= 97 && c <= 122) 
		{
			return SMALL_LETTER;
		}
		
		return OTHER_CHAR;
	}

	/**
	 * Conta o n�mero de caracteres de um determinado tipo em uma senha
	 */
	private static int countLetter(String passwd, int type) 
	{
		int count = 0;
		
		if (null != passwd && passwd.length() > 0) 
		{
			for (char c : passwd.toCharArray()) 
			{
				if (checkCharacterType(c) == type) 
				{
					count++;
				}
			}
		}
		
		return count;
	}

	/**
	 * Verifica a for�a de uma senha
	 */
	public static int checkPasswordStrength(String passwd) 
	{
		if (StringUtils.equalsNull(passwd)) 
		{
			throw new IllegalArgumentException("password is empty");
		}
		
		int len = passwd.length();
		int level = 0;

		// adiciona pontos
		if (countLetter(passwd, NUM) > 0) 
		{
			level++;
		}
		
		if (countLetter(passwd, SMALL_LETTER) > 0) 
		{
			level++;
		}
		
		if (len > 4 && countLetter(passwd, CAPITAL_LETTER) > 0) 
		{
			level++;
		}
		
		if (len > 6 && countLetter(passwd, OTHER_CHAR) > 0) 
		{
			level++;
		}

		if (len > 4 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0
				|| countLetter(passwd, NUM) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0
				|| countLetter(passwd, NUM) > 0 && countLetter(passwd, OTHER_CHAR) > 0
				|| countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0
				|| countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0
				|| countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) 
		{
			level++;
		}

		if (len > 6 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0 
				|| countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0
				|| countLetter(passwd, NUM) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0 
				|| countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) 
		{
			level++;
		}

		if (len > 8 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) 
		{
			level++;
		}

		if (len > 6 && countLetter(passwd, NUM) >= 3 && countLetter(passwd, SMALL_LETTER) >= 3
				|| countLetter(passwd, NUM) >= 3 && countLetter(passwd, CAPITAL_LETTER) >= 3
				|| countLetter(passwd, NUM) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2
				|| countLetter(passwd, SMALL_LETTER) >= 3 && countLetter(passwd, CAPITAL_LETTER) >= 3
				|| countLetter(passwd, SMALL_LETTER) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2
				|| countLetter(passwd, CAPITAL_LETTER) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2) 
		{
			level++;
		}

		if (len > 8 && countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2 
				|| countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2
				|| countLetter(passwd, NUM) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2 
				|| countLetter(passwd, SMALL_LETTER) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2) 
		{
			level++;
		}

		if (len > 10 && countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2) 
		{
			level++;
		}

		if (countLetter(passwd, OTHER_CHAR) >= 3) 
		{
			level++;
		}
		
		if (countLetter(passwd, OTHER_CHAR) >= 6) 
		{
			level++;
		}

		if (len > 12) 
		{
			level++;
			
			if (len >= 16) 
			{
				level++;
			}
		}

		// desconta pontos
		if ("abcdefghijklmnopqrstuvwxyz".indexOf(passwd) > 0 || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(passwd) > 0) 
		{
			level--;
		}
		
		if ("qwertyuiop".indexOf(passwd) > 0 || "asdfghjkl".indexOf(passwd) > 0 || "zxcvbnm".indexOf(passwd) > 0) 
		{
			level--;
		}
		
		if (StringUtils.isNumeric(passwd) && ("01234567890".indexOf(passwd) > 0 || "09876543210".indexOf(passwd) > 0)) 
		{
			level--;
		}

		if (countLetter(passwd, NUM) == len || countLetter(passwd, SMALL_LETTER) == len || countLetter(passwd, CAPITAL_LETTER) == len) 
		{
			level--;
		}

		// aaabbb
		if (len % 2 == 0) 
		{ 
			String part1 = passwd.substring(0, len / 2);
			String part2 = passwd.substring(len / 2);
			
			if (part1.equals(part2)) 
			{
				level--;
			}
			
			if (StringUtils.isCharEqual(part1) && StringUtils.isCharEqual(part2)) 
			{
				level--;
			}
		}
		
		// ababab
		if (len % 3 == 0) 
		{ 
			String part1 = passwd.substring(0, len / 3);
			String part2 = passwd.substring(len / 3, len / 3 * 2);
			String part3 = passwd.substring(len / 3 * 2);

			if (part1.equals(part2) && part2.equals(part3)) 
			{
				level--;
			}
		}

		// 19881010 ou 881010
		if (StringUtils.isNumeric(passwd) && len >= 6) 
		{ 
			int year = 0;
			
			if (len == 8 || len == 6) 
			{
				year = Integer.parseInt(passwd.substring(0, len - 4));
			}
			
			int size = StringUtils.sizeOfInt(year);
			int month = Integer.parseInt(passwd.substring(size, size + 2));
			int day = Integer.parseInt(passwd.substring(size + 2, len));
			
			if (year >= 1950 && year < 2050 && month >= 1 && month <= 12 && day >= 1 && day <= 31) 
			{
				level--;
			}
		}

		// dicionario
		if (null != DICTIONARY && DICTIONARY.length > 0) 
		{
			for (int i = 0; i < DICTIONARY.length; i++) 
			{
				if (passwd.equals(DICTIONARY[i]) || DICTIONARY[i].indexOf(passwd) >= 0) 
				{
					level--;
					break;
				}
			}
		}

		if (len <= 6) 
		{
			level--;

			if (len <= 4) 
			{
				level--;
			
				if (len <= 3) 
				{
					level = 0;
				}
			}
		}

		if (StringUtils.isCharEqual(passwd)) 
		{
			level = 0;
		}

		if (level < 0) 
		{
			level = 0;
		}

		return level;
	}

	/**
	 * Retorna o n�vel de seguran�a de uma senha
	 */
	public static LEVEL getPasswordLevel(String passwd) 
	{
		int level = checkPasswordStrength(passwd);
		
		switch (level) 
		{
			case 0:
			case 1:
			case 2:
			case 3:
				return LEVEL.EASY;

			case 4:
			case 5:
			case 6:
				return LEVEL.MEDIUM;
			
			case 7:
			case 8:
			case 9:
				return LEVEL.STRONG;
			
			case 10:
			case 11:
			case 12:
				return LEVEL.VERY_STRONG;
			
			default:
				return LEVEL.EXTREMELY_STRONG;
		}
	}
	
	public static void checkWordLevel(String passwd) 
	{
		System.out.println("A senha: "+ passwd + " possui forca:  " + CheckStrength.checkPasswordStrength(passwd)+" e o nivel eh: " + CheckStrength.getPasswordLevel(passwd));
	}	
	
}
