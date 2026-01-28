    package logic.unit;

    public class FlyingUnit extends BaseUnit {

        public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name){
            super(startColumn,startRow,isWhite,name);
            isFlying = true;
            this.setHp(2);
        }

        @Override
        public boolean move(int direction) {
            switch (direction) {
                case 0 -> {
                    if(getRow()+2 <= 4){
                        setRow(getRow()+2);
                        return true;}
                }
                case 1 -> {
                    if(getColumn()+2 <= 4){
                        setColumn(getColumn()+2);return true;}
                }

                case 2 -> {
                    if(getRow()-2 >= 0){
                        setRow(getRow()-2);return true;}
                }
                case 3 -> {
                    if(getColumn()-2 >= 0){
                        setColumn(getColumn()-2);return true;}
                }
                default -> {
                    return false;
                }
            }
            return false;
        }
    }
