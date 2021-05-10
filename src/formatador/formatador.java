package formatador;

public class formatador {
	public static String removeimpurezas(String a) {
			   a = a.replaceAll("^\"|\"$", "");
			   return a;
	}
}
