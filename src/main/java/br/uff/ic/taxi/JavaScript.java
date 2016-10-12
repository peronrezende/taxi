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
	
	public static StringBuilder drawMap(int i, Timestamp start, Timestamp end, Config config) {
		StringBuilder map = new StringBuilder();
		map.append("<br><br><p>Mapa ");
		map.append(i);
		map.append(" : ");
		map.append(start);
		map.append(" .. ");
		map.append(end);
		map.append("</p>");

		map.append("<div id=\"map");
		map.append(i);
		map.append("\" style=\"width: ");
		map.append(config.getWidth());
		map.append("px; height: ");
		map.append(config.getHeight());
		map.append("px; position: relative;\"></div>\n");
		map.append("<script>\n");
		map.append("var mymap");
		map.append(i);
		map.append(" = L.map('map");
		map.append(i);
		map.append("').setView([");
		map.append(config.getLatitude());
		map.append(", ");
		map.append(config.getLongitude());
		map.append("], 15);\n");
		map.append("L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw', {\n");
		map.append("\tmaxZoom: 18,\n");
		map.append("\tattribution: 'Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, ' +\n");
		map.append("\t\t'<a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, ' +\n");
		map.append("\t\t'Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',\n");
		map.append("\tid: 'mapbox.streets'\n");
		map.append("}).addTo(mymap");
		map.append(i);
		map.append(");\n\n");
		return map;
	}

	public static String drawArrow(Count dst, List<Ponto> listPonto) {
		StringBuilder seta = new StringBuilder();
		seta.append("var polygon = L.polygon([\n");

		// Base
		seta.append("\t[");
		seta.append(listPonto.get(0).getLatitude());
		seta.append(", ");
		seta.append(listPonto.get(0).getLongitude());
		seta.append("],\n");
		seta.append("\t[");
		seta.append(listPonto.get(1).getLatitude());
		seta.append(", ");
		seta.append(listPonto.get(1).getLongitude());
		seta.append("],\n");
		// Lado Direito
		seta.append("\t[");
		seta.append(listPonto.get(2).getLatitude());
		seta.append(", ");
		seta.append(listPonto.get(2).getLongitude());
		seta.append("],\n");
		seta.append("\t[");
		seta.append(listPonto.get(3).getLatitude());
		seta.append(", ");
		seta.append(listPonto.get(3).getLongitude());
		seta.append("],\n");
		// Topo
		seta.append("\t[");
		seta.append(listPonto.get(4).getLatitude());
		seta.append(", ");
		seta.append(listPonto.get(4).getLongitude());
		seta.append("],\n");
		// Lado Esquerdo
		seta.append("\t[");
		seta.append(listPonto.get(5).getLatitude());
		seta.append(", ");
		seta.append(listPonto.get(5).getLongitude());
		seta.append("],\n");
		seta.append("\t[");
		seta.append(listPonto.get(6).getLatitude());
		seta.append(", ");
		seta.append(listPonto.get(6).getLongitude());
		seta.append("],\n");
		// Fecha
		seta.append("\t[");
		seta.append(listPonto.get(7).getLatitude());
		seta.append(", ");
		seta.append(listPonto.get(7).getLongitude());
		seta.append("],\n");
		seta.append("], {color: 'green'}).addTo(mymap");
		seta.append(dst.getMapa());
		seta.append(");\n");
		return seta.toString();
	}

	public static String drawTaxi(Integer map, Ponto taxi) {
		StringBuilder marker = new StringBuilder(); 
		marker.append("L.marker([");
		marker.append(taxi.getLatitude());
		marker.append(", ");
		marker.append(taxi.getLongitude());
		marker.append("]).addTo(mymap");
		marker.append(map);
		marker.append(");\n");
		return marker.toString();
	}

	public static String drawSquare(Integer map, BigDecimal lat, BigDecimal lng, BigDecimal lado) {
		StringBuilder cube = new StringBuilder();
		cube.append("var polygon = L.polygon([\n");
		cube.append("\t[");
		cube.append(lat);
		cube.append(", ");
		cube.append(lng);
		cube.append("],\n");
		cube.append("\t[");
		cube.append(lat.add(lado));
		cube.append(", ");
		cube.append(lng);
		cube.append("],\n");
		cube.append("\t[");
		cube.append(lat.add(lado));
		cube.append(", ");
		cube.append(lng.add(lado));
		cube.append("],\n");
		cube.append("\t[");
		cube.append(lat);
		cube.append(", ");
		cube.append(lng.add(lado));
		cube.append("]\n");
		cube.append("]).addTo(mymap");
		cube.append(map);
		cube.append(");\n");
		return cube.toString();
	}

}
