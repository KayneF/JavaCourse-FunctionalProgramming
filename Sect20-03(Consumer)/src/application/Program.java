package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import entities.Product;
import util.PriceUpdate;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		// implementação da interface
		list.forEach(new PriceUpdate());

		// reference method (static)
		list.forEach(Product::staticPriceUpdate);

		// reference method (non static)
		list.forEach(Product::nonStaticPriceUpdate);

		// declared lambda expression
		double factor = 1.1;
		Consumer<Product> cons = p -> p.setPrice(p.getPrice() * factor);
		list.forEach(cons);

		// inline lambda expression
		list.forEach(p -> p.setPrice(p.getPrice() * factor));
		
		list.forEach(System.out::println);
	}
}
