package com.ezial.bgmanage.dubbo.provider.controller;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by Ezial on 2018/3/7.
 */
public class NioTest {

    public static void main(String[] args) {

        byteBufferTest();//byte buffer
        // charBufferTest();

    }

    public static void  byteBufferTest(){
        ByteBuffer buffer = ByteBuffer.allocate(100);

        buffer.put((byte)'h');
        buffer.put((byte)'e');
        buffer.put((byte)'l');
        buffer.put((byte)'l');
        buffer.put((byte)'o');

        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        System.out.println("position:"+buffer.position());
        System.out.println("mark:"+buffer.mark());
        System.out.println(buffer.remaining());
        buffer.flip();
        System.out.println(buffer.isDirect());

        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        System.out.println("position:"+buffer.position());
        System.out.println("mark:"+buffer.mark());
        System.out.println(buffer.remaining());

        // remaing = limit -  position;
    }

    public static void  charBufferTest(){
        CharBuffer buffer = CharBuffer.wrap ("Hello World",1,4);

        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        System.out.println("position:"+buffer.position());
        System.out.println("mark:"+buffer.mark());
        System.out.println(buffer.remaining());
        buffer.flip();

        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        System.out.println("position:"+buffer.position());
        System.out.println("mark:"+buffer.mark());
        System.out.println(buffer.remaining());

        String temp = "";
        while(buffer.hasRemaining()){
            temp += buffer.get();
        }

        System.out.println(temp);

    }


}
