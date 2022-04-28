import java.util.Scanner;

public class SomaSubMulti {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//COME�O DO PROGRAMA
		
		//Vari�veis para armazenar quantas linhas e colunas as matrizes teram
		int x = 0, y = 0, z = 0, w = 0;
		
		//Pega os valores de linhas e colunas das matrizes A e B
		System.out.print("Informe o n�mero de linhas da matriz A: ");
		x = input.nextInt();
		System.out.print("Informe o n�mero de colunas da matriz A: ");
		y = input.nextInt();
		
		System.out.print("Informe o n�mero de linhas da matriz B: ");
		z = input.nextInt();
		System.out.print("Informe o n�mero de colunas da matriz B: ");
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
		
		//Verefica se as matrizes A e B s�o de mesma ordem e caso forem faz a soma e a subtra��o delas
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
			
			//Subtra��o de A - B
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					subtracao[i][j] = matrizA[i][j] - matrizB[i][j];
				}
			}
			
			//Mostra a subtra��o de A - B
			System.out.println("Subtra��o de A - B: ");
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					System.out.print(subtracao[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
			
			//Subtra��o de B - A
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					subtracao[i][j] = matrizB[i][j] - matrizA[i][j];
				}
			}
			
			//Mostra a subtra��o de B - A
			System.out.println("Subtra��o de B - A: ");
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					System.out.print(subtracao[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
			
			//Verifica se o numero de colunas da matriz A � igual ao de linhas da matriz B, no caso de serem de mesma ordem
			if(y == z)
			{
				//Multiplica��o A * B
				int[][] multiAB = new int[x][w];
				
				for(int i = 0; i < x; i++) {
					for(int j = 0; j < w; j++) {
						for(int aux = 0; aux < z; aux++) {
							multiAB[i][j] += matrizA[i][aux] * matrizB[aux][j];
						}
					}
				}
				System.out.println("Multiplica��o A * B: ");
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < w; j++) {
						System.out.print(multiAB[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				
				//verefica se B * A � possivel, onde as matrizes s�o de mesma ordem e A * B tamb�m � possivel
				if(w == x){ 
					
					//Multiplica��o DE B * A
					int [][]multiBA = new int[z][y];
					
					for(int i = 0;i < z; i ++) {
						for(int j = 0;j < y; j++) {
							for( int aux = 0; aux < x; aux ++) {
								multiBA[i][j] += matrizB[i][aux] * matrizA[aux][j];
							}
						}
					}
					System.out.println("Multiplica��o B * A: ");
					for (int i = 0; i < z; i++) {
						for (int j = 0; j < y; j++) {
							System.out.print(multiBA[i][j]);
							System.out.print(" ");
						}
						System.out.println();
					}
					
				}
				
			}//Verifica se � possivel a multiplica��o de B * A, caso as matrizes forem de mesma ordem mesmo que A * B n�o seja possivel
			else if(w == x){ 
				
				//Multiplica��o DE B * A				
				int [][]multiBA = new int[z][y];
				
				for(int i = 0;i < z; i ++) {
					for(int j = 0;j < y; j++) {
						for( int aux = 0; aux < z; aux ++) {
							multiBA[i][j] += matrizB[i][aux] * matrizA[aux][j];
						}
					}
				}
				System.out.println("Multiplica��o B * A: ");
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < w; j++) {
						System.out.print(multiBA[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				
			}// � mostrado caso as matrizes A e B tenham a mesma ordem mas a multiplica��o entre elas n�o seja possivel 
			else
				System.out.println("A multiplica��o n�o � poss�vel");
			
			
		}//Caso as matrizes n�o tenham a mesma ordem 
		else {
			System.out.println("N�o � poss�vel somar e subtrair as matrizes, pois possuem ordens diferentes");
			
			//Verifica se a multiplica��o de A * B � possivel
			if(y == z)
			{
				//Multiplica��o de A * B
				int[][] multiAB = new int[x][w];
				
				for(int i = 0; i < x; i++) {
					for(int j = 0; j < w; j++) {
						for(int aux = 0; aux < z; aux++) {
							multiAB[i][j] += matrizA[i][aux] * matrizB[aux][j];
						}
					}
				}
				System.out.println("Multiplica��o A * B: ");
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < w; j++) {
						System.out.print(multiAB[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				
				//Verifica se a multiplica��o de B * A � possivel, onde A * B tamb�m seja possivel
				if(w == x){ 
					//Multiplica��o DE B * A
					int [][]multiBA = new int[z][y];
					
					for(int i = 0;i < z; i ++) {
						for(int j = 0;j < y; j++) {
							for( int aux = 0; aux < x; aux ++) {
								multiBA[i][j] += matrizB[i][aux] * matrizA[aux][j];
							}
						}
					}
					System.out.println("Multiplica��o B * A: ");
					for (int i = 0; i < z; i++) {
						for (int j = 0; j < y; j++) {
							System.out.print(multiBA[i][j]);
							System.out.print(" ");
						}
						System.out.println();
					}
					
				}
				
			}//Verifica se a multiplica��o de B * A � possivel, neste caso A * B n�o � possivel 
			else if(w == x){ 
				
				//Multiplica��o DE B * A
				int [][]multiBA = new int[z][y];
				
				for(int i = 0;i < z; i ++) {
					for(int j = 0;j < y; j++) {
						for( int aux = 0; aux < x; aux ++) {
							multiBA[i][j] += matrizB[i][aux] * matrizA[aux][j];
						}
					}
				}
				System.out.println("Multiplica��o B * A: ");
				for (int i = 0; i < z; i++) {
					for (int j = 0; j < y; j++) {
						System.out.print(multiBA[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				
			}//Neste nenhum caso � possivel, tanto soma e subtra��o quanto a multiplica��o
			else
				System.out.println("A multiplica��o tamb�m n�o � poss�vel");
			
		}
		// FIM DO PROGRAMA
		input.close();
	}

}

