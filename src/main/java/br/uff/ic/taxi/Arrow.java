package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Arrow {
	public static List<Point> getPoints(BigDecimal lado, BigDecimal lat, BigDecimal lng) {
		lado.setScale(10, RoundingMode.HALF_UP);
		lat.setScale(10, RoundingMode.HALF_UP);
		lng.setScale(10, RoundingMode.HALF_UP);
		BigDecimal fator = lado.divide(new BigDecimal(4*5));
		fator.setScale(10, RoundingMode.HALF_UP);
		List<Point> listPonto = new ArrayList<Point>();
		listPonto.add(new Point(lat.add(new BigDecimal(1).multiply(fator)), lng.add(new BigDecimal(2).multiply(fator))));
		listPonto.add(new Point(lat.add(new BigDecimal(1).multiply(fator)), lng.add(new BigDecimal(4).multiply(fator))));
		listPonto.add(new Point(lat.add(new BigDecimal(3).multiply(fator)), lng.add(new BigDecimal(4).multiply(fator))));
		listPonto.add(new Point(lat.add(new BigDecimal(3).multiply(fator)), lng.add(new BigDecimal(5).multiply(fator))));
		listPonto.add(new Point(lat.add(new BigDecimal(5).multiply(fator)), lng.add(new BigDecimal(3).multiply(fator))));
		listPonto.add(new Point(lat.add(new BigDecimal(3).multiply(fator)), lng.add(new BigDecimal(1).multiply(fator))));
		listPonto.add(new Point(lat.add(new BigDecimal(3).multiply(fator)), lng.add(new BigDecimal(2).multiply(fator))));
		listPonto.add(new Point(lat.add(new BigDecimal(1).multiply(fator)), lng.add(new BigDecimal(2).multiply(fator))));
		return listPonto;
	}
	
	public static List<Point> rotate(BigDecimal grau, List<Point> listPonto, BigDecimal centroLat, BigDecimal centroLng) {
		grau.setScale(10, RoundingMode.HALF_UP);
		centroLat.setScale(10, RoundingMode.HALF_UP);
		centroLng.setScale(10, RoundingMode.HALF_UP);
		if (!grau.equals(new BigDecimal(0))) {
			for (Point ponto : listPonto) {
				BigDecimal p1 = ponto.getLatitude().subtract(centroLat);
				p1.setScale(10, RoundingMode.HALF_UP);
				BigDecimal p2 = ponto.getLongitude().subtract(centroLng);
				p2.setScale(10, RoundingMode.HALF_UP);
				BigDecimal cos = new BigDecimal(Math.cos(Math.toRadians(grau.doubleValue())));
				cos.setScale(10, RoundingMode.HALF_UP);
				BigDecimal sin = new BigDecimal(Math.sin(Math.toRadians(grau.doubleValue())));
				sin.setScale(10, RoundingMode.HALF_UP);
				ponto.setLatitude(centroLat.add(p1.multiply(cos)).subtract(p2.multiply(sin)));
				ponto.setLongitude(centroLng.add(p1.multiply(sin)).add(p2.multiply(cos)));
			}
		}
		return listPonto;
	}
}
