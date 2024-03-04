package player;

public class Player {
    private String name;
    private int age;
    private String address;
    private long contact_no;
    private String email;
    private char symbol;

    public void setPlayerDetails (String name, int age, String address, long contact_no, String email, char symbol) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact_no = contact_no;
        this.email = email;
        this.symbol = symbol;
    }

    public void setPlayerNameAndAge (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPlayerNameSymbolEmailAge (String name, char symbol, String email, int age) {
        this.name = name;
        this.symbol = symbol;
        this.email = email;
        this.age = age;
    }

    public void setPlayerNameAndSymbol (String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void changeSymbol (char symbol) {
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return this.name;
    }

    public char getPlayerSymbol() {
        return this.symbol;
    }

    public void getPlayerNameAndAge() {
        System.out.println("Player Name: " + this.name);
        System.out.println("Player Age: " + this.age);
    }

    public void getPlayerNameAndSymbol() {
        System.out.println("Player Name: " + this.name);
        System.out.println("Player Symbol: " + this.symbol);
    }

    public void getPlayerDetails() {
        System.out.println("Player Name: " + this.name);
        System.out.println("Player Age: " + this.age);
        System.out.println("Player Address: " + this.address);
        System.out.println("Player Contact number: " + this.contact_no);
        System.out.println("Player Email: " + this.email);
        System.out.println("Player Symbol: " + this.symbol);
    }
}

