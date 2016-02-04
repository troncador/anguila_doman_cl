package cl.doman.anguila.configuration;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Main implements Runnable {

  public static void main(String[] args) {
    System.out.println("The default locale is: " + Locale.getDefault());
    Locale[] locales = Locale.getAvailableLocales();
    System.out.printf("No. of other available locales is: %d, and they are: %n", locales.length);
    for (Locale locale : locales) {
      System.out.printf("Locale code: %s and it stands for %s %n", locale, locale.getDisplayName());
    }
  }


  @Override
  public void run() {
    // TODO Auto-generated method stub

  }

}
