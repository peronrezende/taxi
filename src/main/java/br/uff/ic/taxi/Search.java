package br.uff.ic.taxi;

import java.util.ArrayList;
import java.util.List;

public class Search {
	
	public static Count maxCountMapZero(List<Count> listCount) {
		Count count = null;
		Integer total = 0;
		for (Count ml : listCount) {			
			if (ml.getMapa().equals(0)) {
				if (ml.getTotal()>total) {
					count = ml;
					total = ml.getTotal();
				}
			}
		}
		return count;
	}
	
	public static Count maxNeighbor(Integer mapa, Count count, List<Count> listCount) {
		List<Integer> listCel = listNeighbor(count.getCelula());
		Count countMax = null;
		Integer total = 0;
		for (Count c : listCount) {			
			if (c.getMapa().equals(mapa)) {
				if (c.getCelula().equals(count.getCelula()) || listCel.contains(c.getCelula())) {
					if (c.getTotal()>total) {
						countMax = c;
						total = c.getTotal();
					}
				}
			}
		}
		return countMax;
	}

	public static List<Integer> listNeighbor(Integer cel) {
		Config config = new Config();
		
		List<Integer> listCel = new ArrayList<Integer>();
		Integer fimLinha = config.getVizinhos()*2+1;
		Integer tL=cel+fimLinha-1;
		Integer t=cel+fimLinha;
		Integer tR=cel+fimLinha+1;
		Integer l=0;
		Integer r=0;
		Integer bL=0;
		Integer b=0;
		Integer bR=0;
		if (cel==1) {
			tL=0;
		}
		if (cel==fimLinha) { 	// Se está no final da linha,
			tR=0;				// não tem ninguem a direita.
		}
		if (tL>(fimLinha*fimLinha)) {	// Se o vizinho superior esquerdo passa do ultimo quadrado,
			tL=0;						// não temos esse vizinho
		}
		if (t>(fimLinha*fimLinha)) {	// O mesmo para o superior
			t=0;
		}
		if (tR>(fimLinha*fimLinha)) {	// O mesmo para o superior direito
			tR=0;
		}
		Integer celInFirstLine;
		if (cel>fimLinha) { // Se a celula não está na primeira linha, tem alguem abaixo (bL+b+bR)			
			b=cel-fimLinha;			
			
			Integer bInFirstLine = b;				// Para saber se o vizinho inferior está no primeiro ou			
			while (bInFirstLine>fimLinha) {			// no ultimo quadrado na linha, vamos "desce-lo" a primeira
				bInFirstLine=bInFirstLine-fimLinha;	// linha			
			}

			if (bInFirstLine!=1) {	// Se o vizinho inferior não for o primeiro quadrado da linha,
				bL=cel-fimLinha-1;	// existe vizinho inferior esquerdo
			}
			if (bInFirstLine!=fimLinha) {	// Se o vizinho inferior não for o ultimo quadrado da linha,
				bR=cel-fimLinha+1;			// existe vizinho inferior direito
			}
			
			celInFirstLine = cel;						// Para saber se a celula central está no primeiro ou			
			while (celInFirstLine>fimLinha) {			// no ultimo quadrado na linha, vamos "desce-la" a primeira
				celInFirstLine=celInFirstLine-fimLinha;	// linha			
			}
		} else {
			celInFirstLine = cel;
		}
		
		if (celInFirstLine!=1) {	// Se a celula central não for o primeiro quadrado da linha,
			l=cel-1;				// existe vizinho esquerdo
		}
		if (celInFirstLine!=fimLinha) {	// Se a celula central não for o ultimo quadrado da linha,
			r=cel+1;					// existe vizinho direito
		}
		listCel.add(tL);
		listCel.add(t);
		listCel.add(tR);
		listCel.add(l);
		listCel.add(r);
		listCel.add(bL);
		listCel.add(b);
		listCel.add(bR);
		System.out.println(String.format("%d - %d - %d", tL, t, tR));
		System.out.println(String.format("%d - %d - %d", l, cel, r));
		System.out.println(String.format("%d - %d - %d", bL, b, bR));
		return listCel;
	}
}
