/**
 * Created by joe on 9/8/16.
 */
public class Cat {
    private String name;
    private String color;
    private String cuddly;
    private String meow;
    private String purr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCuddly() {
        return cuddly;
    }

    public void setCuddly(String cuddly) {
        this.cuddly = cuddly;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    public String getPurr() {
        return purr;
    }

    public void setPurr(String purr) {
        this.purr = purr;
    }
    @Override
    public String toString() {
        return String.format("name: %s color: %s cuddly: %s" +
                " meow: %s purr: %s",name,color,cuddly,meow,purr);
    }

    public void update(){
        System.out.println("Please enter the cat name:");
        setName(FileIO.scanner.nextLine());
        System.out.println("Please enter the cat color");
        setColor(FileIO.scanner.nextLine());
        System.out.println("Was the cat cuddly [yes | no]");
        setCuddly(FileIO.scanner.nextLine());
        System.out.println("How many times did the cat meow:");
        setMeow(FileIO.scanner.nextLine());
        System.out.println("How loud was the cat's purr:");
        setPurr(FileIO.scanner.nextLine());
    }
}
