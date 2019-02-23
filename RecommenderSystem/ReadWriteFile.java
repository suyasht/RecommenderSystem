
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suyash
 */
public class ReadWriteFile {
    
    public  void read(String f_input) throws FileNotFoundException, IOException
    {
        // TODO code application logic here
        BufferedReader br = new BufferedReader (new FileReader (f_input));
        String line;        
        try 
        {
            while ((line = br.readLine()) != null)
            {
                    String[] data = new String[3];
                    data = line.split("\\s+");                    
                    int x=Integer.valueOf(data[0]);
                    int y=Integer.valueOf(data[1]);
                    int z=Integer.valueOf(data[2]);
                    dm_project.input_array[Integer.parseInt(data[0])][Integer.parseInt(data[1])] = Integer.parseInt(data[2]);
                    //System.out.println("["+ x+ "]" + "[" +y+"]"+"["+z+"]");
            }
            br.close();
            
        }
//        if(dataMatrix[i][j]!=0)
//        {
//            
//        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
//        for(int i=1;i<Main.users;i++)
//        {
//            for(int j=1;j<Main.items;j++)
//            {
//                System.out.print(" "+dm_output.input_array[i][j]+ " ");
//            }
//            System.out.println("");
//        }
    }
    public  void write(String f_output) throws FileNotFoundException, IOException
    {
        BufferedWriter br=null;
        
        try 
        {
            File file = new File(f_output);
            br = new BufferedWriter(new FileWriter(file));
            for(int i=1;i<dm_project.users;i++)
            {
                for(int j=1;j<dm_project.items;j++)
                {
                    br.write(i+" "+j+" "+dm_project.output_array[i][j]);
                    br.newLine();
                }   
                
                
            }            
        } 
        catch ( IOException e ) 
        {
            e.printStackTrace();
        } 
        finally
        {
          if ( br != null ) 
          {
            br.close();
          }
        }
    }
 }

