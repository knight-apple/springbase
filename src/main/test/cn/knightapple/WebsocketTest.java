package cn.knightapple;

import cn.knightapple.websocket.WebSocketHandler;
import org.apache.tomcat.websocket.WsWebSocketContainer;
import org.junit.Test;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;

public class WebsocketTest {
    @Test
    public void connectTest(){
        WsWebSocketContainer wsWebSocketContainer = new WsWebSocketContainer();
        wsWebSocketContainer.setDefaultMaxSessionIdleTimeout(300);
        StandardWebSocketClient client = new StandardWebSocketClient(wsWebSocketContainer);
        WebSocketHandler webSocketHandler = new WebSocketHandler();
        String uriTemplate = "ws://127.0.0.1:8080/websocket?account=11111";
        Object uriVars = null;
        ListenableFuture<WebSocketSession> future = client.doHandshake(webSocketHandler, uriTemplate, uriVars);
        try {
            WebSocketSession session = future.get();
            session.sendMessage(new TextMessage("hello world"));
            session.close();
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void connectTest2(){
        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketHandler webSocketHandler = new WebSocketHandler();
        String uriTemplate = "ws://127.0.0.1:8080/websocket";
        UriComponentsBuilder fromUriString = UriComponentsBuilder.fromUriString(uriTemplate);
        fromUriString.queryParam("account","111111");
        /*
         * 作用同上，都是将请求参数填入到URI中
         * MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
         * params.add("account","111111");
         * fromUriString.queryParams(params);
         * */
        URI uri = fromUriString.buildAndExpand().encode().toUri();
        WebSocketHttpHeaders headers = null;
        ListenableFuture<WebSocketSession> doHandshake = client.doHandshake(webSocketHandler, headers  , uri);
        try {
            WebSocketSession session = doHandshake.get();
            session.sendMessage(new TextMessage("hello world"));
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }

    }
}
