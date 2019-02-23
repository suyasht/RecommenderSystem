/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author Suyash
 */
public class Recommend 
{
    public void predictValues(int[][] input, int[][] output) 
    {
		
		double missingValue = 0.0;
		int fValue = 0;
                List<Integer> lt;
		for (int g =1;g<dm_project.users;g++)
                {
                    for (int h=1;h<dm_project.items;h++) 
                    {				
                        if(input[g][h] == 0) 
                        {					
                            lt = dm_project.map.get(h);					                        
                            if (lt!=null)
                            {
                                missingValue = calcWeightedSum(input, g, h, lt);
                                fValue = (int) Math.round(missingValue);                                
                                if (fValue<1) 
                                {
                                        output[g][h]=1;
                                }
                                else if (fValue>5)
                                {
                                        output[g][h]=5;
                                }
                                else 
                                {
                                        output[g][h]=fValue;
                                }
                            }
                            else
                            {
                                output[g][h]=1;
                            }
                        } 
                        else
                        {
                            output[g][h]=input[g][h];
                        } 
                    }
		}
	}
	public double calcWeightedSum(int[][] input, int i, int j, List<Integer> list) {

		double nume = 0.0,deno = 0.0,value = 0.0;		
		int item = 0;		
		for (int k = 0; k < list.size(); k++) 
                {
                    item = list.get(k);			                    
                    if (input[i][item] != 0) 
                    {   
                        double n=0,d=0;
                        n=((dm_project.similarData[j][item]) * (input[i][item]));
                        nume += n;                        
                        deno += Math.abs(dm_project.similarData[j][item]);
                    }
		}				
		value = nume / deno;		
		return value;
	}
}
