import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array; 

// Assignment 6 
// Long Nguyen (V00914145)
public class path{
    private Location start;
    private Location end;
    private boolean[][] box;
    public path(String filepath){
        
        try{
        // change input text file here
            Scanner input = new Scanner(new File(filepath));
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
                        start = new Location(i, j); 
                    }
                    if (str.charAt(j) == 'B'){
                        end = new Location(i, j);
                    }
                }
            } 
            
            input.close();
        } catch (IOException e){
            e.printStackTrace();;
        }
    }
    public Location Entry(){
        return start;
    }
    public Location Exit(){
        return end;
    }
    public int getNumRows(){
        return box.length;
    }

    public int getNumCols() {
        return box[0].length;
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
}


