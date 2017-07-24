package com.younggambyeon.sample;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.younggambyeon.sample.security.CustomUserDetail;
import com.younggambyeon.sample.service.MessagesSenderService;
import com.younggambyeon.sample.service.RedisService;
import com.younggambyeon.sample.service.RedisServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private RedisService redisService;

	@Autowired
	private MessagesSenderService messagesSenderService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest req, Authentication auth) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		// custom
		CustomUserDetail customUserDetail = (CustomUserDetail) auth.getPrincipal();
		String username = customUserDetail.getUsername();
		String sessionId = req.getSession().getId();

		// req.getSession().setMaxInactiveInterval(60 * 1000);

		model.addAttribute("sessionId", sessionId);
		model.addAttribute("username", username);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/login")
	public String showLoginView() {
		return "login";
	}

	@RequestMapping(value = "/redis/set/{key}/{value}")
	public String setRedisKeyValueView(HttpServletRequest req, @PathVariable String key, @PathVariable String value) {
		redisService.setValue(key, value);

		return "login";
	}

	@RequestMapping(value = "/redis/get/{key}")
	public ModelAndView getRedisKeyValueView(@PathVariable String key, ModelAndView mav) {
		Object value = redisService.getValue(key);

		mav.addObject("sessionId", value);
		mav.setViewName("login");

		return mav;
	}

	@RequestMapping(value = "/send/{id}")
	public @ResponseBody String send(@PathVariable String id) throws IOException {

		messagesSenderService.send(id, "test message~~");

		return "success";
	}

}
