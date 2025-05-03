/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package com.ga.tc.common;
	
public class Decoder {
    	public String encode(String value)
	{
		if (value != null) {
			value = value.trim();
			int level = 0;
			String keyStr = new String("12tabsa12");
			byte key[] = keyStr.getBytes();
			IceKey ik = new IceKey(level);
			ik.clear();
			ik.set(key);
			value = ik.encode(value);
			}
        
		return value;
	}
	public String decode(String value)
	{
		  
		String newValue=null;
		if(value!=null)
        {
            value=value.trim();
   
            String keyStr = new String("12tabsa12"); 
            byte key []= keyStr.getBytes();
            newValue = new String(key);
        }
		
		return newValue;
	}
	public static void main(String[] args) {
		System.out.println(new Decoder().encode("000"));
		
	}
}

