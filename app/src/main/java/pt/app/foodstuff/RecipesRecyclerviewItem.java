package pt.app.foodstuff;

public class RecipesRecyclerviewItem {
    private int mImage;
    private String mText;

    public RecipesRecyclerviewItem (int image, String text){
        mImage = image;
        mText = text;
    }

    public int getImage() {
        return mImage;
    }

    public String getText() {
        return mText;
    }
}
