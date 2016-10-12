package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Arrow {
	public static List<Ponto> getPoints(BigDecimal lado, BigDecimal lat, BigDecimal lng) {
		BigDecimal fator = lado.divide(new BigDecimal(4*5));
		List<Ponto> listPonto = new ArrayList<Ponto>();
		listPonto.add(new Ponto(lat.add(new BigDecimal(1).multiply(fator)), lng.add(new BigDecimal(2).multiply(fator))));
		listPonto.add(new Ponto(lat.add(new BigDecimal(1).multiply(fator)), lng.add(new BigDecimal(4).multiply(fator))));
		listPonto.add(new Ponto(lat.add(new BigDecimal(3).multiply(fator)), lng.add(new BigDecimal(4).multiply(fator))));
		listPonto.add(new Ponto(lat.add(new BigDecimal(3).multiply(fator)), lng.add(new BigDecimal(5).multiply(fator))));
		listPonto.add(new Ponto(lat.add(new BigDecimal(5).multiply(fator)), lng.add(new BigDecimal(3).multiply(fator))));
		listPonto.add(new Ponto(lat.add(new BigDecimal(3).multiply(fator)), lng.add(new BigDecimal(1).multiply(fator))));
		listPonto.add(new Ponto(lat.add(new BigDecimal(3).multiply(fator)), lng.add(new BigDecimal(2).multiply(fator))));
		listPonto.add(new Ponto(lat.add(new BigDecimal(1).multiply(fator)), lng.add(new BigDecimal(2).multiply(fator))));
		return listPonto;
	}
	
	public static List<Ponto> rotate(BigDecimal grau, List<Ponto> listPonto, BigDecimal centroLat, BigDecimal centroLng) {
		if (!grau.equals(new BigDecimal(0))) {
			for (Ponto ponto : listPonto) {
				BigDecimal p1 = ponto.getLatitude().subtract(centroLat);
				BigDecimal p2 = ponto.getLongitude().subtract(centroLng);
				BigDecimal cos = new BigDecimal(Math.cos(Math.toRadians(grau.doubleValue())));
				BigDecimal sin = new BigDecimal(Math.sin(Math.toRadians(grau.doubleValue())));
				ponto.setLatitude(centroLat.add(p1.multiply(cos)).subtract(p2.multiply(sin)));
				ponto.setLongitude(centroLng.add(p1.multiply(sin)).add(p2.multiply(cos)));
			}
		}
		return listPonto;
	}
}
