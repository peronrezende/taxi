package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.util.List;

public class JavaScript {
	// TODO drawCircle
	public static String drawCircle(String prefix, String color, double value, BigDecimal lat, BigDecimal lng) {
		StringBuilder code = new StringBuilder();
		code.append("\tvar circle = L.circle([");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("], {\n");
		code.append("\t\tcolor: '");
		code.append(color);
		code.append("',\n");
		code.append("\t\tfillColor: '");
		code.append(color);
		code.append("',\n");
		code.append("\t\tfillOpacity: 0.5,\n");
		code.append("\t\tradius: 100\n");
		code.append("\t}).addTo(map)\n");
		code.append("\t\t.bindPopup('");
		code.append(prefix);
		code.append(": ");
		code.append(value);
		code.append("')\n");
		code.append("\t\t.openPopup();\n");
		code.append("\tcircle");
		code.append(prefix);
		code.append(".matriz.push(circle);\n");
		code.append("\tcircle");
		code.append(prefix);
		code.append(".group.addLayer(circle);\n");
		return code.toString();
	}
	
	// TODO drawMap
	public static String drawMap(Config config) {
		StringBuilder code = new StringBuilder();
		code.append("function loadMap() {\n");
		code.append("\tmap = L.map('map').setView([");
		code.append(config.getLatitude());
		code.append(", ");
		code.append(config.getLongitude());
		code.append("], 15);\n");
		code.append("\tL.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw', {\n");
		code.append("\t\tmaxZoom: 18,\n");
		code.append("\t\tattribution: 'Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, ' +\n");
		code.append("\t\t\t'<a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, ' +\n");
		code.append("\t\t\t'Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',\n");
		code.append("\t\tid: 'mapbox.streets'\n");
		code.append("\t}).addTo(map);\n");
		code.append("}\n\n");
		return code.toString();
	}

	// TODO drawArrow
	public static String drawArrow(Count dst, List<Point> listPonto) {
		StringBuilder code = new StringBuilder();
		code.append("\tvar polygon = L.polygon([\n");

		// Base
		code.append("\t\t[");
		code.append(listPonto.get(0).getLatitude());
		code.append(", ");
		code.append(listPonto.get(0).getLongitude());
		code.append("],\n");
		code.append("\t\t[");
		code.append(listPonto.get(1).getLatitude());
		code.append(", ");
		code.append(listPonto.get(1).getLongitude());
		code.append("],\n");
		// Lado Direito
		code.append("\t\t[");
		code.append(listPonto.get(2).getLatitude());
		code.append(", ");
		code.append(listPonto.get(2).getLongitude());
		code.append("],\n");
		code.append("\t\t[");
		code.append(listPonto.get(3).getLatitude());
		code.append(", ");
		code.append(listPonto.get(3).getLongitude());
		code.append("],\n");
		// Topo
		code.append("\t\t[");
		code.append(listPonto.get(4).getLatitude());
		code.append(", ");
		code.append(listPonto.get(4).getLongitude());
		code.append("],\n");
		// Lado Esquerdo
		code.append("\t\t[");
		code.append(listPonto.get(5).getLatitude());
		code.append(", ");
		code.append(listPonto.get(5).getLongitude());
		code.append("],\n");
		code.append("\t\t[");
		code.append(listPonto.get(6).getLatitude());
		code.append(", ");
		code.append(listPonto.get(6).getLongitude());
		code.append("],\n");
		// Fecha
		code.append("\t\t[");
		code.append(listPonto.get(7).getLatitude());
		code.append(", ");
		code.append(listPonto.get(7).getLongitude());
		code.append("],\n");
		code.append("\t], {color: 'green'});\n");
		code.append("\tpolygon.addTo(map);\n");
		code.append("\tarrow.matriz.push(polygon);\n");
		code.append("\tarrow.group.addLayer(polygon);\n");
		return code.toString();
	}

	// TODO drawSrcTaxi
	public static String drawSrcTaxi(Point taxi) {
		StringBuilder code = new StringBuilder(); 
		code.append("\tvar taxi = L.marker([");
		code.append(taxi.getLatitude());
		code.append(", ");
		code.append(taxi.getLongitude());
		code.append("], {icon: srcIcon});\n");
		code.append("\ttaxi.addTo(map);\n");
		code.append("\tsrcTaxi.matriz.push(taxi);\n");
		code.append("\tsrcTaxi.group.addLayer(taxi);\n");
		return code.toString();
	}

	// TODO drawDstTaxi
	public static String drawDstTaxi(Point taxi) {
		StringBuilder code = new StringBuilder(); 
		code.append("\tvar taxi = L.marker([");
		code.append(taxi.getLatitude());
		code.append(", ");
		code.append(taxi.getLongitude());
		code.append("]);\n");
		code.append("\ttaxi.addTo(map);\n");
		code.append("\tdstTaxi.matriz.push(taxi);\n");
		code.append("\tdstTaxi.group.addLayer(taxi);\n");
		return code.toString();
	}

	// TODO drawSquare
	public static String drawSquare(BigDecimal lat, BigDecimal lng, BigDecimal lado) {
		StringBuilder code = new StringBuilder();
		code.append("\tvar polygon = L.polygon([\n");
		code.append("\t\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng.add(lado));
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng.add(lado));
		code.append("]\n");
		code.append("\t]);\n");
		code.append("\tpolygon.addTo(map);\n");
		code.append("\tsquare.matriz.push(polygon);\n");
		code.append("\tsquare.group.addLayer(polygon);\n");
		return code.toString();
	}

	// TODO drawSquare
	public static String drawSquare(BigDecimal lat, BigDecimal lng, BigDecimal lado, Integer total, Integer celula) {
		Integer r = (total * 200 / 50)+55;
		String hex = String.format("#%02x%02x%02x", r, 0, 0);

		StringBuilder code = new StringBuilder();
		code.append("\t// Celula ");
		code.append(celula);		
		code.append("\n\tvar polygon = L.polygon([\n");
		code.append("\t\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng.add(lado));
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng.add(lado));
		code.append("]\n");
		code.append("\t], {color: '");
		code.append(hex);
		code.append("'});\n");
		code.append("\tpolygon.addTo(map);\n");
		code.append("\tsquare.matriz.push(polygon);\n");
		code.append("\tsquare.group.addLayer(polygon);\n");
		return code.toString();
	}

}
