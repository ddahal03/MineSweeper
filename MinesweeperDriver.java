/*
Diwas Dahal
12/7/2022
CS 110: Final project
Checks if they want to play by taking input form mineSweeper class
*/

public class MinesweeperDriver
{
   /*play method checks if the play want's to play and return true or false base on the input
   @param char start
   @return boolean gameOn
   */
   public boolean play(char start)
   {
      boolean gameOn = false;
      
      if (start == 'Y')
         return gameOn = true;
      else if (start == 'N')
         return gameOn = false; 
      return gameOn;
   }   
}   
   
   