package rooms;

public enum TreasureType {
    GOLD(1),
    JEWELS(1),
    SILVER(1);

    private final int value;

    TreasureType(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
