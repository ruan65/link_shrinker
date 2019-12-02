package org.premiumapp.link_shrinker

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(LinkShrinkerApplication::class))
class LinkShrinkerApplicationTests {

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext
    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    private val BAD_PATH = "bad"

    @Test
    fun controllerMustRedirectIfRequestSuccess() {

        mockMvc.perform(MockMvcRequestBuilders.get("/$PATH"))
                .andExpect(status().`is`(REDIRECT_STATUS))
                .andExpect(header().string(HEADER_NAME, HEADER_VALUE))
    }

    @Test
    fun controllerMustReturn404IfBadPath() {

        mockMvc.perform(MockMvcRequestBuilders.get("/$BAD_PATH"))
                .andExpect(status().`is`(NOT_FOUND_STATUS))
    }

}
