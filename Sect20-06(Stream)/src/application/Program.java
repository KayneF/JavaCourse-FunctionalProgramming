package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(3,4,5,10,7);
		
		// Stream baseado em Collection
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));
		
		// Stream baseado no método "Stream.of()"
		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
		System.out.println(Arrays.toString(st2.toArray()));
		
		// Stream baseado em função de iteração
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));
		
		// Stream usando a "Sequência de Fibonacci"
		Stream<Long> st4 = Stream.iterate(
				new Long[] {0L, 1L}, p -> 
				new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
		System.out.println(Arrays.toString(st4.limit(50).toArray()));
	}
}
