package com.testetres;

import java.util.Scanner;

public class ExercicioQuatro {

	public static void main(String[] args) {
		
		int[] arrayUm = new int[5];
		int[] arrayDois = new int [5];
		int[] concatenacao = new int[10];
		
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.printf("Digite o valor do arrayUm[%d]: ", i);
			arrayUm[i] = input.nextInt();
			concatenacao[i] = arrayUm[i];
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.printf("Digite o valor do arrayDois[%d]", i);
			arrayDois[i] = input.nextInt();
			concatenacao[(i+5)] = arrayDois[i];
		}
		
		System.out.println("Concatenação de Arrays:");
		for (int i = 0; i < 10; i++) {
			System.out.print(concatenacao[i] + " ");
		}
	
		input.close();
		
	}

}
