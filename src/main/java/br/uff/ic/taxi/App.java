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

	public static void main( String[] args )
    {
		Database database = new Database();
		for (int i=0; i<config.getMapas(); i++) {
			try {
				List<Point> listTaxi = database.getListTaxi(i, config);
				buildIndexHtml(i, database.getStart(), database.getEnd());
				buildMapJS(i, listTaxi);				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		database.close();			
	}
	
	private static void buildMapJS(Integer i, List<Point> listTaxi) {
		List<Count> listCount = new ArrayList<Count>();
		
		String map = JavaScript.drawMap(i, config); 						

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
				 * Conta quantos Taxis tem dentro do quadrado
				 */
				Integer total = 0;
				for (Point taxi : listTaxi) {
					if ((taxi.getLatitude().compareTo(lat)>=0 && taxi.getLatitude().compareTo(lat.add(lado))<=0) &&
							(taxi.getLongitude().compareTo(lng)>=0 && taxi.getLongitude().compareTo(lng.add(lado))<=0)) {
						total++;
					}
				}
				listCount.add(new Count(i, celula, total, lat, lng, lado));
				if (total>0) {							
					quadrados.append(JavaScript.drawSquare(i, lat, lng, lado, total, celula));
				}
				lng=lng.add(lado);
				celula++;
			}
			lat=lat.add(lado);
		}
		quadrados.append("}\n\n");
		
		/*
		 * Desenha cada taxi
		 */
		StringBuilder taxis = new StringBuilder();
		taxis.append("function loadTaxi() {\n");
		for (Point taxi : listTaxi) {
			taxis.append(JavaScript.drawSrcTaxi(i, taxi));
		}
		taxis.append("}\n\n");				

		/*
		 * Desenha as setas 
		 */
		List<Point> listPonto = new ArrayList<Point>();
		int c = 0;
		StringBuilder setas = new StringBuilder();
		setas.append("function loadArrow() {\n");
		for (Count org : listCount) {
			// Util.ShowDados(org, listCount);
			Count dst = Search.maxNeighbor(i, org, listCount);
			if (org.getTotal()>0) {
				setas.append(PreProcess.arrow(org, dst));
			}
			listPonto.add(Util.setPonto(c, org, dst));
			c++;
		}
		setas.append("}\n\n");
		
		// printList("Lista escalar do mapa "i, listPonto);
		
		StringBuilder conteudo = new StringBuilder();
		conteudo.append(map.toString());
		conteudo.append(quadrados.toString());
		conteudo.append(taxis.toString());
		conteudo.append(setas.toString());
		
		Point[][] v = matriz(listPonto);
		print("Matriz escalar do mapa ", i, v);
		
		double[][] u = mdfU(i, listPonto.size(), v);
		int t = config.getVizinhos().intValue()*2+1;
		print("Matriz u de ", i, u, t);
		
		/*
		 * Desenha os circulos 
		 */

		StringBuilder circulos = new StringBuilder();
		
		double[][] s = mdfS(i, listPonto.size(), v);
		print("Matriz s de ", i, s, t);
		System.out.println("\n");
		
		circulos.append(setUS(u, s, v));
		
		conteudo.append(circulos.toString());
		Util.build("map.js", i, "", conteudo.toString(), "");		
	}

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

	private static void buildIndexHtml(Integer i, Timestamp start, Timestamp end) {	
		try {
			StringBuilder title = new StringBuilder();
			title.append("<br><br><p>Mapa ");
			title.append(i);
			title.append(" : ");
			title.append(start);
			title.append(" .. ");
			title.append(end);
			title.append("</p>\n");
			
			StringBuilder pagination = new StringBuilder();
			pagination.append("<ul class=\"pagination\">\n");
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
			pagination.append("</ul>\n");			
	
			StringBuilder map = new StringBuilder();
			map.append("<div id=\"map\" style=\"width: ");
			map.append(config.getWidth());
			map.append("px; height: ");
			map.append(config.getHeight());
			map.append("px; position: relative;\"></div>\n");
			
			StringBuilder conteudo = new StringBuilder();
			conteudo.append(title.toString());
			conteudo.append(pagination.toString());
			conteudo.append(map.toString());
			
			String cabecalho = Util.readFile("cabecalho.txt", Charset.defaultCharset());
			String rodape = Util.readFile("rodape.txt", Charset.defaultCharset());
			
			Util.build("index.html", i, cabecalho, conteudo.toString(), rodape);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void uuu()
    {
		try {
			Database database = new Database();
			StringBuilder setas = new StringBuilder();
			StringBuilder conteudo = new StringBuilder();
			for (int i=0; i<config.getMapas(); i++) {
				List<Count> listCount = new ArrayList<Count>();
				List<Point> listTaxi = database.getListTaxi(i, config);
				String map = JavaScript.drawMap(i, config); 						

				StringBuilder quadrados = new StringBuilder();
				BigDecimal tL = new BigDecimal(config.getTamanhoLateral());
				BigDecimal lado = tL.divide(config.FRACAO);
				BigDecimal lat = config.getLatitudeMin();
				Integer celula = 1;
				while (lat.compareTo(config.getLatitudeMax())<0) {
					BigDecimal lng = config.getLongitudeMin();
					while (lng.compareTo(config.getLongitudeMax())<0) {												
						/*
						 * Conta quantos Taxis tem dentro do quadrado
						 */
						Integer total = 0;
						for (Point taxi : listTaxi) {
							if ((taxi.getLatitude().compareTo(lat)>=0 && taxi.getLatitude().compareTo(lat.add(lado))<=0) &&
									(taxi.getLongitude().compareTo(lng)>=0 && taxi.getLongitude().compareTo(lng.add(lado))<=0)) {
								total++;
							}
						}
						listCount.add(new Count(i, celula, total, lat, lng, lado));
						if (total>0) {							
							quadrados.append(JavaScript.drawSquare(i, lat, lng, lado, total, celula));
						}
						lng=lng.add(lado);
						celula++;
					}
					lat=lat.add(lado);
				}
				
				/*
				 * Desenha cada taxi
				 */
				StringBuilder taxis = new StringBuilder();
				for (Point taxi : listTaxi) {
					taxis.append(JavaScript.drawSrcTaxi(i, taxi));
				}
				taxis.append("</script>\n\n");				

				/*
				 * Desenha as setas 
				 */
				List<Point> listPonto = new ArrayList<Point>();
				int c = 0;
				for (Count org : listCount) {
					// Util.ShowDados(org, listCount);
					Count dst = Search.maxNeighbor(i, org, listCount);
					if (org.getTotal()>0) {
						setas.append(PreProcess.arrow(org, dst));
					}
					listPonto.add(Util.setPonto(c, org, dst));
					c++;
				}
				
				// printList("Lista escalar do mapa "i, listPonto);
				
				conteudo.append(map.toString());
				conteudo.append(quadrados.toString());
				conteudo.append(taxis.toString());
				
				Point[][] v = matriz(listPonto);
				print("Matriz escalar do mapa ", i, v);
				
				double[][] u = mdfU(i, listPonto.size(), v);
				int t = config.getVizinhos().intValue()*2+1;
				print("Matriz u de ", i, u, t);
				
				double[][] s = mdfS(i, listPonto.size(), v);
				print("Matriz s de ", i, s, t);
				System.out.println("\n");
			}	

			conteudo.append("<script>\n");
			conteudo.append(setas.toString());
			conteudo.append("</script>\n");
			
			String cabecalho = Util.readFile("cabecalho.txt", Charset.defaultCharset());
			String rodape = Util.readFile("rodape.txt", Charset.defaultCharset());
			
			Util.build("dd", 0, cabecalho, conteudo.toString(), rodape);
			database.close();			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Operation done successfully");
    }

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
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.round(new MathContext(places, RoundingMode.HALF_UP)).doubleValue();
	}

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
