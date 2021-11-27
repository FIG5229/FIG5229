package com.integration.filter;

import com.alibaba.fastjson.JSON;
import com.integration.entity.Audience;
import com.integration.utils.DataUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Resource
	private TokenVerification tokenVerification;

	@Autowired
	private Audience audience;

	String[] includeUrls = new String[] {
			"/hlkj/camp/login",
			"/hlkj/camp/VerificationTicket",
			"/hlkj/camp/VerificationTicketforBody",
			"/hlkj/camp/VerificationTicketforJson",
			"/hlkj/camp/faceId"
	};

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String uri = request.getRequestURI();
		boolean needFilter = isNeedFilter(uri);

		if (!needFilter) {
			ctx.setSendZuulResponse(true);// 对该请求进行路由
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);// 设值，可以在多个过滤器时使用
			return null;
		} else if (audience.getDfilter() == 1) {
			ctx.setSendZuulResponse(true);// 对该请求进行路由
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);// 设值，可以在多个过滤器时使用
			return null;
		} else {

			String username = request.getHeader("token").trim();

			boolean bool = tokenVerification.TokenVerification(username);

			if(bool){
				ctx.setSendZuulResponse(true);// 对该请求进行路由
				ctx.setResponseStatusCode(200);
				ctx.set("isSuccess", true);// 设值，可以在多个过滤器时使用
				return null;
			}else{
				ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
				ctx.setResponseStatusCode(403);// 返回错误码
				ctx.setResponseBody(JSON.toJSONString(DataUtils.returnPrExt("403", "登录超时，请重新登录", null, 0)));// 返回错误内容
				ctx.set("isSuccess", false);
				return null;
			}

//			Claims t = JwtHelper.parseJWT(username, audience.getBase64Secret());
//			if (t != null ) {
//				String key = t.get("id").toString();
//				if (redisUtil.exists(key)) {
//					if (redisUtil.get(key).equals(username)) {
//						ctx.setSendZuulResponse(true);// 对该请求进行路由
//						ctx.setResponseStatusCode(200);
//						ctx.set("isSuccess", true);// 设值，可以在多个过滤器时使用
//						return null;
//					} else {
//						ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
//						ctx.setResponseStatusCode(403);// 返回错误码
//						ctx.setResponseBody(JSON.toJSONString(DataUtils.returnPrExt("403", "登录超时，请重新登录", null, 0)));// 返回错误内容
//						ctx.set("isSuccess", false);
//						return null;
//					}
//				}
//			}
		}

		/*
		 * RequestContext ctx = RequestContext.getCurrentContext(); String
		 * sessionId = httpServletRequest.getSession().getId();
		 * ctx.addZuulRequestHeader("Cookie", "SESSION=" + sessionId);
		 * ctx.setSendZuulResponse(true);// 对该请求进行路由
		 * ctx.setResponseStatusCode(200); // 返回200正确响应 return sessionId;
		 */
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	public boolean isNeedFilter(String uri) {

		for (String includeUrl : includeUrls) {
			if (includeUrl.equals(uri)) {
				return false;
			}
		}

		return true;
	}

}
