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
			List<Count> listCount = new ArrayList<Count>();
			/*
			 * Desenha os mapas, seus quadrados, seus taxis e conta quantos taxis tem dentro de 
			 * cada quadrado de cada mapa
			 */
			for (int i=0; i<config.getMapas(); i++) {
				List<Ponto> listTaxi = database.getListTaxi(i, config);
				StringBuilder map = JavaScript.drawMap(i, database.getStart(), database.getEnd(), config); 						

				StringBuilder quadrados = new StringBuilder();
				Boolean desenha = true;
				BigDecimal tL = new BigDecimal(config.getTamanhoLateral());
				BigDecimal lado = tL.divide(config.FRACAO);
				BigDecimal lat = config.getLatitudeMin();
				Integer celula = 1;
				while (lat.compareTo(config.getLatitudeMax())<0) {
					BigDecimal lng = config.getLongitudeMin();
					while (lng.compareTo(config.getLongitudeMax())<0) {
						/*
						 * Desenha o quadrado
						 */
						if (desenha) { // Hora desenha, hora não desenha
							if ((lng).compareTo(config.getLongitudeMax())<0) {
								quadrados.append(JavaScript.drawSquare(i, lat, lng, lado));
							}
							desenha=false;
						} else {
							desenha=true;
						}
												
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
							listCount.add(new Count(i, celula, total));
						}
						lng=lng.add(lado);
						celula++;
					}
					if ((config.getVizinhos() % 2) == 0) {
						desenha=!desenha; // Para alternar na troca de linha
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
				
				conteudo.append(map.toString());
				conteudo.append(quadrados.toString());
				conteudo.append(taxis.toString());
			}	

			/*
			 * Desenha um circulo no quadrado com mais taxis no primeiro mapa 
			 */
			Count count = Search.maxCountMapZero(listCount);
			StringBuilder circulos = new StringBuilder();
			Integer mapa = 0;
			while (mapa < config.getMapas()) {
				Util.ShowDados(count, listCount);
				circulos.append(PreProcess.circle(count));
				mapa++;
				if (mapa < config.getMapas()) {
					/*
					 * Identifica e desenha um circulo no vizinho com mais taxis no mapa seguinte 
					 */
					Count org = count;
					count = Search.maxNeighbor(mapa, count, listCount);
					circulos.append(PreProcess.circle(count));
					circulos.append(PreProcess.arrow(org, count));
				}
			}
			conteudo.append("<script>\n");
			conteudo.append(circulos.toString());
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
