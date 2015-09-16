package org.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.demo.exception.ResourceNotFoundException;
import org.demo.service.MessageService;

import javax.servlet.http.HttpServletRequest;

@Controller
@SuppressWarnings("unused")
public class DefaultController {

	@Autowired
	private MessageService messageService;

	@RequestMapping ("/**")
	public void unmappedRequest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		throw new ResourceNotFoundException(messageService.getMessage("message.no.resource.for.path", new Object[]{uri}));
	}
}
