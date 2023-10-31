/*
Diwas Dahal
12/7/2022
CS 110: Final project
uncover() method will call setUncovered( ) to change the covered instance variable and set the
element instance variable represent what should be displayed in the grid 
*/

public class MineSquare extends Square
{
   @Override
   /* uncover checks if the box is flagged or not and if not flagged it set the element to a mine "*"
   */
   public void uncover()
   {
      if(!(isFlagged()))
      {    
         setElement("*");
         setUncovered();
      }   
      
   }
   @Override
   /* isMine return true 
   @return booelan 
   */
   public boolean isMine()
   {
      return true;
   }
   

}