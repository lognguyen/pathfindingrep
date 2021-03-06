import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array; 


public class Path{
    private Location start;
    private Location end;
    private Location[][] box;
    public Path(String filepath){
        
        try{
        // change input text file here
            Scanner input = new Scanner(new File(filepath));
            int size = input.nextInt();
            
            Location[][] box = new Location[size][size];
            input.nextLine();

            // Backtracking algorithm
            for (int i = 0;i < size ;i++){
                String str = input.nextLine();
                for (int j=0; j < size;j++){
                    // food
                    if (str.charAt(j) == '#'){
                        // blockage
                        box[i][j] = new Location(i, j, 0,true);
                    } else if (str.charAt(j) == 'A'){
                        // start
                        start = new Location(i, j,-1,false); 
                    } else if (str.charAt(j) == 'B'){
                        // end
                        end = new Location(i, j,-2,false);
                    } else {
                        // checking the format of the digit
                        if (Character.digit(str.charAt(j), 10) == -1){
                            break;
                        } else {
                            int digit = str.charAt(j) - '0';
                        }
                        box[i][j] = new Location(i,j,digit,false);
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
    public boolean isWall(int row, int col) {
        if (row < 0 || box.length <= row) {
            return true;
        }

        if (col < 0 || box[0].length <= col) {
            return true;
        }

        return false;
    }
}


