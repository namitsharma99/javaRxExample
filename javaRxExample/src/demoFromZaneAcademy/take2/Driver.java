package demoFromZaneAcademy.take2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import demoFromZaneAcademy.take1.AVariable;

public class Driver {

	public static void main(String[] args) {

		List<AVariable> variables = Collections.synchronizedList(new ArrayList<AVariable>());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		AVariable aVariable = null;
		String varName = null;
		Double varValue = 0.0;
		
		System.out.println("---------- non reactive example, change is not propagated -------------");
		
		while (true) {
			
			System.out.println("Enter the name: ");
		//	varName = bufferedReader.readLine();
			if (varName.equalsIgnoreCase("exit")) {
				break;
			} else if (varName.isEmpty()) {
				continue;
			} 
			System.out.println("Enter var value");
			try {
				varValue = Double.valueOf(bufferedReader.readLine());
			} catch(Exception e) {
				System.out.println(e);
			}
 			aVariable = new AVariable(varName, varValue);
 			if (variables.contains(aVariable)) {
 				int index = variables.indexOf(aVariable);
 				variables.get(index).setVarValue(aVariable.getVarValue());
 				
 			} else {
 				variables.add(aVariable);
 			}
 			// System.out.println("Added variables : "+ variables.stream().mapToDouble(x -> x.getVarValue().sum()));
 			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			
		}
	}

}
