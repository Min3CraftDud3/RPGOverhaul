package com.SinfulPixel.RPGOverhaul.Restrictions;

/**
 * Created by Min3 on 3/26/2015.
 */
public enum RestrictTypes {
    DEAFULT(11),
    UPGRADE_1(14),
    UPGRADE_2(17),
    UPGRADE_3(20),
    UPGRADE_4(23),
    UPGRADE_5(26),
    UPGRADE_FINAL(36);

    private int value;

    private RestrictTypes(int value) {
        this.value = value;
    }
    public static int getValue(RestrictTypes r){
        return r.value;
    }

    public static RestrictTypes intToType(int i){
        RestrictTypes res = null;
        for(RestrictTypes r :RestrictTypes.values()){
            if(i==r.value){
                res = r;
            }
        }
        return res;
    }
};
