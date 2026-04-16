/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A program that lets the user input guesses for what color the computer will pick
 * and tells them how many correct guesses they made.
 * Due: 09/12/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Griffin Shay
*/


import java.util.Scanner;
import java.util.Random;

//ESPGame simulates a simple guessing game where the user tries to predict a randomly chosen color
public class ESPGame
{
	public static void main(String[] args)
	{
		String name;
		String description;
		String dueDate;
		String userGuess;
		int round = 1, correct = 0;
		final int ITERATIONS = 11;

		Scanner input = new Scanner(System.in);
		Random num = new Random();
		
		// Prompt user and collect user information
		System.out.print("Enter your name: ");
		name = input.nextLine();
		System.out.print("Describe yourself: ");
		description = input.nextLine();
		System.out.print("Due Date: ");
		dueDate = input.nextLine();
		System.out.print("CSMC203 Assignment 1: Test your ESP skills!\n");
		
		//Loop that prompts the user to guess a color, validates the input, and determines if the guess was correct.
		for (int count = 0; count < ITERATIONS; count++)
		{
			//Generates a random number
			int colorNum = num.nextInt(1, 6);
			
			//Default color value
			String color = "Red";
			
			//Display round information and get user's guess
			System.out.print("Round " + round + "\n\n");
			System.out.print("I am thinking of a color.\n");
			System.out.println("Is it Red, Green, Blue, Orange, or Yellow?");
			System.out.println("Enter your guess: ");
			userGuess = input.nextLine();			

			//Validate's that guess is a valid color
			while (!userGuess.equalsIgnoreCase("Red") && !userGuess.equalsIgnoreCase("Green") && !userGuess.equalsIgnoreCase("Blue")
			&& !userGuess.equalsIgnoreCase("Orange") && !userGuess.equalsIgnoreCase("Yellow"))
			{
				System.out.println("You entered an incorrect color. Is it Red, Green, Blue, Orange, or Yellow?");
				System.out.println("Enter your guess again:");
				userGuess = input.nextLine();
			}
			
			//Map the random number to a specific color
			if (colorNum == 1)
				color = "Red";
			else if (colorNum == 2)
				color = "Green";
			else if (colorNum == 3)
				color = "Blue";
			else if (colorNum == 4)
				color = "Orange";
			else if (colorNum == 5)
				color = "Yellow";	

			System.out.print("\n\nI was thinking of " + color + ".\n");
			
			//Check if the user's guess matches the generated color and increments correct guesses if it does
			if (userGuess.equalsIgnoreCase(color))
			{
				correct += 1;
			}
			round++;
		}
		
		//Display final results and user information after all rounds are completed
		System.out.print("Game Over\n\n");
		System.out.println("You guessed " + correct + " out of " + ITERATIONS + " colors correctly.");
		System.out.println("User Name: " + name);
		System.out.println("User Description: " + description);
		System.out.println("Due Date: " + dueDate);

	}
}
