package reinas;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class Demo {
	public static void main(String[] args) {
		Scanner sc = null;
		PrintWriter pr = null;
		Reina [] reinas = null;
		try{
			long tiempo_inicial = System.currentTimeMillis();
			sc = new Scanner(new File("conflictos6.in"));
			
			int dimTablero = sc.nextInt();
			int cantReinas = sc.nextInt();
			if((dimTablero>=1)&&(dimTablero<=10000)&&(cantReinas>=1)&&(cantReinas<=50000)) {
				Tablero t1 = new Tablero(dimTablero, cantReinas);
				
				reinas = new Reina[cantReinas];
				for(int i=0;i<cantReinas;i++) {
					reinas[i] = new Reina(sc.nextInt()-1,sc.nextInt()-1,i+1);
					t1.setReinas(reinas);
					t1.ubicarReinas(i);
				}
								
				System.out.println("SE CARGARON LAS REINAS...");
				
				reinas = t1.buscarConflicto();
				
				pr = new PrintWriter(new File("conflictos.out"));
				for(int r=0; r<cantReinas; r++) {
					pr.print(reinas[r].getCant_conf()); pr.print(" ");
					for(int c=0; c<reinas[r].getConflictos().size(); c++) {
						pr.print(reinas[r].getConflictos().get(c)); pr.print(" ");
					}
					pr.println();
				}
				long tiempo_final = System.currentTimeMillis();
				long tiempo_rta = tiempo_final-tiempo_inicial;
				System.out.println("Tiempo de respuesta="+tiempo_rta);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sc.close();
			pr.close();
		}
	}
}