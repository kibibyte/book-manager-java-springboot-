package com.myapp.usecase

import com.fasterxml.jackson.databind.ObjectMapper
import com.myapp.WebConfig
import org.modelmapper.ModelMapper
import org.springframework.boot.test.json.JacksonTester
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

class MockMvcTest extends Specification {

    private static final WebConfig webConfig = new WebConfig()

    protected MockMvc mockMvc
    protected ModelMapper modelMapper = webConfig.modelMapper()

    def setupMvc(controller) {
        JacksonTester.initFields(this, new ObjectMapper())
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build()
    }

    MockHttpServletResponse post(String path, String content = "") {
        mockMvc.perform(buildPostRequest(path, content))
                .andReturn()
                .response
    }

    MockHttpServletResponse get(String url, MediaType accept = MediaType.APPLICATION_JSON_UTF8) {
        mockMvc.perform(MockMvcRequestBuilders.get(url).accept(accept))
                .andReturn()
                .response
    }

    private static MockHttpServletRequestBuilder buildPostRequest(String path, String content = "") {
        def request = MockMvcRequestBuilders.post(path)
        if (content?.trim()) {
            request.contentType(APPLICATION_JSON_VALUE)
                    .content(content)
                    .accept(APPLICATION_JSON_VALUE)
        }

        request
    }
}