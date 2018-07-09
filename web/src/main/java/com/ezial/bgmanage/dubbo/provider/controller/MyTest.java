package com.ezial.bgmanage.dubbo.provider.controller;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
  public static void main(String[] args) {
//      Locale locale = Locale.getDefault();
//
//      Locale locale2 = new Locale("en", "US", "SiliconValley");;
//
//    System.out.println(locale.getDisplayCountry());
//    System.out.println(locale2.getDisplayCountry());

      final Map<String,String> map = new HashMap<>(2);
      map.put("1","first");
      map.put("2","second");
      map.put("3","third");
      map.put("4","fourth");
      map.put("5","fifth");
      map.put("6","sixth");
      map.put("7","seventh");
      map.put("8","eighth");
      map.put("9","nineth");
      map.put("10","ten");

      System.out.println(map);

  }
}
