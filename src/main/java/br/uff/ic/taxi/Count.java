package br.uff.ic.taxi;

public class Count {
	private Integer mapa;
	private Integer celula;
	private Integer total;
	
	public Count(Integer mapa, Integer celula, Integer total) {
		this.mapa=mapa;
		this.celula=celula;
		this.total=total;
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
}
