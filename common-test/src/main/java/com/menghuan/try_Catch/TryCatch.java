package com.menghuan.try_Catch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TryCatch {

    public static int testNoReturn(){
        int res = 1;
        try{
            res++;
            System.out.println("try ======== res:"+res);
            int a = 1/0;
        }catch (Exception e){
            res++;
            System.out.println("catch ======== res:"+res);
            int a = 1/0;
        }finally {
            res++;
            System.out.println("finally ======== res:"+res);
        }
        return res;
    }

    public static int testTryCatchReturn(){
        int res = 1;
        try{
            res++;
            System.out.println("try ======== res:"+res);
            int a=1/0;
            return res;
        }catch (Exception e){
            res++;
            System.out.println("catch ======== res:"+res);
            return res;
        }finally {
            res++;
            System.out.println("finally ======== res:"+res);
        }
    }

    public static List testTryCatchReturnQuote(){
        List res = new ArrayList();
        try{
            res.add(1);
            System.out.println("try ======== res:"+res);
            int a=1/0;
            return res;
        }catch (Exception e){
            res.add(2);
            System.out.println("catch ======== res:"+res);
            return res;
        }finally {
            res.add(3);
            System.out.println("finally ======== res:"+res);
        }
    }

    public static List testTryCatchReturnNull(){
        List res = new ArrayList();
        try{
            res.add(1);
            System.out.println("try ======== res:"+res);
            int a=1/0;
            return res;
        }catch (Exception e){
            res.add(2);
            System.out.println("catch ======== res:"+res);
            return res;
        }finally {
            res.add(3);
            System.out.println("finally ======== res:"+res);
            res = null;
            System.out.println("finally ======== res:"+res);
        }
    }

    public static int testFinallyReturn(){
        int res = 1;
        try{
            res++;
            System.out.println("try ======== res:"+res);
            int a=1/0;
            return res;
        }catch (Exception e){
            res++;
            System.out.println("catch ======== res:"+res);
            int a = 1/0;
            return res;
        }finally {
            res++;
            System.out.println("finally ======== res:"+res);
            return res;
        }
    }



    @Test
    public void sss() {
        System.out.println("return:" + testNoReturn());
    }

    @Test
    public void ccc() {
        System.out.println("return:" + testTryCatchReturn());
    }

    @Test
    public void fff() {
        System.out.println("return:" + testTryCatchReturnQuote());
    }

    @Test
    public void ggg() {
        System.out.println("return:" + testTryCatchReturnNull());
    }

    @Test
    public void hhh() {
        System.out.println("return:" + testFinallyReturn());
    }

}
