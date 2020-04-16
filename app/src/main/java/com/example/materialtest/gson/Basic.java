package com.example.materialtest.gson;

import com.google.gson.annotations.SerializedName;

public class Basic {
    @SerializedName("city")
    public String cityName;//城市名

    @SerializedName("id")
    public String weatherId;//城市对应的天气id

    public Update update;

    public class Update{

        @SerializedName("loc")
        //由于JSON中的一些字段不适合直接作为Java字段命名，通过@SerializedName注解方式，让JSON字段和Java字段之间建立映射关系
        public String updateTime;//天气更新时间
    }

}
