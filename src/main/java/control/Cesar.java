package control;

public class Cesar {
	private static final int CHAVE = 3;
	public String criptografar(String dado){
		String result = "";
		for(int i = 0; i < dado.length(); i++){
			char carac = (char)(dado.charAt(i));
			for(int j = 0; j < CHAVE; j++){
				if(carac == 'z'){
					carac = 'a';
				}
				else if(carac == '9'){
					carac = '0';
				}
				else{
					carac += 1;
				}
			}
			result += carac;
		}
		return result;
	}
	
	public String descriptografar(String dado){
		String result = "";
		for(int i = 0; i < dado.length(); i++){
			char carac = (char)(dado.charAt(i));
			for(int j = 0; j < CHAVE; j++){
				if(carac == 'a'){
					carac = 'z';
				}
				else if(carac == '0'){
					carac = '9';
				}
				else{
					carac -= 1;
				}
			}
			result += carac;
		}
		return result;
	}
}
