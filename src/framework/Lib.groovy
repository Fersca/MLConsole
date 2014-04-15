package framework
import java.awt.BorderLayout;

import groovy.swing.SwingBuilder
import javax.swing.JFrame
import javax.swing.JOptionPane;

class Lib {
	
	public static def siteId

	static show(def pantalla){

		//Clear the console.
		clearConsole()
		
		def inputs = [:]
		def inputIndex = 0
		
		//print the custom screen 
		pantalla.each { mapa ->
			mapa.each { key, value ->				

				if (key=="titulo"){
					println "*************** ${value} *******************"				
				}
	
				if (key=="linea")
					println "-------${value}-------"
				
				if (key=="texto")
					println value
	
				if (key=="grilla"){
					value.each { element ->
						//add any input to the input map
						try {
							if (element.action){
								println "${inputIndex} - ${element.contenido.toString()}"
								inputs[inputIndex] = element.action
								inputIndex++
							} else {
								println "${element.toString()}"
							}
						} catch (MissingPropertyException e){
							println "${element.toString()}"
						}
					}					
				}
			}
		}
		
		//Add the default options
		println "${inputIndex} - Main Menu"
		inputs[inputIndex] = {MainMenu.view()};
		inputIndex++
		println "${inputIndex} - Exit"
		println "--------------"
		inputs[inputIndex] = {System.exit(0)};
		
		//check the user input
		checkInput(inputs)

	}
	
	static def clearConsole(){
		//for (int i = 0; i < 80; ++i) System.out.println();
		//I dont know how to crear the screen :(	
	}
	
	/**
	 * Ask for inputs
	 * @param inputs
	 * @return
	 */
	static def checkInput(def inputs){
		
		def input = System.console().readLine("Option: ")
		
		def intInput = Integer.parseInt(input)
		
		//check if the option is valid
		if (inputs[intInput]){
			//get the action from the input
			def action = inputs[intInput]
			//execute the action
			action()
		} else {
			println "Invalid Input."
			//call it again
			checkInput(inputs)
		}
	}
		
	/**
	 * Muestra un input con el mensaje que se pase como parametro
	 * @param frase
	 * @return
	 */
	static input(def frase){
	
		def cons = System.console()
		def yn = {((cons.readLine(frase)?:"n").trim()?:"n")?.charAt(0).toLowerCase().toString() }
		def result = yn(frase) 
		if (result=="n") input(frase) else return result; 
	
	}
	
}
