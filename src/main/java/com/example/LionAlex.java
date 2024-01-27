package com.example;

public class LionAlex extends Lion {
    private final String[] friendsOfAlex = {"Марти", "Глория", "Мелман"};
    private final String placeOfLiving = "Нью-Йоркский зоопарк";
    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
    }
    public String[] getFriends() {
        return friendsOfAlex;
    }
    public String getPlaceOfLiving() {
        return placeOfLiving;
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
