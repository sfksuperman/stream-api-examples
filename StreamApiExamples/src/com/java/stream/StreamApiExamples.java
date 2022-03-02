package com.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExamples {

	public static void main(String[] args) {
		
/*	Collection is when we want to represent the group of objects as a single entity. But, Stream is when we want to process the objects from collection.
	Stream s = c.stream(); --Here, 'c' is the collection and 'stream()' is the method which gives 's' as a Stream (java.util.stream package).
		
		A. INTERMEDIATE OPERATIONS on Streams:
			1. map:		The map() operation takes a Function, which is called for each value in the input stream and produces one result value,
						which is sent to the output stream.
			2. flatMap():	
			3. filter:	The filter method is used to select elements as per the Predicate passed as argument.
			4. sorted:	The sorted method is used to sort the stream.
			5. distinct:	
			6. peek():	
			7. limit():	
			8. skip():	

		B. TERMINAL OPERATIONS on Streams:
			1. collect: The collect method is used to return the result of the intermediate operations performed on the stream.
			2. forEach: The forEach method is used to iterate through every element of the stream.
			3. reduce:	The reduce method is used to reduce the elements of a stream to a single value. It takes a BinaryOperator as a parameter.
		
*/		
		// 1. Find the even number from the given ArrayList.
		ArrayList<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		List<Integer> l2 = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("1. " + l2);

		// 2. Add 5 grace marks to every students marks given in ArrayList.
		ArrayList<Integer> studentMarks = new ArrayList<>();
		studentMarks.add(28);
		studentMarks.add(29);
		studentMarks.add(30);
		studentMarks.add(31);
		List<Integer> updatedStudentMarks = studentMarks.stream().map(i -> i + 5).collect(Collectors.toList());
		System.out.println("2. " + updatedStudentMarks);

		// 3. Find the square of the given numbers in ArrayList.
		List<Integer> number = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
		List<Integer> square = number.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.println("3. " + square);

		// 3a. Find the square of only unique numbers in ArrayList.
		List<Integer> number1 = Arrays.asList(2, 2, 3, 3, 4, 5, 6, 6, 7, 8);
		List<Integer> uniqueSquare = number1.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("3a. " + uniqueSquare);
		
		// 4. Find the name of employee whose name starts with 'S' (include case-sensitive)
		List<String> names = Arrays.asList("Ram", "shyam", "Shyam", "Sita", "Manoj", "Rahul", "Sita");
		List<String> result = names.stream().filter(i->i.toUpperCase().startsWith("S")).collect(Collectors.toList());
		System.out.println("4. " + result);
		
		// 5. Sort the name of employee alphabetically
		List<String> names1 = Arrays.asList("Ram", "Shyam", "Sita", "Manoj", "Rahul");
		List<String> sortedNames1 = names1.stream().sorted().collect(Collectors.toList());
		System.out.println("5. " + sortedNames1);
			// the other way is:
		Collections.sort(names1);
		System.out.println("5 other way. " + names1);
		
		// 5a. Sort the name of employee reverse-alphabetically
		List<String> names2 = Arrays.asList("Ram", "Shyam", "Sita", "Manoj", "Rahul");
		List<String> sortedNames2 = names2.stream().sorted().collect(Collectors.toList());
		Collections.reverse(sortedNames2);
		System.out.println("5a. " + sortedNames2);
		
		// 6. Print square of each element using forEach()
		List<Integer> numberFor = Arrays.asList(2,3,4,5);
		numberFor.stream().map(x->x*x).forEach(y->System.out.println("6. " + y));
		
		// 7. 
		List<Integer> numberFor2 = Arrays.asList(2,3,4,5);
		int even = numberFor2.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
		System.out.println("7. " + even);
		
		// 8. Count the number of empty string; can be done using isBlank() also
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		long count = strList.stream().filter(x -> x.isEmpty()).count();
		System.out.println("8. " + count);

		// 9. Count String whose length is more than three
		long num = strList.stream().filter(x -> x.length()> 3).count();
		System.out.println("9. " + num);
		
		// 10. Count number of String which starts with "a"
		long countHere = strList.stream().filter(x -> x.startsWith("a")).count();
		System.out.println("10. " + countHere);
		
		// 11. Remove all empty Strings from List
		List<String> filtered = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		System.out.println("11. " + filtered);
		
		// 12. Create a List with String more than 2 characters
		List<String> filteredAgain = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
		System.out.println("12. " + filteredAgain);
		
		// 13. Convert String to upper case and join them with comma
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println("13. " + G7Countries);
		
		// 14. Get count, min, max, sum, and the average for numbers
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("14. " + stats);
		System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
		
        // 15. Remove duplicate from the stream; Since Set has the property that it cannot contain any duplicate element 
        // So if we add the elements in a Set, it automatically discards the duplicate elements while addition itself.
        Stream<Integer> streamOfDuplicates = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        Set<Integer> setWithoutDuplicates = new HashSet<>();
        streamOfDuplicates.filter(i -> setWithoutDuplicates.add(i)).collect(Collectors.toSet());
        System.out.println("15. " + setWithoutDuplicates);

        // Adding some employees:
        List<Employee> listOfEmp = new ArrayList<>();
        listOfEmp.add(new Employee(101, "siva", 101, 2000, "active"));
        listOfEmp.add(new Employee (102, "reddy", 101, 5000, "active"));
        listOfEmp.add(new Employee (103, "raju", 102, 6000, "inactive"));
        listOfEmp.add(new Employee (104, "shivam", 102, 4000, "inactive"));
        listOfEmp.add(new Employee (105, "bob", 103, 3500, "active"));
        listOfEmp.add(new Employee (106, "alice", 103, 3500, "inactive"));
        listOfEmp.add(new Employee (107, "srinu", 104, 3500, "active"));
        
        
        // 16. Find the maximum and minimum salary of an employee
        Optional<Employee> empMaxSalary = listOfEmp.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        Optional<Employee> empMinSalary = listOfEmp.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
        
        Optional<Employee> empMaxSalary2 = listOfEmp.stream().max(Comparator.comparing(Employee::getSalary));
        Optional<Employee> empMinSalary2 = listOfEmp.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println("16. way1: " + "Max salary is: " + empMaxSalary + "-- and Min Salary is: " + empMinSalary);
        System.out.println("16. way2: " + "Max salary is: " + empMaxSalary2 + "-- and Min Salary is: " + empMinSalary2);
        
		// 17. Print employee details working in each department
        System.out.println("17:");
		Map<Integer, List<Employee>> listOfEmpDeptWise = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));
		listOfEmpDeptWise.entrySet().forEach(i -> System.out.println(i.getKey() + "---" + i.getValue()));
        
		// 18. Print employees count working in each department
		System.out.println("18:");
		Map<Integer, Long> empCountDeptWise = listOfEmp.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
		empCountDeptWise.entrySet().forEach(i-> System.out.println(i.getKey() + " = " + i.getValue()));
		
		// 19. Print active and inactive employees in each department
		System.out.println("19:");
		Map<String, List<Employee>> empByStatus = listOfEmp.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.toList()));
		empByStatus.entrySet().forEach(i-> System.out.println(i.getKey() + "---" + i.getValue()));
		
		// 20. Print the count of active and inactive employees in each department: There are 2 ways we can do.
		System.out.println("20:");
			// 1. using Map<>
			System.out.println("using Map<>:" );
			Map<String, Long> countOfEmpByStatus = listOfEmp.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.counting()));
			countOfEmpByStatus.entrySet().forEach(i-> System.out.println(i.getKey() + " = " + i.getValue()));
			
			// 2. using filter()
			System.out.println("using filter():" );
			long activeEmp = listOfEmp.stream().filter(i-> "active".equals(i.getStatus())).count();
			long inactiveEmp = listOfEmp.stream().filter(i-> "inactive".equals(i.getStatus())).count();
			System.out.println("active employee = " + activeEmp + "\n" + "inactive employee = " + inactiveEmp);
		
		// 21. Print max salary of an employee from each department
		System.out.println("21:");
		Map<Integer, Optional<Employee>> maxSalaryDeptWise = listOfEmp.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId,
						Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		maxSalaryDeptWise.entrySet()
				.forEach(i -> System.out.println("dept " + i.getKey() + " top emp is: " + i.getValue()));
		
		System.out.println("--------------------------------------");
		System.out.println("---STRING CONVERSION EXAMPLES BELOW---");
		System.out.println("--------------------------------------");
		
		//1 Convert `List<String>` to `List<Integer>`
		List<String> l1 = Arrays.asList("1", "2", "3");
		List<Integer> r1 = l1.stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println("1: " + r1);
		//the longer full lambda version:
		List<Integer> r11 = l1.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		System.out.println("1: by lambda: " + r11);
		 
		//2 Convert `List<String>` to `int[]`
		int[] r2 = l1.stream().mapToInt(Integer::parseInt).toArray();
		System.out.println("2: " + Arrays.toString(r2));
		 
		//3 Convert `String[]` to `List<Integer>`
		String[] a1 = {"4", "5", "6"};
		List<Integer> r3 = Stream.of(a1).map(Integer::parseInt).collect(Collectors.toList());
		System.out.println("3: " + r3);
		 
		//4 Convert `String[]` to `int[]`
		int[] r4 = Stream.of(a1).mapToInt(Integer::parseInt).toArray();
		System.out.println("4: " + Arrays.toString(r4));
		 
		//5 Convert `String[]` to `List<Double>`
		List<Double> r5 = Stream.of(a1).map(Double::parseDouble).collect(Collectors.toList());
		System.out.println("5: " + r5);
		
		//6 (bonus) Convert `int[]` to `String[]`
		int[] a2 = {7, 8, 9};
		String[] r6 = Arrays.stream(a2).mapToObj(Integer::toString).toArray(String[]::new);
		System.out.println("6: " + Arrays.toString(r6));
		
		//7 Convert 'Stream' to 'List<String>'
		Stream<String> tokenStream = Stream.of("A", "B", "C", "D");
		List<String> tokenList = tokenStream.collect(Collectors.toList());
		System.out.println("7: " + tokenList); 

		//8 Convert 'Stream' to 'LinkedList'
		Stream<String> tokenStream2 = Arrays.asList("A", "B", "C", "D").stream();
		List<String> tokenList2 = tokenStream2.collect(Collectors.toCollection(LinkedList::new));
		System.out.println("8: " + tokenList2);
		
	}

}
