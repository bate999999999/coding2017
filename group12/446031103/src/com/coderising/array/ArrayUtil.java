package com.coderising.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public void reverseArray(int[] origin){
		int end = origin.length-1;
		int temp ;
		for (int i = 0; i < end; i++,end--) {
			temp=origin[i];
			origin[i]=origin[end];
			origin[end] = temp;
		}
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	
	public int[] removeZero(int[] oldArray){		
		int zeroCnt = 0;
		for (int i : oldArray) {
			if(0==i){
				zeroCnt++;
			}
			
		}		
		int size = 0;
		int [] result = new int[oldArray.length-zeroCnt];
		for (int i : oldArray) {
			if(0!=i){
				result[size]=i;
				size++;
			}
			
		}
		return result;
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public int[] merge(int[] array1, int[] array2){		
		//合拼数组，缺排序，缺去重
		int [] temp = new int[array1.length+array2.length];
		System.arraycopy(array1, 0, temp, 0, array1.length);
		System.arraycopy(array2, 0, temp, array1.length, array2.length);		
		List<Integer>  resultList= new ArrayList<Integer>();
		for (int i : temp) {
			if(!resultList.contains(i))
				resultList.add(i);
		}//已去重数组，缺排序
		int [] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		//冒泡排序
		for (int i = 0; i < result.length-1; i++) {
			for (int j = 0; j < result.length-i-1; j++) {
				if(result[j]>result[j+1]){
					int tempInt = result[j];
					result[j] =result[j+1];
					result[j+1] = tempInt;					
				}
			}
				
		}						
		return  result;
	}
	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int [] oldArray,  int size){
		return Arrays.copyOf(oldArray, oldArray.length+size);
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max){
		int first =0;
		int second = 1;
		List<Integer>  resultList= new ArrayList<Integer>();		
		if(max!=second)
		add(first,second,max,resultList);
		int [] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public int[] getPrimes(int max){
		List<Integer>  resultList= new ArrayList<Integer>();
		for (int i = 2; i < max; i++) {
			boolean isAdd = true;
			for (int j = 2; j < i; j++) {
				if(0==i%j){
					isAdd = false;
					break;
				}					
			}
			if(isAdd)
				resultList.add(i);
		}
		int [] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
	
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max){
		List<Integer>  resultList= new ArrayList<Integer>();
		for (int i = 1; i < max; i++) {
			int temp = 0;
			for (int j = 1; j < i; j++) {
				if(0==i%j){
					temp+=j;
				}
			}
			if(i==temp)
				resultList.add(i);
		}
		int [] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
	
	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	public String join(int[] array, String seperator){
		return Arrays.toString(array).replace("[", "").replace("]", "").replace(", ", seperator);
	}
	
	/**
	 * 
	 * @param number1
	 * @param number2
	 * @param max
	 * @param resultList
	 * @return
	 */
	public List<Integer> add(int number1,int number2,int max,List<Integer>  resultList){
		if(number2<max){
			resultList.add(number2);
			return add(number2,number1+number2,max,resultList);
		}else{
			return resultList;
		}			
	};

}
