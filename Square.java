/*
Diwas Dahal
12/7/2022
CS 110: Final project
The Square class is an abstract class that is meant to be the basis for all Squares in the grid.
*/

public abstract class Square
{
   private String element;
   private boolean flagged, uncovered;
   
   /*Square constructor sets all the instance veriables   
   */
   public Square()
   {
      element = "X";
      flagged = false;
      uncovered = false;
   }
   
   /*Square constructor sets all the instance veriables to whats inputed in the constructor 
   @param String element, boolean flagged, boolean uncover  
   */
   public Square(String element, boolean flagged, boolean uncover)
   {
      this.element = element;
      this.flagged = flagged;
      this.uncovered = uncover;
   }
   
   /*isFlagged check if the point is falgged
   @return boolean flagged
   */
   public boolean isFlagged()
   {
      return flagged;
   }
   
   /*isUncovered check if the point is uncovered
   @return boolean uncovered
   */
   public boolean isUncovered()
   {
      return uncovered;
   }
   
   /*flagSquare set the falgged point to "f" ans return and set the flagged veriable to true 
   */
   public void flagSquare()
   {
     if (flagged)
     {
         setElement("X");
     }
     else 
     {
         setElement("f");
     }
     
     flagged = !flagged;
   }
   
   /*setUncovered sets the uncovered veriable to true   
   */
   public void setUncovered()
   {
      uncovered = true;
   }
   
   /*setElement  sets the element variable to input element
   @param String ele
   */
   public void setElement(String ele)
   {
      element = ele;
   }
   
   /*toString return the element veriable
   @return String element
   */
   public String toString()
   {
      return element;
   }
   /*abstract uncover method which is overridden in the subclasses
   */
   public abstract void uncover();
   
   /*abstract usMine method which is overridden in the subclasses
   */
   public abstract boolean isMine();
       
   
}