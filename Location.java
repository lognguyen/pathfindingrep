
class Location{
    private int row;
    private int column;
    private boolean isWall;

    Location(int row, int column) {
        this.row = row;
        this.column = column;
    }
    Location(int row, int column,boolean isWall) {
        this.row = row;
        this.column = column;
        this.isWall = isWall;
    }
    public boolean equals(Location node){
        return (this.row == node.row && this.col == node.col);
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
}