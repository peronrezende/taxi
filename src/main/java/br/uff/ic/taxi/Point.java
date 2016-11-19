package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Point {
	private BigDecimal latitude = BigDecimal.ZERO;
	private BigDecimal longitude = BigDecimal.ZERO;
	private BigDecimal x = BigDecimal.ZERO;
	private BigDecimal y = BigDecimal.ZERO;
	private int i = -1;
	
	public Point(Integer i, BigDecimal x, BigDecimal y) {
		super();
		this.x = x;
		this.y = y;
		this.i = i;
		this.x.setScale(10, RoundingMode.HALF_UP);
		this.y.setScale(10, RoundingMode.HALF_UP);
	}
	public Point(BigDecimal latitude, BigDecimal longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.latitude.setScale(10, RoundingMode.HALF_UP);
		this.longitude.setScale(10, RoundingMode.HALF_UP);
	}
	public Point() {

	}
	public BigDecimal getLatitude() {
		latitude.setScale(10, RoundingMode.HALF_UP);
		return latitude.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
		this.latitude.setScale(10, RoundingMode.HALF_UP);
	}
	public BigDecimal getLongitude() {
		longitude.setScale(10, RoundingMode.HALF_UP);
		return longitude.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
		this.longitude.setScale(10, RoundingMode.HALF_UP);
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public double getV() {
		if ((x.compareTo(BigDecimal.ZERO) == 0) && (y.compareTo(BigDecimal.ZERO) == 0)) {
			return 0.0;
		} else {
			return 1.0;
		}
	}
	public BigDecimal getX() {
		return x;
	}
	public void setX(BigDecimal x) {
		this.x = x;
		this.x.setScale(10, RoundingMode.HALF_UP);
	}
	public BigDecimal getY() {
		return y;
	}
	public void setY(BigDecimal y) {
		this.y = y;
		this.y.setScale(10, RoundingMode.HALF_UP);
	}
}
