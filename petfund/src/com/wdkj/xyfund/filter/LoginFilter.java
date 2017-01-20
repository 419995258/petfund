package com.wdkj.xyfund.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.util.Const;


public class LoginFilter implements Filter {
	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		HttpServletResponse res = (HttpServletResponse) response;

		// 获得请求的URL

		String url = req.getRequestURL().toString();

		// 获得session中的对象

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute(Const.SESSION_CUSTOMER_USER);
		
		//if (o != null) {
			// 使用endsWith()判断url结尾的字符串
			//User user = (User) o;
			
			if (url.indexOf("index") != -1 || user != null
					|| url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".gif")
					|| url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith("SSH_market/")) {

				// 满足条件就继续执行

				chain.doFilter(request, response);

			} else {

				// 不满足条件就跳转到其他页面

				//PrintWriter out = res.getWriter();

				//out.print("<script language>alert('请登录！…………');top.location.href='login.jsp'</script>");
				PrintWriter out = response.getWriter();
	            StringBuilder builder = new StringBuilder();
	            builder.append("<script type=\"text/javascript\">");
	            builder.append("window.top.location.href='");
	            builder.append("views/001_index.html");
	            builder.append("';");
	            builder.append("</script>");
	            out.print(builder.toString());
				//res.sendRedirect(req.getContextPath() + "/login.html");
				//req.getRequestDispatcher("/login.html").forward(req, res);
			}
		/*} else {
			PrintWriter out = response.getWriter();
            StringBuilder builder = new StringBuilder();
            builder.append("<script type=\"text/javascript\">");
            builder.append("window.top.location.href='");
            builder.append("views/MD020102_003_login.html");
            builder.append("';");
            builder.append("</script>");
            out.print(builder.toString());
			//res.sendRedirect(req.getContextPath() + "/login.html");
			//req.getRequestDispatcher("/login.html").forward(req, res);
		}*/
	}

	/**
	 * 
	 * @see Filter#init(FilterConfig)
	 */

	public void init(FilterConfig fConfig) throws ServletException {

		// TODO Auto-generated method stub

	}

}
