package com.testetres;

import java.util.Scanner;

public class ExercicioDois {
	
	public static void main(String[] args) {
	
	int[] homens = new int[2];
	int[] mulheres = new int[2];
	int mulherMaisVelha = 0, homemMaisVelho = 0, mulherMaisNova = 0, homemMaisNovo = 0, soma = 0;
	double produto;
	
	Scanner input = new Scanner(System.in);
	
	for(int i = 0; i < homens.length; i++) {
		System.out.println("Digite a idade do homem n? " + (i+1));
		homens[i] = input.nextInt();
		
		if (homens[i] > homemMaisVelho | homemMaisVelho == 0) {
			homemMaisVelho = homens[i];
		}
		
		if (homens[i] < homemMaisNovo | homemMaisNovo == 0) {
			homemMaisNovo = homens[i];
		}
	}
	
	for(int i = 0; i < mulheres.length; i++) {
		System.out.println("Digite a idade da mulher n? " + (i+1));
		mulheres[i] = input.nextInt();
		
		if (mulheres[i] > mulherMaisVelha || mulherMaisVelha == 0) {
			mulherMaisVelha = mulheres[i];
		}
		
		if (homens[i] < mulherMaisNova || mulherMaisNova == 0) {
			mulherMaisNova = mulheres[i];
		}
	}
	
	input.close();
	
	soma = homemMaisVelho + mulherMaisNova;
	produto = homemMaisNovo * mulherMaisVelha;
	
	System.out.println("Soma das idades do homem mais velho com a mulher mais nova:");
	System.out.println(soma);
	
	System.out.println("Produto das idades do homem mais novo com a mulher mais velha:");
	System.out.println(produto);
	}
}
