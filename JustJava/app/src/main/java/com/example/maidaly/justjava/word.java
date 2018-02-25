/**
 * Created by Mai Daly on 2/24/2018.
 */
package com.example.maidaly.justjava;

public class word {
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId;
    private String mCoffeType;
    private String mCoffePrice;

    public word(String CoffeType, String CoffePrice, int ImageResourceId) {
        mCoffeType = CoffeType;
        mCoffePrice = CoffePrice;
        mImageResourceId = ImageResourceId;
    }
    public String getmCoffeType(){
        return mCoffeType;
    }
    public String getmCoffePrice (){
        return mCoffePrice;
    }
    public int getmImageResourceId (){
        return mImageResourceId;
    }
}
