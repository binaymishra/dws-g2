package com.dws.g2.gemini;

import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.preview.ChatSession;
import com.google.cloud.vertexai.generativeai.preview.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatSession chatSession;

    @GetMapping("/{text}")
    public String chat(@PathVariable String text) throws IOException {
        GenerateContentResponse generateContentResponse = this.chatSession.sendMessage(text);
        return ResponseHandler.getText(generateContentResponse);
    }

    @GetMapping("history/{text}")
    public List<String> getChatHistory(@PathVariable String text) throws IOException {
        GenerateContentResponse generateContentResponse = this.chatSession.sendMessage(text);
        List<Content> history = this.chatSession.getHistory();
        return history.stream().flatMap(h -> h.getPartsList().stream()).map(part -> part.getText()).collect(Collectors.toList());
    }
}