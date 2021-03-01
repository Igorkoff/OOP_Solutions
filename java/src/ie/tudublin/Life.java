package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
    int size = 100;
    float cellSize = 0;
    boolean[][] board = new boolean[size][size];
    boolean[][] next = new boolean[size][size];

    public int countCellsAround(int row, int col)
    {
        int count = 0;

        for (int r = row - 1; r <= row + 1; r++)
        {
            for (int c = col - 1; c <= col + 1; c++)
            {
                if (!(r == row && c == col))
                {
                    if (getCell(board, r, c))
                    {
                        count++;

                    }   // end inner if

                }   // end outer if

            }   // end inner for

        }   // end outer for

        return count;

    }   // end countCellsAround

    public boolean getCell(boolean[][] board, int row, int col)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col];
        }
        else
        {
            return false;

        }   // end if
        
    }   // end getCell

    public void setCell(boolean[][] board, int row, int col, boolean b)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            board[row][col] = b;

        }   // end if

    }   // end setCell

    public void drawBoard(boolean[][] board)
    {
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                float x = map(col, 0, size, 0, width);      // col * cellSize
                float y = map(row, 0, size, 0, height);     // row * cellSize

                if (board[row][col])
                {
                    rect(x, y, cellSize, cellSize);

                }   // end if

            }   // end inner for

        }   // end outer for

    }   // end drawBoard

    public void updateBoard()
    {
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                int neighbours = countCellsAround(row, col);

                if (getCell(board, row, col))
                {
                    if(neighbours == 2 || neighbours == 3)
                    {
                        setCell(next, row, col, true);
                    }
                    else
                    {
                        setCell(next, row, col, false);

                    }   // end inner if
                }
                else
                {
                    if (neighbours == 3)
                    {
                        setCell(next, row, col, true);
                    }
                    else
                    {
                        setCell(next, row, col, false);

                    }   // end inner if

                }   // end outer if

            }   // end inner for

        }   // end outer for

        
        // swap board and next

        boolean[][] temp = board;
        board = next;
        next = temp;

    }   // end updateBoard

    public void randomize()
    {
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                float dice = random(0.0f, 1.0f);
                
                if (dice < 0.5)
                {
                    setCell(board, row, col, true);
                }
                else
                {
                    setCell(board, row, col, false);

                }   // end if

            }   // end inner for

        }   // end outer for

    }   // end randomize

    public void clear()
    {
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                setCell(board, row, col, false);
            }
        }
    }

    public void drawCross()
    {
        for (int i = 0; i < size; i++)
        {
            setCell(board, size / 2, i, true);
            setCell(board, i, size / 2, true);

        }   // end for

    }   // end drawCross

    public void keyPressed() 
    {
        // the value of mode will be the number of the number key pressed
        
        if (keyCode == '1')
        {
            randomize();
        }

        if (keyCode == '2')
        {
            clear();
        }

        if (keyCode == '3')
        {
            drawCross();
        }

        if (keyCode == ' ')
        {
            if (looping)
            {
                noLoop();
            }
            else
            {
                loop();
            }
        }

    }   // end keyPressed

    public void mouseDragged()
    {
        int row = (int) map(mouseY, 0, height, 0, size);
        int col = (int) map(mouseX, 0, width, 0, size);
        setCell(board, row, col, true);

    }   // end mouseDragged

    public void settings()
    {
        size(600, 600);

    }   // end settings

    public void setup() 
    {
        colorMode(RGB);
        frameRate(60);
        randomize();

        cellSize = width / (size);

    }   // end setup

    public void draw() 
    {
        background(0, 0, 0);
        drawBoard(board);
        updateBoard();

    }   // end draw

}   // end Life