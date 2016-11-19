package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Count {
	private Integer mapa;
	private Integer celula;
	private Integer total;
	private BigDecimal latitudeCentral;
	private BigDecimal longitudeCentral;
	
	public Count(Integer mapa, Integer celula, Integer total, BigDecimal latitude, BigDecimal longitude, BigDecimal lado) {
		this.mapa=mapa;
		this.celula=celula;
		this.total=total;
		this.latitudeCentral = latitude.add(lado.divide(new BigDecimal(2)));
		this.latitudeCentral.setScale(10, RoundingMode.HALF_UP);
		this.longitudeCentral = longitude.add(lado.divide(new BigDecimal(2)));
		this.longitudeCentral.setScale(10, RoundingMode.HALF_UP);
	}
	
	public Integer getMapa() {
		return mapa;
	}
	public void setMapa(Integer mapa) {
		this.mapa = mapa;
	}
	public Integer getCelula() {
		return celula;
	}
	public void setCelula(Integer celula) {
		this.celula = celula;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public BigDecimal getLatitudeCentral() {
		return latitudeCentral;
	}
	public void setLatitudeCentral(BigDecimal latitudeCentral) {
		this.latitudeCentral = latitudeCentral;
		this.latitudeCentral.setScale(10, RoundingMode.HALF_UP);
	}
	public BigDecimal getLongitudeCentral() {
		return longitudeCentral;
	}
	public void setLongitudeCentral(BigDecimal longitudeCentral) {
		this.longitudeCentral = longitudeCentral;
		this.longitudeCentral.setScale(10, RoundingMode.HALF_UP);
	}
}
