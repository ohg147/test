﻿package day13;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import day6.ProductTest;
public class SerialTest3 { 
   public static void main(String[] args) throws Exception{ 
      FileOutputStream fos = 
    		  new FileOutputStream("c:/iotest/test2.ser"); 
      ObjectOutputStream oos = 
    		  new ObjectOutputStream(fos);
      oos.writeObject(new Date());
      Thread.sleep(3000);
      oos.writeObject(new Date()); 
      Product st = new Product("듀크볼펜", 100, 3000);
      oos.writeObject(st);
      oos.close();
      fos.close();
      System.out.println("직렬화 출력 완료");      
   }
}



