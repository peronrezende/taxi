package br.uff.ic.taxi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
					System.out.println(String.format("-Mapa %d Celula %d Total %d", c.getMapa(), c.getCelula(), c.getTotal()));
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

	public static Point setPonto(Integer i, Count org, Count dst) {
		BigDecimal y = dst.getLatitudeCentral().subtract(org.getLatitudeCentral());
		y.setScale(10, RoundingMode.HALF_UP);
		BigDecimal x = dst.getLongitudeCentral().subtract(org.getLongitudeCentral());
		x.setScale(10, RoundingMode.HALF_UP);
		Point ponto = new Point(i, x, y);
		ponto.setLatitude(org.getLatitudeCentral());
		ponto.setLongitude(org.getLongitudeCentral());
		return ponto;
	}

}
