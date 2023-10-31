/*
Diwas Dahal
12/7/2022
CS 110: Final project
Main class that runs the game and its inputs
*/

import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.NumberFormatException;

public class MineSweeper 
{
   
   private static Grid begin, inter, advance, matrice;
   
  
   public static void main (String[] args)
   { 
      
      MinesweeperDriver driver = new MinesweeperDriver();
      
      // Tell what this games have a how to start
      System.out.println("=====Wlecome to the MineSweeperGame!!=====\n");
      System.out.println("This game has levels and will let you Reset that level if you Like to continue playing after the win or loss\nNow only enter y to Play ");
      Scanner play = new Scanner(System.in);
      char choice = play.next().charAt(0);
      char notCaseSensitive = Character.toUpperCase(choice);
      while (notCaseSensitive != 'Y')
      {
         System.out.println("only Y to start the game");
         play = new Scanner(System.in);
         choice = play.next().charAt(0);
         notCaseSensitive = Character.toUpperCase(choice);
      }
      
      boolean Game_On = true;
      if (driver.play(notCaseSensitive))
      {
         Game_On = true;
      }
      else
      { 
         Game_On = false;
         System.exit(0);
      }
   
      // asks for what level
      Scanner levels = new Scanner(System.in);
      System.out.println("What level would you like to do? Options:(B)eginning, (I)ntermediate, (A)dvance");
      char selected = levels.next().charAt(0);
      char notCase = Character.toUpperCase(selected);
      MineSweeper mineSwe = new MineSweeper();
      // exceptions 
      try
      {
         while (selected != 'A' && selected != 'B' && selected != 'I') // while loop that checks if they choose the right Alphabet
         {
            System.out.println("INVALID INPUT!!");
            levels = new Scanner(System.in);
            System.out.println("What level would you like to do? Options:(B)eginning, (I)ntermediate, (A)dvance");
            selected = levels.next().charAt(0);
            notCase = Character.toUpperCase(selected);
            
            mineSwe.gridCreater(notCase);
         }
         if (notCase == 'B' || notCase == 'A' || notCase == 'I') // right alphabet runs the game
         {
            mineSwe.gridCreater(notCase); // sends the the level input to gridCreater class
            System.out.println(matrice.toString());
            while(Game_On == true)
            { 
               Scanner entry;
               char firstChar, isUpper;
               String request;

               try{    
                  System.out.println("What's next?");
                  entry = new Scanner(System.in);
                  System.out.println("Options: (U)ncover r c, (F)lag r c, (Q)uit");                      
                  request = entry.nextLine();
                  firstChar = request.charAt(0);
                  isUpper = Character.toUpperCase(firstChar);
                  if (isUpper == 'Q')
                  {
                     System.out.print("YOU QUIT THE GAME!!");
                     Game_On=false; 
                     System.exit(0); // ends the program
                  }
                  ArrayList<String> list = new ArrayList<String>(Arrays.asList(request.split(" "))); // takes in the input and splits in the spaces
                  int row = Integer.parseInt(list.get(1));
                  int col = Integer.parseInt(list.get(2));
                  while (isUpper != 'U' && isUpper != 'F' || (row <= 0 && row > 10)|| (col<=0 && col>12)) 
                  {
                     System.out.println("Input Invalid");
                     entry = new Scanner(System.in);
                     System.out.println("Options: (U)ncover r c, (F)lag r c, (Q)uit");
                           
                     request = entry.nextLine();
                     firstChar = request.charAt(0);
                     isUpper = Character.toUpperCase(firstChar);
                 } 
                     
                  if (isUpper == 'F') // if they want to flag
                  {
                     matrice.flagSquare(row, col);
                     System.out.println(matrice.toString());
                  }
                  else if(isUpper == 'U')// if they want to uncover
                  {
                     matrice.uncoverSquare(row, col);
                         
                     if (matrice.uncoverSquare(row, col) == Grid.MINE) // if they uncover mine
                     {
                        System.out.println("you lost!");
                        matrice.exposeMines();
                        System.out.println(matrice.toString());
                        Game_On = false;
                        System.out.println("========GAME OVER========");
                        Scanner option = new Scanner(System.in);
                        System.out.println("Woudl you like to restart the level?: "); // let's the player reset the level
                        char charOption = option.nextLine().charAt(0);
                        char isUpperCase = Character.toUpperCase(charOption);
                        if(isUpperCase == 'Y') 
                        {
                           mineSwe.gridCreater(notCase);
                           System.out.println(matrice.toString());
                           Game_On = true;
                        }
                        else if (isUpperCase == 'N')
                        {
                           Game_On = false;
                        }
                     }
                     else if(matrice.uncoverSquare(row, col) == Grid.WIN) // if they win the game
                     {
                        System.out.println(matrice.toString());
                        System.out.println("YOU WIN!");
                        Game_On = false;
                        Scanner option = new Scanner(System.in);
                        System.out.println("Woudl you like to restart the level?: "); // let's the player reset the level
                        char charOption = option.nextLine().charAt(0);
                        char isUpperCase = Character.toUpperCase(charOption);
                        if(isUpperCase == 'Y')
                        {
                           mineSwe.gridCreater(notCase);
                           System.out.println(matrice.toString());
                           Game_On = true;
                        } 
                        else if (isUpperCase == 'N')
                        {
                           Game_On = false;
                        }
                     } 
                     
                     else if(matrice.uncoverSquare(row, col) == Grid.OK) // checks if there are more boxes that need to be empty
                     {
                        System.out.println(matrice.toString());
                     }
                            
                  } 
                            
               }
               catch(Exception E)  // catches the game exceptions
               {
                  System.out.println("There was an expection?");
                  Scanner option = new Scanner(System.in);
                  System.out.print("Woudl you like to restar the level?: ");
                  char charOption = option.nextLine().charAt(0);
                  char isUpperCase = Character.toUpperCase(charOption);
                  if(isUpperCase == 'Y')
                  {
                     mineSwe.gridCreater(notCase);
                     System.out.println(matrice.toString());
                     Game_On = true;
                  } 
                  else if (isUpperCase == 'N')
                  {
                     Game_On = false;
                  }
               }

           } 
           
         } 
                         
     }
     catch (Exception e) // chatchs the level exceptiona and other
     {
      System.out.println("Input Invalid");
      levels = new Scanner(System.in);
      System.out.println("What level would you like to do? Options:(B)eginning, (I)ntermediate, (A)dvance");
      selected = levels.next().charAt(0);
      notCase = Character.toUpperCase(selected);
     }
     
   }    
   
   /*gridCreater  is Grid class that take in level input and set the grid according to level
   @parma char choice
   @return Grid matrice
   */
   public Grid gridCreater(char choice)
   {
      if (choice == 'B' )
      {
         matrice = new Grid(8, 8, 8);
      }
      if (choice == 'I' )
      {
         matrice = new Grid(10, 12, 10);
      }
      
      if (choice == 'A' )
      {
         matrice = new Grid(16, 20, 50);
      }
 
      return matrice;
         
   }   
}

 