package core;

import java.util.Arrays;

public class Exercicio14 {
	// QUICKSORT
	static int[] quickSort(int[] v, int ini, int fim) {
		int meio;
		if (ini < fim) {
			meio = partition(v, ini, fim);
			quickSort(v, ini, meio);
			quickSort(v, meio + 1, fim);
		}
		return v;
	}
	// PARTITION
	static int partition(int[] v, int ini, int fim) {
		int pivo, topo, i;
		pivo = v[ini];
		topo = ini;

		for (i = ini + 1; i <= fim; i++) {
			if (v[i] < pivo) {
				v[topo] = v[i];
				v[i] = v[topo + 1];
				topo++;
			}
		}
		v[topo] = pivo;
		return topo;
	}
	// BINARY SEARCH: FIRST ELEMENT
	static int binarySearchFirstElement(int[] array, int valor) {
		int esq = 0;
		int dir = array.length - 1;
		int meio, resultado = -1;

		while (esq <= dir) {
			meio = (esq + dir) / 2;
			if (valor == array[meio]) {
				resultado = meio;
				dir = meio - 1;//diferenca entre o algoritmo do primeiro e ultimo
			} else if (valor < array[meio]) {
				dir = meio - 1;
			} else {
				esq = meio + 1;
			}
		}
		return resultado;
	}
	// BINARY SEARCH: LAST ELEMENT
	static int binarySearchLastElement(int[] array, int valor) {
		int esq = 0;
		int dir = array.length - 1;
		int meio, resultado = -1;

		while (esq <= dir) {
			meio = (esq + dir) / 2;
			if (valor == array[meio]) {
				resultado = meio;
				esq = meio + 1; //diferenca entre o algoritmo do primeiro e ultimo
			} else if (valor < array[meio]) {
				dir = meio - 1;
			} else {
				esq = meio + 1;
			}
		}
		return resultado;
	}
	public static void main(String args[]) {
		int vEntrada[] = { 1, 2, 3, 4, 5, 5, 4, 3, 2, 2 }; //vetor de entrada
		int vResultado[] = numeroOcorrenciasAdaptado(vEntrada); //faz o algoritmo e retorna o resultado
		imprimeVetorInteiro(vResultado);//imprime o resultado
	}
	private static int [] numeroOcorrenciasAdaptado(int[] entrada) {
		int vEntrada[] = entrada.clone(); //cria um copia do array de entrada para manter os dados originais
		int vOrdenado[] = quickSort(entrada, 0, entrada.length - 1); //ordena o vetor de entrada e coloca em um vetor ordenado
		int vResultado[] = new int[vEntrada.length]; //cria o vetor resultado do mesmo tamanho do vetor de entrada
		int primeiro = 0, ultimo = 0, resultado = 0;
		for (int i = 0; i < vEntrada.length; i++) { //percorre o vetor de entrada (NAO ORDENADO) e faz a busca binaria no array ORDENADO
			//a busca binaria sempre ira retornar uma posicao != de -1, porque o dado de entrada esta em outro array
			primeiro = binarySearchFirstElement(vOrdenado, vEntrada[i]); //encontra a primeira posicao de um elemento no vetor ordenado
			ultimo = binarySearchLastElement(vOrdenado, vEntrada[i]); //encontra a ultima posicao de um elemnto no vetor ordenado
			resultado = ultimo - primeiro + 1; //com a posicao do primeiro elemento e a do ultimo e facil descobrir quantos elementos tem com aquele valor
			vResultado[i] = resultado; //insere a resposta em um novo vetor de resposta
		}
		return vResultado;
	}
	static void imprimeVetorInteiro(int vetor[]) {
		System.out.print("\nOs dados do vetor sao: ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}
}