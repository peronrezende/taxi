package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
		try {
			Database database = new Database();
			
			StringBuilder conteudo = new StringBuilder();
			StringBuilder setas = new StringBuilder();
			for (int i=0; i<config.getMapas(); i++) {
				List<Count> listCount = new ArrayList<Count>();
				List<Point> listTaxi = database.getListTaxi(i, config);
				String map = JavaScript.drawMap(i, database.getStart(), database.getEnd(), config); 						

				StringBuilder quadrados = new StringBuilder();
				BigDecimal tL = new BigDecimal(config.getTamanhoLateral());
				tL.setScale(10, RoundingMode.HALF_UP);
				BigDecimal lado = tL.divide(config.FRACAO);
				lado.setScale(10, RoundingMode.HALF_UP);
				BigDecimal lat = config.getLatitudeMin();
				lat.setScale(10, RoundingMode.HALF_UP);
				tL.setScale(10, RoundingMode.HALF_UP);
				Integer celula = 1;
				while (lat.compareTo(config.getLatitudeMax())<0) {
					BigDecimal lng = config.getLongitudeMin();
					lng.setScale(10, RoundingMode.HALF_UP);
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
					taxis.append(JavaScript.drawTaxi(i, taxi));
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
			
			Util.build(cabecalho, conteudo.toString(), rodape);
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
		h.setScale(10, RoundingMode.HALF_UP);
		double k[] = new double[size];
		double u[] = new double[size];
		double m[][] = new double[size][size];
		int c = 0;
		for (int j=0; j<side; j++) {
			for (int i=0; i<side; i++) {
				BigDecimal r = BigDecimal.ZERO;
				r.setScale(10, RoundingMode.HALF_UP);
				if ((i+1)<side) {
					r = v[i+1][j].getX();
				}
				BigDecimal t = BigDecimal.ZERO;
				t.setScale(10, RoundingMode.HALF_UP);
				if ((j+1)<side) {
					t = v[i][j+1].getY();
				}
				BigDecimal part1 = r.subtract(v[i][j].getX()).divide(h);
				part1.setScale(10, RoundingMode.HALF_UP);
				part1 = part1.multiply(new BigDecimal(-1));
				BigDecimal part2 = t.subtract(v[i][j].getY()).divide(h);
				part2.setScale(10, RoundingMode.HALF_UP);
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
		h.setScale(10, RoundingMode.HALF_UP);
		double k[] = new double[size];
		double u[] = new double[size];
		double m[][] = new double[size][size];
		int c = 0;
		for (int j=0; j<side; j++) {
			for (int i=0; i<side; i++) {
				BigDecimal r = BigDecimal.ZERO;
				r.setScale(10, RoundingMode.HALF_UP);
				if ((i+1)<side) {
					r = v[i+1][j].getX();
				}
				BigDecimal t = BigDecimal.ZERO;
				t.setScale(10, RoundingMode.HALF_UP);
				if ((j+1)<side) {
					t = v[i][j+1].getY();
				}
				BigDecimal part1 = r.subtract(v[i][j].getX()).divide(h);
				part1.setScale(10, RoundingMode.HALF_UP);
				BigDecimal part2 = t.subtract(v[i][j].getY()).divide(h);
				part2.setScale(10, RoundingMode.HALF_UP);
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
				System.out.print(roundBD(v[i][j],10));
				if (i!=(t-1)) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
		
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static double roundBD(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
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
