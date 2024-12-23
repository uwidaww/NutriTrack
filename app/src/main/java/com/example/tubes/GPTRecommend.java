package com.example.tubes;

import android.util.Log;

import com.cjcrafter.openai.OpenAI;
import com.cjcrafter.openai.chat.ChatMessage;
import com.cjcrafter.openai.chat.ChatRequest;
import com.cjcrafter.openai.chat.ChatResponse;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPTRecommend {

    OpenAI openAI;

    public GPTRecommend(String key){
        try {

            openAI = new OpenAI.Builder().apiKey(key).build();
        }catch (Exception e){
            Log.e("err0r",e.getMessage());
        }


    }

    public String getResponse(String text){
        List<ChatMessage> message = new ArrayList<>();
        message.add(ChatMessage.toSystemMessage("" +
                "Help the user to reduce or gain their weight to achive their dream body" +
                "or just being healhier" +
                ""));

        ChatRequest request = ChatRequest.builder().model("gpt-3.5-turbo").messages(message)
                .build();

        message.add(ChatMessage.toUserMessage(text));
        ChatResponse response = openAI.createChatCompletion(request);
        return response.get(0).getMessage().getContent();

    }
}
