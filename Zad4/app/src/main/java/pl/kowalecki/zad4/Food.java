package pl.kowalecki.zad4;

public class Food {

    private String name;
    private String description;
    private int imageResourceId;

    public static final Food[] foods = {
            new Food("Scrambled eggs", "Jajecznica na maśle", R.drawable.scrambled_eggs),
            new Food("Chicken butter", "Kawałki kurczaka w sosie masala", R.drawable.chicken_butter),
            new Food("Mushroom  soup", "Zupa z pieczarek", R.drawable.mushroom_soup) //R.drawable -> obrazki
    };

    private Food(String name, String description, int imageResourceId){
        this.name=name;
        this.description=description;
        this.imageResourceId=imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
