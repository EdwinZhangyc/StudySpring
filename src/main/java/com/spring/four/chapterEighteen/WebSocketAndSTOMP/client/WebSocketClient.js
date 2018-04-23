/**
 * 程序清单18.4 连接到"marco" WebSocket的JavaScript客户端
 */

var url = 'ws://' + window.location.host + '/websocket/marco';
//打开WebSocket
var sock = new WebSocket(url);

//处理连接开启事件
sock.onopen = function() {

    console.log('Opening');
    sayMarco();
};

//处理消息
sock.onmessage = function(e) {
    console.log('Received message: ', e.data);
    setTimeout(function(){sayMarco()}, 2000);
}

//处理连接关闭事件
sock.onclose = function() {
    console.log('Closing');
}

//发送消息
function sayMarco() {
    console.log('Sending Marco!');
    sock.send("Marco!");
}