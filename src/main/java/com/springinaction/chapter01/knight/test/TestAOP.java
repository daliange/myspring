package com.springinaction.chapter01.knight.test;

import com.springinaction.chapter01.knight.HolyGrailQuest;
import com.springinaction.chapter01.knight.Knight;
import com.springinaction.chapter01.knight.KnightOfTheRoundTable;
import com.springinaction.chapter01.knight.QuestFailedException;

public class TestAOP {
	
	public static void main(String[] args) throws QuestFailedException {

		//非spring管理的bean AOP不起作用
		HolyGrailQuest holyGrailQuest = new HolyGrailQuest();
		Knight knight = new KnightOfTheRoundTable(" haha骑士 ",holyGrailQuest);
		knight.embarkOnQuest();
	
	}
	

}
