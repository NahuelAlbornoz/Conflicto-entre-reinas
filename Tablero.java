package reinas;

import java.util.Arrays;

public class Tablero {
	private int dimension;
	private int tablero[][];
	private Reina reinas [];
	private int cant_reinas;
	
	public Tablero(int dimension, int cant_reinas) {
		this.dimension = dimension;
		this.tablero = new int [dimension][dimension];
		this.reinas = new Reina [cant_reinas];
		this.cant_reinas = cant_reinas;
	}
	
	public int getDimension() {
		return dimension;
	}
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	public int[][] getTablero() {
		return tablero;
	}
	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}
	public Reina[] getReinas() {
		return reinas;
	}
	public void setReinas(Reina[] reinas) {
		this.reinas = reinas;
	}		
	public int getCant_reinas() {
		return cant_reinas;
	}
	public void setCant_reinas(int cant_reinas) {
		this.cant_reinas = cant_reinas;
	}
	public String toString() {
		return "Dimension=" + dimension + ", Tamanio=" + Arrays.toString(tablero) + "]";
	}
	public void ubicarReinas(int indice) {
		for(int fila=0; fila<dimension; fila++) {
			for(int col=0; col<dimension; col++) {
				if((reinas[indice].getPos_fila()==fila)&&(reinas[indice]).getPos_col()==col) {
					tablero[fila][col]=1;
				}
			}
		}
	}
	public void verTablero() {
		System.out.println();
		for(int fila=0; fila<dimension; fila++) {
			for(int col=0; col<dimension; col++ ) {
				System.out.print("  "+tablero[fila][col]);
				if(col==dimension-1) {
					System.out.println();
				}
			}
		}
	}
	public Reina[] buscarConflicto() {
		for(int i=0; i<this.cant_reinas; i++) {
			if(this.reinas[i].getPos_fila()>0)
				reinas[i].mover_col_sup(this.tablero, this.dimension, this.reinas, this.cant_reinas);
			if(this.reinas[i].getPos_fila()<this.dimension-1)
				reinas[i].mover_col_inf(this.tablero, this.dimension, this.reinas, this.cant_reinas);
			if(this.reinas[i].getPos_col()>0)
				reinas[i].mover_fila_izq(this.tablero, this.dimension, this.reinas, this.cant_reinas);
			if(this.reinas[i].getPos_col()<this.dimension)
				reinas[i].mover_fila_der(this.tablero, this.dimension, this.reinas, this.cant_reinas);
			if((this.reinas[i].getPos_fila()<this.dimension-1)&&(this.reinas[i].getPos_col()>0))
				reinas[i].mover_diag_inf_izq(this.tablero, this.dimension, this.reinas, this.cant_reinas);
			if((this.reinas[i].getPos_fila()<this.dimension-1)&&(this.reinas[i].getPos_col()<dimension-1))
				reinas[i].mover_diag_inf_der(this.tablero, this.dimension, this.reinas, this.cant_reinas);
			if((this.reinas[i].getPos_fila()>0)&&(this.reinas[i].getPos_col()>0))
					reinas[i].mover_diag_sup_izq(this.tablero, this.dimension, this.reinas, this.cant_reinas);
			if((this.reinas[i].getPos_fila()>0)&&(this.reinas[i].getPos_col()<this.dimension-1))
				reinas[i].mover_diag_sup_der(this.tablero, this.dimension, this.reinas, this.cant_reinas);
		}
		return reinas;
	}
}