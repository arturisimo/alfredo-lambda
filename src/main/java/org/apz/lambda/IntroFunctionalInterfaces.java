package org.apz.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class IntroFunctionalInterfaces {
	
	public static void main(String[] args) {
		usingConsumers();
		usingSuppliers();
		usingPredicates();
		usingFunctions();
	}
	
	
	private static void usingFunctions() {
		List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");
	    Function<String, Integer> nameMappingFunction = String::length;
	    List<Integer> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
	    System.out.println(nameLength);
	}

	private static void usingPredicates() {
		List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
	    Predicate<String> startPredicate = str -> str.startsWith("S");
	    Predicate<String> lengthPredicate = str -> str.length() >= 5;
	    names.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);
	}

	private static void usingConsumers() {
		List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

	    Consumer<List<String>> upperCaseConsumer = list -> {
	        for(int i=0; i< list.size(); i++){
	            list.set(i, list.get(i).toUpperCase());
	        }
	    };
	    Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

	    upperCaseConsumer.andThen(printConsumer).accept(cities);
	}
	

	public static void usingSuppliers(){
	    Supplier<Double> doubleSupplier = () -> Math.random();
	    Optional<Double> optionalDouble = Optional.empty();
	    System.out.println(optionalDouble.orElseGet(doubleSupplier));
	}
	
	
}
