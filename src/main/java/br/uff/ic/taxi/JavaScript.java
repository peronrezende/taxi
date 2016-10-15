package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class JavaScript {
	public static String drawCircle(Count count, BigDecimal lat, BigDecimal lng) {
		StringBuilder code = new StringBuilder();
		code.append("L.circle([");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("], {\n");
		code.append("\tcolor: 'red',\n");
		code.append("\tfillColor: '#f03',\n");
		code.append("\tfillOpacity: 0.5,\n");
		code.append("\tradius: 100\n");
		code.append("}).addTo(mymap");
		code.append(count.getMapa());
		code.append(")\n");
		code.append(".bindPopup('");
		code.append(count.getTotal());
		code.append("')\n");
		code.append(".openPopup();\n\n");			
		return code.toString();
	}
	
	public static String drawMap(int i, Timestamp start, Timestamp end, Config config) {
		StringBuilder code = new StringBuilder();
		code.append("<br><br><p>Mapa ");
		code.append(i);
		code.append(" : ");
		code.append(start);
		code.append(" .. ");
		code.append(end);
		code.append("</p>");

		code.append("<div id=\"map");
		code.append(i);
		code.append("\" style=\"width: ");
		code.append(config.getWidth());
		code.append("px; height: ");
		code.append(config.getHeight());
		code.append("px; position: relative;\"></div>\n");
		code.append("<script>\n");
		code.append("var mymap");
		code.append(i);
		code.append(" = L.map('map");
		code.append(i);
		code.append("').setView([");
		code.append(config.getLatitude());
		code.append(", ");
		code.append(config.getLongitude());
		code.append("], 15);\n");
		code.append("L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw', {\n");
		code.append("\tmaxZoom: 18,\n");
		code.append("\tattribution: 'Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, ' +\n");
		code.append("\t\t'<a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, ' +\n");
		code.append("\t\t'Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',\n");
		code.append("\tid: 'mapbox.streets'\n");
		code.append("}).addTo(mymap");
		code.append(i);
		code.append(");\n\n");
		return code.toString();
	}

	public static String drawArrow(Count dst, List<Ponto> listPonto) {
		StringBuilder code = new StringBuilder();
		code.append("var polygon = L.polygon([\n");

		// Base
		code.append("\t[");
		code.append(listPonto.get(0).getLatitude());
		code.append(", ");
		code.append(listPonto.get(0).getLongitude());
		code.append("],\n");
		code.append("\t[");
		code.append(listPonto.get(1).getLatitude());
		code.append(", ");
		code.append(listPonto.get(1).getLongitude());
		code.append("],\n");
		// Lado Direito
		code.append("\t[");
		code.append(listPonto.get(2).getLatitude());
		code.append(", ");
		code.append(listPonto.get(2).getLongitude());
		code.append("],\n");
		code.append("\t[");
		code.append(listPonto.get(3).getLatitude());
		code.append(", ");
		code.append(listPonto.get(3).getLongitude());
		code.append("],\n");
		// Topo
		code.append("\t[");
		code.append(listPonto.get(4).getLatitude());
		code.append(", ");
		code.append(listPonto.get(4).getLongitude());
		code.append("],\n");
		// Lado Esquerdo
		code.append("\t[");
		code.append(listPonto.get(5).getLatitude());
		code.append(", ");
		code.append(listPonto.get(5).getLongitude());
		code.append("],\n");
		code.append("\t[");
		code.append(listPonto.get(6).getLatitude());
		code.append(", ");
		code.append(listPonto.get(6).getLongitude());
		code.append("],\n");
		// Fecha
		code.append("\t[");
		code.append(listPonto.get(7).getLatitude());
		code.append(", ");
		code.append(listPonto.get(7).getLongitude());
		code.append("],\n");
		code.append("], {color: 'green'}).addTo(mymap");
		code.append(dst.getMapa());
		code.append(");\n");
		return code.toString();
	}

	public static String drawTaxi(Integer map, Ponto taxi) {
		StringBuilder code = new StringBuilder(); 
		code.append("L.marker([");
		code.append(taxi.getLatitude());
		code.append(", ");
		code.append(taxi.getLongitude());
		code.append("]).addTo(mymap");
		code.append(map);
		code.append(");\n");
		return code.toString();
	}

	public static String drawSquare(Integer map, BigDecimal lat, BigDecimal lng, BigDecimal lado) {
		StringBuilder code = new StringBuilder();
		code.append("var polygon = L.polygon([\n");
		code.append("\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng.add(lado));
		code.append("],\n");
		code.append("\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng.add(lado));
		code.append("]\n");
		code.append("]).addTo(mymap");
		code.append(map);
		code.append(");\n");
		return code.toString();
	}

	public static String drawSquare(Integer map, BigDecimal lat, BigDecimal lng, BigDecimal lado, Integer total, Integer celula) {
		Integer r = (total * 200 / 50)+55;
		String hex = String.format("#%02x%02x%02x", r, 0, 0);

		StringBuilder code = new StringBuilder();
		code.append("// Celula ");
		code.append(celula);		
		code.append("\nvar polygon = L.polygon([\n");
		code.append("\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng.add(lado));
		code.append("],\n");
		code.append("\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng.add(lado));
		code.append("]\n");
		code.append("], {color: '");
		code.append(hex);
		code.append("'}).addTo(mymap");
		code.append(map);
		code.append(");\n");
		return code.toString();
	}

}
