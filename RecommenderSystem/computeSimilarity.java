/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author Suyash
 */
public class computeSimilarity 
{

    /**
     * @param args the command line arguments
     */         
    public void clacAvg(double arrayAvg[],int[][] data)
    {
//        int arrX[][]=new int [943][1682];
//        int arrY[][]=new int [943][1682];
        ReadWriteFile ob=new ReadWriteFile();
        
        int sum=0,countUser=0;
        for(int x=1;x<dm_project.users;x++)
        {
            for(int y=1;y<dm_project.items;y++)
            {
                if(data[x][y]!=0)
                {
                    double userSimillar=0;
                    sum+=data[x][y];
                    countUser++;
//                    arrX[x][y]=dataMatrix[x][y];
//                    arrY[x][y]=dataMatrix[x][y];
//                    Simillarity ob= new Simillarity();
//                    ob.coRelation(dataMatrix[x], dataMatrix[y]);
                    
                }
            }
        
            arrayAvg[x]=sum/countUser;           
            sum=0;
            countUser=0;
            //return arrayAvg[x];
         }
        double sumX2=0,sumY2=0, product=0,simillar=0;
            for(int x =1;x<dm_project.items;x++)
            {
                for(int y =1;y<dm_project.items; y++) 
                {
                    for(int z =1;z<dm_project.users;z++)
                    {
                        //Check if both the items are rated by the user
                        if(data[z][x] !=0 && data[z][y] != 0)
                        {
                            double x1=data[z][x] - arrayAvg[z];
                            double y1=data[z][y] - arrayAvg[z];                                
                            double x1x2=(x1) * (y1);
                            product += x1x2;
                            sumX2 += Math.pow(x1, 2.0);
                            sumY2 += Math.pow(y1, 2.0);                                
                        }
                    }				                        
                        simillar = product/(Math.sqrt(sumX2) * Math.sqrt(sumY2));                        
                        if(simillar >= 0.3) 
                        {
                                ItemToHash(dm_project.map, x, y);
                        }                        
                        dm_project.similarData[x][y] = simillar;
                        product = 0.0;
                        sumX2 = 0.0;
                        sumY2 = 0.0;
                        simillar = 0.0;
                }
            }
    }
        public void ItemToHash(Map<Integer, List<Integer>> map, Integer i1, Integer i2)
        {		
            if(dm_project.map.containsKey(i1))
            {
		dm_project.map.get(i1).add(i2);
            }            
            else
            {
                List <Integer> list = new ArrayList<Integer>();
                list.add(i2);
                dm_project.map.put(i1, list);
            }
	}
            
    
}

    

