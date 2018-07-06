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
	final URL resourceUrl = findResource(requestedResource);
	if (resourceUrl != null) {
	    if (isGzipResource(resourceUrl)) {
		if (clientSupportsGzip(req)) {
		    resp.setHeader("Content-Encoding", "gzip");
		    ByteStreams.copy(resourceUrl.openStream(), resp.getOutputStream());
		} else {
		    ByteStreams.copy(new GZIPInputStream(resourceUrl.openStream()), resp.getOutputStream());
		}
	    } else {
		ByteStreams.copy(resourceUrl.openStream(), resp.getOutputStream());
	    }
	} else {
	    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
    }

    private final URL findResource(final String requestedResource) {
	final String resource = String.join("", "/META-INF/resources/", requestedResource);
	URL url = getClass().getResource(resource);
	// use gzip resource if not found
	if (url == null) {
	    url = getClass().getResource(String.join("", resource, ".gz"));
	}
	return url;
    }

    private final boolean isGzipResource(URL url) {
	final String resource = url.toExternalForm();
	return resource.endsWith(".gz");
    }

    private final boolean clientSupportsGzip(final HttpServletRequest req) {
	final String acceptEncoding = req.getHeader("Accept-Encoding");
	return acceptEncoding != null && acceptEncoding.toLowerCase().contains("gzip");
    }
}
