package one;

import com.zyc.test.chapterOne.InitSpring.DIknights.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用main方法调用，xml配置的方式
 */
public class KnightMain {

    public static void main (String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:context/chapterOne/Knights.xml");
        Knight knight = applicationContext.getBean(Knight.class);  //获取knight的bean
        knight.embarkOnQuest ();  //使用knight
        applicationContext.close();
    }
}