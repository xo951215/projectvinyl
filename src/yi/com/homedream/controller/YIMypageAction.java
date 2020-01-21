package yi.com.homedream.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homedream.comm.Action;
import com.homedream.comm.ActionForward;

public class YIMypageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		ActionForward f=new ActionForward();
		if(session.getAttribute("userId")==null)	//세션이 없을때 -> 로그인과 회원가입 선택 페이지
		{
			
			f.setForward(true);
			f.setUrl("yilogin.do");
		}
		else if(session.getAttribute("userId").equals("1"))	//세션이 admin일때 -> admin 페이지
		{
			f.setForward(true);
			f.setUrl("/hs_memberadminmain.jsp");
		}
		
		else	//세션이 회원일때 ->회원페이지
		{
			f.setForward(true);
			f.setUrl("/yi_member/mypage.jsp");
		}
			return f;
			
		}
	}


