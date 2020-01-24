
class Location{
    private int row;
    private int column;
    private boolean isWall;
    private int value;
    private boolean visited;

    Location(int row, int column){
        this.row = row;
        this.column = column;
    }
    Location(int row, int column,int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }
    Location(int row, int column,int value,boolean visited) {
        this.row = row;
        this.column = column;
        this.visited = visited;
        this.value = value;
    }
    public boolean equals(Location node){
        return (this.row == node.row && this.col == node.col);
    }
    public boolean intequals(Location node){
        return (this.value = node.value);
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }
    public boolean isWall(){
        return isWall;
    }
    public int getValue(){
        return value;
    }
    public boolean isVisited(){
        return visited;
    }
}