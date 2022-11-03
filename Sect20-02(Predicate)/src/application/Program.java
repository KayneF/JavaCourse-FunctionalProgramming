package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import entities.Product;
import util.ProductPredicate;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		

		// implementação da interface
		list.removeIf(new ProductPredicate());
		
		// reference method (static)
		list.removeIf(Product::staticProductPredicate);
		
		// reference method (non static)
		list.removeIf(Product::nonStaticProductPredicate);
		
		// declared lambda expression
		Predicate<Product> pred = p -> p.getPrice() >= 100;
		list.removeIf(pred);
		
		// inline lambda expression
		list.removeIf(p -> p.getPrice() >= 100);
		
		for (Product p : list) {
			System.out.println(p);
		}
	}
}
