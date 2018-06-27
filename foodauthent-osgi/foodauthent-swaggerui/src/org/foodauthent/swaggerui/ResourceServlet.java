package org.foodauthent.swaggerui;

import java.io.IOException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.io.ByteStreams;

public class ResourceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String uri = req.getRequestURI();
		final String requestedResource = uri.substring(uri.lastIndexOf("/") + 1);
		final URL resourceUrl = getClass().getResource(
				"/META-INF/resources/" + requestedResource + (requestedResource.endsWith(".png") ? "" : ".gz"));
		final String acceptEncoding = req.getHeader("Accept-Encoding");
		final boolean clientSupportsGzip = acceptEncoding != null && acceptEncoding.toLowerCase().contains("gzip");
		if (resourceUrl != null) {
			if (requestedResource.endsWith(".png") || clientSupportsGzip) {
				if (!requestedResource.endsWith(".png")) {
					resp.setHeader("Content-Encoding", "gzip");
				}
				ByteStreams.copy(resourceUrl.openStream(), resp.getOutputStream());
			} else {
				ByteStreams.copy(new GZIPInputStream(resourceUrl.openStream()), resp.getOutputStream());
			}
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
