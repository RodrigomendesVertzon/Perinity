package com.testetres;
public class ExercicioTres {

	public static void main(String[] args) {
		
		int numeroInicial = 1;
		
		
		while(numeroInicial < 10) {
			
			System.out.print(numeroInicial + ",");
			
			for (int i=1; i <= 10; i++) {
				System.out.print(" " + i);
			}
			System.out.print("\n");
			numeroInicial += 2;
		}
	}
}