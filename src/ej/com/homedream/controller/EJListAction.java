package ej.com.homedream.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homedream.comm.Action;
import com.homedream.comm.ActionForward;

import ej.com.homedream.dto.EJMemberDTO;
import ej.com.homedream.service.EJMemberService;

public class EJListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		
		int currpage=1;
		String curr=request.getParameter("curr");
		if(curr!=null)
		{
			currpage=Integer.parseInt(curr);
		}
		
				
		EJMemberService service=EJMemberService.getService();//BoardService���� �̱����������� ­����
		
		//���ž� �󼼰˻�
		int stxtsearch1=0;
		int stxtsearch2=0;
		
		String s1=request.getParameter("stxtsearch1");
		String s2=request.getParameter("stxtsearch2");
	
		if(s1!=null&&!"".equals(s1))
			stxtsearch1=Integer.parseInt(s1);
		
		if(s2!=null&&!"".equals(s2))
			stxtsearch2=Integer.parseInt(s2);
		
		System.out.println("stxtsearch1 & stxtsearch2"+stxtsearch1+stxtsearch2);
		
		
		//�˻�����
				String search=request.getParameter("search");//list.jsp���� �޾ƿ��°�
				String txtsearch=request.getParameter("txtsearch");//list.jsp���� �޾ƿ��°�
						if(search==null)//null��ó��
							search="";
						if(txtsearch==null)
							txtsearch="";
				//�˻���
		//����¡����
		int totalcount=service.getCount(search, txtsearch, stxtsearch1, stxtsearch2);//��ü�ڷ�
		System.out.println("totalcount: "+totalcount);
		int countperpage=15;//���������� ������ �ڷ�
		int totalpage=(int)Math.ceil((float)totalcount/countperpage);
		int startrow=(currpage-1)*countperpage+1;
		int endrow=startrow+countperpage-1;
		if(endrow>totalcount) endrow=totalcount;

		//����¡ ��
		//��������
		int blockcount=5;
		int startblock=(currpage-1)/blockcount*blockcount+1;
		int endblock=startblock+blockcount-1;
		System.out.println("startblock:"+startblock);
		System.out.println("endblock:"+endblock);
		if(endblock>totalpage) endblock=totalpage;
		//������	
		
		
		
		List<EJMemberDTO> list=service.getList(startrow,endrow,search,txtsearch, stxtsearch1, stxtsearch2);//�̰� �� ��ü �������°Ű�(����¡����)
		
		
///////////////////////////////
		String addpoint1=request.getParameter("addpoint");//��� insert.jsp��������
		String memno1=request.getParameter("what");//list jsp���� ������
		int addpoint=0; 
		int memno=0;
		
		if(addpoint1!=null&&!"".equals(addpoint1))
			addpoint=Integer.parseInt(addpoint1);
		if(memno1!=null&&!"".equals(memno1))
			memno=Integer.parseInt(memno1);
		
		
		//service.update(memno);
		//service.insert(memno,addpoint);
		
		
		System.out.println("����Ʈ�׼ǿ��� addpoint:"+addpoint);
		System.out.println("����Ʈ�׼ǿ��� memno: "+memno);
		
		
		request.setAttribute("list", list);
		request.setAttribute("currpage", currpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("search",search);
		request.setAttribute("txtsearch", txtsearch);

		
	
		//forward�� �ѱ��
		ActionForward f=new ActionForward();
		f.setForward(true);//forward�� �������̵�
		f.setUrl("/ej_member/ej_list.jsp");//ej_list.jsp�� �ѱ�. �ٵ� �� �� jsp���� �𸣰���. ������ �����
		
		return f;
		
	
	}
	

}