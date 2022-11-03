package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;
import util.UpperCaseName;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		// A função "map()", funciona somente para "stream()"

		// implementação da interface
		List<String> names = list.stream().map(
				new UpperCaseName()).collect(Collectors.toList());
		names.forEach(System.out::println);
		
		// reference method (static)
		List<String> names2 = list.stream().map(
				Product::staticUpperCaseName).collect(Collectors.toList());
		names2.forEach(System.out::println);
		
		// reference method (non static)
		List<String> names3 = list.stream().map(
				Product::staticUpperCaseName).collect(Collectors.toList());
		names3.forEach(System.out::println);
		
		// declared lambda expression
		Function<Product, String> func = p -> p.getName().toUpperCase();
		List<String> names4 = list.stream().map(
				func).collect(Collectors.toList());
		names4.forEach(System.out::println);
		
		// inline lambda expression
		List<String> names5 = list.stream().map(
				p -> p.getName().toUpperCase()).collect(Collectors.toList());
		names5.forEach(System.out::println);
	}
}
