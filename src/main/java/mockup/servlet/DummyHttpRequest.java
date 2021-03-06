/*******************************************************************************
 * Copyright (c) 2012 Secure Software Engineering Group at EC SPRIDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors: Christian Fritz, Steven Arzt, Siegfried Rasthofer, Eric
 * Bodden, and others.
 ******************************************************************************/
package mockup.servlet;

import mockup.Replaces;
import ourlib.nonapp.TaintAPI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

@Replaces("javax.servlet.http.HttpServletRequest")
public class DummyHttpRequest implements HttpServletRequest {
	enum count {
		ONE, TWO
	};
	Map<String,String> headers;

	@Override
	public Object getAttribute(String arg0) {
		return "";
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Enumeration getAttributeNames() {

		return new StringTokenizer("one two");
	}

	@Override
	public String getCharacterEncoding() {
		return "UTF-8";
	}

	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return "contenttype";
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return new DummyServletInputStream(TaintAPI.getTaintedString());
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return Locale.ENGLISH;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Enumeration getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParameter(String arg0) {
		return TaintAPI.getTaintedString();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Map getParameterMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("dummy", TaintAPI.getTaintedString());
		return map;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Enumeration getParameterNames() {
		return new StringTokenizer("name1 name2");
	}

	@Override
	public String[] getParameterValues(String arg0) {
		// TODO Auto-generated method stub
		return new String[] { TaintAPI.getTaintedString() };
	}

	@Override
	public String getProtocol() {
		return TaintAPI.getTaintedString();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRealPath(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterEncoding(String arg0)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAuthType() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getContextPath() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Cookie[] getCookies() {
		String s = TaintAPI.getTaintedString();
		Cookie c = new Cookie(s, s);
		c.setComment(s);
		return new Cookie[] { c };
	}

	@Override
	public long getDateHeader(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHeader(String arg0) {		
		return TaintAPI.getTaintedString();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Enumeration getHeaderNames() {
		String s = TaintAPI.getTaintedString();
		return new StringTokenizer(s);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Enumeration getHeaders(String arg0) {
		String s = TaintAPI.getTaintedString();
		return new StringTokenizer(s);
	}

	@Override
	public int getIntHeader(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPathInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPathTranslated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getRemoteUser() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getRequestURI() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public StringBuffer getRequestURL() {
		// TODO Auto-generated method stub
		return new StringBuffer("http://");
	}

	@Override
	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpSession getSession() {
		return new DummyHttpSession();
	}

	@Override
	public HttpSession getSession(boolean arg0) {
		return new DummyHttpSession();
	}

	@Override
	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromUrl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserInRole(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}
}
