package kaisarasSipherGUI;

public class KaisarasDecode {
	private String teliko = "";
	private char character,decoded=' ';
	private int s = 3;
	private char[] alpha = {'α','β','γ','δ','ε','ζ','η','θ','ι','κ','λ','μ','ν','ξ','ο','π','ρ','σ','τ','υ','φ','χ','ψ','ω'};
	
	public String kodikopoioisi(String arxiko) {
		arxiko = arxiko.toLowerCase();
		for (int i=0; i<arxiko.length(); i++) {
			character = arxiko.charAt(i);
			if(character != ' ') {
				decoded = (char) (arxiko.charAt(i)+s);
				if (decoded > 'ω') {
					decoded = (char) (arxiko.charAt(i)-s);
					for(int j=0; j<alpha.length; j++) {
						if (alpha[j] == character) {
							int dif = 23 - j;	
							decoded = (char)('α' + dif);
							break;
						}
					}
					if(character == 'ω') {
						decoded = (char)('α' + s-1);
					}
				}
				teliko +=decoded;
			}else {
				decoded = ' ';
				teliko +=decoded;
			}
		}
		return teliko;
	}
	
	public String apokodikopoioisi(String arxiko) {
		teliko = "";
		arxiko = arxiko.toLowerCase();
		for (int i=0; i<arxiko.length(); i++) {
			character = arxiko.charAt(i);
			if(character != ' ') {
				decoded = (char) (arxiko.charAt(i)-s);
				if (decoded < 'α') {
					decoded = (char) (arxiko.charAt(i)+s);
					for(int j=0; j<alpha.length; j++) {
						if (alpha[j] == character) {
							int dif = 23 - j;	
							decoded = (char)('ω' - dif);
							break;
						}
					}
					if(character == 'α') {
						decoded = (char)('ω' - s+1);
					}
				}
				teliko +=decoded;
			}else {
				decoded = ' ';
				teliko +=decoded;
			}
		}
		return teliko;
	}
}
