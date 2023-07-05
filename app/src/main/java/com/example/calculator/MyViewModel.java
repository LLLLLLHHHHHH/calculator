package com.example.calculator;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.math.BigDecimal;

//用于储存数据模型
public class MyViewModel extends ViewModel {
    public MutableLiveData<String> mainNum;//主数值（用户正在操作的数）
    public String num[] = {"",""};//储存参与计算的数值
    public String sign1 = "",sign2 = "";
    public boolean havePoint = false;//主数值中是否包含小数点
    public MutableLiveData<String> getMainNum(){
        if(mainNum == null){
            mainNum = new MutableLiveData<>();
            mainNum.setValue("0");
        }
        return mainNum;
    }
    public void setMainNum(String n){
        if(mainNum.getValue().equals("0")){
            mainNum.setValue(n);
        }else{
            mainNum.setValue(mainNum.getValue() + n);
        }
    }
    public String mainNumWithNum_0_Total(){
        String value = "0";
        if(mainNum.getValue().contains(".") || num[0].contains(".")){
            switch(sign1){
                case "+":
                    value = String.valueOf(Double.valueOf(num[0]) + Double.valueOf(mainNum.getValue()));
                    break;
                case "-":
                    value = String.valueOf(Double.valueOf(num[0]) - Double.valueOf(mainNum.getValue()));
                    break;
                case "*":
                    value = String.valueOf(Double.valueOf(num[0]) * Double.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if(mainNum.getValue().equals("0")){
                        mainNum.setValue("0");
                    }
                    value = String.valueOf(Double.valueOf(num[0]) / Double.valueOf(mainNum.getValue()));
                    break;
                case "+/-":
                    if(Double.valueOf(mainNum.getValue())>0){
                        value = String.valueOf(Double.valueOf(mainNum.getValue())-2*Double.valueOf(mainNum.getValue()));
                    }else{
                        value = String.valueOf(Double.valueOf(mainNum.getValue())-2*Double.valueOf(mainNum.getValue()));
                    }
            }
        }else{//如果两个数都是整数
            switch(sign1){
                case "+":
                    value = String.valueOf(Integer.valueOf(num[0]) + Integer.valueOf(mainNum.getValue()));
                    break;
                case "-":
                    value = String.valueOf(Integer.valueOf(num[0]) - Integer.valueOf(mainNum.getValue()));
                    break;
                case "*":
                    value = String.valueOf(Integer.valueOf(num[0]) * Integer.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if(mainNum.getValue().equals("0")){
                        mainNum.setValue("0");
                    }
                    value = String.valueOf(Double.valueOf(num[0]) / Double.valueOf(mainNum.getValue()));
                    break;
                case "Math.sqrt()":
                    value = String.valueOf(Math.sqrt(Integer.valueOf(mainNum.getValue())));
                    break;
                case "+/-":
                    if(Integer.valueOf(mainNum.getValue())>0){
                        value = String.valueOf(Integer.valueOf(mainNum.getValue())-2*Integer.valueOf(mainNum.getValue()));
                    }else{
                        value = String.valueOf(Integer.valueOf(mainNum.getValue())-2*Integer.valueOf(mainNum.getValue()));
                    }
            }
        }
        return value;
    }
    public String mainNumWithNum_1_Total(){
        String value = "0";
        if(mainNum.getValue().contains(".")|| num[1].contains(".")){
            switch(sign2){
                case "*":
                    value = String.valueOf(Double.valueOf(num[1]) * Double.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if(mainNum.getValue().equals("0")){
                        mainNum.setValue("1");
                    }
                    value = String.valueOf(Double.valueOf(num[1]) / Double.valueOf(mainNum.getValue()));
            }
        }else{//如果两个数都是整数
            switch(sign2){
                case "*":
                    value = String.valueOf(Integer.valueOf(num[1]) * Integer.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if(mainNum.getValue().equals("0")){
                        mainNum.setValue("1");
                    }
                    value = String.valueOf(Double.valueOf(num[1]) / Double.valueOf(mainNum.getValue()));
            }
        }
        return value;
    }
}
