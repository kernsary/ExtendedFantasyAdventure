package rooms;

public enum TreasureType {
    GOLD("gold", 20),
    JEWELS("a hoard of jewels", 5),
    SILVER("silver", 10);

    private final String name;
    private final int value;

    TreasureType(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public int getValue(){
        return value;
    }
}
