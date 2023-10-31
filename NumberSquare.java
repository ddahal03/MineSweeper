/*
Diwas Dahal
12/7/2022
CS 110: Final project
NumberSquare extends Square and is not abstract. This represents a square that is not a mine
*/

public class NumberSquare extends Square
{
   private int neighborMines, myRow, myCol;
   
   /*NumberSquare constructor takes neighbor number and a point
   @param int neighbor, int row, int col
   */
   public NumberSquare(int neighbor,int row,int col) 
   {
      neighborMines = neighbor;
      myRow = row;
      myCol = col;
   }
   
   @Override
   /* uncover checks if the mine is flagged or uncovered if no nucovered it uncovers to "_" 
   or print the number of mine around it
   */
   public void uncover()
   {
      if(isFlagged())
      {    
          
      }
      else 
      {
         setUncovered();
         if(neighborMines == 0)
         {
            setElement("_");
         }
         else
         {
            setElement(""+neighborMines);
         }
         
      }
   }
   
   /* getNeighbor return the neighborMines veriable
   @return string neighborMines
   */
   public int getNeighborMines()
   {
      return neighborMines;
   }
   
   @Override
   /*Check if the square number is mine and return fasle
   @return boolean
   */
   public boolean isMine()
   {
      return false; 
   }
   
  
}