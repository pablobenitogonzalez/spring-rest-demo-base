package org.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.test.exception.ResourceNotFoundException;
import org.test.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@SuppressWarnings("unused")
public class DefaultController {

	@Autowired
	private MessageService messageService;

	@RequestMapping ("/**")
	public void unmappedRequest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		throw new ResourceNotFoundException(messageService.getMessage("org.test.demo.message.no.resource.for.path", new Object[]{uri}));
	}
}