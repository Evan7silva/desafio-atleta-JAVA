import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int contHomem = 0;
		int contMulher = 0;
		double atletaMaisAlto = 0;
		double pesoAtletas = 0;
		double porcHomens = 0;
		double alturaMulheres = 0;
		double altMedMulher = 0;
		double pesoMedia = 0;
		String atleta = null;
		char sexo;
		
		System.out.print("Qual a quantidade de atletas? ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {

			System.out.println("Digite os dados do atleta numero " + (i+1) + " : ");
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Sexo: ");
			sexo = sc.next().charAt(0);

			while (sexo != 'M' && sexo != 'F') {
				System.out.print("Valor invalido! Favor digitar F ou M: ");
				sexo = sc.next().charAt(0);
			}

			System.out.print("Altura: ");
			double altura = sc.nextDouble();

			while (altura <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}

			if (altura > atletaMaisAlto) {
				atletaMaisAlto = altura;
				atleta = nome;
			}else if (altura < atletaMaisAlto) {
				nome = atleta;
			}
			
			System.out.print("Peso: ");
			double peso = sc.nextDouble();

			while (peso <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}

			pesoAtletas += peso;
			
			if (sexo == 'M') {
				contHomem += 1;
				porcHomens = 100 * contHomem / N;
			}
			if (sexo == 'F') {
				contMulher += 1;
				alturaMulheres += altura;
				altMedMulher = alturaMulheres / contMulher;
			}
			
		}

		pesoMedia = pesoAtletas / N;

		System.out.println();
		System.out.println("RELATÓRIO: ");
		System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedia);
		System.out.printf("Atleta mais alto: %s%n", atleta);
		System.out.printf("Porcentagem de homens: %.1f%%%n", porcHomens);
		if (contMulher > 0) {
			System.out.printf("Altura média das mulheres: %.2f%n", altMedMulher);
		} else {
			System.out.println("Não há mulheres cadastradas");
		}

		sc.close();
	}

}
