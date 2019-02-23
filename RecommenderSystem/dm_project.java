



import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suyash
 */
public class dm_project
{
    
    public static int users=944;
    public static int items=1683;
    public static int [][] input_array = new int[users][items];
    public static int [][]output_array= new int[users][items];
    public static double[]  arrayAvg = new double [users];
    public static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    public static double [][]similarData=new double [items][items];
        
    public static void main(String[] args) throws IOException
    {
        String file_in="train_all_txt.txt";
        String file_out="output.txt";
        ReadWriteFile ob=new ReadWriteFile();
        computeSimilarity obj= new computeSimilarity();
        Recommend rc=new Recommend();
        
        
        ob.read(file_in);
        
        obj.clacAvg(arrayAvg,input_array);
        
        rc.predictValues(input_array, output_array);
            
        ob.write(file_out);
        
    }
}



