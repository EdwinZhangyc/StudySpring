/**
 * 程序清单18.7 借助STOMP库，通过JavaScript发送消息
 */
var url = 'http://' + window.location.host + '/stomp/marcoplo';
//创建SockJS连接
var sock = new SockJS(url);
//创建STOMP客户端
var stomp = Stomp.over(sock);

var playload = JSON.stringify({'message' : 'Marco!'});

//连接STOMP端点
stomp.connect('guest', 'guest', function (frame) {

    //发送消息
    stomp.send("/marco", {}, playload);
});
