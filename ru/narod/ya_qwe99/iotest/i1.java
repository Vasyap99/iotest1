
package ru.narod.ya_qwe99.iotest;

import java.lang.*;
import java.io.*;


import java.net.*;

class raf_test{
  void test(){
    try{
      RandomAccessFile raf=new RandomAccessFile("data.dat","r");  //new File
      raf.seek(5);  
      System.out.println(""+raf.readDouble()+' '+raf.getFilePointer());
      raf.close();
      //
      raf=new RandomAccessFile("data2.dat","rw");
      raf.writeChars("kok".toByteArray());
    }catch(Exception e){
      System.out.println(e); 
    }
  }
}

public class i1{
  public static void main(String []s){
    try{
      System.out.println("kok");

      byte[]b={60,62,63};

      FileOutputStream fos=new FileOutputStream("data.dat");
      fos.write('a');
      fos.write(b);

      DataOutputStream dos=new DataOutputStream(fos);
      dos.writeByte(60);
      dos.writeDouble(128);
      dos.writeChar('h');

      fos.close(); 

      FileInputStream fis=new FileInputStream("data1.dat");
      //DataInputStream dis=new DataInputStream(fis);
      int t; 
      String x="";
      while((t=fis.read())!=-1) x+=(char)t; 
      fis.close();
      System.out.println(x); 

      fis=new FileInputStream("data.dat");
      DataInputStream dis=new DataInputStream(fis);
      System.out.println((char)dis.readByte());
      for(int i=0;i<3;i++)System.out.println(dis.readByte());

      byte[]buf=new byte[3];
      int j;
      do{
        j=fis.read(buf);
        for(int k=0;k<j;k++)
          System.out.println(buf[k]);  
      }while(j>0);
      System.out.println((char)104);
    }catch(Exception e){}

    (new raf_test()).test();
      //
    try{
      URL url=new URL("https://ya.ru");
      InputStream di=url.openConnection().getInputStream();
      //DataInputStream di=new DataInputStream(url.openStream());
      int q;
      String qq="";
      while((q=di.read())!=-1){qq+=(char)q;}
      System.out.println("qq="+qq);
    }catch(Exception e){
      System.out.println(""+e);
    }
  }
}