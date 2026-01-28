package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit{

    public RangeUnit(int startColumn,int startRow, boolean isWhite, String name){
        super(startColumn,startRow,isWhite,name);
        this.setHp(2);
    }

    public void attack(ArrayList<BaseUnit> targetPieces){
        if(isWhite()) {
            for (BaseUnit bu : targetPieces) {
                if (bu.getRow()-1 == this.getRow() && bu.getColumn() == this.getColumn()) {
                    bu.setHp(bu.getHp() - this.getPower());
                    System.out.println(this.getName() + " attacks " + bu.getName());
                    if (bu.getHp() < 0) {
                        targetPieces.remove(bu);
                    }
                }
            }
        }
        else{
            for (BaseUnit bu : targetPieces) {
                if (bu.getRow()+1 == this.getRow() && bu.getColumn() == this.getColumn()) {
                    bu.setHp(bu.getHp() - this.getPower());
                    System.out.println(this.getName() + " attacks " + bu.getName());
                    if (bu.getHp() < 0) {
                        targetPieces.remove(bu);
                    }
                }
            }

        }
    }
}
