/**
 * M�todos est�ticos para manipula��o de strings
 */
public class StringUtils 
{
	private final static int[] SIZE_TABLE = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };

	/**
	 * Calcula o tamanho de um n�mero inteiro
	 */
	public static int sizeOfInt(int x) 
	{
		for (int i = 0;; i++)
			if (x <= SIZE_TABLE[i]) 
				return i + 1;
	}

	/**
	 * Verifica se todos os caracteres de uma string s�o iguais
	 */
	public static boolean isCharEqual(String str) 
	{
		return str.replace(str.charAt(0), ' ').trim().length() == 0;
	}

	/**
	 * Verifica se uma string � formada apenas por d�gitos num�ricos
	 */
	public static boolean isNumeric(String str) 
	{
		for (int i = str.length(); --i >= 0;) 
		{
			if (!Character.isDigit(str.charAt(i))) 
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Verifica se uma string cont�m apenas espa�os em branco, � vazia ou nula
	 */
	public static boolean equalsNull(String str) 
	{
		int strLen;
		
		if (str == null || (strLen = str.length()) == 0 || str.equalsIgnoreCase("null")) 
		{
			return true;
		}
		
		for (int i = 0; i < strLen; i++) 
		{
			if (!Character.isWhitespace(str.charAt(i)))
			{
				return false;
			}
		}
		
		return true;
	}
}