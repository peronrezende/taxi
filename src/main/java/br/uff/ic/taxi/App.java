package br.uff.ic.taxi;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Config config = new Config();
	private static List<Count> oldListCount = null;
	
	// TODO main
	public static void main( String[] args )
    {
		Database database = new Database();
		int oldI = -1;
		Timestamp oldStart = null;
		Timestamp oldEnd = null;
		List<Point> oldListTaxi = null;
		for (int i=0; i<config.getMapas(); i++) {
			try {
				List<Point> listTaxi = database.getListTaxi(i, config);
				buildIndexHtml(i, database.getStart(), database.getEnd(), oldI, oldStart, oldEnd);				
				buildMapJS(i, listTaxi, oldI, oldListTaxi);				
				oldI = i;
				oldStart = database.getStart();
				oldEnd = database.getEnd();
				oldListTaxi = listTaxi;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		database.close();			
	}
	
	// TODO buildMapJS
	private static void buildMapJS(Integer i, List<Point> listTaxi, Integer oldI, List<Point> oldListTaxi) {
		List<Count> listCount = new ArrayList<Count>();
		
		/*
		 * Desenha o mapa (trecho comum aos dois mapas)
		 */
		String map = JavaScript.drawMap(config); 						

		StringBuilder quadrados = new StringBuilder();
		quadrados.append("function loadSquare() {\n");
		BigDecimal tL = new BigDecimal(config.getTamanhoLateral());
		BigDecimal lado = tL.divide(config.FRACAO);
		BigDecimal lat = config.getLatitudeMin();
		Integer celula = 1;
		while (lat.compareTo(config.getLatitudeMax())<0) {
			BigDecimal lng = config.getLongitudeMin();
			while (lng.compareTo(config.getLongitudeMax())<0) {												
				/*
				 * Conta quantos Taxis tem dentro do quadrado (trecho comum aos dois mapas)
				 */
				Integer total = 0;
				for (Point taxi : listTaxi) {
					if ((taxi.getLatitude().compareTo(lat)>=0 && taxi.getLatitude().compareTo(lat.add(lado))<=0) &&
							(taxi.getLongitude().compareTo(lng)>=0 && taxi.getLongitude().compareTo(lng.add(lado))<=0)) {
						total++;
					}
				}
				/*
				 * Desenha os quadrados (trecho comum aos dois mapas)
				 */
				listCount.add(new Count(i, celula, total, lat, lng, lado));
				if (total>0) {							
					quadrados.append(JavaScript.drawSquare(lat, lng, lado, total, celula));
				}
				lng=lng.add(lado);
				celula++;
			}
			lat=lat.add(lado);
		}
		quadrados.append("}\n\n");
		
		/*
		 * Desenha cada taxi (mapa de densidade)
		 */
		StringBuilder taxisDst = new StringBuilder();
		taxisDst.append("function loadTaxi() {\n");
		for (Point taxi : listTaxi) {
			taxisDst.append(JavaScript.drawDstTaxi(taxi));
		}
		taxisDst.append("}\n\n");				

		/*
		 * Desenha cada taxi (mapa de deslocamento)
		 */		
		StringBuilder taxisSrcDst = new StringBuilder();
		taxisSrcDst.append("function loadTaxi() {\n");
		if (oldI > -1) { // Se existe mapa anterior (não ocorre no Mapa 0)
			for (Point taxi : oldListTaxi) {
				taxisSrcDst.append(JavaScript.drawSrcTaxi(taxi));
			}
		}
		for (Point taxi : listTaxi) {
			taxisSrcDst.append(JavaScript.drawDstTaxi(taxi));
		}
		taxisSrcDst.append("}\n\n");				

		/*
		 * Desenha as setas (mapa de densidade)
		 */
		List<Point> listPonto = new ArrayList<Point>();
		int c = 0;
		StringBuilder setasDst = new StringBuilder();
		setasDst.append("function loadArrow() {\n");
		for (Count org : listCount) {
			// Util.ShowDados(org, listCount);
			Count dst = Search.maxNeighbor(i, org, listCount);
			if (org.getTotal()>0) {
				setasDst.append(PreProcess.arrow(org, dst));
			}
			listPonto.add(Util.setPonto(c, org, dst));
			c++;
		}
		setasDst.append("}\n\n");
		
		// printList("Lista escalar do mapa "i, listPonto);
				
		Point[][] v = matriz(listPonto);
		print("Mapa densidade: Matriz escalar do ", i, v);
		
		double[][] u = mdfU(i, listPonto.size(), v);
		int t = config.getVizinhos().intValue()*2+1;
		print("Mapa densidade: Matriz u de ", i, u, t);
		
		/*
		 * Desenha os circulos (mapa de densidade)
		 */

		StringBuilder circulosDst = new StringBuilder();
		
		double[][] s = mdfS(i, listPonto.size(), v);
		print("Matriz s de ", i, s, t);
		System.out.println("\n");
		
		circulosDst.append(setUS(u, s, v));
		
		/*
		 * Desenha as setas (mapa de deslocamento)
		 */
		StringBuilder setasSrcDst = new StringBuilder();
		StringBuilder circulosSrcDst = new StringBuilder();
		if (oldI > -1) { // Se existir mapa anterior (não ocorre no Mapa 0)
			listPonto = new ArrayList<Point>();
			c = 0;
			setasSrcDst.append("function loadArrow() {\n");
			for (Count org : oldListCount) {
				// Util.ShowDados(org, listCount);
				Count dst = Search.maxNeighbor(i, org, listCount);
				if (org.getTotal()>0) {
					setasSrcDst.append(PreProcess.arrow(org, dst));
				}
				listPonto.add(Util.setPonto(c, org, dst));
				c++;
			}
			setasSrcDst.append("}\n\n");
			
			// printList("Lista escalar do mapa "i, listPonto);
			
			v = matriz(listPonto);
			print("Mapa deslocamento: Matriz escalar do mapa ", i, v);
			
			u = mdfU(i, listPonto.size(), v);
			t = config.getVizinhos().intValue()*2+1;
			print("Mapa deslocamento: Matriz u de ", i, u, t);
			
			/*
			 * Desenha os circulos (mapa de deslocamento)
			 */
	
			s = mdfS(i, listPonto.size(), v);
			print("Mapa deslocamento: Matriz s de ", i, s, t);
			System.out.println("\n");
			
			circulosSrcDst.append(setUS(u, s, v));
		} else {
			setasSrcDst.append("function loadArrow() {\n");
			setasSrcDst.append("\t// Não tem mapa anterior, não há o que fazer aqui.\n");
			setasSrcDst.append("}\n\n");
			circulosSrcDst.append("function loadCircle() {\n");
			circulosSrcDst.append("\t// Não tem mapa anterior, não há o que fazer aqui.\n");
			circulosSrcDst.append("}\n\n");
		}
		
		StringBuilder conteudo = new StringBuilder();
		conteudo.append(map.toString());
		conteudo.append(quadrados.toString());
		conteudo.append(taxisDst.toString());
		conteudo.append(setasDst.toString());
		conteudo.append(circulosDst.toString());
		Util.build("densidade", "map.js", i, "", conteudo.toString(), "");
		
		conteudo = new StringBuilder();
		conteudo.append(map.toString());
		conteudo.append(quadrados.toString());
		conteudo.append(taxisSrcDst.toString());
		conteudo.append(setasSrcDst.toString());
		conteudo.append(circulosSrcDst.toString());
		Util.build("deslocamento", "map.js", i, "", conteudo.toString(), "");

		oldListCount = listCount;
	}

	// TODO setUS
	private static String setUS(double[][] u, double[][] s, Point[][] v) {
		int o = config.getVizinhos()*2+1;		
		List<Point> listPoint = new ArrayList<Point>();
		for (int i=0; i<o; i++) {
			for (int j=0; j<o; j++) {
				v[i][j].setU(u[i][j]);
				v[i][j].setS(s[i][j]);
				listPoint.add(v[i][j]);
			}	 
		}
		
		Collections.sort(listPoint, new Comparator<Point>() {
	        public int compare(Point p2, Point p1)
	        {
	            return  p1.getU().compareTo(p2.getU());
	        }
	    });
		
		StringBuilder code = new StringBuilder();
		code.append("function loadCircle() {\n");
		
		System.out.println("U");
		for (int i=0; i<listPoint.size(); i++) {
			if (i<config.getMarcas()) {
				code.append(JavaScript.drawCircle("UMax", "red", round(listPoint.get(i).getU().doubleValue(), 5),  listPoint.get(i).getLatitude(), listPoint.get(i).getLongitude()));
			}
			if (i>=(listPoint.size()-config.getMarcas())) {
				code.append(JavaScript.drawCircle("UMin", "blue", round(listPoint.get(i).getU().doubleValue(), 5),  listPoint.get(i).getLatitude(), listPoint.get(i).getLongitude()));
			}
			System.out.println(round(listPoint.get(i).getU().doubleValue(), 5));
		}
		
		Collections.sort(listPoint, new Comparator<Point>() {
	        public int compare(Point p2, Point p1)
	        {
	            return  p1.getS().compareTo(p2.getS());
	        }
	    });
		
		System.out.println("S");
		for (int i=0; i<listPoint.size(); i++) {
			if (i<config.getMarcas()) {
				code.append(JavaScript.drawCircle("SMax", "orange", round(listPoint.get(i).getS().doubleValue(), 5),  listPoint.get(i).getLatitude(), listPoint.get(i).getLongitude()));
			}
			if (i>=(listPoint.size()-config.getMarcas())) {
				code.append(JavaScript.drawCircle("SMin", "yellow", round(listPoint.get(i).getS().doubleValue(), 5),  listPoint.get(i).getLatitude(), listPoint.get(i).getLongitude()));
			}
			System.out.println(round(listPoint.get(i).getS().doubleValue(), 5));
		}
		
		code.append("}");
				
		return code.toString();
	}

	// TODO buildIndexHtml
	private static void buildIndexHtml(Integer i, Timestamp start, Timestamp end, Integer oldI, Timestamp oldStart, Timestamp oldEnd) {	
		try {
			StringBuilder pagination = new StringBuilder();
			pagination.append("\t<ul class=\"pagination\">\n");
			for (int j=0; j<config.getMapas(); j++) {
				if (i==j) {
					pagination.append("\t<li class=\"active\"><a href=\"../map");
					pagination.append(j);
					pagination.append("/index.html\">");
				} else {
					pagination.append("\t<li><a href=\"../map");
					pagination.append(j);
					pagination.append("/index.html\">");
				}
				pagination.append(j);
				pagination.append("</a></li>\n");	
			}
			pagination.append("</ul>\n\n");			
			
			StringBuilder titleDst = new StringBuilder();			
			titleDst.append("\t<p>Mapa ");
			titleDst.append(i);
			titleDst.append(" : ");
			titleDst.append(start);
			titleDst.append(" .. ");
			titleDst.append(end);
			titleDst.append("</p>\n");
			
			StringBuilder map = new StringBuilder();
			map.append("\t<div id=\"map\" style=\"width: ");
			map.append(config.getWidth());
			map.append("px; height: ");
			map.append(config.getHeight());
			map.append("px; position: relative;\"></div>\n");
			
			StringBuilder titleSrcDst = new StringBuilder();
			titleSrcDst.append("\t<p>Mapa ");
			
			titleSrcDst.append(i);
			titleSrcDst.append(" : ");
			titleSrcDst.append(start);
			titleSrcDst.append(" .. ");
			titleSrcDst.append(end);
			
			if (oldI > -1) {
				titleSrcDst.append(" + Mapa ");
				titleSrcDst.append(oldI);
				titleSrcDst.append(" : ");
				titleSrcDst.append(oldStart);
				titleSrcDst.append(" .. ");
				titleSrcDst.append(oldEnd);
			}
			
			titleSrcDst.append("</p>\n");
			
			String cabecalho = Util.readFile("cabecalhoDensidade.txt", Charset.defaultCharset());
			StringBuilder conteudo = new StringBuilder();
			conteudo.append(pagination.toString());			
			conteudo.append(titleDst.toString());
			conteudo.append(map.toString());			
			String rodape = Util.readFile("rodape.txt", Charset.defaultCharset());			
			Util.build("densidade", "index.html", i, cabecalho, conteudo.toString(), rodape);
			
			cabecalho = Util.readFile("cabecalhoDeslocamento.txt", Charset.defaultCharset());			
			conteudo = new StringBuilder();
			conteudo.append(pagination.toString());			
			conteudo.append(titleSrcDst.toString());
			conteudo.append(map.toString());
			Util.build("deslocamento", "index.html", i, cabecalho, conteudo.toString(), rodape);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO printList
	private static void printList(String title, int i, double[] k) {
		System.out.print(title);
		System.out.println(i);
		int c = 0;
		for (double ponto : k) {
			System.out.print(c);
			System.out.print("[");
			System.out.print(ponto);
			System.out.println("]");
			c++;
		}
	}
	
	private static void printList(String title, int i, List<Point> listPoint) {
		System.out.print(title);
		System.out.println(i);
		int c = 0;
		for (Point ponto : listPoint) {
			System.out.print(c);
			System.out.print(" ");
			System.out.print(ponto.getX());
			System.out.print(" ");
			System.out.println(ponto.getY());
			c++;
		}
	}

	// TODO mdfS
	private static double[][] mdfS(Integer map, Integer size, Point[][] v0) {
		int o = config.getVizinhos()*2+1;
		Point[][] v = new Point[o][o];
		for (int i=0; i<o; i++) {
			for (int j=0; j<o; j++) {
				Point a = v0[i][j];
				Point n = new Point(a.getLatitude(), a.getLongitude());
				n.setI(a.getI());
				n.setX(a.getY());
				n.setY(a.getX().multiply(new BigDecimal(-1)));
				v[i][j] = n;
			}	
		}
		int side = config.getVizinhos().intValue()*2+1;
		BigDecimal h = new BigDecimal(config.getTamanhoLateral()).divide(config.FRACAO);
		double k[] = new double[size];
		double u[] = new double[size];
		double m[][] = new double[size][size];
		int c = 0;
		for (int j=0; j<side; j++) {
			for (int i=0; i<side; i++) {
				BigDecimal r = BigDecimal.ZERO;
				if ((i+1)<side) {
					r = v[i+1][j].getX();
				}
				BigDecimal t = BigDecimal.ZERO;
				if ((j+1)<side) {
					t = v[i][j+1].getY();
				}
				BigDecimal part1 = r.subtract(v[i][j].getX()).divide(h);
				part1 = part1.multiply(new BigDecimal(-1));
				BigDecimal part2 = t.subtract(v[i][j].getY()).divide(h);
				k[c] = part1.add(part2).doubleValue();
				c++;
			}
		}
		printList("MDF de s, matriz com os totais de ", map, k);
		for (int j=0; j<size; j++) {
			for (int i=0; i<size; i++) {
				m[i][j]=0;
			}
		}
		for (int d=0; d<size; d++) {
			m[d][d]=-4;
		}
		c = 0;
		for (int j=0; j<side; j++) {
			for (int i=0; i<side; i++) {
				Point r = new Point();
				if ((i+1)<side) {
					r = v[i+1][j];
				}
				Point t = new Point();
				if ((j+1)<side) {
					t = v[i][j+1];
				}
				Point l = new Point();
				if ((i-1)>-1) {
					l = v[i-1][j];
				}
				Point b = new Point();
				if ((j-1)>-1) {
					b = v[i][j-1];
				}
				if (r.getI() != -1) {
					m[r.getI()][c] = r.getV();
				}
				if (t.getI() != -1) {
					m[t.getI()][c] = t.getV();
				}
				if (l.getI() != -1) {
					m[l.getI()][c] = l.getV();
				}
				if (b.getI() != -1) {
					m[b.getI()][c] = b.getV();
				}
				c++;
			}
		}
		int t = config.getVizinhos().intValue()*2+1;
		t = t*t;
		print("MDF de s, matriz m de ", map, m, t);
		RealMatrix coefficients = new Array2DRowRealMatrix(m, false);
		DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
		RealVector constants = new ArrayRealVector(k, false);
		RealVector solution = solver.solve(constants);
		
		for (int d=0; d<size; d++) {
			u[d]=solution.getEntry(d);
		}
		return matriz(u);		
	}

	// TODO mdfU
	private static double[][] mdfU(Integer map, Integer size, Point[][] v) {
		int side = config.getVizinhos().intValue()*2+1;
		BigDecimal h = new BigDecimal(config.getTamanhoLateral()).divide(config.FRACAO);
		double k[] = new double[size];
		double u[] = new double[size];
		double m[][] = new double[size][size];
		int c = 0;
		for (int j=0; j<side; j++) {
			for (int i=0; i<side; i++) {
				BigDecimal r = BigDecimal.ZERO;
				if ((i+1)<side) {
					r = v[i+1][j].getX();
				}
				BigDecimal t = BigDecimal.ZERO;
				if ((j+1)<side) {
					t = v[i][j+1].getY();
				}
				BigDecimal part1 = r.subtract(v[i][j].getX()).divide(h);
				BigDecimal part2 = t.subtract(v[i][j].getY()).divide(h);
				k[c] = part1.add(part2).doubleValue();
				c++;
			}
		}
		printList("MDF de u, matriz com os totais de ", map, k);
		for (int j=0; j<size; j++) {
			for (int i=0; i<size; i++) {
				m[i][j]=0;
			}
		}
		for (int d=0; d<size; d++) {
			m[d][d]=-4;
		}
		c = 0;
		for (int j=0; j<side; j++) {
			for (int i=0; i<side; i++) {
				Point r = new Point();
				if ((i+1)<side) {
					r = v[i+1][j];
				}
				Point t = new Point();
				if ((j+1)<side) {
					t = v[i][j+1];
				}
				Point l = new Point();
				if ((i-1)>-1) {
					l = v[i-1][j];
				}
				Point b = new Point();
				if ((j-1)>-1) {
					b = v[i][j-1];
				}
				if (r.getI() != -1) {
					m[r.getI()][c] = r.getV();
				}
				if (t.getI() != -1) {
					m[t.getI()][c] = t.getV();
				}
				if (l.getI() != -1) {
					m[l.getI()][c] = l.getV();
				}
				if (b.getI() != -1) {
					m[b.getI()][c] = b.getV();
				}
				c++;
			}
		}
		int t = config.getVizinhos().intValue()*2+1;
		t = t*t;
		print("MDF de u, matriz m de ", map, m, t);
		RealMatrix coefficients = new Array2DRowRealMatrix(m, false);
		DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
		RealVector constants = new ArrayRealVector(k, false);
		RealVector solution = solver.solve(constants);
		
		for (int d=0; d<size; d++) {
			u[d]=solution.getEntry(d);
		}
		return matriz(u);		
	}

	// TODO print
	private static void print(String title, int n, Point[][] v) {
		System.out.print(title);
		System.out.println(n);
		int t = config.getVizinhos().intValue()*2+1;
		for (int j=(t-1); j>=0; j--) {
			System.out.print("[");
			for (int i=0; i<t; i++) {
				System.out.print("{");
				System.out.print(v[i][j].getX());
				System.out.print(",");
				System.out.print(v[i][j].getY());
				if (i==(t-1)) {
					System.out.print("}");
				} else {
					System.out.print("}, ");
				}
			}
			System.out.println("]");
		}
		
	}

	private static void print(String title, int n, double[][] v, int t) {
		System.out.print(title);
		System.out.println(n);		
		for (int j=(t-1); j>=0; j--) {
			System.out.print("[");
			for (int i=0; i<t; i++) {
				System.out.print(round(v[i][j],10));
				if (i!=(t-1)) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
		
	}
	
	// TODO round
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.round(new MathContext(places, RoundingMode.HALF_UP)).doubleValue();
	}

	// TODO matriz
	private static Point[][] matriz(List<Point> listPonto) {
		int i = config.getVizinhos()*2+1;
		int j = i;
		Point[][] v = new Point[i][j];
		int x = 0;
		int y = 0;
		for (Point ponto : listPonto) {
			v[x][y] = ponto;
			x++;
			if (x==i) {
				x=0;
				y++;
			}
		}
		return v;
	}
	
	private static double[][] matriz(double[] u) {
		int i = config.getVizinhos()*2+1;
		int j = i;
		double[][] v = new double[i][j];
		int x = 0;
		int y = 0;
		for (double ponto : u) {
			v[x][y] = ponto;
			x++;
			if (x==i) {
				x=0;
				y++;
			}
		}
		return v;
	}
}
