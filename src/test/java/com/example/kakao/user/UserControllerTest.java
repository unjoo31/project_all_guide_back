package com.example.kakao.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.kakao.MyWithRestDoc;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8080)
@SpringBootTest
public class UserControllerTest extends MyWithRestDoc{
    @Test
    public void join_test() throws Exception{
        
        // given
        UserRequest.JoinDTO requestDTO = new UserRequest.JoinDTO();
        requestDTO.setEmail("who@nate.com");
        requestDTO.setPassword("1234");
        ObjectMapper om = new ObjectMapper();
        String requestBody = om.writeValueAsString(requestDTO); // dto를 json으로 변경해줌
        System.out.println("=========================");
        System.out.println(requestBody);
        System.out.println("=========================");

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/join")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);

        // then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.password").value("1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.email").value("who@nate.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").isEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }
}
