package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class Encriptador {
	private String cadena;
	private String cadenaEncriptada;
	private String archivo;

	public Encriptador(String cadena) {
		this.cadena = cadena;
	}
	
	public Encriptador(String cadenaEncriptada, String archivo) {
		this.cadenaEncriptada = cadenaEncriptada;
		this.archivo = archivo;
	}

	public void encriptarCadena(String cadena) throws Exception {
		String[] cadenaAscii = crearListaAscii();
		String archivo = "CERTIFICADORAS";
		String[] codigo = new String[cadena.length()];
		for (int i = 0; i < codigo.length; i++) {
			int bytes = encontrarNumeroPorCaracter(cadena.charAt(i) + "");
			int bytesArchivo = encontrarNumeroPorCaracter(archivo.charAt(i) + "");

			int suma = bytes + bytesArchivo;

			codigo[i] = cadenaAscii[suma];
		}

		String codigoEncriptado = "";
		for (int i = 0; i < codigo.length; i++) {
			codigoEncriptado += codigo[i];
		}
		guardarArchivo(codigoEncriptado + "-" + archivo);
	}

	public static int encontrarNumeroPorCaracter(String cadena) {
		String[] cadenaAscii = crearListaAscii();
		for (int i = 34; i < cadenaAscii.length; i++) {
			if (cadenaAscii[i].equals(cadena)) {
				return i;
			}
		}
		return -1;
	}

	public static String[] crearListaAscii() {
		String[] diccionarioAscii = new String[256];
		diccionarioAscii[32] = " ";
		diccionarioAscii[33] = "!";
		diccionarioAscii[34] = " "; // Agregar el caracter "
		diccionarioAscii[35] = "#";
		diccionarioAscii[36] = "$";
		diccionarioAscii[37] = "%";
		diccionarioAscii[38] = "&";
		diccionarioAscii[39] = "/";
		diccionarioAscii[40] = "(";
		diccionarioAscii[41] = ")";
		diccionarioAscii[42] = "*";
		diccionarioAscii[43] = "+";
		diccionarioAscii[44] = ",";
		diccionarioAscii[45] = "-";
		diccionarioAscii[46] = ".";
		diccionarioAscii[47] = "/";
		diccionarioAscii[48] = "0";
		diccionarioAscii[49] = "1";
		diccionarioAscii[50] = "2";
		diccionarioAscii[51] = "3";
		diccionarioAscii[52] = "4";
		diccionarioAscii[53] = "5";
		diccionarioAscii[54] = "6";
		diccionarioAscii[55] = "7";
		diccionarioAscii[56] = "8";
		diccionarioAscii[57] = "9";
		diccionarioAscii[58] = ":";
		diccionarioAscii[59] = ";";
		diccionarioAscii[60] = "<";
		diccionarioAscii[61] = "=";
		diccionarioAscii[62] = ">";
		diccionarioAscii[63] = "?";
		diccionarioAscii[64] = "@";
		diccionarioAscii[65] = "A";
		diccionarioAscii[66] = "B";
		diccionarioAscii[67] = "C";
		diccionarioAscii[68] = "D";
		diccionarioAscii[69] = "E";
		diccionarioAscii[70] = "F";
		diccionarioAscii[71] = "G";
		diccionarioAscii[72] = "H";
		diccionarioAscii[73] = "I";
		diccionarioAscii[74] = "J";
		diccionarioAscii[75] = "K";
		diccionarioAscii[76] = "L";
		diccionarioAscii[77] = "M";
		diccionarioAscii[78] = "N";
		diccionarioAscii[79] = "O";
		diccionarioAscii[80] = "P";
		diccionarioAscii[81] = "Q";
		diccionarioAscii[82] = "R";
		diccionarioAscii[83] = "S";
		diccionarioAscii[84] = "T";
		diccionarioAscii[85] = "U";
		diccionarioAscii[86] = "V";
		diccionarioAscii[87] = "W";
		diccionarioAscii[88] = "X";
		diccionarioAscii[89] = "Y";
		diccionarioAscii[90] = "Z";
		diccionarioAscii[91] = "[";
		diccionarioAscii[92] = " "; // Agregar el simbolo \
		diccionarioAscii[93] = "]";
		diccionarioAscii[94] = "^";
		diccionarioAscii[95] = "_";
		diccionarioAscii[96] = "`";
		diccionarioAscii[97] = "a";
		diccionarioAscii[98] = "b";
		diccionarioAscii[99] = "c";
		diccionarioAscii[100] = "d";
		diccionarioAscii[101] = "e";
		diccionarioAscii[102] = "f";
		diccionarioAscii[103] = "g";
		diccionarioAscii[104] = "h";
		diccionarioAscii[105] = "i";
		diccionarioAscii[106] = "j";
		diccionarioAscii[107] = "k";
		diccionarioAscii[108] = "l";
		diccionarioAscii[109] = "m";
		diccionarioAscii[110] = "n";
		diccionarioAscii[111] = "o";
		diccionarioAscii[112] = "p";
		diccionarioAscii[113] = "q";
		diccionarioAscii[114] = "r";
		diccionarioAscii[115] = "s";
		diccionarioAscii[116] = "t";
		diccionarioAscii[117] = "u";
		diccionarioAscii[118] = "v";
		diccionarioAscii[119] = "w";
		diccionarioAscii[120] = "x";
		diccionarioAscii[121] = "y";
		diccionarioAscii[122] = "z";
		diccionarioAscii[123] = "{";
		diccionarioAscii[124] = "|";
		diccionarioAscii[125] = "}";
		diccionarioAscii[126] = "~";
		diccionarioAscii[127] = " "; // Es borrado tecla del
		diccionarioAscii[128] = "??";
		diccionarioAscii[129] = "??";
		diccionarioAscii[130] = "??";
		diccionarioAscii[131] = "??";
		diccionarioAscii[132] = "??";
		diccionarioAscii[133] = "??";
		diccionarioAscii[134] = "??";
		diccionarioAscii[135] = "??";
		diccionarioAscii[136] = "??";
		diccionarioAscii[137] = "??";
		diccionarioAscii[138] = "??";
		diccionarioAscii[139] = "??";
		diccionarioAscii[140] = "??";
		diccionarioAscii[141] = "??";
		diccionarioAscii[142] = "??";
		diccionarioAscii[143] = "??";
		diccionarioAscii[144] = "??";
		diccionarioAscii[145] = "??";
		diccionarioAscii[146] = "??";
		diccionarioAscii[147] = "??";
		diccionarioAscii[148] = "??";
		diccionarioAscii[149] = "??";
		diccionarioAscii[150] = "??";
		diccionarioAscii[151] = "??";
		diccionarioAscii[152] = "??";
		diccionarioAscii[153] = "??";
		diccionarioAscii[154] = "??";
		diccionarioAscii[155] = "??";
		diccionarioAscii[156] = "??";
		diccionarioAscii[157] = "??";
		diccionarioAscii[158] = "??";
		diccionarioAscii[159] = "??";
		diccionarioAscii[160] = "??";
		diccionarioAscii[161] = "??";
		diccionarioAscii[162] = "??";
		diccionarioAscii[163] = "??";
		diccionarioAscii[164] = "??";
		diccionarioAscii[165] = "??";
		diccionarioAscii[166] = "??";
		diccionarioAscii[167] = "??";
		diccionarioAscii[168] = "??";
		diccionarioAscii[169] = "??";
		diccionarioAscii[170] = "??";
		diccionarioAscii[171] = "??";
		diccionarioAscii[172] = "??";
		diccionarioAscii[173] = "??";
		diccionarioAscii[174] = "??";
		diccionarioAscii[175] = "??";
		diccionarioAscii[176] = "???";
		diccionarioAscii[177] = "???";
		diccionarioAscii[178] = "???";
		diccionarioAscii[179] = "???";
		diccionarioAscii[180] = "???";
		diccionarioAscii[181] = "??";
		diccionarioAscii[182] = "??";
		diccionarioAscii[183] = "??";
		diccionarioAscii[184] = "??";
		diccionarioAscii[185] = "???";
		diccionarioAscii[186] = "???";
		diccionarioAscii[187] = "???";
		diccionarioAscii[188] = "???";
		diccionarioAscii[189] = "??";
		diccionarioAscii[190] = "??";
		diccionarioAscii[191] = "???";
		diccionarioAscii[192] = "???";
		diccionarioAscii[193] = "???";
		diccionarioAscii[194] = "???";
		diccionarioAscii[195] = "???";
		diccionarioAscii[196] = "???";
		diccionarioAscii[197] = "???";
		diccionarioAscii[198] = "??";
		diccionarioAscii[199] = "??";
		diccionarioAscii[200] = "???";
		diccionarioAscii[201] = "???";
		diccionarioAscii[202] = "???";
		diccionarioAscii[203] = "???";
		diccionarioAscii[204] = "???";
		diccionarioAscii[205] = "???";
		diccionarioAscii[206] = "???";
		diccionarioAscii[207] = "??";
		diccionarioAscii[208] = "??";
		diccionarioAscii[209] = "??";
		diccionarioAscii[210] = "??";
		diccionarioAscii[211] = "??";
		diccionarioAscii[212] = "??";
		diccionarioAscii[213] = "??";
		diccionarioAscii[214] = "??";
		diccionarioAscii[215] = "??";
		diccionarioAscii[216] = "??";
		diccionarioAscii[217] = "???";
		diccionarioAscii[218] = "???";
		diccionarioAscii[219] = "???";
		diccionarioAscii[220] = "???";
		diccionarioAscii[221] = "??";
		diccionarioAscii[222] = "??";
		diccionarioAscii[223] = "???";
		diccionarioAscii[224] = "??";
		diccionarioAscii[225] = "??";
		diccionarioAscii[226] = "??";
		diccionarioAscii[227] = "??";
		diccionarioAscii[228] = "??";
		diccionarioAscii[229] = "??";
		diccionarioAscii[230] = "??";
		diccionarioAscii[231] = "??";
		diccionarioAscii[232] = "??";
		diccionarioAscii[233] = "??";
		diccionarioAscii[234] = "??";
		diccionarioAscii[235] = "??";
		diccionarioAscii[236] = "??";
		diccionarioAscii[237] = "??";
		diccionarioAscii[238] = "??";
		diccionarioAscii[239] = "??";
		diccionarioAscii[240] = "???";
		diccionarioAscii[241] = "??";
		diccionarioAscii[242] = "???";
		diccionarioAscii[243] = "??";
		diccionarioAscii[244] = "??";
		diccionarioAscii[245] = "??";
		diccionarioAscii[246] = "??";
		diccionarioAscii[247] = "??";
		diccionarioAscii[248] = "??";
		diccionarioAscii[249] = "??";
		diccionarioAscii[250] = "??";
		diccionarioAscii[251] = "??";
		diccionarioAscii[252] = "??";
		diccionarioAscii[253] = "??";
		diccionarioAscii[254] = "???";
		diccionarioAscii[255] = "nbsp";
		return diccionarioAscii;
	}

	public void guardarArchivo(String contenido) throws Exception {
		String ruta = "encriptador.txt";

		File file = new File(ruta);
		// Si el archivo no existe es creado
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(contenido);
		bw.close();
	}
	
	public String desencriptarCadena(String cadenaEncriptada, String archivo){
		String[] cadenaAscii = crearListaAscii();
		String[] codigo = new String[cadenaEncriptada.length()];
		for (int i = 0; i < codigo.length; i++) {
			int bytes = encontrarNumeroPorCaracter(cadenaEncriptada.charAt(i) + "");
			int bytesArchivo = encontrarNumeroPorCaracter(archivo.charAt(i) + "");
						
			int suma = bytes - bytesArchivo;
						
			codigo[i] = cadenaAscii[suma];
		}
		
		String codigoEncriptado = "";
		for (int i = 0; i < codigo.length; i++) {
			codigoEncriptado += codigo[i];
		}
		return codigoEncriptado;
	}
}
