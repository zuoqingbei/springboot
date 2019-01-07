package com.hailian.interceptors;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.hailian.annotation.AuthPower;
import com.hailian.common.TokenConstants;
import com.hailian.conf.Constant;
import com.hailian.enums.PlatformType;
import com.hailian.exception.AppWebException;
import com.hailian.utils.JWTUtil;

/**
 * Package: com.hailian.interceptor.AppInterceptors
 * Description: 描述
 * Copyright: Copyright (c) 2017
 *
 * @author lv bin
 * Date: 2018/1/19 14:11
 * Version: V1.0.0
 */
@Configuration
public class AppInterceptors extends WebMvcConfigurerAdapter{

    // 路径中版本的前缀， 这里用 /v[1-9]/的形式
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");

    @Value("${app.version}")
    private String APP_VERSION;

    /**
     * 默认请求request header 头部存放 token 名称
     */
    public static String DEFAULT_TOKEN_NAME = "X-Token";

    /**
     * 参数加密值
     */
    public static String DEFAULT_AUTH_NAME = "X-Sign";

    public static String DEFAULT_PLATFORM = "X-Platform";
    public static String REQUEST_TIME = "http_request_time";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	/*registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                     Object handler) throws Exception {
                request.setAttribute(REQUEST_TIME, new Date());
                return true;
            }
        }).addPathPatterns("/*","/user/**");*/
        registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/api/**");
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/bigSreen/**");
    }

    /**
     * 单点登录
     * @author lzg
     */
    private class TokenInterceptor extends HandlerInterceptorAdapter{
    	 @Override
    	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    		 response.setCharacterEncoding("utf-8");
    		 request.setCharacterEncoding("utf-8");
    		 String targetUrl = "http://t.c.haier.net/login?url=http://dvp.haier.net";
    		 //检验session
    		 HttpSession session = request.getSession();
    		 String userCode = (String) session.getAttribute(Constant.PORTAL_USER_690);
    		 
    		 //若session为空检验token
    		 if(StringUtils.isEmpty(userCode)) {
    			 
    			 String tokenStr = request.getParameter("token");
        		 
        		 if(StringUtils.isEmpty(tokenStr)) {response.sendRedirect(targetUrl);}
        		 
        		 HttpPost post = new HttpPost("http://dvp.haier.net/userServiceYonghong/checkUserToken?token="+tokenStr);
        			 
        		 CloseableHttpClient client = HttpClients.createDefault();
        		 CloseableHttpResponse response1 = null;
        		 String rest = "";
        			try {
        				response1 = client.execute(post);
        				
        				rest = EntityUtils.toString(response1.getEntity(), "utf-8");
        				
        				//返回结果形如  {"result":"success","userAlias":"王健","userId":"A0000662"}
        				System.out.println(rest);
        				
        				if(StringUtils.isEmpty(rest)) {response.sendRedirect(targetUrl);}
        				
        				//获取信息账户
        				ObjectMapper  objectMapper = new ObjectMapper(); 
        				Map<String,String> maps = objectMapper.readValue(rest, Map.class);
        				for (String string : maps.keySet()) { System.out.println(string+":"+maps.get(string)); 	}
        				String status =  maps.get("result");
        				String userAlias = maps.get("userAlias");
        				userCode = maps.get("userId");
        				if("error".equals(status)||StringUtils.isEmpty(status)||StringUtils.isEmpty(userAlias)||StringUtils.isEmpty(userCode)) {
        					response.reset();response.sendRedirect(targetUrl);
        				}
        				//设置session
        				request.getSession().setAttribute(Constant.PORTAL_USER_690,userCode);
        			} catch (JsonParseException e) { e.printStackTrace();
        			response.sendRedirect(targetUrl);
        			} catch (JsonMappingException e) { e.printStackTrace();
        			response.sendRedirect(targetUrl);
        			} catch (IOException e) { e.printStackTrace();
        			} catch (Exception e) { e.printStackTrace();
        			}
    		 }
			return true;
    	 }
    	
    }
    
    /**
     * api 拦截器
     */
    private class ApiInterceptor extends HandlerInterceptorAdapter{

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            String uri = request.getRequestURI();

            boolean avoidVersion = false;

            boolean avoidLogin = true;

            boolean avoidPower = true;

            boolean avoidSign = true;
            boolean avoidPlatform = true;
            if(handler instanceof HandlerMethod) {

                HandlerMethod method = (HandlerMethod) handler;
                AuthPower authPower = method.getMethodAnnotation(AuthPower.class);
                avoidVersion = authPower.avoidVersion();
                avoidLogin = authPower.avoidLogin();
                avoidPower = authPower.avoidPower();
                avoidSign = authPower.avoidSign();
                avoidPlatform=authPower.avoidPlatform();
            }

            String platform =  request.getHeader(TokenConstants.X_PLATFORM);

            if(!avoidPlatform&&(StringUtils.isEmpty(platform) || PlatformType.getTypeByPlatform(platform) == null)){
                throw new AppWebException("平台类型异常：只能为PC、ANDROID、IOS");
            }

            String version = "/api/".concat(APP_VERSION);

            // 版本号校验
            if(!avoidVersion && !uri.startsWith(version)){
                throw new AppWebException("版本参数异常，当前版本"+version);
            }

            String tokenAuth = request.getHeader(DEFAULT_TOKEN_NAME);

            // 登录校验
            if(!avoidLogin){
                // token 是否为空  以及redis中获取token是否存在
                if(StringUtils.isEmpty(tokenAuth)){
                    throw new AppWebException("X-Token不能为空！");
                }

                String userId = JWTUtil.getUserId(tokenAuth);
                if(userId == null){
                    throw new AppWebException("登陆超时，请重新登陆！");
                }

                // 延长token时间
                
                //RedisUtils.put(TokenConstants.CURRENT_LOGIN_TOKEN, tokenAuth, String.valueOf(userId), TokenConstants.TOKEN_EXPIRES_TIME);
            }

            if(!avoidPower){
                // 需要判断用户是否有权访问接口 -- db内配置用户角色接口访问权限
                throw new AppWebException("没有访问权限!");
            }

            String signAuth = request.getHeader(DEFAULT_AUTH_NAME);
            if(!avoidSign&&StringUtils.isEmpty(signAuth)){
                // 判断是否需要校验参数规则  
                throw new AppWebException("非法参数加密值 !");

            }

            /*if(request instanceof BodyReaderHttpServletRequestWrapper){

                BodyReaderHttpServletRequestWrapper requestWrapper = (BodyReaderHttpServletRequestWrapper) request;

                // 请求body不为空
                BufferedReader reader = requestWrapper.getReader();
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                System.out.println("--------------------------" + sb.toString());
            }*/


            return super.preHandle(request, response, handler);
        }
    }
}
