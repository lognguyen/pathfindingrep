import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;



// Assignment 6 
// Long Nguyen (V00914145)
public class Solution{
   

    public static void main(String[] args) throws FileNotFoundException {
        int startx =0;
        int starty =0;
        int endx =0;
        int endy =0;
        
        // change input text file here
        Scanner input = new Scanner(new File("input00.txt"));
        int size = input.nextInt();
        
        boolean[][] box = new boolean[size][size];
        input.nextLine();

        // Backtracking algorithm
        for (int i = 0;i < size ;i++){
            String str = input.nextLine();
            for (int j=0; j < size;j++){
                // food
                box[i][j] = str.charAt(j) == '#';
                if (str.charAt(j) == 'A'){
                    startx = i;
                    starty = j;
                }
                if (str.charAt(j) == 'B'){
                    endx = i;
                    endy = j;
                }
            }
        } 
        
        Stack<Location> bta = new Stack<Location>();
        boolean[][] visited = new boolean[box.length][box.length];
        for (int i=0;i<visited.length;i++){
            for (int j=0;j<visited[i].length;j++){
                visited[i][j] = true;
            }
        }

        bta.push(new Location(startx, starty));
        try {
            while (bta.size()!=0 && (endx != bta.peek().getRow() && endy != bta.peek().getCol())){
                Location current = bta.peek();
                visited[current.getRow()][current.getCol()] = false;
                if (up(current.getRow(),current.getCol(),box,visited)==true){
                    Location upl = new Location(current.getRow()-1,current.getCol());
                    bta.push(upl);
                }
                else if (down(current.getRow(),current.getCol(),box,visited)==true){
                    
                    Location downl = new Location(current.getRow()+1, current.getCol());
                    bta.push(downl);
                }
                else if (left(current.getRow(),current.getCol(),box,visited)==true){
                    
                    Location leftl = new Location(current.getRow(), current.getCol()-1);
                    bta.push(leftl);
                }
                else if (right(current.getRow(),current.getCol(),box,visited)==true){
                    Location rightl = new Location(current.getRow(), current.getCol()+1);
                    bta.push(rightl);
                } else {
                    try {
                        bta.pop();
                    } catch (EmptyStackException e){
                        System.out.println("IMPOSSIBLE");
                    }
                }
            }
        } catch (EmptyStackException e){
            System.out.println("IMPOSSIBLE");
        } 
        
        int answer = bta.size();
        if (answer == 0){
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
        input.close();
    }

    public static boolean up(int currentx,int currenty,boolean[][] box,boolean[][] visited){
        // try "up"
        if (currentx< box.length && currentx>0){
            if (isWall(currentx-1,currenty,box) == false && visited[currentx-1][currenty]==true) {
                return true;
            }
        }
        return box[currentx][currenty];
    }

    public static boolean down(int currentx,int currenty,boolean[][] box,boolean[][] visited){
        // try "down"
        if (currentx+1<box.length && currenty>-1){
            if (isWall(currentx+1,currenty,box) == false && visited[currentx+1][currenty]==true) {
                return true;
            }
        }   
        return false;
    }
    public static boolean left(int currentx,int currenty,boolean[][] box,boolean[][] visited){
        // try "left"
        if (currentx<box.length && currenty>0){
            if (isWall(currentx,currenty-1,box) == false && visited[currentx][currenty-1]==true) {
                return true;
            }
        }
        return false;
    }
    public static boolean right(int currentx,int currenty,boolean[][] box,boolean[][] visited){
        // try "right"
        if (currentx+1<box.length && currenty>-1){
            if (isWall(currentx,currenty+1,box) == false && visited[currentx][currenty+1]==true) {
                return true;
            }
        }
        return false;
    }
    public static boolean isWall(int row, int col,boolean[][] box) {
        if (row < 0 || box.length <= row) {
            return true;
        }

        if (col < 0 || box[0].length <= col) {
            return true;
        }

        return false;
    }
    public static boolean lengthchange(){
        return false;
    }
    
}
class Location{
    private int row;
    private int column;

    Location(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }
}

