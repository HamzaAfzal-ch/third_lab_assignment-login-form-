package com.example.hamza_assignment;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;
public class NewFIle {
    File file;
    public NewFIle(){
        File directory=new File("D:\\hamza_assignment\\hamza_assignment");
        if (!directory.exists()) {
            directory.mkdirs();
        }
     file=new File(directory,"Data.txt");
        try{
             file.createNewFile();
        }catch(Exception j){
System.out.println(j.getMessage());
        }
       
    }

    public  void writeInFile( String name,String id,String gender,String province,LocalDate date){
        try{
            FileWriter fileWriter=new FileWriter(file,true);
            fileWriter.write(name+"="+id+"="+gender+"="+province+"="+date+"\n");
            fileWriter.close();
        }catch(Exception e){
System.out.println(e.getMessage());
        }
     
    }
    
    public boolean checkInFile(String name,String id)throws Exception{
      
              Scanner scanner = new Scanner(file);
       
   
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=");

                if (parts.length == 5) {
                    String fileUsername = parts[0];
                    String fileId = parts[1];
                    

                    if (fileUsername.equals(name) && fileId.equals(id)) {
                        return true;
                    }
                }
            }
       
        return false;
    }
}
