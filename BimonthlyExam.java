package EstruturaSequencial_Exercicio_4;
import java.util.Scanner;

class BimonthlyExam {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		BimonthlyExamGrades calculateGrades = new BimonthlyExamGrades();
		calculateGrades.calculateBimonthlyGrades(userInput);
		userInput.close();
	}
}

class BimonthlyExamGrades {
	public int[] grades = new int[4]; //definindo que serão 4 avaliações bimestrais
	public String[] textNested = {"Deseja ver a soma das notas ou a média das notas das quatro avaliações?", "[1] - Soma das notas", "[2] - Média das notas", "[3] - Ver soma e média das notas"};
	public void calculateBimonthlyGrades(Scanner userInput){
		for(int i = 0; i < 4; i++){
			System.out.println("Por favor insira abaixo a nota avaliação bimestral "+i+":");
			grades[i] = Integer.parseInt(userInput.nextLine());
		}
		//pergunte se o usuário quer ver a soma das notas ou a média.
		for(int n = 0; n < 4; n++){ 
			System.out.println(textNested[n]);
		}
		String userAnswer = userInput.nextLine();
		if(userAnswer.contains("1") || userAnswer.toLowerCase().contains("soma")){
		//se for escolhido a soma das notas das avaliações
			System.out.println("A soma das notas de todas as avaliações é: " + calculateSumOfTheGrades());
		} else if (userAnswer.contains("2") || userAnswer.toLowerCase().contains("media") || userAnswer.toLowerCase().contains("média")){
		//se for escolhido a média das avaliações
			System.out.println("A média das avaliações é: " + calculateClassAverage());
		} else if (userAnswer.contains("3")) {
			System.out.println("A soma das notas de todas as avaliações é: " + calculateSumOfTheGrades());
			System.out.println("A média das avaliações é: " + calculateClassAverage());
		}
	}
	double calculateClassAverage(){
		//Some todas a notas e divida pelo total de avaliações.
		double classAverageGrade = calculateSumOfTheGrades() / grades.length;  
		return classAverageGrade;
	}
	int calculateSumOfTheGrades(){
		int sumOfTheGrades = grades[0] + grades[1] + grades[2] + grades[3];
		return sumOfTheGrades;
	}
}
