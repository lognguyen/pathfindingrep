
import java.util.Stack;
import javax.xml.stream.events.EndDocument;

import java.lang.Math.abs;


public class A_Solver {
    // default value of D used in heurestic
    private int Dvalue = 1;
    private int D2value = 1; //default Chebyshev distance

    public static String findPath(Path maze) {
        String result = "";
        

        Stack<Location> bta = new Stack<Location>();
        boolean[][] visited = new boolean[maze.getNumRows()][maze.getNumCols()];
        makethearrayunvisited(visited);
        // assign all elements to true

        Location start = maze.Entry();
        Location end = maze.Exit();
        bta.push(start);
        
        try {
            while (bta.size()!=0 && end.equals(bta.peek())==false){
                Location current = bta.peek();
                visited[current.getRow()][current.getCol()] = false;
                if (up(current,maze,visited)==true){
                    Location upl = new Location(current.getRow()-1,current.getCol());
                    bta.push(upl);
                }
                else if (down(current, maze, visited)==true){
                    Location downl = new Location(current.getRow()+1, current.getCol());
                    bta.push(downl);
                }
                else if (left(current, maze, visited)==true){
                    Location leftl = new Location(current.getRow(), current.getCol()-1);
                    bta.push(leftl);
                }
                else if (right(current, maze, visited)==true){
                    Location rightl = new Location(current.getRow(), current.getCol()+1);
                    bta.push(rightl);
                } else {
                    try {
                        bta.pop();
                    } catch (StackEmptyException e){
                        return result;
                    }
                }
            }
        } catch (StackEmptyException e){
            return result;
        } 
        // Last In First Out Rule --> reverse stack to put the path in the right order
        return reverseStringStack(bta);
    }
    
    // check all 4 possible directions
    public static boolean up(Location sth,Path moar,boolean[][] arr){
        // try "up"
        if (sth.getRow()< moar.getNumRows() && sth.getRow()>0){
            if (moar.isWall(sth.getRow()-1, sth.getCol()) == false && arr[sth.getRow()-1][sth.getCol()]==true) {
                return true;
            }
        }
        return false;
    }
    public static boolean down(Location sth,Path moar,boolean[][] arr){
        // try "down"
        if (sth.getRow()+1<moar.getNumRows() && sth.getRow()>-1){
            if (moar.isWall(sth.getRow()+1, sth.getCol()) == false && arr[sth.getRow()+1][sth.getCol()]==true) {
                return true;
            }
        }   
        return false;
    }
    public static boolean left(Location sth,Path moar,boolean[][] arr){
        // try "left"
        if (sth.getCol()<moar.getNumCols() && sth.getCol()>0){
            if (moar.isWall(sth.getRow(), sth.getCol()-1) == false && arr[sth.getRow()][sth.getCol()-1]==true) {
                return true;
            }
        }
        return false;
    }
    public static boolean right(Location sth,Path moar,boolean[][] arr){
        // try "right"
        if (sth.getCol()+1<moar.getNumCols() && sth.getCol()>-1){
            if (moar.isWall(sth.getRow(), sth.getCol()+1) == false && arr[sth.getRow()][sth.getCol()+1]==true) {
                return true;
            }
        }
        return false;
    }
    public static void makethearrayunvisited(boolean[][] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                arr[i][j] = true;
            }
        }
    }

    // Heuristics

    // Manhanttan distance -- 4 directions
    public int manhanttanheu(Location node, Path maze){
        // D is the lowest cost between adjecent blocks 
        // check around the node to find the lowest
        int dx = abs(node.getRow() - maze.Exit().getRow());
        int dy = abs(node.getCol() - maze.Exit().getCol());
        return Dvalue * (dx+dy);
    }

    public int diagonalheu(Location node, Path maze){
        int dx = abs(node.getRow() - maze.Exit().getRow());
        int dy = abs(node.getCol() - maze.Exit().getCol());
        return Dvalue * (dx+dy) + (D2value - 2 * Dvalue) * Math.min(dx, dy);
    }



    // min cost between two blocks
    public static int checkingD(Location node, Path maze,boolean[][]arr){
        ;
    }

    public static String reverseStringStack(Stack<Location> stack){
        // use another stack to reverse the original stack
        Stack<Location> reversestack = new Stack<Location>();
        try {
            while (stack.size()!=0){
                reversestack.push(stack.pop());
            }
        } catch (StackEmptyException e){
            return reversestack.toString();
        }
        return reversestack.toString();
    }

}
