/*
Diwas Dahal
12/7/2022
CS 110: Final project
The Grid is the two dimensional collection of Square objects. The default grid size is
10 rows and 12 columns, with 10 mines randomly placed.
*/

import java.util.Random;
public class Grid
{
   private Square[][] grid;
   private int width, height, numMines; 
   int numSquaresUncovered; 
   public static final int OK = 1; 
   public static final int WIN = 2;
   public static final int MINE = 3;
   
   
   /*Gird constructor takes in hight width and creats a gird and randomly places mines in thouse grids
   @param int height, width, numMines
   */
   public Grid(int height, int width, int numMines)
   {
      this.numMines = numMines;
      this.height = height;
      this.width = width;
      numSquaresUncovered = 0;
      grid = new Square[height][width]; //Random mines
      int var = 0;
      int row, col;
      Random random = new Random();
      while(var!=numMines)
      {
         row = random.nextInt(height);
         col = random.nextInt(width);
         if (grid[row][col] == null)
         {
            grid[row][col] = new MineSquare();
            var++;   
         }  
      }
      
      // 2d Grid 
      for(row=0; row < height; row++) 
      { 
         for(col=0; col < width; col++) 
         {
            if (grid[row][col]==null)
            {
               grid[row][col] = new NumberSquare(getNeighbors(row,col), row,col);
            }
         }
      }   
   
   }
   /*getNeighbors takes in row and col and will return the number of Squares, adjacent to r, c that contain mines.
   while not going off the edge of the grid. 
   @param int row, int col
   @return int count
   */
   public int getNeighbors(int row, int col)
   { 
      int count = 0;
      for(int x=row-1; x <= row+1; x++)
      {
         for(int y = col-1; y <= col+1; y++)
         {
            if (x >-1 && x < height && y >-1 && y < width)
            {
               if (grid[x][y] != null)
               {
                 if(grid[x][y].isMine())
                  count++;

               }
            }
         }
      }
      return count;   
   }
   
   /*uncoverSquare takes in row and col and checks if that point is mine, if not it check if it's uncovored, 
   if not it uncovers the point. Also chekcs if the player won or not
   @param int row, int col
   @return int MINE, WIN, OK 
   */
   public int uncoverSquare(int row, int col)
   {
      int neighobre = getNeighbors(row, col);       
      if(grid[row][col].isMine()) // Checks if it's mine
      {
         return MINE;
      }
      
      if(neighobre == 0) // check if there are 0 mines 
      {
         for(int x=row-2; x <= row+2; x++)
         {
            for(int y = col-2; y <= col+2; y++)
            {
               if (x >-1 && x < height && y >-1 && y < width)
               {
                  if (!grid[x][y].isMine() && !grid[x][y].isUncovered() && !grid[row][col].isFlagged())
                  {
                     grid[x][y].uncover();
                     numSquaresUncovered++;
                  }             
               }
            }
         }
      }
      
      else if(neighobre == 1) // check if there are 1 mines
      {
         for(int x=row-1; x <= row+1; x++)
         {
            for(int y = col-1; y <= col+1; y++)
            {
               if (x >-1 && x < height && y >-1 && y < width)
               {
                  if (!grid[x][y].isMine() && !grid[x][y].isUncovered() && !grid[row][col].isFlagged())
                  {
                     grid[x][y].uncover();
                     numSquaresUncovered++;
                  }    
               }
            }
         }
      }
      else // check if there are more then 1 mines
      {
         if (!grid[row][col].isMine() && !grid[row][col].isUncovered() && !grid[row][col].isFlagged())
         {
            grid[row][col].uncover();
            numSquaresUncovered++;
         }                 
      } 
      
      // Check for win or loss
        
      int numForWin = (height * width) - numMines;
      if (numSquaresUncovered == numForWin)
         return WIN;
      else 
         return OK;
   }
   
   /* exposeMines exposes all the mines if they uncover mine 
   */
   public void exposeMines()
   {
      for(int row=0; row < height; row++) 
      { 
         for(int col=0; col < width; col++) 
         {
            if (grid[row][col].isMine())
            {
              grid[row][col].uncover();
            }
         }
      }    
   }
   
   /*flagSquare take in a x y point and checks if it's flagged and set it's to flage if not.
   @param int row, col
   */
   public void flagSquare(int row, int col)
   {
      grid[row][col].flagSquare();
      grid[row][col].isFlagged();  
   }
   
   /*toString prints the grid and wiht number on top and left side 
   also calss the square toString class and and retruns it all
   @return String str;
   */
   public String toString()
   {
      String str = "";
      System.out.print("\t");
      for (int i =0; i < width; i++)
         System.out.print(i+"\t");
      System.out.println("");
      for(int row=0; row<height; row++) // print row of 0 - 9
      { 
         str += row;
         for(int col=0; col<width; col++) 
         {
            str += ("\t" + grid[row][col].toString()); 
         }
         str += "\n";  
      } 
      return str; 
   }     
}