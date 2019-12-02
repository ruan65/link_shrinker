package org.premiumapp.link_shrinker

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/{key}")
class RedirectController {

    @RequestMapping()
    fun redirect(@PathVariable("key") key: String, response: HttpServletResponse) {
        print("key************************************************* = $key")
        if (key == PATH) {
            response.setHeader(HEADER_NAME, HEADER_VALUE)
            response.status = REDIRECT_STATUS
        } else {
            print("key************************************************* = $key")

            response.status = NOT_FOUND_STATUS
        }

    }
}