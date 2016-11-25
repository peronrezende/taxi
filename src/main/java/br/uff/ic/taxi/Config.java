package br.uff.ic.taxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

public class Config {

	private Integer ddd = 21;
	private Timestamp dataHoraInicio = Timestamp.valueOf("2016-06-22 12:00:00");
	private Timestamp dataHoraFim = Timestamp.valueOf("2016-06-22 12:03:00");
	private Long tamanhoLateral = 100000000000l;
	private Integer vizinhos = 100;
	private Integer mapas = 1;
	private BigDecimal latitude = new BigDecimal(-22.90);
	private BigDecimal longitude = new BigDecimal(-43.25);
	private Integer width = 1200;
	private Integer height = 800;
	private BigDecimal latitudeMin;
	private BigDecimal latitudeMax;
	private BigDecimal longitudeMin;
	private BigDecimal longitudeMax;
	private Long raio;
	private Integer marcas = 1;
	public BigDecimal FRACAO = new BigDecimal(10000000000000l);

	public Config() {
		load();
	}
	
	public BigDecimal getLatitudeMin() {
		return latitudeMin;
	}

	public BigDecimal getLatitudeMax() {
		return latitudeMax;
	}

	public BigDecimal getLongitudeMin() {
		return longitudeMin;
	}

	public BigDecimal getLongitudeMax() {
		return longitudeMax;
	}

	public Long getRaio() {
		return raio;
	}

	public Timestamp getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Timestamp dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Timestamp getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Timestamp dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public Long getTamanhoLateral() {
		return tamanhoLateral;
	}

	public void setTamanhoLateral(Long tamanhoLateral) {
		this.tamanhoLateral = tamanhoLateral;
		Long a = (long) Math.sqrt(Math.pow(tamanhoLateral,2) + Math.pow(tamanhoLateral,2)); 
		raio = a + (a*getVizinhos()*2);
		BigDecimal tL = new BigDecimal(tamanhoLateral);
		BigDecimal lado = tL.divide(FRACAO);
		BigDecimal v = new BigDecimal(getVizinhos());
		BigDecimal dois = new BigDecimal(2l);
		latitudeMin = getLatitude().subtract(lado.divide(dois)).subtract(lado.multiply(v));
		latitudeMax = getLatitude().add(lado.divide(dois)).add(lado.multiply(v));
		longitudeMin = getLongitude().subtract(lado.divide(dois)).subtract(lado.multiply(v)); 
		longitudeMax = getLongitude().add(lado.divide(dois)).add(lado.multiply(v));			
	}

	public Integer getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(Integer vizinhos) {
		this.vizinhos = vizinhos;
		Long a = (long) Math.sqrt(Math.pow(getTamanhoLateral(),2) + Math.pow(getTamanhoLateral(),2)); 
		raio = a + (a*vizinhos*2);
		BigDecimal tL = new BigDecimal(tamanhoLateral);
		BigDecimal lado = tL.divide(FRACAO);
		BigDecimal v = new BigDecimal(getVizinhos());
		BigDecimal dois = new BigDecimal(2l);
		latitudeMin = getLatitude().subtract(lado.divide(dois)).subtract(lado.multiply(v));
		latitudeMax = getLatitude().add(lado.divide(dois)).add(lado.multiply(v));
		longitudeMin = getLongitude().subtract(lado.divide(dois)).subtract(lado.multiply(v)); 
		longitudeMax = getLongitude().add(lado.divide(dois)).add(lado.multiply(v));
	}

	public Integer getMapas() {
		return mapas;
	}

	public void setMapas(Integer mapas) {
		this.mapas = mapas;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getMarcas() {
		return marcas;
	}

	public void setMarcas(Integer marcas) {
		this.marcas = marcas;
	}

	private void load() {
		Properties properties = new Properties();
		String fileName = "config.properties";
		 
		File file = new File(fileName);
		InputStream inputStream = null;
		try {			
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			create();
			try {
				inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		 
		if (inputStream != null) {
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		setDdd(Integer.parseInt(properties.getProperty("ddd")));
		setDataHoraInicio(Timestamp.valueOf(properties.getProperty("data.hora.inicio")));
		setDataHoraFim(Timestamp.valueOf(properties.getProperty("data.hora.fim")));
		setLatitude(new BigDecimal(properties.getProperty("latitude")));
		setLongitude(new BigDecimal(properties.getProperty("longitude")));
		setTamanhoLateral(Long.parseLong(properties.getProperty("tamanho.lateral")));
		setVizinhos(Integer.parseInt(properties.getProperty("vizinhos")));
		setMapas(Integer.parseInt(properties.getProperty("mapas")));
		setWidth(Integer.parseInt(properties.getProperty("width")));
		setHeight(Integer.parseInt(properties.getProperty("height")));
		setMarcas(Integer.parseInt(properties.getProperty("marcas")));
	}
	
	public void create() {
		String fileName = "config.properties";
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printWriter.println("ddd=".concat(getDdd().toString()));
		printWriter.println("data.hora.inicio=".concat(getDataHoraInicio().toString()));
		printWriter.println("data.hora.fim=".concat(getDataHoraFim().toString()));
		printWriter.println("tamanho.lateral=".concat(getTamanhoLateral().toString()));
		printWriter.println("vizinhos=".concat(getVizinhos().toString()));
		printWriter.println("mapas=".concat(getMapas().toString()));
		printWriter.println("latitude=".concat(getLatitude().toString()));
		printWriter.println("longitude=".concat(getLongitude().toString()));
		printWriter.println("width=".concat(getWidth().toString()));
		printWriter.println("height=".concat(getHeight().toString()));
		printWriter.close();
	}
}
