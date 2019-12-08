/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

//import static collection.Collection.ara1;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;



class ListOfDummy extends AbstractList {

    private String ara1[] = new String[1];
    private String ara[];
    private int i = 0;
    

    
    @Override
    public int size(){
        return 0;
    }
    
    public void add(String st){
        
        ara1[i] = st;
        i++;
        ara = new String[i];
        
        for(int l = 0; l < i; l++){
            

            
            ara[l] = ara1[l];
            
        }
        
        ara1 = new String[i+1];
        for(int k = 0; k < i; k++){
            ara1[k] = ara[k];
        
        }
    }
    
    @Override
    public String remove(int index){
        
        i--;
        ara = new String[i];
        
        for(int k = 0, l = 0; k <= i; k++){
            
            if(k==index){
                
                continue;
                
            }
            
            ara[l++] = ara1[k];
            
            
        }
        
        ara1 = new String[i+1];
        for(int k = 0; k < i; k++){
            ara1[k] = ara[k];
        
        }
        
        return "";
    }
    
    public void remove(String item){
        
        i--;
        ara = new String[i];
        
        for(int k = 0, l = 0; k <= i; k++){
            
            if(ara1[k]==item){
                
                continue;
                
            }
            
            ara[l++] = ara1[k];
            
        }
        
        ara1 = new String[i+1];
        for(int k = 0; k < i; k++){
            ara1[k] = ara[k];
        
        }
        
    }
    
    public String get(int index){
        
        return ara[index];
        
    }
    
    public void set(int index, String st){
        ara[index] = st;
    }
    
    public boolean container(String st){
        boolean a = false;
        for(int i = 0; i < ara.length; i++){
            if(ara[i]==st){
                a = true; 
            }
        }
        return a;
    }

    @Override
    public String toString(){
        System.out.print("[");
        for(int i = 0; i < ara.length; i++){
            
            System.out.print(ara[i]);
            
            if(i==ara.length-1){
                
                continue;
                
            }
            
            
            System.out.print(", ");
            
        }
        
        System.out.println("]");
        
        return "";
    }
    
    public void reverse(){
        String swap;
        for(int i = 0, j = ara.length-1; i < ara.length/2; i++){
            swap = ara[j];
            ara[j--] = ara[i];
            ara[i] = swap;
        } 
    }
    
    public void show(){
        for(String s : ara){
            System.out.print(s+" ");
        }
    }
    
    public void addAll(ListOfDummy o){
        
    }
    

   

    
}
