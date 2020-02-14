package reinas;
import java.util.ArrayList;
import java.util.Collections;

public class Reina {
	private int pos_fila;
	private int pos_col;
	private int cant_conf;
	private int num_reina;
	private ArrayList<Integer> conflictos;
	
	public Reina(int fila, int col, int num_reina) {
		this.pos_fila = fila;
		this.pos_col = col;
		this.num_reina = num_reina;
		this.cant_conf = 0; 	
		this.conflictos = new ArrayList<Integer>();
	}

	public int getPos_fila() {
		return pos_fila;
	}
	public void setPos_fila(int pos_fila) {
		this.pos_fila = pos_fila;
	}
	public int getPos_col() {
		return pos_col;
	}
	public void setPos_col(int pos_col) {
		this.pos_col = pos_col;
	}		
	public int getCant_conf() {
		return cant_conf;
	}
	public void setCant_conf(int cant_conf) {
		this.cant_conf = cant_conf;
	}
	public int getNum_reina() {
		return num_reina;
	}

	public void setNum_reina(int num_reina) {
		this.num_reina = num_reina;
	}
	public ArrayList<Integer> getConflictos() {
		return conflictos;
	}
	public void setConflictos(ArrayList<Integer> conflictos) {
		this.conflictos = conflictos;
	}
	public String toString() {
		return "Num_reina=" + this.num_reina +" ,Pos_fila=" + pos_fila + ", Pos_col=" + pos_col + ", Cant_conf=" + this.cant_conf ;
	}
	public void mover_fila_der(int tablero [] [], int dim, Reina reinas [], int cant_reinas) {
		int col = this.pos_col;
		int fila = this.pos_fila;
		while(col<=dim-1) {
			col++;
			if((col<=dim-1)&&(tablero[fila][col]==1)) {
				this.cant_conf++;
				this.conflicto_con(fila, col, reinas, cant_reinas);
				break;
			}
		}
	}
	public void mover_fila_izq(int tablero [] [], int dim, Reina reinas [],int cant_reinas) {
		int col = this.pos_col;
		int fila = this.pos_fila;
		while(col>=0) {
			col--;
			if((col>=0)&&(tablero[fila][col]==1)) {
				this.cant_conf++;
				this.conflicto_con(fila, col, reinas, cant_reinas);
				break;
			}
		}
	}
	public void mover_col_sup(int tablero [] [], int dim, Reina reinas [], int cant_reinas) {
		int col = this.pos_col;
		int fila = this.pos_fila;
		while(fila>=0) {
			fila--;
			if((fila>=0)&&(tablero[fila][col]==1)) {
				this.cant_conf++;
				this.conflicto_con(fila, col, reinas, cant_reinas);
				break;
			}
		}
	}
	public void mover_col_inf(int tablero [] [], int dim, Reina reinas [], int cant_reinas) {
		int col = this.pos_col;
		int fila = this.pos_fila;
		while(fila<=dim-1) {
			fila++;
			if((fila<=dim-1)&&(tablero[fila][col]==1)) {
				this.cant_conf++;
				this.conflicto_con(fila, col, reinas, cant_reinas);
				break;
			}
		}
	}
	public void mover_diag_inf_izq(int tablero [] [], int dim, Reina reinas [], int cant_reinas) {
		int col = this.pos_col;
		int fila = this.pos_fila;
		while((fila<=dim-1)&&(col>=0)) {
			fila++;
			col--;
			if((fila<=dim-1)&&(col>=0)&&tablero[fila][col]==1) {
				this.cant_conf++;
				this.conflicto_con(fila, col, reinas, cant_reinas);
				break;
			}
		}
	}
	public void mover_diag_inf_der(int tablero [] [], int dim, Reina reinas [],int cant_reinas) {
		int col = this.pos_col;
		int fila = this.pos_fila;
		while((fila<=dim-1)&&(col<=dim-1)) {
			fila++;
			col++;
			if((fila<=dim-1)&&(col<=dim-1)&&tablero[fila][col]==1) {
				this.cant_conf++;
				this.conflicto_con(fila, col, reinas, cant_reinas);
					break;
			}
		}
	}
	public void mover_diag_sup_izq(int tablero [] [], int dim, Reina reinas [], int cant_reinas) {
		int col = this.pos_col;
		int fila = this.pos_fila;
		while(fila>=0) {
			fila--;
			col--;
			if((fila>=0)&&(col>=0)&&tablero[fila][col]==1) {
				this.cant_conf++;
				this.conflicto_con(fila, col, reinas, cant_reinas);
					break;
			}
		}
	}	
	public void mover_diag_sup_der(int tablero [] [], int dim, Reina reinas [], int cant_reinas) {
		int col = this.pos_col;
		int fila = this.pos_fila;
		while(col<=dim-1) {
			fila--;
			col++;
			if((col<=dim-1)&&(fila>=0)&&(tablero[fila][col]==1)) {
				this.cant_conf++;
				this.conflicto_con(fila, col, reinas, cant_reinas);
					break;
			}
		}
	}
	private void conflicto_con(int fila, int col, Reina [] reinas, int cant_reinas) {
		for(int i=0; i<cant_reinas; i++) {
			if((reinas[i].getPos_col()==col)&&(reinas[i].getPos_fila()==fila)) {
				this.conflictos.add(reinas[i].getNum_reina());
				break;
			}
		}
		Collections.sort(this.conflictos);
	}
}
