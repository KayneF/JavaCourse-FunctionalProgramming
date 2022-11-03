package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Product;

public class Program {
	
	/**
	 * "Lambda expressions", são blocos de código que recebem parâmetros e 
	 * retornam valores. São similares a funções, porém, não precisam de um 
	 * nome (função anonima), e podem ser implementadas dentro de um método. 
	 * Elas podem ser armazenadas em uma variável, desde que essa variável seja
	 * do mesmo tipo da interface que tenha apenas um método (Comparator<> por 
	 * exemplo).
	 */
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.0));
		list.add(new Product("Laptop", 1200.0));
		list.add(new Product("Tablet", 450.0));
		
		/**
		 * "Comparable<T>" é uma interface funcional que possui apenas um método.
		 * O método "compare" é utilizado para comparar dois objetos.
		 */
//		// Normal function
//		Comparator<Product> comp = new Comparator<Product>() {
//			@Override
//			public int compare(Product p1, Product p2) {
//				return p1.getName().toUpperCase()
//						.compareTo(p2.getName().toUpperCase());
//			}
//		};
		
		
		// Lambda expression
		/** 
		 * Detalhe que o compilador reconhece automaticamente os tipos dos
		 * parâmetros, sendo desnecessário (mas não proibido) defini-los ao
		 * lados das variáveis parâmetros.
		 * Ex: 
		 * 		(Product p1, Product p2) ->
		 * pode ser substituído por:
		 * 		(p1, p2) ->
		 */
		Comparator<Product> compTest = (p1, p2) -> {
			return p1.getName().toUpperCase()
					.compareTo(p2.getName().toUpperCase());
		};
//		list.sort(compTest);
		
		// Lambda expression (reduzido)
		/**
		 * Quando a expressão lambda possui apenas uma linha de código, é 
		 * possivel simplifacar o código, retirando as chaves, e o comando
		 * "return".
		 */
		Comparator<Product> comp = (p1, p2) -> 
			p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		
//		list.sort(comp);
			
		/**
		 * Caso a expressão seja bem pequena, pode ser interessante reduzi-la 
		 * um pouco mais, para isso, basta criar a expressão dentro do campo 
		 * em forma de argumento, ao invéz de declarar uma variável para 
		 * guaradar e reutilizar.
		 */
			
		list.sort((p1, p2) -> 
			p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		for (Product p : list) {
			System.out.println(p);
		}
	}
}
