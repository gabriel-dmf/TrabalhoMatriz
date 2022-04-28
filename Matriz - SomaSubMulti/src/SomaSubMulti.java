import java.util.Scanner;

public class SomaSubMulti {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//COMEÇO DO PROGRAMA
		
		//Variáveis para armazenar quantas linhas e colunas as matrizes teram
		int x = 0, y = 0, z = 0, w = 0;
		
		//Pega os valores de linhas e colunas das matrizes A e B
		System.out.print("Informe o número de linhas da matriz A: ");
		x = input.nextInt();
		System.out.print("Informe o número de colunas da matriz A: ");
		y = input.nextInt();
		
		System.out.print("Informe o número de linhas da matriz B: ");
		z = input.nextInt();
		System.out.print("Informe o número de colunas da matriz B: ");
		w = input.nextInt();
		
		int[][] matrizA = new int[x][y];
		int[][] matrizB = new int[z][w];
		
		//Insere os valores da matriz A
		System.out.println("VALARES DA MATRIZ A: ");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print("Digite a matriz ["+(i+1)+","+(j+1)+"]= ");
				matrizA[i][j] = input.nextInt();
			}
		}
		
		//Insere os valores da matriz B
		System.out.println("VALARES DA MATRIZ B: ");
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print("Digite a matriz ["+(i+1)+","+(j+1)+"]= ");
				matrizB[i][j] = input.nextInt();
			}
		}
		System.out.println();
		
		//Verefica se as matrizes A e B são de mesma ordem e caso forem faz a soma e a subtração delas
		if(x == z && y == w) {
			int[][] soma = new int[x][y];
			int[][] subtracao = new int[x][y];
			
			//Soma das matrizes A e B
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					soma[i][j] = matrizA[i][j] + matrizB[i][j];
				}
			}
			
			//Mostra a soma entre as matrizes
			System.out.println("Soma de A + B: ");
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					System.out.print(soma[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
			
			//Subtração de A - B
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					subtracao[i][j] = matrizA[i][j] - matrizB[i][j];
				}
			}
			
			//Mostra a subtração de A - B
			System.out.println("Subtração de A - B: ");
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					System.out.print(subtracao[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
			
			//Subtração de B - A
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					subtracao[i][j] = matrizB[i][j] - matrizA[i][j];
				}
			}
			
			//Mostra a subtração de B - A
			System.out.println("Subtração de B - A: ");
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					System.out.print(subtracao[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
			
			//Verifica se o numero de colunas da matriz A é igual ao de linhas da matriz B, no caso de serem de mesma ordem
			if(y == z)
			{
				//Multiplicação A * B
				int[][] multiAB = new int[x][w];
				
				for(int i = 0; i < x; i++) {
					for(int j = 0; j < w; j++) {
						for(int aux = 0; aux < z; aux++) {
							multiAB[i][j] += matrizA[i][aux] * matrizB[aux][j];
						}
					}
				}
				System.out.println("Multiplicação A * B: ");
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < w; j++) {
						System.out.print(multiAB[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				
				//verefica se B * A é possivel, onde as matrizes são de mesma ordem e A * B também é possivel
				if(w == x){ 
					
					//Multiplicação DE B * A
					int [][]multiBA = new int[z][y];
					
					for(int i = 0;i < z; i ++) {
						for(int j = 0;j < y; j++) {
							for( int aux = 0; aux < x; aux ++) {
								multiBA[i][j] += matrizB[i][aux] * matrizA[aux][j];
							}
						}
					}
					System.out.println("Multiplicação B * A: ");
					for (int i = 0; i < z; i++) {
						for (int j = 0; j < y; j++) {
							System.out.print(multiBA[i][j]);
							System.out.print(" ");
						}
						System.out.println();
					}
					
				}
				
			}//Verifica se é possivel a multiplicação de B * A, caso as matrizes forem de mesma ordem mesmo que A * B não seja possivel
			else if(w == x){ 
				
				//Multiplicação DE B * A				
				int [][]multiBA = new int[z][y];
				
				for(int i = 0;i < z; i ++) {
					for(int j = 0;j < y; j++) {
						for( int aux = 0; aux < z; aux ++) {
							multiBA[i][j] += matrizB[i][aux] * matrizA[aux][j];
						}
					}
				}
				System.out.println("Multiplicação B * A: ");
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < w; j++) {
						System.out.print(multiBA[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				
			}// É mostrado caso as matrizes A e B tenham a mesma ordem mas a multiplicação entre elas não seja possivel 
			else
				System.out.println("A multiplicação não é possível");
			
			
		}//Caso as matrizes não tenham a mesma ordem 
		else {
			System.out.println("Não é possível somar e subtrair as matrizes, pois possuem ordens diferentes");
			
			//Verifica se a multiplicação de A * B é possivel
			if(y == z)
			{
				//Multiplicação de A * B
				int[][] multiAB = new int[x][w];
				
				for(int i = 0; i < x; i++) {
					for(int j = 0; j < w; j++) {
						for(int aux = 0; aux < z; aux++) {
							multiAB[i][j] += matrizA[i][aux] * matrizB[aux][j];
						}
					}
				}
				System.out.println("Multiplicação A * B: ");
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < w; j++) {
						System.out.print(multiAB[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				
				//Verifica se a multiplicação de B * A é possivel, onde A * B também seja possivel
				if(w == x){ 
					//Multiplicação DE B * A
					int [][]multiBA = new int[z][y];
					
					for(int i = 0;i < z; i ++) {
						for(int j = 0;j < y; j++) {
							for( int aux = 0; aux < x; aux ++) {
								multiBA[i][j] += matrizB[i][aux] * matrizA[aux][j];
							}
						}
					}
					System.out.println("Multiplicação B * A: ");
					for (int i = 0; i < z; i++) {
						for (int j = 0; j < y; j++) {
							System.out.print(multiBA[i][j]);
							System.out.print(" ");
						}
						System.out.println();
					}
					
				}
				
			}//Verifica se a multiplicação de B * A é possivel, neste caso A * B não é possivel 
			else if(w == x){ 
				
				//Multiplicação DE B * A
				int [][]multiBA = new int[z][y];
				
				for(int i = 0;i < z; i ++) {
					for(int j = 0;j < y; j++) {
						for( int aux = 0; aux < x; aux ++) {
							multiBA[i][j] += matrizB[i][aux] * matrizA[aux][j];
						}
					}
				}
				System.out.println("Multiplicação B * A: ");
				for (int i = 0; i < z; i++) {
					for (int j = 0; j < y; j++) {
						System.out.print(multiBA[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				
			}//Neste nenhum caso é possivel, tanto soma e subtração quanto a multiplicação
			else
				System.out.println("A multiplicação também não é possível");
			
		}
		// FIM DO PROGRAMA
		input.close();
	}

}

