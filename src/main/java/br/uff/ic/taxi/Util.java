package br.uff.ic.taxi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Util {
	public static void ShowDados(Count count, List<Count> listCount) {
		System.out.println(String.format("Mapa %d Celula %d Total %d", count.getMapa(), count.getCelula(), count.getTotal()));
		List<Integer> listCel = Search.listNeighbor(count.getCelula());		
		for (Count c : listCount) {			
			if (c.getMapa().equals(count.getMapa())) {
				if (c.getCelula().equals(count.getCelula()) || listCel.contains(c.getCelula())) {
					System.out.println(String.format("Celula %d Total %d", c.getCelula(), c.getTotal()));
				}
			}
		}		
	}

	public static String readFile(String path, Charset encoding) 
			  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
		
	public static void build(String cabecalho, String conteudo, String rodape) {
		String fileName = "magic.html";
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printWriter.println(cabecalho);
		printWriter.println(conteudo);
		printWriter.println(rodape);
		printWriter.close();
	}

}
