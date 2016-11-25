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
	private BigDecimal u = BigDecimal.ZERO;
	private BigDecimal s = BigDecimal.ZERO;
	
	public Point(Integer i, BigDecimal x, BigDecimal y) {
		super();
		this.x = x;
		this.y = y;
		this.i = i;
	}
	public Point(BigDecimal latitude, BigDecimal longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Point() {

	}
	public BigDecimal getLatitude() {
		latitude.setScale(10, RoundingMode.HALF_UP);
		return latitude.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		longitude.setScale(10, RoundingMode.HALF_UP);
		return longitude.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public double getV() {
		/*if ((x.compareTo(BigDecimal.ZERO) == 0) && (y.compareTo(BigDecimal.ZERO) == 0)) {
			return 0.0;
		} else {
			return 1.0;
		}*/
		return 1.0;
	}
	public BigDecimal getX() {
		return x;
	}
	public void setX(BigDecimal x) {
		this.x = x;
	}
	public BigDecimal getY() {
		return y;
	}
	public void setY(BigDecimal y) {
		this.y = y;
	}
	public BigDecimal getU() {
		u.setScale(10, RoundingMode.HALF_UP);
		return u.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public void setU(BigDecimal u) {
		this.u = u;
	}
	public BigDecimal getS() {
		s.setScale(10, RoundingMode.HALF_UP);
		return s.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public void setS(BigDecimal s) {
		this.s = s;
	}
	public void setU(double u) {
		setU(new BigDecimal(u));
	}
	public void setS(double s) {
		setS(new BigDecimal(s));
	}

}
