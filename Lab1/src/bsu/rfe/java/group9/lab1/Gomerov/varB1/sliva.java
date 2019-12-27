package bsu.rfe.java.group9.lab1.Gomerov.varB1;

public class sliva extends Food {
    public String color;
    public sliva (String color)
    {
        super("Слива");
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    @Override
    public void consume() {
        System.out.println(this + " съедена");
    }

    @Override
    public int calculateCalories() {
        return 0;
    }
}
