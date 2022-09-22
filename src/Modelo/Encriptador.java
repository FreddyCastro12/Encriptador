package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class Encriptador {
	private String cadena;

	public Encriptador(String cadena) {
		this.cadena = cadena;
	}

	public void encriptarCadena(String cadena) throws Exception {
		String archivo = "COMPUTADORA";

		char[] codigo = new char[cadena.length()];

		for (int i = 0; i < codigo.length; i++) {
			char bytes = cadena.charAt(i);
			char bytesArchivo = archivo.charAt(i);
			
			int suma = bytes + bytesArchivo;
			
			codigo[i] = (char) suma;
			System.out.println(codigo[i]);
		}

		String codigoEncriptado = new String(codigo);
		guardarArchivo(codigoEncriptado);
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
}
