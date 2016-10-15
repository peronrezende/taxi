package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
				List<Ponto> listTaxi = database.getListTaxi(i, config);
				String map = JavaScript.drawMap(i, database.getStart(), database.getEnd(), config); 						

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
						for (Ponto taxi : listTaxi) {
							if ((taxi.getLatitude().compareTo(lat)>=0 && taxi.getLatitude().compareTo(lat.add(lado))<=0) &&
									(taxi.getLongitude().compareTo(lng)>=0 && taxi.getLongitude().compareTo(lng.add(lado))<=0)) {
								total++;
							}
						}
						if (total>0) {
							listCount.add(new Count(i, celula, total, lat, lng, lado));
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
				for (Ponto taxi : listTaxi) {
					taxis.append(JavaScript.drawTaxi(i, taxi));
				}
				taxis.append("</script>\n\n");				

				/*
				 * Desenha as setas 
				 */
				List<Ponto> listPonto = new ArrayList<Ponto>();
				for (Count org : listCount) {
					// Util.ShowDados(org, listCount);
					Count dst = Search.maxNeighbor(i, org, listCount);
					setas.append(PreProcess.arrow(org, dst));
					listPonto.add(Util.setPonto(org, dst));
				}

				System.out.print("Mapa ");
				System.out.println(i);
				for (Ponto ponto : listPonto) {
					System.out.print(ponto.getLatitude());
					System.out.print(" ");
					System.out.println(ponto.getLongitude());
				}
				
				conteudo.append(map.toString());
				conteudo.append(quadrados.toString());
				conteudo.append(taxis.toString());
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
}
