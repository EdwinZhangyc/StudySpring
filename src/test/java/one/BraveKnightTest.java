package one;

import com.spring.one.chapterOne.InitSpring.DIknights.BraveKnight;
import com.spring.one.chapterOne.InitSpring.DIknights.Quest;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * 使用mock做quest实现类 进行测试BraveKnight
 * 同时使用Mockito框架验证Quest的mock实现的embark方法只调用一次
 */
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest () {

        Quest mockQuest = mock(Quest.class); //创建mock Quest  （模仿quest的实现类）
        BraveKnight braveKnight = new BraveKnight(mockQuest); //注入mock Quest
        braveKnight.embarkOnQuest();
        //使用Mockito框架验证Quest的mock实现的embark方法只调用一次
        verify(mockQuest, times(1)).embark();
    }
}