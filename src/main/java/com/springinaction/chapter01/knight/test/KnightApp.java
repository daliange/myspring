package com.springinaction.chapter01.knight.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.chapter01.knight.Knight;

public class KnightApp {
  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = 
      new ClassPathXmlApplicationContext(
          "com/springinaction/chapter01/knight/knight.xml");

    Knight knight =
        (Knight) ctx.getBean("knight");

    knight.embarkOnQuest();
  }
}