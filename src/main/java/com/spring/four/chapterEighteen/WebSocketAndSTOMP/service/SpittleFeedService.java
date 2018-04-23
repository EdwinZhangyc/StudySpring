package com.spring.four.chapterEighteen.WebSocketAndSTOMP.service;

import com.spring.four.chapterEighteen.WebSocketAndSTOMP.pojo.Spittle;

public interface SpittleFeedService {

	void broadcastSpittle(Spittle spittle);

}