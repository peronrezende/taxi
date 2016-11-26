package br.uff.ic.taxi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Util {
	// TODO showDados
	public static void showDados(Count count, List<Count> listCount) {
		System.out.println(String.format("Mapa %d Celula %d Total %d", count.getMapa(), count.getCelula(), count.getTotal()));
		List<Integer> listCel = Search.listNeighbor(count.getCelula());		
		for (Count c : listCount) {			
			if (c.getMapa().equals(count.getMapa())) {
				if (c.getCelula().equals(count.getCelula()) || listCel.contains(c.getCelula())) {
					System.out.println(String.format("-Mapa %d Celula %d Total %d", c.getMapa(), c.getCelula(), c.getTotal()));
				}
			}
		}		
	}

	// TODO readFile
	public static String readFile(String path, Charset encoding) 
			  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
		
	// TODO build
	public static void build(String path, String name, Integer i, String cabecalho, String conteudo, String rodape) {
		StringBuilder fileName = new StringBuilder();
		fileName.append(path);
		fileName.append("/");
		fileName.append("map");
		fileName.append(i);
		File file = new File(fileName.toString());
		file.mkdirs();
		
		fileName.append("/");
		fileName.append(name);
		PrintWriter printWriter = null;
		try {			
			printWriter = new PrintWriter(fileName.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printWriter.println(cabecalho);
		printWriter.println(conteudo);
		printWriter.println(rodape);
		printWriter.close();
	}

	// TODO setPonto
	public static Point setPonto(Integer i, Count org, Count dst) {
		BigDecimal y = dst.getLatitudeCentral().subtract(org.getLatitudeCentral());
		BigDecimal x = dst.getLongitudeCentral().subtract(org.getLongitudeCentral());
		Point ponto = new Point(i, x, y);
		ponto.setLatitude(org.getLatitudeCentral());
		ponto.setLongitude(org.getLongitudeCentral());
		return ponto;
	}

}
