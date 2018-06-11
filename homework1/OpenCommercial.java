package com.homework1;/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

      BufferedReader keyboard;
      String inputLine;



      keyboard = new BufferedReader(new InputStreamReader(System.in));

      System.out.print("Please enter the name of a company (without spaces): ");
      System.out.flush();        /* Make sure the line is printed immediately. */
      inputLine = keyboard.readLine();

      /* Replace this comment with your solution.  */

      String address = "http://www." + inputLine + ".com";
      System.out.println(address);
      String firstFiveString[] = new String[5];
      URL url = new URL(address);

      BufferedReader urlContent = new BufferedReader(new InputStreamReader(url.openStream()));
      String onInputLine;
      int i = 0;
      while ((onInputLine = urlContent.readLine()) != null && i < firstFiveString.length){
          firstFiveString[i] = onInputLine;
          i++;
      }
      System.out.println("Output:");
      for (int j = firstFiveString.length-1; j >= 0; j--){
          System.out.println(firstFiveString[j]);
      }


//      String adress="http://www." + inputLine + ".com";
//      System.out.println(adress);
//
//      String firstFiveLines[] = new String[5];
//      URL url =new URL(adress);
//
//      BufferedReader urlContent = new BufferedReader(new InputStreamReader(url.openStream()));
//      String oneInputLine;
//      int i=0;
//
//      while((oneInputLine=urlContent.readLine())!=null && i<firstFiveLines.length){
//        firstFiveLines[i]=oneInputLine;
//        i++;
//      }
//
//      for(int j=firstFiveLines.length-1;j>=0;j--){
//        System.out.println(firstFiveLines[j]);
//      }


    }
}
