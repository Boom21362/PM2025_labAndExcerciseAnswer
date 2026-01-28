package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
    private int row;
    private int column;
    private boolean isWhite;
    private String name;
    protected int hp;
    protected int power;
    protected boolean isFlying;

    public BaseUnit(int startColumn,int startRow, boolean isWhite, String name){
            power = 1;
            isFlying = false;
            this.setHp(2);
            this.setRow(startRow);
            this.setColumn(startColumn);
            this.setWhite(isWhite);
            this.setName(name);
    }

    public BaseUnit() {
    }

    public boolean move(int direction) {
        switch (direction) {
            case 0 -> {
                if(getRow()+1 <= 4){
                        setRow(getRow()+1);
                return true;}
            }
            case 1 -> {
                if(getColumn()+1 <= 4){
                setColumn(getColumn()+1);
                return true;
                }

            }

            case 2 -> {
                if(getRow()-1 >= 0){
                    setRow(getRow()-1);
                    return true;
                }
            }
            case 3 -> {
                if(getColumn()-1 >= 0){
                    setColumn(getColumn()-1);
                    return true;
                }
            }
            default -> {
                return false;
            }
        }
        return false;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if(row < 0){
            this.row = 0;
        }
        else this.row = Math.min(row, 4);
    }

    public void attack(ArrayList<BaseUnit> targetPieces){
        for(BaseUnit bu: targetPieces){
            if(bu.getRow() == this.getRow() && bu.getColumn() == this.getColumn() && !bu.isFlying()){
                bu.setHp(bu.getHp()-this.getPower());
                System.out.println(this.getName() + " attacks "+ bu.getName());
                if(bu.getHp() < 0){
                    targetPieces.remove(bu);
                }
            }
        }
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        if(column < 0){
            this.column = 0;
        }
        else this.column = Math.min(column, 4);
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public boolean isFlying() {
        return isFlying;
    }
}
